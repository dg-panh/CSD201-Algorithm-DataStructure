/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Iterator;
import java.util.TreeSet;
import util.Validation;

/**
 *
 * @author PC
 */
public class StudentList extends TreeSet<Student>{

    public StudentList() {
        super();
    }
    
    public void addStudent() {
        String id, name;
        int mark;
        Student stu;
        do {
            id = Validation.getID("Input student's id (SEXXX): ", "The format of id is SEXXX (X stands for a digit)", "^[S|s][E|e]\\d{3}$");
            stu = search(id);
            if (stu.getId().equalsIgnoreCase(id)) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (stu.getId().equalsIgnoreCase(id));
        name = Validation.getString("Input student's name: ", "Name mustn't empty or contains all whitespace characters. Please input name again!", 1, 15);
        mark = Validation.getAnInteger("Input student's mark: ", "Mark must be from 1 to 100. Please input price again!", 1, 100);
        if(this.add(new Student(id, name, mark)) == true)
            System.out.println("A student information is added successfully!");
        else
            System.out.println("A student information is added failed!");
        
    }
    
    public Student search(String id) {
        return this.ceiling(new Student(id));
    }
    
    public void searchStudent() {
        if (this.isEmpty()) {
            System.out.println("The list of student is empty. Please add a new student!");
            return;
        }

        String id;
        Student x;

        id = Validation.getID("Input student's id (SEXXX): ", "The format of id is SEXXX (X stands for a digit)", "^[S|s][E|e]\\d{3}$");
        x = search(id);
        System.out.println("------------------------------------");
        if (x == null || !x.getId().equalsIgnoreCase(id)) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the student that you want to search");
            String header = String.format("|%-5s|%-15s|%4s|", "ID", "NAME", "MARK");
            System.out.println(header);
            System.out.println(x);;
        }
    }
    
    public void displayAll() {
        if (this.isEmpty()) {
            System.out.println("The list of student is empty. Nothing to print");
            return;
        }
        System.out.println("------------------------------------");
        System.out.println("Here is the student list");
        String header = String.format("|%-5s|%-15s|%4s|", "ID", "NAME", "MARK");
        System.out.println(header);
        Iterator it = this.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
}
