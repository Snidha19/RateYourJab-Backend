package io.muzoo.ssc.project.backend;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tbl_review")
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

    private int question1;
    private int question2;
    private int question3;
    private int question4;
    private int question5;
    private int question6;
    private String review;
    private String tag;
}
