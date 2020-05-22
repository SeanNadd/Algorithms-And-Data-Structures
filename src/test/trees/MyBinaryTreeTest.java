package trees;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MyBinaryTreeTest {

    MyBinaryTree<String> myBinaryTree;

    @Before
    public void setUp() throws Exception {
        TreeNode<String> root = new TreeNode<>("D", null);
        myBinaryTree = new MyBinaryTree<>(root);
        root.addLeftChild("B").addLeftChild("A");
        root.getLeftChild().addRightChild("C");
        root.addRightChild("F").addLeftChild("E");
        root.getRightChild().addRightChild("G");
    }

    @Test
    public void testPreOrderTraversal(){
        assertEquals("Traversing with pre-order technique", "DBACFEG", myBinaryTree.getPreOrderTraversal().stream().collect(Collectors.joining()));
    }

    @Test
    public void testPostOrderTraversal(){
        assertEquals("Traversing with post-order technique", "ACBEGFD", myBinaryTree.getPostOrderTraversal().stream().collect(Collectors.joining()));
    }

    @Test
    public void testInOrderTraversal(){
        assertEquals("Traversing with in-order technique", "ABCDEFG", myBinaryTree.getInOrderTraversal().stream().collect(Collectors.joining()));
    }

    @Test
    public void testLevelOrderTraversal(){
        assertEquals("Traversing with level-order technique", "DBFACEG", myBinaryTree.getLevelOrderTraversal().stream().collect(Collectors.joining()));
    }

    @Test
    public void testBinarySearchTree(){
        assertEquals("Using binary search on an existing value", "C", myBinaryTree.getValue("C"));
        assertEquals("Using binary search on a non-existing value", null, myBinaryTree.getValue("P"));
    }

    @Test
    public void testBinarySearchTreeInsertion(){
        assertEquals("Inserting an existing value", null, myBinaryTree.insert("A"));
        assertEquals("Inserting a new value", "P", myBinaryTree.insert("P"));
        assertEquals("Checking value properly inserted", "P", myBinaryTree.getValue("P"));
    }

    @Test
    public void testBinarySearchTreeDeletionNonExisting(){
        assertEquals("Attampting to delete a non-existing value", null, myBinaryTree.delete("P"));
    }

    @Test
    public void testBinarySearchTreeDeletionLeafNode(){
        assertEquals("Deleting a leaf node", "A", myBinaryTree.delete("A"));
        assertEquals("Checking that leaf node was deleted", null, myBinaryTree.getValue("A"));
    }

    @Test
    public void testBinarySearchTreeDeletionOneChildNode(){
        myBinaryTree.insert("L");
        myBinaryTree.insert("I");
        myBinaryTree.insert("H");
        myBinaryTree.insert("J");
        assertEquals("Deleting a node with one child", "L", myBinaryTree.delete("L"));
        assertEquals("Checking the one child node was deleted OK", null, myBinaryTree.getValue("L"));
        assertEquals("Checking the one child node was deleted OK", "I", myBinaryTree.getValue("I"));
        assertEquals("Checking the one child node was deleted OK", "H", myBinaryTree.getValue("H"));
        assertEquals("Checking the one child node was deleted OK", "J", myBinaryTree.getValue("J"));
    }

    @Test
    public void testBinarySearchTreeDeletionBothChildNodes(){
        myBinaryTree.insert("J");
        myBinaryTree.insert("H");
        myBinaryTree.insert("L");
        myBinaryTree.insert("K");
        myBinaryTree.insert("M");
        assertEquals("Deleting a node with one child", "J", myBinaryTree.delete("J"));
        assertEquals("Checking the two child node was deleted OK", "H", myBinaryTree.getValue("H"));
        assertEquals("Checking the two child node was deleted OK", "L", myBinaryTree.getValue("L"));
        assertEquals("Checking the two child node was deleted OK", "K", myBinaryTree.getValue("K"));
        assertEquals("Checking the two child node was deleted OK", "M", myBinaryTree.getValue("M"));
    }



}
