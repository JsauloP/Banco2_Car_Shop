package br.edu.unijuazeiro.carshop.model.CAR;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class CAR {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_car")
    @SequenceGenerator(sequenceName = "seq_car", allocationSize = 1, 
        initialValue = 1, name = "gen_car")
    private Integer code;

    private String title;

    private String category;
    
    private Timestamp duration;

    private double price;

}
