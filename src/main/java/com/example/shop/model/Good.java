package com.example.shop.model;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "good_id")
    private Integer id;

    @Column(name = "good_name")
    private String name;

    @Column(name = "good_price")
    private Integer price;
}
