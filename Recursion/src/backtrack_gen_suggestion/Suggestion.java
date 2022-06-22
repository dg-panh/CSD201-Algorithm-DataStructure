/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen_suggestion;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Suggestion extends ArrayList<Product> implements  Comparable<Suggestion> {
    double cost;

    public Suggestion() {
        super();
        this.cost = 0;
    }
    
    @Override
    public int compareTo(Suggestion o) {
        if (this.cost < o.cost) return -1;
        if (this.cost > o.cost) return 1;
        return 0;
    }

    @Override
    public String toString() {
        String result = "";
        for (Product p : this) {
            result += p ;
        }
        return result;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
