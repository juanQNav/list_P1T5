package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator<T>  implements Iterator<T>{
    T []array;
    int currentIndex;
    ArrayListIterator(T []first){
        array = first;
        currentIndex = 0;
    }
    public boolean hasNext(){return array[currentIndex] != null;}
    public T next(){
        T data = array[currentIndex];
        currentIndex++;
        return data;
    }
}

