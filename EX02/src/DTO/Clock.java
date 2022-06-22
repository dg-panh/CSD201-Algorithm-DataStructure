/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Comparator;

/**
 *
 * @author PC
 */
public class Clock {
    String id, manufacturer;
    int price;
    
    public static Comparator<Clock> comparator = new Comparator<Clock>() {
        @Override
        public int compare(Clock o1, Clock o2) {
            return o1.id.compareToIgnoreCase(o2.id);
        }
    };

    public Clock(String id) {
        this.id = id;
    }

    public Clock(String id, String manufacturer, int price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Comparator<Clock> getComparator() {
        return comparator;
    }

    public static void setComparator(Comparator<Clock> comparator) {
        Clock.comparator = comparator;
    }

    @Override
    public String toString() {
        return String.format("|%-4s|%-15s|%5d|", id, manufacturer, price);
    }
    
    
}
