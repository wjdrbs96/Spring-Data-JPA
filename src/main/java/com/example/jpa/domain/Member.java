package com.example.jpa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * created by jg 2021/06/02
 */
@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    @SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "review_sequence")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;
}
