package uaslp.objetos.list.linkedlist.arraylist;

public class ArrayListIterator {
    String []currentIndex;
    int index;
    ArrayListIterator(String []first){
        currentIndex = first;
        index = 1;
    }
    public boolean hasNext(){return currentIndex != null;}
    public String next(){
        String data = currentIndex[index];
        index++;
        return data;
    }
}
