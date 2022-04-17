package com.springboot.jpamapping.service;

import com.springboot.jpamapping.model.Laptop;
import com.springboot.jpamapping.model.Student;
import com.springboot.jpamapping.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    private  static List<Laptop> list =new ArrayList<>();

    public  List<Laptop> getList(String brand){
        return list;
    }

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public Integer saveLaptop(Laptop laptop) {
        Student s=new Student();
        s.setId(3);
        laptop.setStudent(s);

        return laptopRepository.save(laptop).getLid();
    }

    @Override
    public List<Laptop> getAllLaptop() {
        return (List<Laptop>) laptopRepository.findAll();
    }

    @Override
    public Laptop getLaptopById(Integer lid) {
        return laptopRepository.findById(lid).get();
    }

    @Override
    public void deleteLaptop(Integer lid) {
        laptopRepository.deleteById(lid);

    }
}
