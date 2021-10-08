package com.example.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * created by Gyunny 2021/10/08
 */
@AllArgsConstructor
@Getter
public class ResultDTO<T> {
    private T data;
}
