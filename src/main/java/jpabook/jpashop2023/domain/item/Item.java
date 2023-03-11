package jpabook.jpashop2023.domain.item;

import jpabook.jpashop2023.domain.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속하는 부모에 상속 전략을 표시해둔다
@DiscriminatorColumn(name="dtype")  //구분코드값 설정
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
