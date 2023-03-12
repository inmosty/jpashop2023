package jpabook.jpashop2023.controller;

import jpabook.jpashop2023.domain.Member;
import jpabook.jpashop2023.domain.Order;
import jpabook.jpashop2023.domain.item.Item;
import jpabook.jpashop2023.repository.OrderSearch;
import jpabook.jpashop2023.service.ItemService;
import jpabook.jpashop2023.service.MemberService;
import jpabook.jpashop2023.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model){
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members",members);
        model.addAttribute("items",items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count){
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch")OrderSearch orderSearch,Model model){
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders",orders);
        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String canelOrder(@PathVariable("orderId") Long orderId ){
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
