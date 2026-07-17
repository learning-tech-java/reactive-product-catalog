package com.example.reactiveproductcatalog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table("product")
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
