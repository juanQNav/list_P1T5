package uaslp.objetos.list.arraylist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayListTest {
    @Test
    public void whenArrayListCreate_thenItIsEmpty(){
        //incialización
        ArrayList <String> arrayList = new ArrayList<>();
        //Ejecución
        int size = arrayList.getSize();
        //validación
        Assertions.assertEquals(0,size);
    }
    @Test
    public void whenAddAtTailWithNullDataOnArrayList_thenExceptionIsThrow (){
        //inicializacón
        ArrayList <String> arrayList = new ArrayList<>();
        //validación
        Assertions.assertThrows(NotNullAllowedException.class, ()-> arrayList.addAtTail(null));
    }
    @Test
    public void whenAddAtTail_andExceedsTheSize_thenSizeIncreases() throws NotNullAllowedException{
        //inicializacion
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtTail("1");
        arrayList.addAtTail("2");
        //ejecuccion
        arrayList.addAtTail("3");
        //validadcion
        Assertions.assertEquals(3, arrayList.getSize());
    }
    @Test
    public void whenAddAtFrontWithNullDataOnArrayList_thenExceptionIsThrow (){
        //inicializacón
        ArrayList <String> arrayList = new ArrayList<>();
        //validación
        Assertions.assertThrows(NotNullAllowedException.class, ()-> arrayList.addAtFront(null));
    }
    @Test
    public void whenAddAtFront_andExceedsTheSize_thenSizeIncreases() throws NotNullAllowedException{
        //inicializacion
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtFront("1");
        arrayList.addAtFront("2");
        //ejecuccion
        arrayList.addAtFront("3");
        //validadcion
        Assertions.assertEquals(3, arrayList.getSize());
    }
    @Test
    public void whenRemoveBadIndexOnArrayList_thenExceptionIsThrow() throws NotNullAllowedException{
        //incialización
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtFront("1");
        arrayList.addAtFront("2");
        //validación
        Assertions.assertThrows(BadIndexException.class,()-> arrayList.remove(4));
    }
    @Test
    public  void whenRemoveIndexOnArrayList_thenSizeIsDecreasesOne() throws NotNullAllowedException, BadIndexException{
        //inicializacion
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtFront("1");
        arrayList.addAtFront("2");
        arrayList.addAtFront("3");
        //ejeucion
        arrayList.remove(1);
        //validacion
        Assertions.assertEquals(2,arrayList.getSize());
    }
    @Test
    public void whenRemoveAllOnArrayList_thenSizeIsZero() throws NotNullAllowedException{
        //inicialización
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtFront("1");
        arrayList.addAtFront("2");
        arrayList.addAtFront("3");
        //ejecucin
        arrayList.removeAll();
        //validacion
        Assertions.assertEquals(0,arrayList.getSize());
    }
    @Test
    public void whenSetAtBadIndexOnArrayList_theExceptionIsThrow() throws NotNullAllowedException{
        //inicializacion
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtFront("1");
        //validacion
        Assertions.assertThrows(BadIndexException.class,()-> arrayList.setAt(3,"3"));
    }
    @Test
    public void whenSetAtNullDataOnArrayList_theExceptionIsThrow() throws NotNullAllowedException{
        //inicializacion
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtFront("1");
        //validacion
        Assertions.assertThrows(NotNullAllowedException.class,()-> arrayList.setAt(0,null));
    }
    @Test
    public void whenSetAtDataWithCorrectIndexOnArrayList_thenDataInThisIndexChanges() throws NotNullAllowedException, BadIndexException{
        //incializacion
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtTail("1");
        arrayList.addAtTail("2");
        //ejecucion
        String data = arrayList.getAt(1);
        arrayList.setAt(1,"x");
        //evaluacion
        Assertions.assertFalse(data == arrayList.getAt(1));
    }
    @Test
    public void whenGetAtBadIndexOnArrayList_theExceptionIsThrow() throws NotNullAllowedException{
        //inicializacion
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtFront("1");
        //validacion
        Assertions.assertThrows(BadIndexException.class,()-> arrayList.getAt(3));
    }
    @Test
    public void whenRemoveAllWithValueOnArrayList_thenSizeIsDecrease() throws NotNullAllowedException{
        //incialización
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.addAtTail("1");
        arrayList.addAtTail("2");
        arrayList.addAtTail("2");
        arrayList.addAtTail("2");
        arrayList.addAtTail("3");
        //ejecucion
        arrayList.removeAllWithValue("2");
        //evaluación
        Assertions.assertEquals(2,arrayList.getSize());
    }
}
