package jpabook.jpashop2023.domain.item;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Slf4j
@DiscriminatorValue("B") //구분코드값 만들기
@Entity
@Getter
@Setter
public class Book extends Item{
    private String author;
    private String isbn;
}
