package com.example.hello;

import static org.assertj.core.api.Assertions.*;

import com.example.hello.model.onemany.bidirection.Department;
import com.example.hello.model.onemany.bidirection.Professor;
import com.example.hello.model.onemany.unidirection.Category;
import com.example.hello.model.onemany.unidirection.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@DataJpaTest
public class OneToManyTest {
    @Autowired private EntityManager em;

    @Test @Transactional
    public void testUniDirection(){
        Category homeAppliance=new Category("Home Appliance");
        Product fridge=new Product("Fridge",homeAppliance);
        em.persist(fridge);
        assertThat(fridge.getCategory()).isEqualTo(homeAppliance);
        em.flush();
    }

    @Test @Transactional
    public void testBiDirection(){
        Department mathDepth=new Department("Math");
        Professor newton=new Professor("New Ton");
        Professor einstein=new Professor("Einstein");
        mathDepth.add(newton);
        mathDepth.add(einstein);
        em.persist(mathDepth);
        em.flush();
        assertThat(mathDepth.getProfessors()).hasSize(2);

        em.remove(newton);
        em.flush();
        assertThat(mathDepth.getProfessors()).hasSize(1);

        em.remove(mathDepth);
        em.flush();
        assertThat(einstein.getDepartment()).isNull();

        Department physic=new Department("Physics");
        physic.add(einstein);
        assertThat(physic.getProfessors()).hasSize(1);
        assertThat(einstein.getDepartment()).isEqualTo(physic);


    }

}
