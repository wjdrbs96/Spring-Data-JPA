package com.example.jpa.service;

import com.example.jpa.domain.Address;
import com.example.jpa.domain.Member;
import com.example.jpa.domain.Order;
import com.example.jpa.domain.OrderStatus;
import com.example.jpa.domain.item.Book;
import com.example.jpa.domain.item.Item;
import com.example.jpa.exception.NotEnoughStockException;
import com.example.jpa.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * created by Gyunny 2021/10/07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void 상품주문() {
        Member member = new Member();
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);

        Item book = new Book();
        book.setName("JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
        assertEquals("주문한 상품 종류 수가 정확해야 한다.", 1, getOrder.getOrderItems().size());
        assertEquals("주문 가격은 가격 * 수량 이다", 10000 * orderCount, getOrder.getTotalPrice());
        assertEquals("주문 수량 만큼 재고가 줄어야 한다.", 8, book.getStockQuantity());
    }

    @Test
    public void 주문취소() {
        Member member = new Member();
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);

        Item book = new Book();
        book.setName("JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        orderService.cancelOrder(orderId);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("주문 취소는 CANCEL 이다.", OrderStatus.CANCEL, getOrder.getStatus());
        assertEquals("주문이 취소된 상품은 그만큼 재고가 증가해야 한다.", 10, book.getStockQuantity());
    }

    @Test
    public void 상품주문_재고수량초과() {
        Member member = new Member();
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);

        Item book = new Book();
        book.setName("JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);

        int orderCount = 11;

        try {
            orderService.order(member.getId(), book.getId(), orderCount);
        } catch (NotEnoughStockException e) {
            return;
        }

        fail("주문 예외!!");
    }

}