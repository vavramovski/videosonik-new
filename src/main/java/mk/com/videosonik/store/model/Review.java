package mk.com.videosonik.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {

    // TODO: za da postgre generira id, treba ID da e SERIAL, a tuka generationType da e identity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "username")
    @ManyToOne
    private User user;

    @JoinColumn(name = "productid")
    @ManyToOne
    private Product product;

    private String comment;

    private Integer rate;

    @Column(name="date")
    private Long dateLong;
}
