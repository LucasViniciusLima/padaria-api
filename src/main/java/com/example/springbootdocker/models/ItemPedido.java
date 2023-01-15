package com.example.springbootdocker.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
@Getter
@Setter
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    Pedido pedido;

    @ManyToOne
    Item item;

    @Column(name = "quantidade_itens")
    int quantidadeItens;

    @Column(name = "preco_atual")
    BigDecimal precoAtual;

    public ItemPedido() {
    }

}
