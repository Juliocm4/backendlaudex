package com.examen.prueba.secu.cont;
import com.examen.prueba.dto.msn;
import com.examen.prueba.secu.dto.jwtdto;
import com.examen.prueba.secu.dto.loginusu;
import com.examen.prueba.secu.dto.nuevousu;
import com.examen.prueba.secu.ent.rol;
import com.examen.prueba.secu.ent.usuario;
import com.examen.prueba.secu.enums.rolnom;
import com.examen.prueba.secu.jwt.jwtprovider;
import com.examen.prueba.secu.serv.rolserv;
import com.examen.prueba.secu.serv.ususervs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class authcont {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ususervs usuarioService;

    @Autowired
    rolserv rolService;

    @Autowired
    jwtprovider jwtProviders;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody nuevousu nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new msn("nombre de usuario o contraseña incorrectos"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new msn("ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        usuario usuario =
                new usuario( nuevoUsuario.getNombreUsuario(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(rolnom.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(rolnom.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new msn("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<jwtdto> login(@Valid @RequestBody loginusu loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new msn("nombre de usuario o contraseña incorrectos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProviders.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        jwtdto jwtDto = new jwtdto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
