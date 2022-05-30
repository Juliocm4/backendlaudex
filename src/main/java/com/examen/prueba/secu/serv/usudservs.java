package com.examen.prueba.secu.serv;
import com.examen.prueba.secu.ent.usuario;
import com.examen.prueba.secu.ent.usup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class usudservs implements UserDetailsService{
    @Autowired
    ususervs usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return (UserDetails) usup.build(usuario);
    }
}
