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
public class ClockList extends TreeSet<Clock>{

    public ClockList() {
        super(Clock.comparator);
    }
    
    public void addClock() {
        String id, manufacturer;
        int price;
        Clock c;
        do {
            id = Validation.getID("Input clock's id (CXXX): ", "The format of id is CXXX (X stands for a digit)", "^[C|c]\\d{3}$");
            c = search(id);
            if (c.getId().equalsIgnoreCase(id)) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (c.getId().equalsIgnoreCase(id));
        manufacturer = Validation.getString("Input clock's manufacturer: ", "Manufacturer mustn't empty or contains all whitespace characters. Please input clock's manufact again!", 1, 15);
        price = Validation.getAnInteger("Input clock's price: ", "Price must be from 1 to 999999. Please input price again!", 1, 99999);
        if(this.add(new Clock(id, manufacturer, price)) == true)
            System.out.println("A clock information is added successfully!");
        else
            System.out.println("A clock information is added failed!");
        
    }
    
    public Clock search(String id) {
        return this.ceiling(new Clock(id));
    }
    
    public void searchClock() {
        if (this.isEmpty()) {
            System.out.println("The list of clock is empty. Please add a new clock!");
            return;
        }

        String id;
        Clock x;

        id = Validation.getID("Input clock's id (CXXX): ", "The format of id is CXXX (X stands for a digit)", "^[C|c]\\d{3}$");
        x = search(id);
        System.out.println("------------------------------------");
        if (x == null || !x.getId().equalsIgnoreCase(id)) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the clock that you want to search");
            String header = String.format("|%-4s|%-15s|%5s|", "ID", "MANUFACTURER", "PRICE");
            System.out.println(header);
            System.out.println(x);
        }
    }
    
    public void displayAll() {
        if (this.isEmpty()) {
            System.out.println("The list of clock is empty. Nothing to print");
            return;
        }
        System.out.println("------------------------------------");
        System.out.println("Here is the clock list");
        String header = String.format("|%-4s|%-15s|%5s|", "ID", "MANUFACTURER", "PRICE");
        System.out.println(header);
        Iterator it = this.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
