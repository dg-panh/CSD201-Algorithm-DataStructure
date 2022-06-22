/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Clock;
import DTO.ClockList;

/**
 *
 * @author PC
 */
public class ClockManager {
    public static void main(String[] args) {
        Menu menu = new Menu("Clock Management");
        menu.addNewOption("1. Add information of new clock");
        menu.addNewOption("2. Show information all clocks");
        menu.addNewOption("3. Search for clock information by ID");
        menu.addNewOption("4. Quit");
        
        ClockList list = new ClockList();
        list.add(new Clock("C009", "Nam HN", 120));
        list.add(new Clock("C003", "SG", 125));
        list.add(new Clock("C007", "STG", 70));
        list.add(new Clock("C001", "Seiko", 210));
        list.add(new Clock("C004", "Citizen", 180));
        
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch(choice) {
                case 1:
                    System.out.println("You have requested to add information of new clock");
                    list.addClock();
                    break;
                case 2:
                    System.out.println("You have requested to show information all clocks");
                    list.displayAll();
                    break;
                case 3:
                    System.out.println("You have requested to search for clock information by ID");
                    list.searchClock();
                    break;
                case 4:
                    break;
            }
        } while(choice != 4);
    }
}
