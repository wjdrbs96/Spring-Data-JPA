package com.example.jpa.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * created by Gyunny 2021/10/06
 */
@DiscriminatorValue("M")
@Setter
@Getter
@Entity
public class Movie extends Item {

    private String director;
    private String ect;

}
