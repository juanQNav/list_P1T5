package uaslp.objetos.list.linkedlist;
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
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
        Node next, previous;
        if(head != null) {
            int indexIterator = 1;
            LinkedListIterator iterator = getIterator();
            while (iterator.hasNext() && indexIterator != index){
                iterator.next();
                indexIterator++;
            }
            if(index <= size && index == indexIterator) {
                next = iterator.currentNode.next;
                previous = iterator.currentNode.previous;
                if (size == 1 && index == 1) {
                    head = null;
                    tail = null;
                } else if (index > 1) {
                    if (index == size) {
                        previous = next;
                        tail = previous;
                    } else {
                        next.previous = previous;
                        previous.next = next;
                    }
                } else {
                    next.previous = previous;
                    head = next;
                }
                size--;
            }else {
                System.out.println("error: index not found");
            }
        }else {
            System.out.println("error: list is empty");
        }
    }
    public void removeAll()
    {
        if(head != null){
            head = null;
            tail = null;
        }else{
            System.out.println("error: list is empty");
        }
    }
    public void setAt(int index, String data){
        Node node = new Node(data);

        if( head != null) {
            int indexIterator = 1;
            LinkedListIterator iterator = getIterator();
            while (iterator.hasNext() && indexIterator != index) {
                iterator.next();
                indexIterator++;
            }
            if (index <=size && index == indexIterator) {
                if (size == 1 && index == 1) {
                    node.next = head;
                    head.previous = node;
                    head = node;
                } else if (index > 1) {
                    if (index == size) {
                        Node auxiliary = tail.previous;
                        node.next = tail;
                        node.previous = tail.previous;
                        tail.previous = node;
                        auxiliary.next = node;
                    } else {
                        Node auxiliary = iterator.currentNode.previous;
                        node.next = iterator.currentNode;
                        node.previous = auxiliary;
                        auxiliary.next = node;
                        iterator.currentNode.previous = node;
                    }
                } else {
                    node.next = head;
                    head.previous = node;
                    head = node;
                }
                size++;
            }else {
                System.out.println("error: index not found");
        }
        }else {
            System.out.println("error: list is empty");
        }
    }
    public String getAt(int index){
        String data;
        if(head == null) {
            return "error: list is empty";
        }
        else{
            int indexIterator = 1;
            LinkedListIterator iterator = getIterator();
            data = iterator.next();
            while (iterator.hasNext() && indexIterator != index){
                data = iterator.next();
                indexIterator++;
            }
            if(index == indexIterator){
                return data;
            }else {
                return  "error: index not found";
            }
        }
    }
    public int getSize(){
        return size;
    }
    public LinkedListIterator getIterator(){
        return new LinkedListIterator(head);
    }
}
