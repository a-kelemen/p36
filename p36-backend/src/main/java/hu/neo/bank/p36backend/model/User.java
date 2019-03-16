package hu.neo.bank.p36backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String userName;

    @Column
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "huf_id", referencedColumnName = "id")
    private HufAccount hufAccount;

    @OneToOne
    @JoinColumn(name = "euro_id", referencedColumnName = "id")
    private EuroAccount euroAccount;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private List<BankCard> bankCard;

}
