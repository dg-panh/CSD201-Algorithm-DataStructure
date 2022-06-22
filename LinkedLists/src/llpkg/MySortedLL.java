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
public class MySortedLL {

    LL_Element head;
    LL_Element tail;

    public MySortedLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //Determine the ceiling of x in the list
    //x = 7 List: 1 2 3 4 5 8 9 --> return reference of 8 --> O(n/2)
    public LL_Element ceiling(Comparable x) {
        LL_Element t = head;
        while (t != null && t.data.compareTo(x) < 0) //data < x
            t = t.next;
        return t;
    }

    public LL_Element search(Comparable x) { //O(n/2)
        LL_Element result = ceiling(x);
        if (result == null)
            return null;
        return (result.data.compareTo(x) == 0) ? result : null;
    }
    
    //add dat x to the sorted linked list --> O(n/2)
    public LL_Element add(Comparable x) {
        LL_Element newEle = new LL_Element(x);
        LL_Element after = ceiling(x); //O(n/2)
        if (head == null)
            head = tail = newEle;
        else if (after == null) { //there is no ceiling -> add x the the end
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        }
        else if (after == head) {
            newEle.previous = null;
            newEle.next = head;
            head.previous = newEle;
            head = newEle;
        }
        else { //ORDER: before <-> newEle <-> after
            LL_Element before = after.previous;
            newEle.next = after;
            newEle.previous = before;
            before.next = newEle;
            after.previous = newEle;
        }
        return newEle;
    }
    
    //tool for add some data
    public void add(Comparable... group) {
        for (Comparable data : group) 
            add(data);
    }
    
    //Remove a specific valid reference --> O(1)
    private LL_Element remove(LL_Element remRef) {
        //if list has only one element and it will be removed
        if (remRef == head && head == tail) {
            head = tail = null;
            return remRef;
        }
        LL_Element before = remRef.previous;
        LL_Element after = remRef.next;
        //The list has more than one element
        if (remRef == head) { //remove first element
            after.previous = null;
            head = after;
        }
        else if (remRef == tail) {
            before.next = null;
            tail = before;
        }
        else { //before -> remRef -> after
            before.next = after;
            after.previous = before;
        }
        return remRef;
    }
    
    //Remove a specific data --> search --> O(n/2)
    public LL_Element remove(Comparable x) {
        LL_Element remRef = search(x); //O(n/2)
        if (remRef != null)
            remove(remRef); //O(1)
        return remRef;
    }
    
    //Inner class as a tool for traversing all data in the list
    private class Traverser implements MyIterator <Comparable> {

        //Data structure of Traverser: curRef -> head -> ... -> tail
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
    
    public MyIterator iterator() {
        if (head == null)
            return null;
        return new Traverser();
    }

}
