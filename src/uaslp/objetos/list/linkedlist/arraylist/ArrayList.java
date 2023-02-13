package uaslp.objetos.list.linkedlist.arraylist;

public class ArrayList {
    private static final int INITIAL_SIZE = 2;
    private String []array;
    private int size; // cuántos datos se han insertado al arreglo

    public ArrayList(){
        array = new String [INITIAL_SIZE];
    }

    public void addAtTail(String data){
        if(size == array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(String data){
        if(size == array.length){
            increaseSize();
        }
        if(size < 1){
            array[0] = data;
        }else{
            String aux = array[size-1];
            for(int i = size; i > 0; i--){
                array[i] = array[i - 1];
            }
            array[0] = data;
        }
        size++;
    }
    public void remove(int index){
        if(index <= size) {
            for(int i = index ; i < size-1; i++){
                array[i] = array[i + 1];
            }
            size--;
        }else {
            System.out.println("error: index not found");
        }
    }
    public void removeAll(){
        String []newArray = new String[INITIAL_SIZE];
        array = newArray;
        size= 0;
    }
    public void setAt(int index, String data){
        array[index] = data;
    }
    public String getAt(int index){
        String data = null;
        int indexIterator = 0;
        if(index <= size)
        {
            ArrayListIterator iterator = getIterator();
            data = iterator.currentIndex[0];
            while (iterator.hasNext() && indexIterator != index){
                data = iterator.next();
                indexIterator++;
            }
            return data;
        }else {
            return "error: index not found";
        }
    }
    public void removeAllWithValue(String data){
        ArrayListIterator iterator = getIterator();
        int index = 0;
        int eliminatorCounter = 0;
        while (iterator.hasNext() && index < size){
            if(data.equals(iterator.next())){
                remove(index-eliminatorCounter);
            }
            index++;
        }
    }
    public int getSize(){
        return size;
    }
    private void increaseSize(){
        String []newArray = new String[array.length * 2];

        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
    public ArrayListIterator getIterator() {
        return new ArrayListIterator(array);
    }
}
