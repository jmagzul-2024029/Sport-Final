package com.jorgemagzul.sportfinal.model;


import jakarta.persistence.*;

//anotaciones que van fuera del class (es para todo lo que tenga dentro)
@Entity //indica que es una clase gestionada por JPA(se usará una persistencia de datos)
@Table(name = "users")

public class User {
    //mapeo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que se genere el id porque en la base de datos es auto increment
    private Integer id;

    @Column(name = "first_name") //de la base de datos, si no existe entonces la crea
    private String firstName; //declarar lo de la base de datos pero ya en camelCase

    @Column(name = "last_name") //de la base de datos, si no existe entonces la crea
    private String lastName; //declarar lo de la base de datos pero ya en camelCase

    @Column(name = "email") //de la base de datos, si no existe entonces la crea
    private String email; //declarar lo de la base de datos pero ya en camelCase

    //Setters and getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
