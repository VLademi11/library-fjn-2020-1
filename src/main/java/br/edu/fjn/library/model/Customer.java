package br.edu.fjn.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String cpf;

    private String email;

    @OneToOne(cascade = CascadeType.ALL) // cardinalidade
    @JoinColumn // deve ser criado a chave estrangeira
    private Address address;

}