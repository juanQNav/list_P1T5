@startuml

title LinkedList - Class Diagram


+class uaslp.objetos.list.linkedlist.LinkedList {
-Node head;
-Node tail;
-int size;

+addAtTail (String data)
+addAtFront(String data)
+remove(index)
+removeAll()
+setAt(index, data)
+getAt(index):String
+removeAllWithValue(String data)
+getSize();
+getIterator(): LinkedListIterator


}

~class uaslp.objetos.list.linkedlist.Node{
~String data;
~Node next;
~Node previous;
}

+class uaslp.objetos.list.linkedlist.LinkedListIterator{
+hasNext(): boolean;
+next(): String;
}


@enduml
