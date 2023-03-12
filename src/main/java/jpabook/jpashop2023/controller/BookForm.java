package jpabook.jpashop2023.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
public class BookForm {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;
}
