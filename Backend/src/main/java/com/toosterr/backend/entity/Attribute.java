package com.toosterr.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attribute")
@Builder
public class Attribute extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
