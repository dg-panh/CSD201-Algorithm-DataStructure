/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen_suggestion;

import backtrack_gen.BackTrackGenerator;
import backtrack_gen.Configuration;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PC
 */
public class ProductConsultantProblem {
    double maxBudget;
    int noProduct;
    ArrayList<ArrayList<Product>> domains;
    boolean solved = false;
    ArrayList<Suggestion> solutions;

    public ProductConsultantProblem(double maxBudget) {
        this.maxBudget = maxBudget;
        noProduct = 0;
        domains = new ArrayList<>();
        solutions = new ArrayList<>();
    }
    
    public void addRequest(ArrayList<Product> domain) {
        noProduct++;
        domains.add(domain);
    }
    
    public Suggestion getSuggestion(Configuration conf) {
        Suggestion suggestion = new Suggestion();
        double sumCost = 0;
        for (int i = 0; i < conf.size(); i++) {
            ArrayList<Product> domain = domains.get(i);
            int productIndex = conf.get(i);
            Product p = domain.get(productIndex);
            suggestion.add(p);
            sumCost += domain.get(productIndex).price;
        }
        suggestion.setCost(sumCost);
        return suggestion;
    }
    
    public boolean isAccepted(Suggestion suggestion) {
        return suggestion.getCost() <= this.maxBudget;
    }
    
    public void solve() {
        solved = false;
        BackTrackGenerator gen = new BackTrackGenerator();
        for (int i = 0; i < noProduct; i++) {
            gen.addDomain(domains.get(i));
        }
        gen.init();
        Configuration config = gen.getFirstConfig();
        while (config != null) {
            Suggestion suggestion = this.getSuggestion(config);
            if (isAccepted(suggestion)) solutions.add(suggestion);
            config = gen.nextConfiguration();
        }
        solved = true;
    }
    
    public void printSolutions() {
        if (solved == false) System.out.println("The problem is not solved yet!");
        else if (solutions.isEmpty()) System.out.println("No solution!");
        else {
            System.out.printf("Maximun budget: %.0f\n", maxBudget);
            Collections.sort(solutions);
            for (int i = 0; i < solutions.size(); i++) {
                Suggestion sol = solutions.get(i);
                System.out.printf("Solution %d: %.0f\n", (i + 1), sol.getCost());
                System.out.println(sol);
            }
            System.out.println(solutions.size() + " solution(s).");
        }
    }
    
}
