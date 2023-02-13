import uaslp.objetos.list.linkedlist.arraylist.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList array = new ArrayList();
        String data, answer;
        int index;

        //*********addAtTail
        System.out.println("*********addAtTail");
        do {
            System.out.print("Enter data: ");
            data = in.nextLine();
            array.addAtTail(data);
            System.out.print("another one? ");
            answer = in.nextLine();
        } while (answer.equals("yes"));

        for(index = 0; index < array.getSize(); index++){
            data = array.getAt(index);
            System.out.println(data + " ");
        }

        //********getAt
        System.out.println("*********getAt ");
        System.out.print("what index? ");
        index = in.nextInt();
        data = array.getAt(index-1);
        System.out.println(data + " ");
        //*********remove
        System.out.println("*********remove");
        System.out.print("what index remove? ");
        index = in.nextInt();
        array.remove(index-1);
        for(index = 0; index < array.getSize(); index++){
            data = array.getAt(index);
            System.out.println(data + " ");
        }
        
        //*********removeAll
        System.out.println("*********removeALl");
        System.out.print("you want to empty the list: ");
        data = in.next();
        if(data.equals("yes")){
            array.removeAll();
        }

        //*********addAtFront
        System.out.println("*********addAtFront");
        do {
            System.out.print("Enter data: ");
            data = in.next();
            array.addAtFront(data);
            System.out.print("another one? ");
            answer = in.next();
        } while (answer.equals("yes"));

        for(index = 0; index < array.getSize(); index++){
            data = array.getAt(index);
            System.out.println(data + " ");
        }
        //*********setAt
        System.out.println("*********setAt");
        System.out.print("Enter data: ");
        data = in.next();
        System.out.print("what index? ");
        index = in.nextInt();
        array.setAt(index-1,data);
        for(index = 0; index < array.getSize(); index++){
            data = array.getAt(index);
            System.out.println(data + " ");
        }
        //*********removeAllWIthValue
        System.out.println("*********removeAllWithValue");
        System.out.print("what value: ");
        data = in.next();
        array.removeAllWithValue(data);
        for(index = 0; index < array.getSize(); index++){
            data = array.getAt(index);
            System.out.println(data + " ");
        }
        //*********getSize
        System.out.println("The current size of the list is: "+array.getSize());
    }
}
