package com.toosterr.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category",
        uniqueConstraints = {
            @UniqueConstraint(name = "UK_category_name", columnNames = {"category_name"})
        }
)
@Builder
@SQLRestriction("deleted = false")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "category_name", unique = true, nullable = false)
    public String categoryName;
    public String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    public List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Attribute> categoryAttributes;

}
