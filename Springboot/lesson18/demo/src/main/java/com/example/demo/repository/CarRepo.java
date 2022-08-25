package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findByModel(String model);
    Optional<Car> findById(long id);

    List<Car> findCarsByYears(int year);

    List<Car> findByOrderByYearsDesc();

    Optional<Car> findByModelAndYears(String model, int year);

    @Query("SELECT o FROM oto AS o WHERE o.years=2009")
    List<Car> listCarsIn2009();

    @Query("select o from oto as o where o.years=:year")
    List<Car> listCarsInYear(@Param("year")int year);


    @Query("select new com.example.demo.repository.CountCarBrand(o.brand, count (o.brand)) "+
    "from oto as o group by o.brand order by o.brand asc ")
    List<CountCarBrand> countBrand();

    @Query("select new com.example.demo.repository.CountCarBrand(o.brand, count (o.brand)) "+
            "from oto as o group by o.brand order by count (o.brand) desc ")
    List<CountCarBrand> topBrand(Pageable pageable);




















}