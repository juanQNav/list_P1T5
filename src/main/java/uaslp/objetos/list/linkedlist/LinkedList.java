package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedList <T> implements List <T> {
    private Node <T> head;
    private Node <T> tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public void addAtTail(T data) throws NotNullAllowedException {
        if (data == null){
            throw new NotNullAllowedException();
        }
        Node <T> node = new Node <> (data);
        Node <T> pointer;
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
    public void addAtFront(T data) throws NotNullAllowedException {
        if( data == null){
            throw new NotNullAllowedException();
        }
        Node <T> node = new Node<>(data);
        Node <T> pointer;

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
    public void remove(int index) throws BadIndexException {
        if (index < 0 || index >= size){
            throw new BadIndexException();
        }
        Node <T> next;
        Node <T> previous;
        if(head != null) {
            if(size == 1){
                head = null;
                tail = null;
            }else{
                if(index == 0){
                    next = head.next;
                    next.previous = null;
                    head = next;
                }else {
                    int indexIterator = 0;
                    LinkedListIterator <T> iterator = (LinkedListIterator <T>) getIterator();
                    while (iterator.hasNext() && indexIterator != index) {
                        iterator.next();
                        indexIterator++;
                    }
                    if(index == size -1){
                        previous = iterator.currentNode.previous;
                        previous.next = null;
                    }else {
                        next = iterator.currentNode.next;
                        previous = iterator.currentNode.previous;
                        previous.next = next;
                        next.previous = previous;
                    }
                }
            }
            size--;
        }
    }
    public void removeAll()
    {
        if(head != null){
            head = null;
            tail = null;
            size = 0;
        }
    }
    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException {
        if(index < 0 || index >= size){
            throw new BadIndexException();
        }
        if(data == null){
            throw new NotNullAllowedException();
        }
        if(head != null) {
            LinkedListIterator <T> iterator = (LinkedListIterator <T>) getIterator();
            int indexIterator = 0;
            while (iterator.hasNext() && indexIterator != index) {
                iterator.next();
                indexIterator++;
            }
            if(indexIterator == index)
            {
                iterator.currentNode.data = data;
            }
        }
    }
    public T getAt(int index) throws BadIndexException{
        if (index < 0 || index > size){
            throw new BadIndexException();
        }
        T data = null;
        if(head != null){
            int indexIterator = 0;
            LinkedListIterator <T> iterator = (LinkedListIterator <T>) getIterator();
            data = iterator.next();
            while (iterator.hasNext() && indexIterator != index){
                data = iterator.next();
                indexIterator++;
            }
        }
        return data;
    }
    public void removeAllWithValue(Object data){
        if(head != null) {
            LinkedListIterator <T> iterator = (LinkedListIterator <T>) getIterator();
            int indexIterator = 0;
            int eliminationCounter = 0;
            while (iterator.hasNext()) {
                if (data.equals(iterator.currentNode.data)) {
                    try {
                        remove(indexIterator-eliminationCounter);
                    } catch (BadIndexException ignored) {
                    }
                    eliminationCounter++;
                }
                iterator.next();
                indexIterator++;
            }
        }
    }
    public int getSize(){
        return size;
    }
    public Iterator <T> getIterator(){
        return new LinkedListIterator<>(head);
    }
}
