package com.example.reactiveproductcatalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("products")
public class ProductEntity {

    /**
     * Идентификатор товара
     */
    @Id
    @Column("id")
    private UUID id;

    /**
     * Код товара
     */
    @Column("code")
    private String code;

    /**
     * Наименование товара
     */
    @Column("name")
    private String name;

    /**
     * Цена товара
     */
    @Column("price")
    private BigDecimal price;

}
