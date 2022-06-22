
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class SortDemo {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("ID004", "Michel", 400));
        list.add(new Employee("ID001", "Helen", 200));
        list.add(new Employee("ID003", "Hemming", 400));
        System.out.println("Sorting on IDs ascending: ");
        Collections.sort(list);
        System.out.println(list);
        System.out.println("Sorting on descending salary then ascending IDs: ");
        Collections.sort(list, Employee.compartObj);
        System.out.println(list);
    }
}
