package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator implements Iterator {
    String []currentIndex;
    int index;
    ArrayListIterator(String []first){
        currentIndex = first;
        index = 0;
    }
    public boolean hasNext(){return currentIndex[index] != null;}
    public String next(){
        String data = currentIndex[index];
        index++;
        return data;
    }
}
