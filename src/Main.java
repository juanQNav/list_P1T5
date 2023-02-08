package main;

import uaslp.objetos.list.linkedlist.LinkedList;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList list = new LinkedList();
        String data, answer;
        int index;

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


        System.out.print("what index? ");
        index = in.nextInt();

        data = list.getAt(index);
        System.out.println(data + " ");

        System.out.print("what index remove? ");
        index = in.nextInt();

        list.remove(index);
        for(index = 1; index <= list.getSize(); index++){
            data = list.getAt(index);
            System.out.println(data + " ");
        }
    }
}
