/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llpkg;

/**
 *
 * @author PC
 */
public interface MyIterator <E> {
    //checking whether any element is not visited
    public boolean hasNext();
    //get data of the next element
    public E next();
}
