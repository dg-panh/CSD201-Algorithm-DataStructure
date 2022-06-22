/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.Stack;

/**
 *
 * @author PC
 */
public class RecurEliminateDemo {
    public static String cur_convert(int n, int base) {
        if ( n == 0) return "0";
        return cur_convert(n / base, base) + Character.forDigit(n % base, base);
    }
    
    public static String convert2(int n, int base) {
        String result = "";
        do {
            result = Character.forDigit(n % base, base) + result;
            n /= base;
        } while (n > 0);
        return result;
    }
    
    public static String convert3(int n, int base) {
        Stack<Character> stk = new Stack();
        do {
            stk.push(Character.forDigit(n % base, base));
            n /= base;
        } while (n > 0);
        String result = "";
        while (!stk.empty()) result += stk.pop();
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("10-base: " + cur_convert(122, 10));
        System.out.println("2-base: " + cur_convert(122, 2));
        System.out.println("8-base: " + cur_convert(122, 8));
        System.out.println("16-base: " + cur_convert(122, 16));
        String s1 = cur_convert(122, 16);
        String s2 = convert2(122, 16);
        String s3 = convert3(122, 16);
        System.out.println(s1 + ", " + s2 + ", " + s3);
    }
}
