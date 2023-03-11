package jpabook.jpashop2023.domain.item;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Slf4j
@DiscriminatorValue("M") //구분코드값 만들기
@Entity
public class Movie extends Item{
    private String director;
    private String actor;

}
