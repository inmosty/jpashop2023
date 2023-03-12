package jpabook.jpashop2023.repository;

import jpabook.jpashop2023.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter @Setter
public class OrderSearch {
    private String memberName;  //회원 이름
    private OrderStatus orderStatus;//주문 상태[ORDER,CANCEL]
}

