package com.examen.prueba.secu.ent;
import com.examen.prueba.secu.enums.rolnom;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private rolnom rolNombre;

    public rol() {
    }

    public rol(@NotNull rolnom rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public rolnom getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(rolnom rolNombre) {
        this.rolNombre = rolNombre;
    }
}
