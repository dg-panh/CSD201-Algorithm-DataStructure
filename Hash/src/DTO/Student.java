/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class Student implements Comparable<Student>{

    String code, name;
    int mark;

    public Student(String code, String name, int mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return code + ", " + name + ", " + mark ;
    }
    
    @Override
    public int compareTo(Student o) {
        return code.compareToIgnoreCase(o.code);
    }
    
    public void update() {
        
    }
    
}
