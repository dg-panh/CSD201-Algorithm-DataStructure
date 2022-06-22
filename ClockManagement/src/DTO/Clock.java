/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author P.anh
 */
public class Clock {
    String id, manufact;
    int price, guarantee;

    public Clock(String id) {
        this.id = id;
    }

    public Clock(String id, String manufact, int price, int guarantee) {
        this.id = id;
        this.manufact = manufact;
        this.price = price;
        this.guarantee = guarantee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public void output() {
        System.out.printf("|%4s|%15s|%6d|%9d|\n", id, manufact, price, guarantee);
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equalsIgnoreCase(((Clock)obj).id); 
    }
    
}
