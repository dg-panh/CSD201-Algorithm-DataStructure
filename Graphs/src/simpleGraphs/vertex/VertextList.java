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
public class VertextList extends OrderedList<Vertex>{

    public VertextList() {
        super();
    }
    
    public Vertex search(String key) {
        Vertex v = new Vertex(key);
        return search(v);
    }
    
    public Vertex addVertex(String key) {
        Vertex newV = new Vertex(key);
        Vertex t = search(newV);
        if (t != null) return t;
        this.add(newV);
        return newV;
    }
    
    public Vertex addVertex(String key, String name) {
        Vertex newV = new Vertex(key, name);
        Vertex t = search(newV);
        if (t != null) return t;
        this.add(newV);
        return newV;
    }
    
    public void resetNum() {
        for (Comparable thi : this) {
            ((Vertex)thi).num = 0;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Comparable thi : this) {
            result += ((Vertex)thi).toString() + "\n";
        }
        return result;
    }
    
    
}
