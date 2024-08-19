package com.toosterr.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_attribute")
@SQLRestriction("deleted = false")
@Builder
public class ProductAttribute extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
