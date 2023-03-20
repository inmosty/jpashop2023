package jpabook.jpashop2023.service;

import jpabook.jpashop2023.domain.Delivery;
import jpabook.jpashop2023.domain.Member;
import jpabook.jpashop2023.domain.Order;
import jpabook.jpashop2023.domain.OrderItem;
import jpabook.jpashop2023.domain.item.Item;
import jpabook.jpashop2023.repository.ItemRepository;
import jpabook.jpashop2023.repository.MemberRepository;
import jpabook.jpashop2023.repository.OrderRepository;
import jpabook.jpashop2023.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**주문*/
    @Transactional
    public Long order(Long memberId,Long itemId,int count){
        //엔티티 조회
        Member member = memberRepository.findById(memberId).get();
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }
    /**취소*/
    @Transactional
    public void cancelOrder(Long orderId){
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);

        //주문취소
        order.cancel();
    }

    //검색
    public List<Order> findOrders(OrderSearch orderSearch){
        //return orderRepository.findAllByString(orderSearch);
        return orderRepository.findAll(orderSearch);
    }

}
