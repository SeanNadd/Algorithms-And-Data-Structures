package linkedlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    private static final int LONG_LIST_LENGTH =10;

    MyLinkedList<String> shortList;
    MyLinkedList<Integer> emptyList;
    MyLinkedList<Integer> longerList;
    MyLinkedList<Integer> list1;
    MyLinkedList<Integer> list2;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // Feel free to use these lists, or add your own
        shortList = new MyLinkedList<String>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new MyLinkedList<Integer>();
        longerList = new MyLinkedList<Integer>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++)
        {
            longerList.add(i);
        }
        list1 = new MyLinkedList<Integer>();
        list1.add(65);
        list1.add(21);
        list1.add(42);


        list2 = new MyLinkedList<Integer>();
        list2.add(0);
        list2.add(11);
        list2.add(22);
        list2.add(44);
        list2.add(55);
        list2.add(66);
    }


    /** Test if the get method is working correctly.
     */
    /*You should not need to add much to this method.
     * We provide it as an example of a thorough test. */
    @Test
    public void testGet()
    {
        //test empty list, get should throw an exception
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }

        // test short list, first contents, then out of bounds
        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));

        try {
            shortList.get(-1);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
        try {
            shortList.get(2);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
        // test longer list contents
        for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
            assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
        }

        // test off the end of the longer array
        try {
            longerList.get(-1);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {

        }
        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {
        }

    }


    /** Test removing an element from the list.
     * We've included the example from the concept challenge.
     * You will want to add more tests.  */
    @Test
    public void testRemove()
    {
        int a = list1.remove(0);
        assertEquals("Remove: check a is correct ", 65, a);
        assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
        assertEquals("Remove: check size is correct ", 2, list1.size());

        try {
            list1.get(2);
            fail("This index should not exist anymore");
        }catch (IndexOutOfBoundsException e){

        }

        try {
            list1.remove(5);
            fail("This index should not exist, and thus could not be removed.");
        }catch (IndexOutOfBoundsException e){

        }

        try {
            list1.remove(-1);
            fail("Cannot pass invalid value as Index.");
        }catch (IndexOutOfBoundsException e){

        }
    }

    /** Test adding an element into the end of the list, specifically
     *  public boolean add(E element)
     * */
    @Test
    public void testAddEnd()
    {
        try {
            list2.add(null);
            fail("Null elements cannot be added to the list.");
        }catch (NullPointerException e){

        }
        list2.add(77);
        assertEquals("Check list size increase", 7, list2.size());
        assertEquals("Check the value added is correct", (Integer)77, list2.get(6));
    }


    /** Test the size of the list */
    @Test
    public void testSize()
    {
        assertEquals("Check list size increase", 6, list2.size());
        assertEquals("Check list size increase", 0, emptyList.size());
    }



    /** Test adding an element into the list at a specified index,
     * specifically:
     * public void add(int index, E element)
     * */
    @Test
    public void testAddAtIndex()
    {
        try {
            list2.add(3, null);
            fail("Cannot add null values");
        }catch (NullPointerException e){

        }

        try{
            list2.add(9, 99);
            fail("Cannot add on an index outside the bounds");
        }catch (IndexOutOfBoundsException e){

        }

        try{
            list2.add(-1, 99);
            fail("Cannot add to an invalid index");
        }catch (IndexOutOfBoundsException e){

        }

        list2.add(3,33);
        assertEquals("Check the value added is correct", (Integer)33, list2.get(3));
        assertEquals("Check the value of previous index is correct", (Integer)22, list2.get(2));
        assertEquals("Check the value of next index is correct", (Integer)44, list2.get(4));
        assertEquals("Check list size increase", 7, list2.size());

        emptyList.add(0, 0);
        assertEquals("Check the value added is correct", (Integer)0, emptyList.get(0));
        assertEquals("Check list size increase", 1, emptyList.size());


    }

    /** Test setting an element in the list */
    @Test
    public void testSet()
    {
        try {
            list2.set(3, null);
            fail("Cannot set null values");
        }catch (NullPointerException e){

        }

        try{
            list2.set(9, 99);
            fail("Cannot set on an index outside the bounds");
        }catch (IndexOutOfBoundsException e){

        }

        try{
            list2.set(-1, 99);
            fail("Cannot set to an invalid index");
        }catch (IndexOutOfBoundsException e){

        }

        list2.set(3,33);
        assertEquals("Check the value added is correct", (Integer)33, list2.get(3));
        assertEquals("Check the value of previous index is correct", (Integer)22, list2.get(2));
        assertEquals("Check the value of next index is correct", (Integer)55, list2.get(4));

    }

}