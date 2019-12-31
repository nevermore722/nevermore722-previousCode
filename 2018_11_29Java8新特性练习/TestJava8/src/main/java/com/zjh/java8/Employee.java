package com.zjh.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Integer age;
    private double salary;
    private Status status;


    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, salary);
    }

    public Employee(int id){
        this.id = id;
    }
    public Employee(int id,int age){
        this.id = id;
        this.age = age;
    }

    public Employee(int id, String name, Integer age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public enum Status{
        FREE,
        BUZY,
        VOCATION;
    }
}
