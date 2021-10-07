package com.example.jpa.repository;

import com.example.jpa.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * created by Gyunny 2021/10/07
 */
@Getter @Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus; // 주문 상태 (ORDER, CANCEL)

}
