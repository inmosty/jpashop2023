package jpabook.jpashop2023.domain.item;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Slf4j
@DiscriminatorValue("A") //구분코드값 만들기
@Entity
public class Album extends Item{
    private String artist;
    private String etc;
}
