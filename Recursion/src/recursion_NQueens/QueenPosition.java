/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion_NQueens;

/**
 *
 * @author PC
 */
public class QueenPosition {
    int x, y;

    public QueenPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean valid(QueenPosition p) {
        int dx = this.x - p.x;
        if (dx < 0) dx = -dx;
        int dy = this.y - p.y;
        if (dy < 0) dy = -dy;
        return (dx != 0 && dy != 0 && dx != dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    
}
