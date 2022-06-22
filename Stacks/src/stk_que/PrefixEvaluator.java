/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stk_que;

import java.util.StringTokenizer;
import java.util.Stack;

/**
 *
 * @author PC
 */
public class PrefixEvaluator {
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
    
    public static double evaluate(String op, double n1, double n2) {
        if (op.equals("+")) return n1 + n2;
        if (op.equals("-")) return n1 - n2;
        if (op.equals("*")) return n1 * n2;
        if (op.equals("/")) {
            if (n2 == 0) throw new RuntimeException("Divide by 0!");
            return n1 / n2;
        }
        throw new RuntimeException("Operator is not supported!");
    }
    
    public static double evaluate(String exp) {
        double result = 0;
        
        StringTokenizer stk = new StringTokenizer(exp, "() ");
        Stack<String> stack = new Stack();
        Stack<Double> stack2 = new Stack<>();
        double n1, n2;
        
        while(stk.hasMoreElements()) {
            String part = stk.nextToken();
            stack.push(part);
        }
        
        while (!stack.isEmpty()) {
            String tmp = stack.pop();
            if (!isOperator(tmp)) stack2.push(Double.parseDouble(tmp));
            else {
                n1 = stack2.pop();
                n2 = stack2.pop();
                result = evaluate(tmp, n1, n2);
                stack2.push(result);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String exp = "*(3)+ *(5)(6)*(3)(4)";
        System.out.println(evaluate(exp));
    }
}
