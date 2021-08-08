package ru.ruslanator.msauth.entities;

import lombok.Data;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
}
