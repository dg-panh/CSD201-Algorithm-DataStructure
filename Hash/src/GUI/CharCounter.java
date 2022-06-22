/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author PC
 */
public class CharCounter extends HashMap<Integer, Integer>{
    int numOfChars;

    public CharCounter() {
        super();
    }
    
    public CharCounter(String filename) {
        super();
        try {
            FileReader fr = new FileReader(filename);
            int code;
            while((code = fr.read()) != -1) {
                if (!this.containsKey(code)) this.put(code, 1);
                else this.replace(code, this.get(code) + 1);
                numOfChars++;
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void print() {
        for (Integer object : this.keySet()) {
            System.out.println((char)object.intValue() + ", " + this.get(object) + ", " + 1.0*this.get(object)/numOfChars);
        }
    }
    
    public static void main(String[] args) {
        CharCounter counter = new CharCounter("laychong.txt");
        counter.print();
    }
}
