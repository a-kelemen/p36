package hu.neo.bank.p36backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "HUF")
public class HufAccount {

    @Id
    private int id;

    @Column
    private int accountNumber;

    @OneToOne(mappedBy = "HUF")
    private User user;

    @OneToOne(mappedBy = "HUF")
    private BankCard card;

}
