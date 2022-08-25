package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;
import java.time.LocalDate;

@DataJpaTest
public class PersonTest {
    @Autowired private EntityManager em;

    @Autowired private PersonRepo personRepo;

    @Test @Transactional
    public void testAge(){
        Person p1=new Person("Quân","Lập trình","Male","Hà Nam",15000000,LocalDate.of(1994,07,31));
        em.persist(p1);
        em.flush();
//        Assertions.assertThat(p1.getSex()).isTrue();
       Assertions.assertThat(p1.getAge()).isEqualTo(27);
       Long id= p1.getId();
        Person person=em.find(Person.class,id);
        Assertions.assertThat(person).isEqualTo(p1);
        person.setBirthday(LocalDate.of(1995,07,31));
        em.merge(person);
        em.flush();
        Assertions.assertThat(p1.getAge()).isEqualTo(26);
        Assertions.assertThat(person).isEqualTo(p1);

    }

    @Test
    public void testPersonRepo(){
        Person p1=new Person("Quân","Lập trình viên","Male","Hà Nam",15000000, LocalDate.of(1994,07,31));
        personRepo.save(p1);
        Long id=p1.getId();

        Person p2=personRepo.findById(id).get();
        Assertions.assertThat(p2).isEqualTo(p1);

        personRepo.delete(p2);
        Assertions.assertThat(personRepo.existsById(id)).isFalse();

    }

    @Test @Transactional
    public void testInsertQuery(){
        LocalDate date=LocalDate.of(1995,12,15);
        em.createNativeQuery("INSERT INTO person (id,name,job,gender,city,salary,birthday) VALUES (?,?,?,?,?,?,?)",Person.class)
                .setParameter(1,100)
                .setParameter(2,"Lan Anh")
                .setParameter(3,"Kế toán")
                .setParameter(4,"Male")
                .setParameter(5,"Hà Nam")
                .setParameter(6,15000000)
                .setParameter(7, date)
                .executeUpdate();
        em.flush();
        Person p=em.find(Person.class,100L);
        Assertions.assertThat(p).isNotNull();
    }
}
