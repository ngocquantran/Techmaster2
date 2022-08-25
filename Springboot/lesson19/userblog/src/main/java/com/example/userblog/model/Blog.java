package com.example.userblog.model;

import com.example.userblog.dto.BlogInfo;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SqlResultSetMapping(
        name = "listBlogInfo",
        classes = @ConstructorResult(
                targetClass = BlogInfo.class,
                columns = {
                        @ColumnResult(name = "id",type = String.class),
                        @ColumnResult(name = "title",type = String.class),
                        @ColumnResult(name = "slug",type = String.class),
                        @ColumnResult(name = "thumbnail",type = String.class),
                        @ColumnResult(name = "publish_at",type = String.class),
                        @ColumnResult(name = "count_comment",type = Integer.class),
                        @ColumnResult(name = "author",type = String.class),



                }
        )
)
@NamedNativeQuery(
        name = "getAllBlogInfo",
        resultSetMapping = "listBlogInfo",
        query = "SELECT b.id, b.title ,b.slug ,b.thumbnail ,\n" +
                "DATE_FORMAT(b.publish_at,'%d,%m,%Y') as publish_at ,\n" +
                "JSON_OBJECT(\"id\",u.id,\"name\",u.name) as author,\n" +
                "COUNT(c.id) as count_comment \n" +
                "FROM blog b \n" +
                "LEFT JOIN `User` u \n" +
                "ON b.user_id =u.id \n" +
                "LEFT JOIN Comment c \n" +
                "ON b.id =c.blog_id \n" +
                "WHERE b.status =1\n" +
                "GROUP BY b.id \n" +
                "ORDER BY b.publish_at DESC"
)


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "blog")
@Entity
public class Blog {
    @Id
    @GeneratedValue(generator = "custom_generate")
    @GenericGenerator(name = "custom_generate",strategy = "com.example.userblog.generic.CustomIdGenerator")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "content", nullable = false,columnDefinition = "TEXT")
    private String content;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP")
    private LocalDateTime createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP")
    private LocalDateTime  updateAt;

    @Column(name = "publish_at",columnDefinition = "TIMESTAMP")
    private LocalDateTime  publishAt;

    @Column(name = "status",columnDefinition = "int default 0")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany()
    @JoinTable(name = "blog_categories",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private List<Category> categories = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createAt=LocalDateTime.now().minusMonths(2);
        updateAt=createAt;
        if (status==1){
            publishAt=updateAt;
        }

    }
}