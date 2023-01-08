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
public class TestCustomer {

    public static boolean runTest() {
        boolean commonTestResult = true;
        boolean result = runTest_correctPriority();
        commonTestResult &= result;
        System.out.println("\nTestCustomer -> runTest_correctPriority Result: " + result);

        result = runTest_remove();
        commonTestResult &= result;
        System.out.println("\nTestCustomer -> runTest_remove Result: " + result);

        result = runTest_poll();
        commonTestResult &= result;
        System.out.println("\nTestCustomer -> runTest_poll Result: " + result);

        result = runTest_contains();
        commonTestResult &= result;
        System.out.println("\nTestCustomer -> runTest_contains Result: " + result);


        return commonTestResult;
    }

    private static boolean runTest_correctPriority() {
        PriorityQueue<CustomerTestObject> queue = new PriorityQueue<>(6);
        ArrayList<CustomerTestObject> testCustmers = new ArrayList<>();

        CustomerTestObject c1 = new CustomerTestObject("ABA", "2345", "inquire 1");
        CustomerTestObject c3 = new CustomerTestObject("aaa", "5786", "inquire 3");
        CustomerTestObject c4 = new CustomerTestObject("bbb", "3453", "inquire 4");
        CustomerTestObject c5 = new CustomerTestObject("wer", "5674", "inquire 5");
        CustomerTestObject c6 = new CustomerTestObject("qwqw", "1232", "inquire 4");

        queue.add(c1, 5);
        queue.add(c3, 1);
        queue.add(c4, 3);
        queue.add(c5, 1);
        queue.add(c6, 5);

        testCustmers.add(c3);
        testCustmers.add(c5);
        testCustmers.add(c4);
        testCustmers.add(c1);
        testCustmers.add(c6);

        return testBothArraysAreEqual(queue.iterator(), testCustmers.iterator());

    }

    private static boolean runTest_poll() {
        PriorityQueue<CustomerTestObject> queue = new PriorityQueue<>(6);
        ArrayList<CustomerTestObject> testCustmers = new ArrayList<>();

        CustomerTestObject c1 = new CustomerTestObject("ABA", "2345", "inquire 1");
        CustomerTestObject c3 = new CustomerTestObject("aaa", "5786", "inquire 3");
        CustomerTestObject c4 = new CustomerTestObject("bbb", "3453", "inquire 4");
        CustomerTestObject c5 = new CustomerTestObject("wer", "5674", "inquire 5");
        CustomerTestObject c6 = new CustomerTestObject("qwqw", "1232", "inquire 4");

        queue.add(c1, 5);
        queue.add(c3, 1);
        queue.add(c4, 3);
        queue.add(c5, 1);
        queue.add(c6, 5);

        testCustmers.add(c3);
        testCustmers.add(c5);
        testCustmers.add(c4);
        testCustmers.add(c1);
        testCustmers.add(c6);

        CustomerTestObject removed = queue.poll();
        testCustmers.remove(c3);

        if (!c3.equals(removed)) {
            return false;
        }

        return testBothArraysAreEqual(queue.iterator(), testCustmers.iterator());

    }

    private static boolean runTest_remove() {
        PriorityQueue<CustomerTestObject> queue = new PriorityQueue<>(6);
        ArrayList<CustomerTestObject> testCustmers = new ArrayList<>();

        CustomerTestObject c1 = new CustomerTestObject("ABA", "2345", "inquire 1");
        CustomerTestObject c3 = new CustomerTestObject("aaa", "5786", "inquire 3");
        CustomerTestObject c4 = new CustomerTestObject("bbb", "3453", "inquire 4");
        CustomerTestObject c5 = new CustomerTestObject("wer", "5674", "inquire 5");
        CustomerTestObject c6 = new CustomerTestObject("qwqw", "1232", "inquire 4");

        queue.add(c1, 5);
        queue.add(c3, 1);
        queue.add(c4, 3);
        queue.add(c5, 1);
        queue.add(c6, 5);

        testCustmers.add(c3);
        testCustmers.add(c5);
        testCustmers.add(c4);
        testCustmers.add(c1);
        testCustmers.add(c6);

        queue.remove(c3);
        testCustmers.remove(c3);

        return testBothArraysAreEqual(queue.iterator(), testCustmers.iterator());

    }

    private static boolean runTest_contains() {
        PriorityQueue<CustomerTestObject> queue = new PriorityQueue<>(6);

        CustomerTestObject c1 = new CustomerTestObject("ABA", "2345", "inquire 1");
        CustomerTestObject c2 = new CustomerTestObject("ABA_1", "2345", "inquire 1");
        CustomerTestObject c3 = new CustomerTestObject("aaa", "5786", "inquire 3");
        CustomerTestObject c4 = new CustomerTestObject("bbb", "3453", "inquire 4");
        CustomerTestObject c5 = new CustomerTestObject("wer", "5674", "inquire 5");
        CustomerTestObject c6 = new CustomerTestObject("qwqw", "1232", "inquire 4");

        queue.add(c1, 5);
        queue.add(c3, 1);
        queue.add(c4, 3);
        queue.add(c5, 1);
        queue.add(c6, 5);

        if (!queue.contains(c2)) {
            return false;
        }

        return true;
    }

    private static void printAll(Iterator<CustomerTestObject> iterator) {
        for (; iterator.hasNext();) {
            CustomerTestObject next = (CustomerTestObject) iterator.next();
            System.out.print(" <" + next + "> ");
        }
    }

    private static boolean testBothArraysAreEqual(Iterator<CustomerTestObject> queueIterator,
            Iterator<CustomerTestObject> testIterator) {

        while (queueIterator.hasNext() && testIterator.hasNext()) {
            if (!queueIterator.next().equals(testIterator.next())) {
                return false;
            }
        }

        if (queueIterator.hasNext() || testIterator.hasNext()) {
            return false;
        }

        return true;
    }
}
