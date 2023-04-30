package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedListTest {

    @Test
    public void whenLinkedListIsCreate_thenItIsEmpty() {
        //inicialización
        LinkedList<String> list = new LinkedList<>();
        //ejecución
        int size = list.getSize();
        //validación
        Assertions.assertEquals(0, size);
    }

    @Test
    public void whenAddAtTailList_thenSizeIncreasesOne() throws NotNullAllowedException {
        //incializacion
        LinkedList<String> list = new LinkedList<>();
        //ejecucion
        list.addAtTail("1");
        //validacion
        Assertions.assertEquals(1, list.getSize());
        //ejecucion2
        list.addAtTail("2");
        //validacion2
        Assertions.assertEquals(2, list.getSize());
    }

    @Test
    public void whenAddNullDataToAddAtTailList_thenExceptionIsThrow() {
        //incializacion
        LinkedList<String> list = new LinkedList<>();
        //ejecución
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtTail(null));
        //validación

    }

    //checkpoint********
    @Test
    public void whenAddAtFrontList_thenSizeIncreasesOne() throws NotNullAllowedException {
        //incializacion
        LinkedList<String> list = new LinkedList<>();
        //ejecucion
        list.addAtFront("1");
        //validacion
        Assertions.assertEquals(1, list.getSize());
        //ejecucion2
        list.addAtFront("2");
        //validacion2
        Assertions.assertEquals(2, list.getSize());
    }

    @Test
    public void whenAddNullDataToAddAtFrontList_thenExceptionIsThrow() {
        //incializacion
        LinkedList<String> list = new LinkedList<>();
        //ejecución
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));
        //validación

    }

    @Test
    public void whenRemoveAllList_thenSizeZero() throws NotNullAllowedException {
        //incializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        //ejecucion
        list.removeAll();
        //verificacion
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void whenRemoveOneElementIndexOnList_thenSizeDecrementOne() throws BadIndexException, NotNullAllowedException {
        //incializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        //ejecucion1
        list.remove(0);
        //verificacion1
        Assertions.assertEquals(1, list.getSize());
        //inicializacion2
        list.addAtTail("2");
        list.addAtTail("3");
        //ejecucion2
        list.remove(1);
        //verificacion2
        Assertions.assertEquals(2, list.getSize());
        //ejecucion3
        list.remove(1);
        list.remove(0);
        //verificacion3
        Assertions.assertEquals(0,list.getSize());
    }

    @Test
    public void whenRemoveBadIndexOnList_thenExceptionIsThrow() throws NotNullAllowedException {
        //inicialización
        LinkedList<String> list = new LinkedList<>();
        //ejecución
        list.addAtFront("1");
        //validación
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(10));
    }
    @Test
    public void whenRemoveAllWithValueList_thenSizeDecrement() throws NotNullAllowedException{
        //incializacion
        LinkedList <String> list = new LinkedList<>();
        list.addAtFront("1");
        list.addAtFront("2");
        list.addAtFront("2");
        list.addAtFront("2");
        list.addAtFront("3");
        //ejecucion
        list.removeAllWithValue("2");
        //verificacion
        Assertions.assertEquals(2, list.getSize());
    }
    ///**********
    @Test
    public void whenSetAtNullDataOnList_thenExceptionIsThrow() throws NotNullAllowedException{
        //inicializacion
        LinkedList <String> list = new LinkedList<>();
        //ejecucion
        list.addAtTail("1");
        //verificacion
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.setAt(0, null));
    }
    @Test
    public void whenSetAtBadIndexOnList_thenExceptionISThrow() throws NotNullAllowedException{
        //incializacion
        LinkedList <String> list = new LinkedList<>();
        //ejecucion
        list.addAtTail("1");
        //verificacion
        Assertions.assertThrows(BadIndexException.class, () -> list.setAt(3,"2"));
    }
    @Test
    public void whenSetAtDataOnList_thenThisIndexDataChange() throws NotNullAllowedException, BadIndexException{
        //incializacion
        LinkedList <String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        list.addAtTail("3");
        //ejecucion
        list.setAt(1, "5");
        //verificacion
        Assertions.assertEquals("5",list.getAt(1));
    }
    @Test
    public void whenGetAtBadIndexOnList_thenExceptionIsThrow() throws NotNullAllowedException{
        //incializacion
        LinkedList <String> list = new LinkedList<>();
        //ejecucion
        list.addAtTail("1");
        //validadcion
        Assertions.assertThrows(BadIndexException.class, ()-> list.getAt(5));
    }
}
