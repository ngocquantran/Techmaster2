package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepo;
import static org.assertj.core.api.Assertions.*;

import com.example.demo.repository.CountCarBrand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;


@DataJpaTest
public class CarTest {
    @Autowired
    private EntityManager em;

    @Autowired private CarRepo carRepo;

    @Test
    void testQueryUsingEntityManager(){
//Chú ý ở đây phải dùng tên của entity chứ không không dùng tên bảng trong CSDL
        Query jpqlQuery = em.createQuery("SELECT o FROM oto as o WHERE o.id=:id");  //Đây là JPQL
        jpqlQuery.setParameter("id", 1L);
        Car car = (Car) jpqlQuery.getSingleResult();
        System.out.println(car);

    }

    @Test
    void testTypeQuery(){
        TypedQuery<Car> query=em.createQuery("select o from oto as o where o.id=:id",Car.class);
        query.setParameter("id",2L);
        Car car= query.getSingleResult();
        System.out.println(car);

    }

    @Test
    void testNativeQuery(){
        Query query=em.createNativeQuery("select * from car c where c.id=:id",Car.class).setParameter("id",3L);
        Car car=(Car) query.getSingleResult();
        System.out.println(car);

    }

    @Test
    void findById(){
        Optional<Car> car=carRepo.findById(5L);
        assertThat(car.get()).isNotNull();
        assertThat(car.get().getYears()).isEqualTo(2001);
    }

    @Test
    void findByModelAndYears(){
        Optional<Car> car=carRepo.findByModelAndYears("Corvette",1953);
        assertThat(car.get().getId()).isEqualTo(10L);
        Optional<Car> car2=carRepo.findByModelAndYears("Corvet",1953);
        assertThat(car2).isNotPresent();
    }

    @Test
    void findByOderByYears(){
        List<Car> cars=carRepo.findByOrderByYearsDesc();
      assertThat(cars).isSortedAccordingTo((c1,c2)->c2.getYears()-c1.getYears());
 //       assertThat(cars).isSortedAccordingTo((c1,c2)->c1.getYears()-c2.getYears());

    }

    @Test
    void listCarIn2009(){
        List<Car> cars=carRepo.listCarsIn2009();
        assertThat(cars).extracting(Car::getYears).containsOnly(2009);
    }

    @Test
    void listCarInYear(){
        List<Car> cars=carRepo.listCarsInYear(1994);
        assertThat(cars).extracting(Car::getYears).containsOnly(1994);

    }

    @Test
    void findByYears(){
        List<Car> cars=carRepo.findCarsByYears(1994);
        assertThat(cars).extracting(Car::getYears).containsOnly(1994);
        System.out.println(cars);
    }

    @Test
    void countBrandFrequency(){
     List<CountCarBrand> counts=carRepo.countBrand();
     counts.stream().forEach(System.out::println);

    }

    @Test
    void top5brand(){
        List<CountCarBrand> top5=carRepo.topBrand(PageRequest.of(0,5));
        top5.stream().forEach(System.out::println);
    }


}
