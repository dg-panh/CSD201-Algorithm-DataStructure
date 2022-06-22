/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.lzw;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LZW_Test {

    public static void main(String[] args) {
        //test 1
        String src = "AABAABBCCACC", initDictStr = "ABC";
        LZW_Coder coder = new LZW_Coder(initDictStr);
        ArrayList<Integer> zippedData = coder.zip(src);
        System.out.println("Test 1 src: " + src);
        System.out.println("Zipped data:\n" + zippedData);
        System.out.println("\nNumber of codewords after zipping: " + zippedData.size());
        LZW_Decoder decoder = new LZW_Decoder(initDictStr);
        String unzippedStr = decoder.unzip(zippedData);
        System.out.println("After unzipping: " + unzippedStr + "\n\n");
        
        //test 2
        src = "LZW starts out with a dictionary of 256 characters\n (in the case of 8 bits)"
                + "and uses those as the \"standard\" character set.\nIt then reads data 8 bits "
                + "at a time (e.g., 't', 'r', etc.) and encodes \n the data as the number that "
                + "represents its index in the dictionary.\nEverytime it comes across a new substring (say, \"tr\")\n";
        System.out.println("Test 2 src: " + src + "\nLength: " + src.length());
        coder = new LZW_Coder();
        zippedData = coder.zip(src);
        System.out.println("Zipped data:\n" + zippedData);
        System.out.println("\nNumber of codewords after zipping: " + zippedData.size());
        decoder = new LZW_Decoder();
        unzippedStr = decoder.unzip(zippedData);
        System.out.println("After unzipping:\n\n" + unzippedStr);
    }

}
