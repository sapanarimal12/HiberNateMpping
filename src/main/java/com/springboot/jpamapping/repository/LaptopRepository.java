package com.springboot.jpamapping.repository;

import com.springboot.jpamapping.model.Laptop;
import com.springboot.jpamapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Integer> {

}
