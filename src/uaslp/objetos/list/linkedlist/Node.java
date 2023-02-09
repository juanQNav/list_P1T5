package uaslp.objetos.list.linkedlist;

class Node {
    String data;
    Node next;
    Node previous;

    public Node(String data) {
        this.data = data;
        next = null;
        previous = null;
    }
}
