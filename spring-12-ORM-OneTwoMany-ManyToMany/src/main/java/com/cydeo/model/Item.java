package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String code;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @ManyToMany
    private List<Cart> cartList;
}
