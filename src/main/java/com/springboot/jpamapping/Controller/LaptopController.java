package com.springboot.jpamapping.Controller;

import com.springboot.jpamapping.model.Laptop;
import com.springboot.jpamapping.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/laptop",method = RequestMethod.GET)

public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping("/save")
    public ResponseEntity<String > saveLaptop(@RequestBody Laptop laptop) {
        Integer lid= laptopService.saveLaptop(laptop);
        return new ResponseEntity<String>("Laptop with id :"+lid+ " has been added", HttpStatus.OK);

    }
    @GetMapping("/laptopList")
    public  ResponseEntity<List<Laptop>> getAllLaptopDetail(){
        List<Laptop> list =laptopService.getAllLaptop();
        return new ResponseEntity<List<Laptop>>(list,HttpStatus.OK);
    }
    @GetMapping("/getLaptopById/{lid}")
    public  ResponseEntity<Laptop> getLaptopByID(@PathVariable Integer lid){
        Laptop id= laptopService.getLaptopById(lid);
        return new ResponseEntity<Laptop>(id,HttpStatus.OK);
    }

    @PutMapping("/updateLaptop/{lid}")
    public ResponseEntity<String> updateLaptop(@PathVariable Integer lid , @RequestBody Laptop laptop){
        Laptop laptopFromDb = laptopService.getLaptopById(lid);
        laptopFromDb.setBrand(laptop.getBrand());
        Integer id=laptopService.saveLaptop(laptopFromDb);
        return new ResponseEntity<String>("Laptop with 'brand' "+lid+" has been updated",HttpStatus.OK);

    }

}

