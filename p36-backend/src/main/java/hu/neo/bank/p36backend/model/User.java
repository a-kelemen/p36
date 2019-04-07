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
    private String firstname; // firstName-re sql unkonw column name hibát dobott

    @Column
    private String lastname; // dettó

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    /*
        @OneToOne
        @JoinColumn(name = "huf_id", referencedColumnName = "id")
        private HufAccount hufAccount;

        @OneToOne
        @JoinColumn(name = "euro_id", referencedColumnName = "id")
        private EuroAccount euroAccount;

        @OneToOne
        @JoinColumn(name = "card_id", referencedColumnName = "id")
        private BankCard bankCard;

        @ManyToOne
        @JoinColumn(name = "address_id", nullable = false)
        private Address address;
    */
    public enum Role {
        ROLE_USER, ROLE_ADMIN;
    }

}
