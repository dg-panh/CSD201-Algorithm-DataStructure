/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GUI.Menu;
import java.util.LinkedList;
import util.Validation;

/**
 *
 * @author P.anh
 */
public class ClockList extends LinkedList<Clock> {

    public void addClock() {
        String id, manufact;
        int price, guarantee;
        int pos;
        do {
            id = Validation.getID("Input clock's id (CXXX): ", "The format of id is CXXX (X stands for a digit)", "^[C|c]\\d{3}$");
            pos = searchClockReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        manufact = Validation.getString("Input clock's manufact: ", "Manufact mustn't empty or contains all whitespace characters. Please input clock's manufact again!", 1, 15).toUpperCase();
        price = Validation.getAnInteger("Input clock's price: ", "Price must be from 1 to 999999. Please input price again!", 1, 999999);
        guarantee = Validation.getAnInteger("Input clock's number of guarantee month: ", "Number of guarantee month must be from 1 to 99. Please input number of guarantee month again!", 1, 99);
        if(this.add(new Clock(id, manufact, price, guarantee)) == true)
            System.out.println("A clock information is added successfully!");
        else
            System.out.println("A clock information is added failed!");
        
    }

    public void displayAll() {
        if (this.isEmpty()) {
            System.out.println("The list of clock is empty. Nothing to print");
            return;
        }
        System.out.println("------------------------------------");
        System.out.println("Here is the clock list");
        String header = String.format("|%4s|%15s|%6s|%9s|", "ID", "MANUFACT", "PRICE", "GUARANTEE");
        System.out.println(header);
        this.forEach(c -> {
            c.output();
        });
    }
    
    public void displayPriceRange() {
        if (this.isEmpty()) {
            System.out.println("The list of clock is empty. Nothing to print");
            return;
        }
        
        int lowerBound, upperBound;
        System.out.println("Range of price");
        lowerBound = Validation.getAnInteger("From: ", "Must be from 1 to 999999. Please input again!", 1, 999999);
        upperBound = Validation.getAnInteger("To: ", "Must be from 1 to 999999. Please input again!", 1, 999999);
        
        if(lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        
        System.out.println("------------------------------------");
        System.out.println("Here is a list of clocks priced from " + lowerBound + " to " + upperBound);
        String header = String.format("|%4s|%15s|%6s|%9s|", "ID", "MANUFACT", "PRICE", "GUARANTEE");
        System.out.println(header);
        for (Clock c : this) {
            int price = c.getPrice();
            if(price >= lowerBound && price <= upperBound) 
                c.output();
        }
    }

    public void searchClock() {
        if (this.isEmpty()) {
            System.out.println("The list of clock is empty. Please add a new clock!");
            return;
        }

        String id;
        Clock x;

        id = Validation.getID("Input clock's id (CXXX): ", "The format of id is CXXX (X stands for a digit)", "^[C|c]\\d{3}$");
        x = searchClockReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the clock that you want to search");
            String header = String.format("|%4s|%15s|%6s|%9s|", "ID", "MANUFACT", "PRICE", "GUARANTEE");
            System.out.println(header);
            x.output();
        }
    }

    public int searchClockReturnPos(String id) {
        return this.indexOf(new Clock(id)); //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
    }

    public Clock searchClockReturnObj(String id) {
        for (Clock c : this) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public void updateClock() {
        if (this.isEmpty()) {
            System.out.println("The list of clock is empty. Please add a new clock!");
            return;
        }

        String id, newManufact;
        int newPrice, newGuarantee;
        Clock x;
        id = Validation.getID("Input clock's id (CXXX): ", "The format of id is CXXX (X stands for a digit)", "^[C|c]\\d{3}$");
        x = searchClockReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the clock before updating");
            String header = String.format("|%4s|%15s|%6s|%9s|", "ID", "MANUFACT", "PRICE", "GUARANTEE");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Clock Update");
            updateMenu.addNewOption("1. Update clock's manufact");
            updateMenu.addNewOption("2. Update clock's price");
            updateMenu.addNewOption("3. Update clock's number of guarantee month");
            updateMenu.addNewOption("4. Quit");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new manufact");
                        newManufact = Validation.getString("Input clock's manufact: ", "Manufact mustn't empty or contains all whitespace characters. Please input clock's manufact again!", 1, 15).toUpperCase();
                        x.setManufact(newManufact);
                        System.out.println("The clock's manufact is updated successfully! Here is the clock after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new price");
                        newPrice = Validation.getAnInteger("Input clock's price: ", "Price must be from 1 to 999999. Please input price again!", 1, 999999);
                        x.setPrice(newPrice);
                        System.out.println("The clock's manufact is updated successfully! Here is the clock after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        System.out.println("You are required to input a new number of guarantee month");
                        newGuarantee = Validation.getAnInteger("Input clock's number of guarantee month: ", "Number of guarantee month must be from 1 to 99. Please input number of guarantee month again!", 1, 99);
                        x.setGuarantee(newGuarantee);
                        System.out.println("The clock's number of guarantee month is updated successfully! Here is the clock after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 4:
                        break;
                }
            } while (choice != 4);
        }
    }

    public void removeClock() {
        if (this.isEmpty()) {
            System.out.println("The list of clock is empty. Please add a new clock!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getID("Input clock's id (CXXX): ", "The format of id is CXXX (X stands for a digit)", "^[C|c]\\d{3}$");
        pos = searchClockReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%4s|%15s|%6s|%9s|", "ID", "MANUFACT", "PRICE", "GUARANTEE");
            System.out.println(header);
            this.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this clock? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                this.remove(pos);
                System.out.println("The selected customer is removed successfully!");
            }
        }
    }
}
