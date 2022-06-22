/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stk_que.QDemo;

import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class Accountant implements Runnable {
    LinkedList<String> queue;
    int duty;
    int count = 0;

    public Accountant(LinkedList<String> queue, int duty) {
        this.queue = queue;
        this.duty = duty;
    }

    @Override
    public void run() {
        while (count < duty) {
            try {
                if (!queue.isEmpty()) {
                    count++;
                    String info = "Invoice " + count + "/" + duty + ": " + queue.removeFirst();
                    System.out.println(info);
                }
                if (count == duty) Thread.yield();
                else Thread.sleep(duty);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}
