package com.example.springbootdocker.models;

import com.example.springbootdocker.enums.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Item() {
    }
}
