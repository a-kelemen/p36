package hu.neo.bank.p36backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    private int id;

    @Column
    private int zipCode;

    @Column
    private String settlement;

    @Column
    private String publicPlace; //street, square, avenue und so weiter

    @Column
    private int streetNumber;

    @OneToMany(mappedBy = "address")
    private Set<User> users;

}
