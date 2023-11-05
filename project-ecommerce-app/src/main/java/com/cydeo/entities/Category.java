package com.cydeo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Category extends BaseEntity{
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_category_rel",
    joinColumns = @JoinColumn(name = "p_id"),
    inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Product> productList;

}
