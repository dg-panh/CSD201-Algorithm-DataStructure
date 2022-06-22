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
public class MyLinkedList {
    LL_Element head; //reference to the beginning of the list
    LL_Element tail; //reference to the end of the list
    //Default constructor: Initialize an empty list
    public MyLinkedList() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    //Operations: Add, Search, Remove will return LL_Element
    //as an extra utilities if needed
    //All ADD operations have the complexity of O(1)
    public LL_Element addFirst(LL_Element newEle) {
        //case of the list is empty
        if(head == null)
            head = tail = newEle;
        //case of the list is not empty
        else { 
            newEle.next = head;
            newEle.previous = null;
            head.previous = newEle;
            head = newEle;
        }
        return newEle;
    }
    
    public LL_Element addLast(LL_Element newEle) {
        if (head == null)
            head = tail = newEle;
        else {
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        }
        return newEle;
    }
    
    //Add new element to the position after the element p
    public LL_Element addAfter(LL_Element newEle, LL_Element p) {
        if (p == null || p == tail)
            return addLast(newEle);
        LL_Element pAfter = p.next;
        newEle.next = pAfter;
        newEle.previous = p;
        pAfter.previous = newEle;
        p.next = newEle;
        return newEle;
    }
    
    //Add new element to the position before the element p
    public LL_Element addBefore(LL_Element newEle, LL_Element p) {
        if (p == null || p == head)
            return addFirst(newEle);
        LL_Element pBefore = p.previous;
        newEle.next = p;
        newEle.previous = pBefore;
        pBefore.next = newEle;
        p.previous = newEle;
        return newEle;
    }
    
    //Linear search data in the list -> Complexity is O(n)
    public LL_Element search(Comparable x) {
        LL_Element t;
        for (t = head; t != null; t = t.next) 
            if (t.data.compareTo(x) == 0)
                return t;
        return null;
    }
    
    //All remove operation have the complexity of O(1)
    public LL_Element removeFirst() {
        if (head == null)
            return null;
        if (head == tail)
            head = tail = null;
        LL_Element result = head;
        LL_Element newHead = head.next;
        newHead.previous = null;
        head = newHead;
        return result;
    }
    
    public LL_Element removeLast() {
        if (tail == null)
            return null;
        if (head == tail)
            head = tail = null;
        LL_Element result = tail;
        LL_Element newTail = tail.previous;
        newTail.next = null;
        tail = newTail;
        return result;
    }
    
    //remove a valid element in the list
    private LL_Element remove(LL_Element ele) {
        if (ele == null) 
            return null;
        if (ele == head)
            return removeFirst();
        if (ele == tail)
            return removeLast();
        // Update references, order: pBefore ele pAfter
        LL_Element pBefore = ele.previous;
        LL_Element pAfter = ele.next;
        pBefore.next = pAfter;
        pAfter.previous = pBefore;
        return ele;
    }
    
    // Complexity is O(n)
    public LL_Element remove(Comparable x) {
        return remove(search(x));
    }
    
    //Inner class takes a role as a tool for traversing all data in the list
    private class Traverser implements MyIterator <Comparable> {
        //Data structure of Traversor: curRef -> head -> ... -> tail
        LL_Element curRef;
        public Traverser() {
            curRef = new LL_Element(null);
            curRef.next = head;
        }

        @Override
        public boolean hasNext() {
            return (curRef.next != null);
        }

        @Override
        public Comparable next() {
            curRef = curRef.next;
            return curRef.data;
        }
    }
    
    //The MyLinkedList class
    public MyIterator iterator() {
        if (head == null)
            return null;
        return new Traverser();
    }
    
    //Tools for add some data
    public void addFirst(Comparable... group) {
        for (Comparable data : group) {
            addFirst(new LL_Element(data));
        }
    }
    
    public void addLast(Comparable... group) {
        for (Comparable data : group) {
            addLast(new LL_Element(data));
        }
    }
    
}


