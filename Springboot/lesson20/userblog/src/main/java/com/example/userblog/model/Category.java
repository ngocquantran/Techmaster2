package com.example.userblog.model;

import com.github.javafaker.Cat;
import lombok.*;

import javax.persistence.*;


@NamedNativeQuery(
        name = "getPopularCategories",
        query = "SELECT c.id, c.name\n" +
                "FROM category c \n" +
                "INNER JOIN\n" +
                "(\n" +
                "\tSELECT bc.categories_id as id , count(bc.blog_id) as count_blog\n" +
                "\tFROM blog_categories bc \n" +
                "\tGROUP BY bc.categories_id \n" +
                ") as temp\n" +
                "ON c.id = temp.id\n" +
                "ORDER BY temp.count_blog DESC\n" +
                "LIMIT ?1\n",
        resultClass = Category.class
)


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}