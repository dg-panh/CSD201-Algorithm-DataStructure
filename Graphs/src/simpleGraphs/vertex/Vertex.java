/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs.vertex;

import simpleGraphs.com.OrderedList;

/**
 *
 * @author PC
 */
public class Vertex implements Comparable<Vertex>{
    public String key, name;
    public int num;
    public double pathLen;
    public Vertex predecessor;
    public OrderedList adjList;

    public Vertex(String key) {
        this.key = key;
        adjList = new OrderedList();
    }

    public Vertex(String key, String name) {
        this.key = key;
        this.name = name;
        adjList = new OrderedList();
    }

    @Override
    public int compareTo(Vertex o) {
        return key.compareToIgnoreCase(o.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + name + ", adj:" + adjList + ')';
    }

    public OrderedList getAdjList() {
        return adjList;
    }

    public void setAdjList(OrderedList adjList) {
        this.adjList = adjList;
    }
    
}
