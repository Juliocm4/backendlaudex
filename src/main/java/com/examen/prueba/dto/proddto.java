package com.examen.prueba.dto;

import java.util.Date;

public class proddto {

    private String nom;
    private String app;
    private String apm;
    private Date fechanac;
    private String sexo;
    private String grado;
    private String email;
    private String tel;

    public proddto() {
    }

    public proddto(String nom, String app, String apm, Date fechanac, String sexo, String grado, String email, String tel) {
        this.nom = nom;
        this.app = app;
        this.apm = apm;
        this.fechanac = fechanac;
        this.sexo = sexo;
        this.grado = grado;
        this.email = email;
        this.tel = tel;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
