/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen_uses;

import backtrack_gen.BackTrackGenerator;
import backtrack_gen.Configuration;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class BuffaloesProblem {
    int noOfBuffaloes;
    int noOfBunches;
    ArrayList<Configuration> solutions;
    boolean solved = false;

    public BuffaloesProblem(int noOfBuffaloes, int noOfBunches) {
        this.noOfBuffaloes = noOfBuffaloes;
        this.noOfBunches = noOfBunches;
        solutions = new ArrayList<>();
    }
    
    private boolean isAccepted(Configuration suggestion) {
        int small = suggestion.get(0);
        int big = suggestion.get(1);
        int old = suggestion.get(2);
        if (old % 2 == 1) return false;
        int noBuffaloes = small + big + old;
        return (noBuffaloes == this.noOfBuffaloes) &&
                (small * 1 + big * 2 + old / 2 == this.noOfBuffaloes);
    }
    
    public void solve() {
        solved = false;
        BackTrackGenerator gen = new BackTrackGenerator();
        gen.addDomain(0, noOfBunches);
        gen.addDomain(0, noOfBunches / 2);
        gen.addDomain(0, noOfBunches);
        gen.init();
        Configuration suggestion = gen.getFirstConfig();
        while (suggestion != null) {
            if (isAccepted(suggestion)) solutions.add(suggestion);
            suggestion = gen.nextConfiguration();
        }
        solved = true;
    }
    
    public void printSolutions() {
        if (!solved) System.out.println("The problem is not solved yet!");
        else if (solutions.isEmpty()) System.out.println("No solution!");
        else {
            System.out.println("SOLUTIONS: \n<small, big, old>");
            for (Configuration sol : solutions) {
                System.out.println(sol);
            }
            System.out.println(solutions.size() + " solution(s).");
        }
    }
    
    public static void main(String[] args) {
        BuffaloesProblem prob = new BuffaloesProblem(50,50);
        prob.solve();
        prob.printSolutions();
    }
    
}
