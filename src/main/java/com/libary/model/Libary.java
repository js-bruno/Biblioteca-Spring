package com.libary.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Libary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String nome;
    @NotNull
    private String autor;
    @NotNull
    private int quantidade;
    @NotNull
    private double preco;
}
