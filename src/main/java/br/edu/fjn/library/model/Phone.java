package br.edu.fjn.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ph_gen")
    @SequenceGenerator(name = "ph_gen", initialValue = 1, allocationSize = 1, 
        sequenceName = "ph_seq")
    private Integer code;

    @Column(nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

}