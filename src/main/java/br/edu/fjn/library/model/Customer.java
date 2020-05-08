package br.edu.fjn.library.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_gen")
    @SequenceGenerator(name = "cust_gen", initialValue = 1, allocationSize = 1, sequenceName = "customer_seq")
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String cpf;

    private String email;

    @OneToOne(cascade = CascadeType.ALL) // cardinalidade
    @JoinColumn // deve ser criado a chave estrangeira
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Phone> phones;

}