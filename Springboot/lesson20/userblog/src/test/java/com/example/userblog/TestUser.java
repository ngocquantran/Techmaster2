package com.example.userblog;


import com.example.userblog.dto.BlogInfo;
import com.example.userblog.model.*;
import com.example.userblog.repository.*;
import com.github.javafaker.Cat;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class TestUser {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private IdentityCardRepo identityCardRepo;
    @Autowired
    private BlogRepo blogRepo;

    @Autowired private EntityManager em;

    @Autowired private Slugify slugify;
    @Autowired private Faker faker;
    @Autowired private Random random;

    @Test
    void save_user_identify_card(){
        for (int i=0;i<10;i++){
            User user=User.builder()
                    .name(faker.name().name())
                    .email(faker.internet().emailAddress())
                    .password(faker.internet().password(8,16))
                    .avatar(faker.avatar().image())
                    .identityCard(new IdentityCard())
                    .build();

            userRepo.save(user);
        }
        List<User> userList= userRepo.findAll();
        System.out.println(userList);
        Assertions.assertThat(userList).hasSizeGreaterThan(0);
    }

    @Test
    void save_category(){
        for (int i=0;i<10;i++){
            Category category=Category.builder()
                    .name(faker.leagueOfLegends().rank())
                    .build();
            categoryRepo.save(category);
        }
    }

    @Test
    void save_image(){
        List<User> users=userRepo.findAll();

        for (int i=0;i<150;i++){
            User userRd=users.get(random.nextInt(users.size()));
            Image img=Image.builder()
                    .url(faker.company().logo())
                    .user(userRd)
                    .build();
            imageRepo.save(img);
        }
    }

    @Test
    void save_avatar_of_user() {
        // Lấy ds user
        List<User> users = userRepo.findAll();

        users.forEach(user -> {
            List<Image> images = imageRepo.getImagesByUserId(user.getId());
            String imageRd = images.get(random.nextInt(images.size())).getUrl();
            user.setAvatar(imageRd);
            userRepo.save(user);
        });
    }

    @Test
    void save_blog(){
        List<User> users=userRepo.findAll();
        List<Category> categories=categoryRepo.findAll();

        for (int i=0;i<100;i++){
            User userRd=users.get(random.nextInt(users.size()));

            List<Image> images=imageRepo.getImagesByUserId(userRd.getId());
            String imgRd=images.get(random.nextInt(images.size())).getUrl();

            List<Category> categoriesRd=new ArrayList<>();
            for (int j=0;j<3;j++){
                Category categoryRd=categories.get(random.nextInt(categories.size()));
                if(!categoriesRd.contains(categoryRd)){
                    categoriesRd.add(categoryRd);
                }
            }
            String title=faker.lorem().sentence(10);
            Blog blog =Blog.builder().title(title)
                    .slug(slugify.slugify(title))
                    .content(faker.lorem().sentence(5))
                    .thumbnail(imgRd)
                    .categories(categoriesRd)
                    .status(random.nextInt(2))
                    .user(userRd)
                    .build();

            blogRepo.save(blog);

        }

    }

    @Test
    void save_comment() {
        List<User> users = userRepo.findAll();
        List<Blog> blogs = blogRepo.findAll();

        for (int i = 0; i < 100; i++) {
            User userRd = users.get(random.nextInt(users.size()));
            Blog blogRd = blogs.get(random.nextInt(blogs.size()));

            Comment comment = Comment.builder()
                    .content(faker.lorem().sentence(20))
                    .user(userRd)
                    .blog(blogRd)
                    .build();

            commentRepo.save(comment);
        }
    }

    @Test
    void get_all_blog_info(){
        List<BlogInfo> list=blogRepo.getAllBlogInfo();
        list.forEach(System.out::println);
    }




}
