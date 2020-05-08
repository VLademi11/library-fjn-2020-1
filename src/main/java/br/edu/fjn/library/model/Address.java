package br.edu.fjn.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_gen")
    @SequenceGenerator(name = "add_gen", initialValue = 1, allocationSize = 1, 
        sequenceName = "address_seq")
    private Integer code;
    private String street;
    private String number;
}