package com.examen.prueba.util;

import com.examen.prueba.secu.ent.rol;
import com.examen.prueba.secu.enums.rolnom;
import com.examen.prueba.secu.serv.rolserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {
    @Autowired
    rolserv rolService;

    @Override
    public void run(String... args) throws Exception {
        /**rol rolAdmin = new rol(rolnom.ROLE_ADMIN);
         rol rolUser = new rol(rolnom.ROLE_USER);
         rolService.save(rolAdmin);
         rolService.save(rolUser);**/

    }
}
