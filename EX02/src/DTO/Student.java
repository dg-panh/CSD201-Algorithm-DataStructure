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
    String id, name;
    int mark;

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student o) {
        return id.compareToIgnoreCase(o.id);
    }

    @Override
    public String toString() {
        return String.format("|%-5s|%-15s|%4d|", id, name, mark);
    }
    
    
    
}
