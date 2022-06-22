/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

/**
 *
 * @author PC
 */
public class MyStrMatcher {
    //Bruth Force approach
    public static int indexOf_BF(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;
            while (j < m) {
                if (s.charAt(i + j) != pattern.charAt(j)) break;
                j++;
                if (j == m) return i;
            }
        }
        return -1;
    }
    
    public static int lastIndexOf_BF(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();
        for (int i = n - m; i >= 0; i--) {
            int j = 0;
            while (j < m) {
                if (s.charAt(i + j) != pattern.charAt(j)) break;
                j++;
                if (j == m) return i;
            }
        }
        return -1;
    }
    
    //Knuth-Morris-Pratt
    public static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m];
        fail[0] = 0; //first element having no previous element
        int j = 1;
        int k = 0;
        while (j < m) {
            if (pattern[j] == pattern[k]) {
                fail[j] = k + 1;
                k++;
            }
            else if (k > 0) k = fail[k - 1];
            else fail[j] = 0;
            j++;
        }
        return fail;
    }
    
    public static int indexOf_KMP(char[] s, char[] p) {
        int n = s.length;
        int m = p.length;
        int[] prefixes = computeFailKMP(p);
        int j = 0; //position into source string s
        int k = 0; //index into pattern p
        while (j < n) {
            if (s[j] == p[k]) {
                if (k == m -1) return j - m + 1;
            }
            else if (k > 0) k = prefixes[k - 1];
            j++;
            k++;
        }
        return -1;
    }
    
    public static int indexOf_KMP(String s, String pattern) {
        return indexOf_KMP(s.toCharArray(), pattern.toCharArray());
    }
    
    public static void printArray(int a[]) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }
    
    public static void main(String[] args) {
        //test Bruth Force
        String s1 = "Jack! go away, and you, please do not go away tonight";
        String p1 = "go";
        String p2 = "away";
        int pos1 = indexOf_BF(s1, p1);
        int pos2 = indexOf_BF(s1, p2);
        int pos3 = lastIndexOf_BF(s1, p2);
        System.out.println("s1 = " + s1);
        System.out.println("p1 = " + p1);
        System.out.println("Index of p1 in s1: " + pos1);
        System.out.println("p2 = " + p2);
        System.out.println("Index of p2 in s1: " + pos2);
        System.out.println("Last index of p2 in s1: " + pos3);
        
        //test KMP
        String s2 = "bacbabababacaca";
        String pattern = "ababaca";
        int fail[] = computeFailKMP(pattern.toCharArray());
        System.out.println("s2: " + s2);
        System.out.println("Pattern: " + pattern);
        System.out.println("fail[]: ");
        printArray(fail);
        System.out.println("\nPattern at position in s2: " + indexOf_KMP(s2, pattern));
    }
}
