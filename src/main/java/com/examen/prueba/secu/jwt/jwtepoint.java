package com.examen.prueba.secu.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class jwtepoint implements AuthenticationEntryPoint {

    private final static Logger logger = LoggerFactory.getLogger(jwtepoint.class);
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        logger.error("Error en la petición");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
    }
}
