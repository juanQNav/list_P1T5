package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayList <T> implements List <T>{
    private static final int INITIAL_SIZE = 2;
    private Object []array;
    private int size; // cuántos datos se han insertado al arreglo

    public ArrayList(){
        array = new Object [INITIAL_SIZE];
    }

    public void addAtTail(T data) throws NotNullAllowedException {
        if(data == null){
            throw new NotNullAllowedException();
        }
        if(size == array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(T data) throws NotNullAllowedException {
        if(data == null){
            throw new NotNullAllowedException();
        }
        if(size == array.length){
            increaseSize();
        }
        if (size >= 1) {
            for (int i = size; i > 0; i--) {
                array[i] = array[i - 1];
            }
        }
        array[0] = data;
        size++;
    }
    public void remove(int index) throws BadIndexException {
        if(index < 0 || index >= size) {
            throw new BadIndexException();
        }else {
            for(int i = index ; i < size; i++){
                array[i] = array[i + 1];
            }
            size--;
        }
    }
    public void removeAll(){
        array = new Object[INITIAL_SIZE];
        size= 0;
    }
    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException {
        if(index < 0 || index >= size){
            throw new BadIndexException();
        }
        if(data == null){
            throw new NotNullAllowedException();
        }
        array[index] = data;
    }
    public T getAt(int index) throws BadIndexException{
        if(index < 0 || index > size){
            throw new BadIndexException();
        }else{
        int indexIterator = 0;
            ArrayListIterator <T> iterator = (ArrayListIterator <T>) getIterator();
            while (iterator.hasNext() && indexIterator != index){
                indexIterator++;
                iterator.next();
            }
            return iterator.array[indexIterator];
        }
    }
    public void removeAllWithValue(T data){
        int counterEliminations = 0;
        int auxSize = getSize();
       for(int i = 0; i < auxSize; i++){
           if(data.equals(array[i-counterEliminations])){
               try {
                   remove(i - counterEliminations);
               } catch (BadIndexException ignored) {

               }
               counterEliminations++;
           }
       }

    }
    public int getSize(){
        return size;
    }
    private void increaseSize(){
        Object []newArray = new Object[array.length * 2];

        for(int i = 0; i < array.length; i++){
            newArray[i] = (T) array[i];
        }
        array = newArray;
    }
    public Iterator <T> getIterator() {
        return (Iterator<T>) new ArrayListIterator<>(array);
    }
}
