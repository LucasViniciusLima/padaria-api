package com.example.springbootdocker.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    List<ItemPedido> itemPedidoList = new ArrayList<>();

    private LocalDate date;

    private BigDecimal total;

    public Pedido() {
    }
}
