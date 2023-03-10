package uaslp.objetos.list;
public interface List {
    public void addAtTail(String data);
    public void addAtFront(String data);
    public void remove(int index);
    public void removeAll();
    public void setAt(int index, String data);
    public String getAt(int index);
    public void removeAllWithValue(String data);
    public int getSize();
    public Iterator getIterator();
}
