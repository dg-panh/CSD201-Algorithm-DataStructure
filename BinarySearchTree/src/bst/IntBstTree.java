/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class IntBstTree {
    IntBstNode root;

    public IntBstTree() {
        root = null;
    }
    
    public boolean add(int x) {
        IntBstNode newNode = new IntBstNode(x);
        if (root == null) root = newNode;
        else {
            IntBstNode pAfter = null;
            IntBstNode pBefore = root;
            while (pBefore != null && pBefore.key != x) {
                pAfter = pBefore;
                if (x < pBefore.key) pBefore = pBefore.left;
                else pBefore = pBefore.right;
            }
            
            if (pBefore != null) { //-> x = pBefore.key
                return false;
            }
            if (x < pAfter.key) pAfter.left = newNode;
            else pAfter.right = newNode;
            newNode.father = pAfter;
        }
        return true;
    }
    
    public void add(int...a) {
        for (int i : a) {
            this.add(i);
        }
    }
    
    //Breadth-first
    public void printLevelBased() {
        if (root == null) System.out.println("\nEmpty tree.\n");
        else {
            LinkedList<IntBstNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                IntBstNode node = (IntBstNode) queue.removeFirst();
                System.out.print(node + ", ");
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
    }
    
    //Pre-order
    private void printNLR(IntBstNode p) {
        if (p != null) {
            System.out.print("" + p + ", ");
            printNLR(p.left);
            printNLR(p.right);
        }
    }
    
    public void printNLR() {
        if (root == null) System.out.println("\nEmpty tree\n");
        else printNLR(root);
    }
    
    //print all values in align format (NLR)
    private void printAlign(IntBstNode p, int nSpace) {
        if (p != null) {
            for (int i = 0; i < nSpace; i++) {
                System.out.print(" ");
            }
            System.out.println(p);
            printAlign(p.left, nSpace + 3);
            printAlign(p.right, nSpace + 3);
        }
    }
    
    public void printAlign() {
        if (root == null) System.out.println("\nEmpty tree\n");
        else printAlign(root, 0);
    }
    
    //In-order
    private void printLNR(IntBstNode p) {
        if (p != null) {
            printLNR(p.left);
            System.out.print("" + p + ", ");
            printLNR(p.right);
        }
    }
    
    public void printLNR() {
        if (root == null) System.out.println("\nEmpty tree\n");
        else printLNR(root);
    }
    
    private void printRNL(IntBstNode p) {
        if (p != null) {
            printRNL(p.right);
            System.out.print("" + p + ", ");
            printRNL(p.left);
        }
    }
    
    public void printRNL() {
        if (root == null) System.out.println("\nEmpty tree\n");
        else printRNL(root);
    }
    
    //Post-order
    private void printPostOrder(IntBstNode p) {
        if (p != null) {
            printPostOrder(p.left);
            printPostOrder(p.right);
            System.out.print("" + p + ", ");
        }
    }
    
    public void printPostOrder() {
        if (root == null) System.out.println("\nEmpty tree\n");
        else printPostOrder(root);
    }
    
    public IntBstNode search(int x) {
        IntBstNode result = root;
        while (result != null) {
            if (x == result.key) return result;
            else if (x < result.key) result = result.left;
            else result = result.right;
        }
        return null;
    }
    
    public int getMin() {
        if (root == null)
            throw new RuntimeException("Empty tree!");
        IntBstNode p = root;
        while (p.left != null) p = p.left;
        return p.key;
    }
    
    public int getMax() {
        if (root == null)
            throw new RuntimeException("Empty tree!");
        IntBstNode p = root;
        while (p.right != null) p = p.right;
        return p.key;
    }
    
    public int getHeight() {
        class Node_Level {
            IntBstNode node;
            int level;

            public Node_Level(IntBstNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
        if (root == null) return 0;
        LinkedList<Node_Level> q = new LinkedList<>();
        Node_Level v;
        int result = 0;
        q.add(new Node_Level(root, 1));
        while (!q.isEmpty()) {
            v = q.removeFirst();
            int curL = v.level;
            if (result < curL) result = curL;
            IntBstNode left = v.node.left;
            IntBstNode right = v.node.right;
            if (left != null) q.add(new Node_Level(left, curL + 1));
            if (right != null) q.add(new Node_Level(right, curL + 1));
        }
        return result;
    }
    
    public double getAverage() {
        int n = 0; //number of nodes
        double sum = 0; //sum of keys
        if (root == null) return 0;
        else {
            LinkedList<IntBstNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                IntBstNode node = (IntBstNode) queue.removeFirst();
                n++;
                sum += node.key;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return sum/n;
    }
    
    private boolean removeLeaf(IntBstNode leaf) {
        if (!leaf.isLeaf()) return false;
        if (leaf == root && root.isLeaf()) root = null;
        else {
            IntBstNode father = leaf.father;
            if (father.left == leaf) father.left = null;
            else father.right = null;
        }
        return true;
    }
    
    private boolean removeOneChildNode(IntBstNode delNode) {
        if (delNode.isLeaf() || delNode.having2Child()) return false;
        if (delNode == root) {
            if (root.left == null) root = root.right;
            else root = root.left;
            root.father = null;
        } 
        else {
            IntBstNode grandFather = delNode.father;
            IntBstNode grandChild;
            if (delNode.left == null) grandChild = delNode.right;
            else grandChild = delNode.left;
            if (delNode == grandFather.left) grandFather.left = grandChild;
            else grandFather.right = grandChild;
            grandChild.father = grandFather;
        }
        return true;
    }
    
    private boolean deleteByMerging(IntBstNode delNode) {
        if (delNode.isLeaf() || delNode.havingOneChild()) return false;
        IntBstNode grandFather = delNode.father;
        IntBstNode leftGrandChild = delNode.left;
        IntBstNode rightGrandChild = delNode.right;
        //Determining the rightmost node of the left subtree
        IntBstNode rightMost = leftGrandChild;
        while (rightMost.right != null) rightMost = rightMost.right;
        
        rightMost.right = rightGrandChild;
        rightGrandChild.father = rightMost;
        
        if (delNode == root) {
            root = root.left;
            root.father = null;
        }
        else {
            if (grandFather.left == delNode) grandFather.left = leftGrandChild;
            else grandFather.right = leftGrandChild;
            leftGrandChild.father = grandFather;
        }
        return true;
    }
    
    public boolean deleteByMerging(int x) {
        IntBstNode delNode = search(x);
        if (delNode == null) return false;
        if (delNode.isLeaf()) return removeLeaf(delNode);
        if (delNode.havingOneChild()) return removeOneChildNode(delNode);
        return deleteByMerging(delNode);
    }
    
    private boolean deleteByCopying(IntBstNode delNode) {
        if (!delNode.having2Child()) return false;
        IntBstNode rightMost = delNode.left;
        while (rightMost.right != null) rightMost = rightMost.right;
        delNode.key = rightMost.key;
        if (rightMost.isLeaf()) removeLeaf(rightMost);
        if (rightMost.havingOneChild()) removeOneChildNode(rightMost);
        return true;
    }
    
    public boolean deleteByCopying(int x) {
        IntBstNode delNode = search(x);
        if (delNode == null) return false;
        if (delNode.isLeaf()) return removeLeaf(delNode);
        if (delNode.havingOneChild()) return removeOneChildNode(delNode);
        return deleteByCopying(delNode);
    }
}
