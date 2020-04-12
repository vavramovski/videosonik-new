package mk.com.videosonik.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contact_mails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactEMail {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String subject;

    @Column(name = "sender_name")
    private String sender;

    @Column(name = "sender_email")
    private String email;

    private String content;

    @Column(name="date")
    private Long dateLong;

}
