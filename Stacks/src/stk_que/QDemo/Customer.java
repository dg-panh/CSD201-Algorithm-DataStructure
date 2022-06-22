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
public class Customer extends Thread {
    static Random rand = new Random(System.currentTimeMillis());
    long delay;
    LinkedList<String> queue;
    Thread acc;

    public Customer(String custName, long delay, LinkedList<String> queue, Thread acc) {
        super(custName);
        this.delay = delay;
        this.queue = queue;
        this.acc = acc;
    }

    @Override
    public void run() {
        while (acc.isAlive()) {
            try {
                int price = 100 + rand.nextInt(100);
                String msg = this.getName() + ", " + price + "$";
                queue.addLast(msg);
                if (!acc.isAlive()) Customer.yield();
                else Customer.sleep(delay);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    
}
