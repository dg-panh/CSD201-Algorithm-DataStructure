/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stk_que;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author PC
 */
public class Converter {
    
    public static void main(String[] args) {
        int num;
        System.out.print("Input a number that you want to convert: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        
        System.out.println("After convert " + num + ":");
        System.out.println(convert(num, 2) + "b");
        System.out.println(convert(num, 8) + "q");
        System.out.println(convert(num, 10) + "d");
        System.out.println(convert(num, 16) + "h");
        
    }
    
    public static String convert(int n, int base) {
        String result = "";
        //Push remainder to stacks
        Stack <Integer> stk = new Stack();
        do {
            stk.push(n % base);
            n /= base;
        } while (n > 0);
        
        //Pop values in stack then concatenate it to the result
        while (!stk.empty()) {
            int value = stk.pop();
            result += Character.forDigit(value, base); //digit in base system
        }
        return result;
    }
    
}
