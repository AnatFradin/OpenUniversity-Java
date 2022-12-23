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

    public boolean runTest() {
        System.out.println("\nRunning runTest1" );
        boolean result = runTest1();
        System.out.println("\nrunTest1 : " + result);
        
        System.out.println("\nRunning runTest2" );
        result = runTest2();
        System.out.println("\nrunTest2 : " + result);
        
        System.out.println("\nRunning runTest3" );
        result = runTest3();
        System.out.println("\nrunTest3 : " + result);
        
        
        return result;
    }

    private void printAll(Iterator<String> iterator) {
        for (; iterator.hasNext();) {
            String next = (String) iterator.next();
            System.out.print(" <" + next + "> ");
        }
    }

    private boolean runTest1() {
          PriorityQueue<String> queue = new PriorityQueue<>(8);

        ArrayList<TestObject<String>> testArr = new ArrayList();

        testArr.add(new TestObject<String>("THE GREAT GATSBY", 1));
        testArr.add(new TestObject<String>("Lolita", 1));
        testArr.add(new TestObject<String>("BRAVE NEW WORLD", 4));
        testArr.add(new TestObject<String>("CATCH-22", 8));

        for (TestObject<String> testObject : testArr) {
            queue.add(testObject.getItem(), testObject.getPriority());
        }

        int index = 0;
        for (Iterator iterator = queue.iterator(); iterator.hasNext();) {
            String next = (String) iterator.next();

            if (!next.equals(testArr.get(index).getItem())) {
                System.out.println("Test Failed. Expected <" + testArr.get(index).getItem() + "> "
                        + "Got <" + next + ">.");
                printAll(queue.iterator());
                return false;
            }
            index++;
        }
        printAll(queue.iterator());

        return true;
    }
    
    private boolean runTest2() {
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
        
        int index = 0;
        for (Iterator iterator = queue.iterator(); iterator.hasNext();) {
            String next = (String) iterator.next();

            if (!next.equals(testArr.get(index).getItem())) {
                System.out.println("Test Failed. Expected <" + testArr.get(index).getItem() + "> "
                        + "Got <" + next + ">.");
                printAll(queue.iterator());
                return false;
            }
            index++;
        }
        printAll(queue.iterator());

        return true;
    }
    
    private boolean runTest3() {
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
        
        
        int index = 0;
        for (Iterator iterator = queue.iterator(); iterator.hasNext();) {
            String next = (String) iterator.next();

            if (!next.equals(testArr.get(index).getItem())) {
                System.out.println("Test Failed. Expected <" + testArr.get(index).getItem() + "> "
                        + "Got <" + next + ">.");
                printAll(queue.iterator());
                return false;
            }
            index++;
        }
        printAll(queue.iterator());

        return true;
    }
}
