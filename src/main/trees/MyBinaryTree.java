package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinaryTree<E> {
    private TreeNode<E> root;
    private List<E> traversal;

    public MyBinaryTree(TreeNode<E> root){
        this.root = root;
    }

    private void preOrderTraversal(TreeNode<E> node){
        if(node != null) {
            traversal.add(node.getValue());
            preOrderTraversal(node.getLeftChild());
            preOrderTraversal(node.getRightChild());
        }
    }

    private void postOrderTraversal(TreeNode<E> node){
        if(node != null){
            postOrderTraversal(node.getLeftChild());
            postOrderTraversal(node.getRightChild());
            traversal.add(node.getValue());
        }
    }

    private void inOrderTraversal(TreeNode<E> node){
        if(node != null){
            inOrderTraversal(node.getLeftChild());
            traversal.add(node.getValue());
            inOrderTraversal(node.getRightChild());
        }
    }

    private void levelOrderTraversal(){
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode<E> curr = q.remove();
            if(curr != null) {
                traversal.add(curr.getValue());
                q.add(curr.getLeftChild());
                q.add(curr.getRightChild());
            }
        }
    }

    public List<E> getPreOrderTraversal(){
        traversal = new ArrayList<>();
        preOrderTraversal(this.root);
        return traversal;
    }

    public List<E> getPostOrderTraversal(){
        traversal = new ArrayList<>();
        postOrderTraversal(this.root);
        return traversal;
    }

    public List<E> getInOrderTraversal(){
        traversal = new ArrayList<>();
        inOrderTraversal(this.root);
        return traversal;
    }

    public List<E> getLevelOrderTraversal(){
        traversal = new ArrayList<>();
        levelOrderTraversal();
        return traversal;
    }
}

class TreeNode<E>{
    private E value;
    private TreeNode<E> parent;
    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;

    public TreeNode(E val, TreeNode<E> par){
        this.value = val;
        this.parent = par;
        this.leftChild = null;
        this.rightChild = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public TreeNode<E> addLeftChild(E value){
        this.leftChild = new TreeNode<>(value, this);
        return this.leftChild;
    }

    public TreeNode<E> addRightChild(E value){
        this.rightChild = new TreeNode<>(value, this);
        return this.rightChild;
    }
}
