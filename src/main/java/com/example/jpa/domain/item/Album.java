package com.example.jpa.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * created by Gyunny 2021/10/06
 */
@DiscriminatorValue("A")
@Setter
@Getter
@Entity
public class Album extends Item {

    private String artist;
    private String ect;

}
