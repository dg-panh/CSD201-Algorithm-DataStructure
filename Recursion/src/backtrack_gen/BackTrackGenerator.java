/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author PC
 */
public class BackTrackGenerator {
    protected int noOfSet = 0;
    ArrayList<IntMinMaxSet> iDomains = new ArrayList<>();
    Configuration curConfig = new Configuration();
    boolean initiated = false;
    
    public void addDomain(int min, int max) {
        IntMinMaxSet aSet = new IntMinMaxSet(min, max);
        iDomains.add(aSet);
        noOfSet++;
    }
    
    public void addDomain(Collection list) {
        IntMinMaxSet aSet = new IntMinMaxSet(list);
        iDomains.add(aSet);
        noOfSet++;
    }
    
    public void init() {
        curConfig.clear();
        for (int i = 0; i < noOfSet; i++) {
            IntMinMaxSet set = iDomains.get(i);
            set.reset();
            curConfig.add(set.nextValue());
        }
        initiated = true;
    }
    
    public void reset() {
        initiated = false;
    }
    
    private boolean isLastConfiguration() {
        for (int i = 0; i < noOfSet; i++) {
            if (!iDomains.get(i).isLastValue()) return false;
        }
        return true;
    }
    
    private Configuration copyConfiguration() {
        Configuration result = new Configuration(curConfig.size());
        for (int i = 0; i < curConfig.size(); i++) {
            result.add(curConfig.get(i).intValue());
        }
        return result;
    }
    
    public Configuration getFirstConfig() {
        init();
        return copyConfiguration();
    }
    
    public Configuration nextConfiguration() {
        if (!initiated || isLastConfiguration()) return null;
        int lastIndex = noOfSet - 1;
        while (lastIndex >= 0 && iDomains.get(lastIndex).isLastValue())
            lastIndex--;
        int nextVlaue = iDomains.get(lastIndex).nextValue();
        curConfig.update(lastIndex, nextVlaue);
        if (lastIndex >= 0) {
            for (int i = lastIndex + 1; i < noOfSet; i++) {
                IntMinMaxSet aSet = iDomains.get(i);
                aSet.reset();
                curConfig.update(i, aSet.nextValue());
            }
        }
        return copyConfiguration();
    }
}
