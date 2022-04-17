package com.springboot.jpamapping.service;

import com.springboot.jpamapping.model.Laptop;
import com.springboot.jpamapping.model.Student;

import java.util.List;

public interface LaptopService {
    public  Integer saveLaptop(Laptop laptop);

    public List<Laptop> getAllLaptop();

    public  Laptop getLaptopById(Integer lid);
    public void  deleteLaptop(Integer lid);
}
