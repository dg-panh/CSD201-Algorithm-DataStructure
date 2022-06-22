/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author PC
 */
public class RecurDemo {
    public static double factorial(int n) {
        if (n < 2) return 1;
        return n * factorial(n - 1);
    }
    
    public static int fibo(int n) {
        if (n < 2) return 1;
        return fibo(n - 2) + fibo(n -1);
    }
    
    public static boolean testFibo(int x) {
        if (x < 1) return false;
        int aFibo = 1;
        int n = 2;
        while (aFibo < x) aFibo = fibo(n++);
        return x == aFibo;
    }
    
    public static double ap(int n, double a, double d) {
        if (n == 1) return a;
        return d + ap(n - 1, a, d);
    }
    
    public static double gp(int n, double a, double q) {
        if (n == 1) return a;
        return q * gp(n - 1, a, q);
    }
    
    public static double sum(double[] a, int n) {
        if (n == 0) return 0;
        if (n == 1) return a[0];
        return a[n - 1] + sum(a, n - 1);
    }
    
    public static double max(double[] a, int n) {
        if (n == 1) return a[0];
        double m = max(a, n - 1);
        return m > a[n - 1] ? m : a[n - 1]; 
    }
    
    public static double min(double[] a, int n) {
        if (n == 1) return a[0];
        double m = min(a, n - 1);
        return m < a[n - 1] ? m : a[n - 1]; 
    }
    
    public static String convert(int n, int base) {
        if ( n == 0) return "0";
        return convert(n / base, base) + Character.forDigit(n % base, base);
    }
    
    public static void main(String[] args) {
        System.out.println("Test factorial(5):");
        System.out.println(factorial(5));
        
        System.out.println("Test Fibo:");
        System.out.println(testFibo(55));
        System.out.println(testFibo(144));
        System.out.println(testFibo(120));
        
        System.out.println("Test arithmetic progression:");
        System.out.println(ap(6, 1.5, 2));
        
        System.out.println("Test geometric progression:");
        System.out.println(gp(6, 1.5, 2));
        
        System.out.println("Test sum of integral array:");
        double[] a = {1.5, 2, 4, 5, 2, 6.5};
        System.out.println(sum(a, 6));
        
        System.out.println("Test the maximum value in an integral array:");
        double[] b = {1, 5, 9, 7, 2, 19, 10};
        System.out.println(max(b, 7));
        
        System.out.println("Test the minimum value in an integral array:");
        System.out.println(min(b, 7));
        
        System.out.println("Test convert decimal integer to:");
        System.out.println("Binary: " + convert(266, 2));
        System.out.println("Decimal: " + convert(266, 10));
        System.out.println("Octal: " + convert(266, 8));
        System.out.println("Hexadecimal: " + convert(266, 16));
    }
}
