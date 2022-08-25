package com.example.demo;


import com.example.demo.model.id.Bar;
import com.example.demo.model.naturalId.Person;
import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@DataJpaTest
public class IdTest {
    @Autowired private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;

    @Test
    public void randomIDGenerator(){
        Bar bar=new Bar();
        bar.setName("Tôi là bar");
        entityManager.persist(bar);
        System.out.println("Đây là ID: "+bar.getId());
        Assertions.assertThat(bar.getId()).hasSize(10);
    }

    @Test  @Transactional
    public void naturalId(){
        Person person1=new Person();
        person1.setEmail("quan@gmail.com");
        entityManager.persist(person1);
        Session session=entityManager.unwrap(Session.class);
        Person person2=session.byNaturalId(Person.class).using("email","quan@gmail.com").load();
        Assertions.assertThat(person2).isEqualTo(person1);

    }


}
