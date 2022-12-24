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
public class TestString {

    public static boolean runTest() {
        
        boolean commonTestResult = true;
        boolean result = runTest_add_orderCorrect();
        commonTestResult &= result;
        System.out.println("\nTestString -> runTest_add_orderCorrect Result: " + result);

        result = runTest_remove();
        commonTestResult &= result;
        System.out.println("\nTestString -> runTest_remove Result: " + result);

        result = runTest_Add_Remove();
        commonTestResult &= result;
        System.out.println("\nTestString -> runTest_Add_Remove Result: " + result);
        
        result = runTest_Poll_Remove();
        commonTestResult &= result;
        System.out.println("\nTestString -> runTest_Poll_Remove Result: " + result);
        
        
        return commonTestResult;
    }

    private static void printAll(Iterator<String> iterator) {
        for (; iterator.hasNext();) {
            String next = (String) iterator.next();
            System.out.print(" <" + next + "> ");
        }
    }

    private static boolean runTest_add_orderCorrect() {
        PriorityQueue<String> queue = new PriorityQueue<>(8);

        ArrayList<TestObject<String>> testArr = new ArrayList();

        testArr.add(new TestObject<String>("THE GREAT GATSBY", 1));
        testArr.add(new TestObject<String>("Lolita", 1));
        testArr.add(new TestObject<String>("BRAVE NEW WORLD", 4));
        testArr.add(new TestObject<String>("CATCH-22", 8));

        for (TestObject<String> testObject : testArr) {
            queue.add(testObject.getItem(), testObject.getPriority());
        }

        return testBothArraysAreEqual(queue.iterator(),testArr.iterator());
    }
    
    private static boolean runTest_remove() {
          PriorityQueue<String> queue = new PriorityQueue<>(8);

        ArrayList<TestObject<String>> testArr = new ArrayList();

        testArr.add(new TestObject<String>("THE GREAT GATSBY", 1));
        testArr.add(new TestObject<String>("Lolita", 1));
        testArr.add(new TestObject<String>("BRAVE NEW WORLD", 4));
        testArr.add(new TestObject<String>("CATCH-22", 8));

        for (TestObject<String> testObject : testArr) {
            queue.add(testObject.getItem(), testObject.getPriority());
        }

        queue.remove("Lolita");
        testArr.remove(1);
        
        return testBothArraysAreEqual(queue.iterator(),testArr.iterator());
    }
    
    private static boolean runTest_Add_Remove() {
        PriorityQueue<String> queue = new PriorityQueue<>(8);

        ArrayList<TestObject<String>> testArr = new ArrayList();

        testArr.add(new TestObject<String>("THE GREAT GATSBY", 1));
        testArr.add(new TestObject<String>("Lolita", 1));
        testArr.add(new TestObject<String>("BRAVE NEW WORLD", 4));
        testArr.add(new TestObject<String>("CATCH-22", 8));

        for (TestObject<String> testObject : testArr) {
            queue.add(testObject.getItem(), testObject.getPriority());
        }

        queue.remove("Lolita");
        testArr.remove(1);
        
        queue.add("DARKNESS AT NOON",2);
        testArr.add(1,new TestObject<String>("DARKNESS AT NOON", 1));
        
        return testBothArraysAreEqual(queue.iterator(),testArr.iterator());

    }
    
    private static boolean runTest_Poll_Remove() {
          PriorityQueue<String> queue = new PriorityQueue<>(8);

        ArrayList<TestObject<String>> testArr = new ArrayList();

        testArr.add(new TestObject<String>("THE GREAT GATSBY", 1));
        testArr.add(new TestObject<String>("Lolita", 1));
        testArr.add(new TestObject<String>("BRAVE NEW WORLD", 4));
        testArr.add(new TestObject<String>("CATCH-22", 8));

        for (TestObject<String> testObject : testArr) {
            queue.add(testObject.getItem(), testObject.getPriority());
        }

        String highest = queue.poll();
        if(!highest.equals("THE GREAT GATSBY")){
            System.out.println("Failed. Expected < THE GREAT GATSBY >" +
                        "Got <" + highest + ">.");
            printAll(queue.iterator());
            return false;
        }
        
        queue.remove("THE GREAT GATSBY");
        
        highest = queue.poll();
        if(!highest.equals("Lolita")){
            System.out.println("Failed. Expected < Lolita >" +
                        "Got <" + highest + ">.");
            
            printAll(queue.iterator());
            return false;
        }
        return true;
    }
    
    private static boolean testBothArraysAreEqual(Iterator<String> queueIterator,
            Iterator<TestObject<String>> testIterator) {

        while (queueIterator.hasNext() && testIterator.hasNext()) {
            String valFromQueue = queueIterator.next();
            String valFromTestArray = testIterator.next().getItem();
            
            if (!valFromQueue.equals(valFromTestArray)) {
                
                System.out.println("Failed. Expected <" + valFromTestArray + "> "
                        + "Got <" + valFromQueue + ">.");
                printAll(queueIterator);
                
                return false;
            }
        }

        if (queueIterator.hasNext() || testIterator.hasNext()) {
            return false;
        }

        return true;
    }
}
