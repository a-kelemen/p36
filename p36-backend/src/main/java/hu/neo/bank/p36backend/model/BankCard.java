package hu.neo.bank.p36backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bankcard")
public class BankCard {

    @Id
    private int id;

    @OneToOne(mappedBy = "bankCard")
    private User user;

    @OneToOne
    @JoinColumn(name = "euro_id", referencedColumnName = "id")
    private EuroAccount euroAccount;

    @OneToOne
    @JoinColumn(name = "huf_id", referencedColumnName = "id")
    private EuroAccount hufAccount;
}
