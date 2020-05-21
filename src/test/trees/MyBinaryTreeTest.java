package trees;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MyBinaryTreeTest {

    MyBinaryTree<String> myBinaryTree;

    @Before
    public void setUp() throws Exception {
        TreeNode<String> root = new TreeNode<>("A", null);
        myBinaryTree = new MyBinaryTree<>(root);
        root.addLeftChild("B").addLeftChild("C");
        root.getLeftChild().addRightChild("D");
        root.addRightChild("E").addLeftChild("F");
        root.getRightChild().addRightChild("G");
    }

    @Test
    public void testPreOrderTraversal(){
        assertEquals("Traversing with pre-order technique", "ABCDEFG", myBinaryTree.getPreOrderTraversal().stream().collect(Collectors.joining()));
    }

    @Test
    public void testPostOrderTraversal(){
        assertEquals("Traversing with post-order technique", "CDBFGEA", myBinaryTree.getPostOrderTraversal().stream().collect(Collectors.joining()));
    }

    @Test
    public void testInOrderTraversal(){
        assertEquals("Traversing with in-order technique", "CBDAFEG", myBinaryTree.getInOrderTraversal().stream().collect(Collectors.joining()));
    }

    @Test
    public void testLevelOrderTraversal(){
        assertEquals("Traversing with level-order technique", "ABECDFG", myBinaryTree.getLevelOrderTraversal().stream().collect(Collectors.joining()));
    }


}
