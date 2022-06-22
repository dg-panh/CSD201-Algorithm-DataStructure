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
public class DogsAndChickens {
    int nLegs;
    ArrayList<Configuration> solutions;
    boolean solved = false;

    public DogsAndChickens(int nLegs) {
        if (nLegs > 0) this.nLegs = nLegs;
        solutions = new ArrayList<>();
    }
    
    private boolean isAccepted(Configuration suggestion) {
        int dogs = suggestion.get(0);
        int chickens = suggestion.get(1);
        return (dogs * 4 + chickens * 2) == nLegs;
    }
    
    public void solve() {
        solved = false;
        BackTrackGenerator gen = new BackTrackGenerator();
        gen.addDomain(1, (nLegs - 2) / 4);
        gen.addDomain(1, (nLegs - 4) / 2);
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
            System.out.println("SOLUTIONS: \n<dogs, chickens>");
            for (Configuration sol : solutions) {
                System.out.println(sol);
            }
            System.out.println(solutions.size() + " solution(s).");
        }
    }
    
    public static void main(String[] args) {
        int nLegs = 100;
        DogsAndChickens prob = new DogsAndChickens(nLegs);
        prob.solve();
        prob.printSolutions();
    }
    
}
