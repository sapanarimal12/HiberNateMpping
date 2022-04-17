package com.springboot.jpamapping.model;

import javax.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer lid;

    @Column(name = "Brand")
    private String brand;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private  Student student;

    public  Laptop(){

    }

    public Integer getLid() {
        return lid;
    }

        public void setLid(Integer lid) {
            this.lid = lid;
        }

        public Laptop(String brand) {
            this.brand = brand;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
}
