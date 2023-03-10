import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.linkedlist.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list1 = new ArrayList();
        List list2 = new LinkedList();
        String data, answer;
        int index;

        //*********addAtTail
        System.out.println("*********addAtTail");
        do {
            System.out.print("Enter data: ");
            data = in.nextLine();
            list1.addAtTail(data);
            System.out.print("another one? ");
            answer = in.nextLine();
        } while (answer.equals("yes"));

        printList(list1);

        //********getAt
        System.out.println("*********getAt ");
        System.out.print("what index? ");
        index = in.nextInt();
        data = list1.getAt(index);
        System.out.println(data + " ");

        //*********remove
        System.out.println("*********remove");
        System.out.print("what index remove? ");
        index = in.nextInt();
        list1.remove(index - 1);

        printList(list1);
        
        //*********removeAll
        System.out.println("*********removeALl");
        System.out.print("you want to empty the list: ");
        data = in.next();
        if(data.equals("yes")){
            list1.removeAll();
        }

        //*********addAtFront
        System.out.println("*********addAtFront");
        do {
            System.out.print("Enter data: ");
            data = in.next();
            list1.addAtFront(data);
            System.out.print("another one? ");
            answer = in.next();
        } while (answer.equals("yes"));

        printList(list1);

        //*********setAt
        System.out.println("*********setAt");
        System.out.print("Enter data: ");
        data = in.next();
        System.out.print("what index? ");
        index = in.nextInt();
        list1.setAt(index - 1,data);

        printList(list1);

        //*********removeAllWIthValue
        System.out.println("*********removeAllWithValue");
        System.out.print("what value: ");
        data = in.next();
        list1.removeAllWithValue(data);

        printList(list1);

        //*********getSize
        System.out.println("The current size of the list is: "+list1.getSize());
    }
    public static void printList(List list){
        Iterator iterator = list.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
