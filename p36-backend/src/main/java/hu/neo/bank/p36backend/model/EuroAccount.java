package hu.neo.bank.p36backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EURO")
public class EuroAccount {

    @Id
    private int id;

    @Column
    private int accountNumber;

    @OneToOne(mappedBy = "EUR")
    private User user;

    @OneToOne(mappedBy = "EUR")
    private BankCard card;
}
