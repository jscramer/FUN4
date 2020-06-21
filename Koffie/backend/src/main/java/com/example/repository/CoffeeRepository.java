package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.Coffee;
import java.util.List;


@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    List<Coffee> findByActive(long active);
}
