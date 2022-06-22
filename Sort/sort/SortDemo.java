package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author truongletuankiet <truongletuankiet.longan@gmail.com>
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