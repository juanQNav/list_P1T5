import uaslp.objetos.list.linkedlist.LinkedList;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList list = new LinkedList();
        String data, answer;
        int index;

        //*********addAtTail
        System.out.println("*********addAtTail");
        do {
            System.out.print("Enter data: ");
            data = in.nextLine();
            list.addAtTail(data);
            System.out.print("another one? ");
            answer = in.nextLine();
        } while (answer.equals("yes"));

        for(index = 1; index <= list.getSize(); index++){
            data = list.getAt(index);
            System.out.println(data + " ");
        }

        //*********getAt
        System.out.println("*********getAt ");
        System.out.print("what index? ");
        index = in.nextInt();
        data = list.getAt(index);
        System.out.println(data + " ");

        //*********remove
        System.out.println("*********remove");
        System.out.print("what index remove? ");
        index = in.nextInt();
        list.remove(index);
        for(index = 1; index <= list.getSize(); index++){
            data = list.getAt(index);
            System.out.println(data + " ");
        }

        //*********removeAll
        System.out.println("*********removeALl");
        System.out.print("you want to empty the list: ");
        data = in.next();
        if(data.equals("yes")){
            list.removeAll();
        }

        //*********addAtFront
        System.out.println("*********addAtFront");
        do {
            System.out.print("Enter data: ");
            data = in.next();
            list.addAtFront(data);
            System.out.print("another one? ");
            answer = in.next();
        } while (answer.equals("yes"));

        for(index = 1; index <= list.getSize(); index++){
            data = list.getAt(index);
            System.out.println(data + " ");
        }
        //*********setAt
        System.out.println("*********setAt");
        System.out.print("Enter data: ");
        data = in.next();
        System.out.print("what index? ");
        index = in.nextInt();
        list.setAt(index,data);
        for(index = 1; index <= list.getSize(); index++){
            data = list.getAt(index);
            System.out.println(data + " ");
        }
        //*********removeAllWIthValue
        System.out.println("*********removeAllWithValue");
        System.out.print("what value: ");
        data = in.next();
        list.removeAllWithValue(data);
        for(index = 1; index <= list.getSize(); index++){
            data = list.getAt(index);
            System.out.println(data + " ");
        }
        //*********getSize
        System.out.println("The current size of the list is: "+list.getSize());
    }
}
