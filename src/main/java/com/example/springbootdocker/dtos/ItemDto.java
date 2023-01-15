package com.example.springbootdocker.dtos;

import com.example.springbootdocker.enums.Category;
import com.example.springbootdocker.models.Item;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class ItemDto {
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    @NotBlank
    private String category;
}
