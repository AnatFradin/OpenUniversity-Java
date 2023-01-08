/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_14_q1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author anatfradin
 */
public class PriorityQueue <T> implements Iterable<T>{
    
    private ArrayList<T>[] priorityList;
    
    public PriorityQueue(int max_priority) {
        if (max_priority < 1 || max_priority > 10) {
            max_priority = 10;
        }
        priorityList = new ArrayList[max_priority];
        
        for (int i = 0; i < priorityList.length; i++) {
            priorityList[i] = new ArrayList<T>();
        }
    }

    public void add(T item, int priority){
        if(priority < 1 || priority > priorityList.length){
            priority = priorityList.length;
        }
        
        priorityList[priority-1].add(item);
    }
    
    public T poll(){
        T theItem = null;
        
        for (ArrayList<T> arrayList : priorityList) {
            if (arrayList != null && !arrayList.isEmpty()){
                 theItem = arrayList.remove(0);
                 break;
            }
        }
        return theItem;
    }
    
    public boolean contains(T item){    
        for (ArrayList<T> arrayList : priorityList){
            if(arrayList.contains(item))
                return true;
        }
        return false;
    }
    
    public boolean remove(T item){
        for (ArrayList<T> arrayList : priorityList){
            int index = arrayList.indexOf(item);
            if(index != -1){
                arrayList.remove(index);
                return true;
            }
        }
        return false;
    }
    
    public int size(){
        int size=0;
        for (ArrayList<T> arrayList : priorityList){
            size += arrayList.size();
        }
        return size;
    }
    
    private ArrayList<T> getAllItems(){
        ArrayList<T> allItems = new ArrayList<>();
        for (ArrayList<T> arrayList : priorityList){
            if (!arrayList.isEmpty()){
                allItems.addAll(arrayList);
            }
        }
        return allItems;
    }
    
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<T>() {
            
            private ArrayList<T> allItems = PriorityQueue.this.getAllItems();
            private int index=0;
            
            @Override
            public boolean hasNext() {
                return allItems.size() != index;
            }

            @Override
            public T next() {
                if(hasNext())
                    return allItems.get(index++);
                return null;
            }
        };
        return iter;
    }
    
}
