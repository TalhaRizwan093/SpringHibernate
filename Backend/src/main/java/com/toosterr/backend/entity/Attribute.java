package com.toosterr.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attribute",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_Category_Attribute_Name", columnNames = {"name","category_id"})
    }
)
@Builder
@SQLRestriction("deleted = false")
public class Attribute extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL)
    private List<ProductAttribute> attributesProduct;


}
