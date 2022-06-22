 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Configuration extends ArrayList<Integer>{

    public Configuration() {
        super();
    }
    
    public Configuration(int size) {
        super(size);
    }
    
    public void update(int index, int val) {
        if (index >= 0 && index < this.size())
            this.set(index, val);
    }
}
