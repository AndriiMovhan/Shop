package com.example.shop.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

import static com.example.shop.repository.CustomIdentityGenerator.CUSTOM_IDENTITY_GENERATOR;
import static com.example.shop.repository.CustomIdentityGenerator.CUSTOM_IDENTITY_GENERATOR_FULLY_QUALIFIED_NAME;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(schema = "public", name = "good")
public class Good {

    @Id
    @GenericGenerator(
            name = CUSTOM_IDENTITY_GENERATOR,
            strategy = CUSTOM_IDENTITY_GENERATOR_FULLY_QUALIFIED_NAME
    )
    @GeneratedValue(
            generator = CUSTOM_IDENTITY_GENERATOR,
            strategy = IDENTITY
    )
    @Column(name = "good_id")
    private Integer id;


    @Column(name = "good_name")
    private String name;

    @Column(name = "good_price")
    private Integer price;

    @Builder.Default
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "category_goods",
            joinColumns = @JoinColumn(name = "good_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Collection<Category> categories = new ArrayList<>();
}
