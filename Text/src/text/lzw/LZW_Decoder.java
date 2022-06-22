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
public class LZW_Decoder {
    Hashtable<Integer, String> dict = null;
    String unzippedStr = null;
    int code;
    String initDictStr = null;

    public LZW_Decoder() {
        dict = new Hashtable<>();
        unzippedStr = "";
        initDict();
    }

    public LZW_Decoder(String initDictStr) {
        dict = new Hashtable<>();
        unzippedStr = "";
        this.initDictStr = initDictStr;
        initDict();
    }
    
    private void initDict() {
        if(initDictStr == null) {
            for (int i = 0; i < 256; i++) {
                dict.put(i, "" + (char)i);
            }
            code = 256;
        } else {
            int L = initDictStr.length();
            for (int i = 0; i < L; i++) {
                dict.put(i, "" + initDictStr.charAt(i));
            }
            code = L;
        }
    }
    
    private void putToDict(String newSubStr) {
        dict.put(code++, newSubStr);
    }
    
    private void output(String subStr) {
        unzippedStr += subStr;
    }
    
    public String unzip(ArrayList<Integer> zippedCodes) {
        unzippedStr = "";
        int curCode;
        char ch;
        curCode = zippedCodes.get(0);
        String curTrans = dict.get(curCode);
        output(curTrans);
        String nextTrans;
        int i = 1;
        while(i < zippedCodes.size()) {
            curCode = zippedCodes.get(i);
            nextTrans = dict.get(curCode);
            output(nextTrans);
            ch = nextTrans.charAt(0);
            String newSubStr = curTrans + ch;
            putToDict(newSubStr);
            curTrans = nextTrans;
            i++;
        }
        return unzippedStr;
    }
}
