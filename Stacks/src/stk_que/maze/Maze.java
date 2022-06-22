/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stk_que.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class Maze {
    
    public static char ENTRY_VAL = 'E', DEST_VAL = 'M';
    int rows = 0, cols = 0;
    Cell[][] cells = null;
    Cell entry = null;
    Cell destination = null;
    boolean completed = false;
    boolean succeeded = false;
    
    private boolean valid(int x, int y) {
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }
    
    private void add(Cell curCell, int x, int y, ArrayList<Cell> adjs) {
        Cell c;
        if (valid(x, y)) {
            c = cells[x][y];
            if (c.canMoveTo()) {
                c.previous = curCell;
                adjs.add(c);
            }
        }
    }
    
    private ArrayList<Cell> getAdjs(Cell curCell) {
        ArrayList<Cell> adjs = new ArrayList();
        int x = curCell.x, y = curCell.y;
        add(curCell, x - 1, y, adjs);
        add(curCell, x + 1, y, adjs);
        add(curCell, x, y - 1, adjs);
        add(curCell, x, y + 1, adjs);
        return adjs;
    }
    
    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("The file " + filename + " doesn't existed!");
            System.exit(0);
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0 ) list.add(line);
            }
            bf.close();
            fr.close();
            
            this.rows = list.size();
            this.cols = list.get(0).length();
            this.cells = new Cell[rows][cols];
            for (int i = 0; i < list.size(); i++) {
                line = list.get(i);
                for (int j = 0; j < cols; j++) {
                    char ch = line.charAt(j);
                    cells[i][j] = new Cell(i, j, ch);
                    
                    if (ch == ENTRY_VAL) this.entry = cells[i][j];
                    if (ch == DEST_VAL) this.destination = cells[i][j];
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return true;
    }
    
    public boolean solve() {
        ArrayList<Cell> adjs = null;
        LinkedList<Cell> stack = new LinkedList<>();
        Cell curCell = this.entry;
        
        while (!completed) {
            curCell.visited = true;
            if (curCell == this.destination) {
                completed = succeeded = true;
            }
            else {
                adjs = getAdjs(curCell);
                if (adjs.size() > 0) {
                    curCell = adjs.get(0);
                    for (int i = 1; i < adjs.size(); i++) {
                        stack.addFirst(adjs.get(i));
                    }
                }
                else if (!stack.isEmpty())
                    curCell = stack.removeFirst();
                else {
                    completed = true;
                    succeeded = false;
                }
            }
        }
        return completed;
    }
    
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].value);
            }
            System.out.println();
        }
    }
    
    public LinkedList<Cell> getPath() {
        if (!succeeded) return null;
        LinkedList<Cell> path = new LinkedList<>();
        
        Cell cell = this.destination;
        while (cell != null) {
            path.addFirst(cell);
            cell = cell.previous;
        }
        return path;
    }
    
    public static void main(String[] args) {
        String filename = "maze01.txt";
        Maze maze = new Maze();
        maze.loadFromFile(filename);
        maze.print();
        maze.solve();
        if (maze.succeeded) {
            System.out.println("Result path: ");
            System.out.println(maze.getPath());
        }
        else System.out.println("Failed!");
    }
    
}
