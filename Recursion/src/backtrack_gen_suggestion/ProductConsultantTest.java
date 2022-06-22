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
public class ProductConsultantTest {
    public static void main(String[] args) {
        int noOfTVs = 3;
        int noOfRefrigerators = 2;
        int noOfFans = 1;
        ArrayList<Product> tvDom = new ArrayList<>();
        tvDom.add(new Product("TV01", "Sony 42", 4800000));
        tvDom.add(new Product("TV02", "LG 42", 3800000));
        tvDom.add(new Product("TV03", "Samsung 48", 7500000));
        tvDom.add(new Product("TV04", "Sony 55", 14800000));
        tvDom.add(new Product("TV05", "LG 65", 16800000));
        tvDom.add(new Product("TV06", "Samsung 55", 11200000));
        
        ArrayList<Product> rfDom = new ArrayList<>();
        rfDom.add(new Product("RF01", "National 420", 11800000));
        rfDom.add(new Product("RF02", "General 380", 10800000));
        rfDom.add(new Product("RF03", "Panasonic 180", 3500000));
        rfDom.add(new Product("RF04", "Hitachi 380", 9800000));
        rfDom.add(new Product("RF05", "Beko 250", 6700000));
        
        ArrayList<Product> fanDom = new ArrayList<>();
        fanDom.add(new Product("F01", "National F11", 800000));
        fanDom.add(new Product("F02", "General F02", 750000));
        fanDom.add(new Product("F03", "Panasonic F80", 1050000));
        
        double budget = 30000000;
        ProductConsultantProblem problem = new ProductConsultantProblem(budget);
        
        for (int i = 0; i < noOfTVs; i++) {
            problem.addRequest(tvDom);
        }
        for (int i = 0; i < noOfRefrigerators; i++) {
            problem.addRequest(rfDom);
        }
        for (int i = 0; i < noOfFans; i++) {
            problem.addRequest(fanDom);
        }
        
        problem.solve();
        problem.printSolutions();
    }
}
