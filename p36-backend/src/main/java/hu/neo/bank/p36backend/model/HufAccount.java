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
/*
    @OneToOne(mappedBy = "hufAccount")
    private User user;
*/
    @OneToOne(mappedBy = "hufAccount")
    private BankCard card;

}
