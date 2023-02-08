package uaslp.objetos.list.linkedlist;

public class ListaEnlazada {
    private Node head;
    private Node tail;
    private int size;

    public ListaEnlazada(){
        head = null;
        tail = null;
        size = 0;
    }
    public void addAtTail(String data){
        Node node = new Node(data);
        Node pointer;
        if(tail != null){
            pointer = tail;
            pointer.next = node;
            node.previous = pointer;
            tail = node;
        }else {
            tail = node;
            head = node;
        }
        size++;
    }
    public void addAtFront(String data){
        Node node = new Node(data);
        Node pointer;

        if(head != null){
            pointer = head;
            pointer.previous = node;
            node.next = head;
            head = node;
        }else{
            head = node;
            tail = node;
        }
        size++;
    }
    public void remove(int index){
        Node pointer;
        Node next, previous;

        if(head != null){
            pointer = searchNode(index);
            next = pointer.next;
            previous = pointer.previous;
            next.previous = previous;
            previous.next = next;
        }
    }
    private Node searchNode(int index){
        int iterator;
        Node pointer;

        if(index < size/2){
            iterator = 1;
            pointer = head;
            while(iterator < index && pointer != null){
                pointer = pointer.next;
                iterator++;
            }
        }else{
            iterator = size;
            pointer = tail;
            while (iterator > index && pointer != null){
                pointer = pointer.previous;
                iterator--;
            }
        }
        if(iterator != index)
            return null;
        else
            return pointer;
    }
    public String getAt(int index){
        Node pointer;

        if(head == null)
            return null;
        else{
            pointer = searchNode(index);
            return pointer.data;
        }
    }
    public int getSize(){
        return size;
    }
}
