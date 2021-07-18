package io.muzoo.ssc.RateYourJab.backend;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String username;
    private String password;

    private String group;
}
