/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stk_que.QDemo;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Shop {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        int duty = 30;
        Accountant acc = new Accountant(queue, duty);
        Thread accThread = new Thread(acc);
        accThread.start();
        int n = 10;
        Customer[] custList = new Customer[n];
        String custName;
        Random rand = Customer.rand;
        int delay;
        for (int i = 0; i < n; i++) {
            custName = "Cust " + (i + 1);
            delay = 200 + rand.nextInt(500);
            custList[i] = new Customer(custName, delay, queue, accThread);
        }
        
        for (int i = 0; i < n; i++) {
            custList[i].start();
        }
    }
}
