/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import GUI.Menu;
import util.Validation;

/**
 *
 * @author PC
 */
public class IntBstDemo {
    public static void main(String[] args) {
        Menu menu = new Menu("Integer Binary Sreach Tree");
        menu.addNewOption("1. Add new key");
        menu.addNewOption("2. Maximum value");
        menu.addNewOption("3. Minimum value");
        menu.addNewOption("4. Average value");
        menu.addNewOption("5. Tree's height");
        menu.addNewOption("6. Breadth-first output");
        menu.addNewOption("7. Align output");
        menu.addNewOption("8. Preorder output");
        menu.addNewOption("9. Inorder-LNR output");
        menu.addNewOption("10. Inorder-RNL output");
        menu.addNewOption("11. Postorder output");
        menu.addNewOption("12. Searching a key");
        menu.addNewOption("13. Removing a key by merging");
        menu.addNewOption("14. Removing a key by copying");
        menu.addNewOption("15. Quit");
        
        IntBstTree tree = new IntBstTree();
        tree.add(32, 11, 57, 6, 18, 40, 80, 2, 8, 16, 22, 35, 50, 70, 90);
        tree.add(1, 5, 10, 15, 17, 34, 45, 85, 3);
        int choice;
        int x; //key inputted
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch(choice) {
                case 1:
                    x = Validation.getAnInteger("Input a key: ", "Key must be a integer!");
                    if (tree.add(x) == true) System.out.println("Adding " + x + " successfully!");
                    else System.out.println("Adding failed!");
                    break;
                case 2:
                    System.out.println("Max value: " + tree.getMax());
                    break;
                case 3:
                    System.out.println("Min value: " + tree.getMin());
                    break;
                case 4:
                    System.out.println("Average value: " + tree.getAverage());
                    break;
                case 5:
                    System.out.println("Tree's height: " + tree.getHeight());
                    break;
                case 6:
                    System.out.println("Breadth-first/level-based output: ");
                    tree.printLevelBased();
                    break;
                case 7:
                    System.out.println("Tree in aligned format: ");
                    tree.printAlign();
                    break;
                case 8:
                    System.out.println("Tree in preorder list: ");
                    tree.printNLR();
                    break;
                case 9:
                    System.out.println("Inorder-LNR output");
                    tree.printLNR();
                    break;
                case 10:
                    System.out.println("Inorder-RNL output");
                    tree.printRNL();
                    break;
                case 11:
                    System.out.println("Postorder output");
                    tree.printPostOrder();
                    break;
                case 12:
                    x = Validation.getAnInteger("Input searched value: ", "Value must be a integer!");
                    IntBstNode node = tree.search(x);
                    if (node == null) System.out.println("Not found!");
                    else System.out.println("Found: " + node.key);
                    break;
                case 13:
                    x = Validation.getAnInteger("Input delete key: ", "Key must be a integer!");
                    if (tree.deleteByMerging(x)) System.out.println("Deleting successfully!");
                    else System.out.println("Deleting fail!");
                    break;
                case 14:
                    x = Validation.getAnInteger("Input delete key: ", "Key must be a integer!");
                    if (tree.deleteByCopying(x)) System.out.println("Deleting successfully!");
                    else System.out.println("Deleting fail!");
                    break;
                case 15:
                    break;
            }
        } while (choice != 15);
    }
}
