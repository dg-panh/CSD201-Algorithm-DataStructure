/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Student;
import DTO.StudentList;

/**
 *
 * @author PC
 */
public class StudentManager {
    public static void main(String[] args) {
        Menu menu = new Menu("Student Management");
        menu.addNewOption("1. Add information of new student");
        menu.addNewOption("2. Show information all students");
        menu.addNewOption("3. Search for student information by ID");
        menu.addNewOption("4. Quit");
        
        StudentList list = new StudentList();
        list.add(new Student("SE009", "Nam", 4));
        list.add(new Student("SE001", "Phuc", 7));
        list.add(new Student("SE006", "Vinh", 8));
        list.add(new Student("SE002", "Truong", 9));
        list.add(new Student("SE005", "Dat", 2));
        
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch(choice) {
                case 1:
                    System.out.println("You have requested to add information of new student");
                    list.addStudent();
                    break;
                case 2:
                    System.out.println("You have requested to show information all students");
                    list.displayAll();
                    break;
                case 3:
                    System.out.println("You have requested to search for student information by ID");
                    list.searchStudent();
                    break;
                case 4:
                    break;
            }
        } while(choice != 4);
    }
}
