/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author PC
 */
public class DSWIntBstTree extends IntBstTree{
    public void rotateRight(IntBstNode Gr, IntBstNode Par, IntBstNode Ch) {
        if (Par != root) {
            Ch.father = Gr;
            Gr.right = Ch;
        }
        Par.left = Ch.right;
        if (Par.left != null) Par.left.father = Par;
        Ch.right = Par;
        Par.father = Ch;
    }
    
    private int createBackbone() {
        if (root == null) return 0;
        int noOfNodes = 0;
        IntBstNode tmp = root, Gr, Par, Ch;
        while (tmp != null) {
            while (tmp.left != null) {
                Gr = tmp.father;
                Par = tmp;
                Ch = tmp.left;
                rotateRight(Gr, Par, Ch);
                if (Gr == null) {
                    root = Ch;
                    root.father = null;
                }
                tmp = Ch;
            }
            tmp = tmp.right;
            noOfNodes++;
        }
        return noOfNodes;
    }
    
    public void rotateLeft(IntBstNode Gr, IntBstNode Par, IntBstNode Ch) {
        if (Gr == null) root = Ch;
        else Gr.right = Ch;
        Ch.father = Gr;
        Par.right = Ch.left;
        if (Par.right != null) Par.right.father = Par;
        Ch.left = Par;
        Ch.father = Gr;
    }
    
    private void createBalancedTree(int noOfNodes) {
        int n = noOfNodes;
        double log2nPlus1 = Math.log(n + 1) / Math.log(2);
        int L = (int) (log2nPlus1);
        int m = (int) (Math.pow(2, L) - 1);
        IntBstNode Gr = null, Par = root, Ch = Par.right;
        for (int i = 0; i < n - m; i++) {
            rotateLeft(Gr, Par, Ch);
            Gr = Ch;
            Par = Gr.right;
            Ch = Par.right;
        }
        while (m > 1) {
            m /= 2;
            Gr = null; Par = root; Ch = Par.right;
            for (int i = 0; i < m; i++) {
                if (Ch != null) {
                    rotateLeft(Gr, Par, Ch);
                    Gr = Ch;
                    Par = Gr.right;
                    if (Par != null) Ch = Par.right;
                    else Ch = null;
                }
            }
        }
    }
    
    public void DSW_Balance() {
        if (root != null) {
            int noOfNodes = createBackbone();
            createBalancedTree(noOfNodes);
        }
    }
}
