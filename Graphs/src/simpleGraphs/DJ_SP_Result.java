/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs;

import java.util.ArrayList;
import simpleGraphs.edge.Edge;
import simpleGraphs.edge.Path;
import simpleGraphs.vertex.AdjInfo;
import simpleGraphs.vertex.Vertex;

/**
 *
 * @author PC
 */
public class DJ_SP_Result {
    Vertex start;
    AbstractGraph g;
    ArrayList<Path> paths;

    public DJ_SP_Result(Vertex start, AbstractGraph g) {
        this.start = start;
        this.g = g;
        paths = new ArrayList<>(g.size());
        for (int i = 0; i < g.size(); i++) {
            paths.add(new Path());
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < g.size(); i++) {
            s += "From " + start.key + " to " + ((Vertex)g.get(i)).key +
                    ", len: " + paths.get(i).pathLen + ": " + paths.get(i) + "\n";
        }
        return s;
    }
    
    public void setupPath(int vertexIndex) {
        Vertex dest = (Vertex)g.get(vertexIndex);
        Path path = paths.get(vertexIndex);
        path.pathLen = dest.pathLen;
        AdjInfo adj;
        Edge e;
        //add edges to the path
        Vertex src = dest.predecessor;
        while (src != null) {
            adj = g.getAdjInfo(src, dest);
            e = new Edge(src, dest, adj.weight);
            path.addFirst(e);
            dest = src;
            src = dest.predecessor;
        }
    }
    
    public void setupPath() {
        for (int i = 0; i < g.size(); i++) {
            setupPath(i);
        }
    }
    
}
