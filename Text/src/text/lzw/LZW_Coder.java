/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.lzw;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author PC
 */
public class LZW_Coder {
    Hashtable<String, Integer> dict = null;
    ArrayList<Integer> zippedData = null;
    int code;
    String initDictStr = null;

    public LZW_Coder() {
        dict = new Hashtable<>();
        zippedData = new ArrayList<>();
        initDict();
    }

    public LZW_Coder(String initDictStr) {
        this.initDictStr = null;
        dict = new Hashtable<>();
        zippedData = new ArrayList<>();
        this.initDictStr = initDictStr;
        initDict();
    }
    
    private void initDict() {
        if(initDictStr == null) {
            for (int i = 0; i < 256; i++) {
                dict.put("" + (char)i, i);
            }
            code = 256;
        } else {
            int L = initDictStr.length();
            for (int i = 0; i < L; i++) {
                dict.put("" + initDictStr.charAt(i), i);            
            }
            code = L;
        }
    }
    
    private void putToDict(String s) {
        dict.put(s, code++);
    }
    
    private void output(int code) {
        zippedData.add(code);
    }
    
    public ArrayList<Integer> zip(String src) {
        Integer code;
        String curSub = "";
        String newSub;
        char c;
        int i = 0;
        int n = src.length();
        while(i < n) {
            c = src.charAt(i);
            newSub = curSub + c;
            if(dict.containsKey(newSub)) curSub = newSub;
            else {
                code = dict.get(curSub);
                output(code);
                putToDict(newSub);
                curSub = "" + c;
            }
            i++;
        }
        code = dict.get(curSub);
        output(code);
        return zippedData;
    }
}
