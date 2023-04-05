import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.exceptions.CollectionsException;
import  uaslp.objetos.list.exceptions.NotNullAllowedException;

import uaslp.objetos.list.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {

        List<Object> list1 = new LinkedList<>();
        List<Object> list2 = new ArrayList<>();

        try {

            System.out.println("\nTest list1 (LinkedList)");
            testAddAtFront(list1);
            testAddAtTail(list1);
            testRemoveNthElement(list1);
            testSetAtIndex(list1);
            testGetAtIndex(list1);
            testRemoveAllWithValue(list1);

            System.out.println("\nTest list2 (ArrayList)");
            testAddAtFront(list2);
            testAddAtTail(list2);
            testRemoveNthElement(list2);
            testSetAtIndex(list2);
            testGetAtIndex(list2);
            testRemoveAllWithValue(list2);

        } catch (CollectionsException ex) {
            ex.printStackTrace();
        }
    }

    private static void testRemoveAllWithValue(List<Object> list) throws NotNullAllowedException {
        System.out.println("\n-> Test remove all with value.");
        list.addAtTail("A");
        list.addAtTail(1);
        list.addAtTail(1);
        list.addAtTail("A");
        list.addAtTail(1);
        list.addAtTail("A");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: ");
        list.removeAllWithValue("A");
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAllWithValue(1);
        printList(list);
        System.out.println("Size: " + list.getSize());
    }

    private static void testGetAtIndex(List<Object> list) throws CollectionsException {
        System.out.println("\n-> Test get at index.");
        list.addAtTail("0");
        list.addAtTail(1);
        list.addAtTail('2');
        printList(list);
        System.out.println(list.getAt(0));
        System.out.println(list.getAt(1));
        System.out.println(list.getAt(2));
        System.out.println(list.getAt(3));
        list.removeAll();
    }

    private static void testSetAtIndex(List<Object> list) throws CollectionsException {
        System.out.println("\n-> Test set at index.");
        list.addAtTail("A");
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail("D");
        printList(list);
        list.setAt(0, "X");
        list.setAt(1, 10);
        list.setAt(3, "Z");
        list.setAt(4, "ERROR");
        printList(list);
        list.removeAll();
    }

    private static void testRemoveNthElement(List<Object> list) throws CollectionsException{
        System.out.println("\n-> Test remove nth-element.");
        list.addAtTail("A");
        list.addAtTail(2);
        list.addAtTail("C");
        list.addAtTail(4);
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(4);
        list.remove(3);
        list.remove(1);
        list.remove(0);
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(0);
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(0);
    }

    private static void testAddAtTail(List<Object> list) throws NotNullAllowedException {
        System.out.println("\n-> Test add at Tail.");
        list.addAtTail("A");
        list.addAtTail('C');
        list.addAtTail(3);
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAll();
    }

    private static void testAddAtFront(List<Object> list) throws NotNullAllowedException {
        System.out.println("\n-> Test add at Front.");
        list.addAtFront("A");
        list.addAtFront(2);
        list.addAtFront('C');
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAll();
    }

    public static void printList(List<Object> list) {
        Iterator<Object> it = list.getIterator();
        System.out.print("List contents: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.print("\n");
    }

}