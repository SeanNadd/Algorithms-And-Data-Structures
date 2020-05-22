package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinaryTree<E extends Comparable<E>> {
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

    private TreeNode<E> binarySearch(TreeNode<E> node, E value){
        if(node == null) return null;
        if(node.getValue() == value) return node;
        if(node.compareTo(value) > 0) return binarySearch(node.getLeftChild(), value);
        else return binarySearch(node.getRightChild(), value);
    }

    private TreeNode<E> binaryTreeInsertion(TreeNode<E> node, E value){
        if(node.getValue() == value) return null;
        if(node.compareTo(value) > 0){
            if(node.getLeftChild() == null) return node.addLeftChild(value);
            else return binaryTreeInsertion(node.getLeftChild(), value);
        }
        else{
            if(node.getRightChild() == null) return node.addRightChild(value);
            else return binaryTreeInsertion(node.getRightChild(), value);
        }
    }

    private TreeNode<E> binaryTreeDeletion(TreeNode<E> node, E value) {
        if(node == null) return null;
        TreeNode<E> toDelete = binarySearch(this.root, value);
        if(toDelete == null) return null;
        if(toDelete.getParent() == null) return null;
        TreeNode<E> parent = toDelete.getParent();

        if(toDelete.getRightChild() == null && toDelete.getLeftChild() == null){
            deleteReference(parent, toDelete);
            return toDelete;
        }else if(toDelete.getLeftChild() != null && toDelete.getRightChild() != null) {
                TreeNode<E> smallestChild = findSmallestValue(toDelete.getRightChild());
                toDelete.setValue(smallestChild.getValue());
                deleteReference(smallestChild.getParent(), smallestChild);
                return toDelete; //TODO return value or somehow return node in previous state?
        }else {
            hoistReference(parent, toDelete);
            return toDelete;
        }
    }

    private void deleteReference(TreeNode<E> parent, TreeNode<E> child){
        if(parent.getLeftChild() != null && parent.getLeftChild().equals(child)){
            parent.setLeftChild(null);
        }else {
            parent.setRightChild(null);
        }
    }

    private void hoistReference(TreeNode<E> parent, TreeNode<E> child){
        TreeNode<E> newChild = null;
        if(child.getLeftChild() != null) newChild = child.getLeftChild();
        else newChild = child.getRightChild();

        if(parent.getLeftChild() != null && parent.getLeftChild().equals(child)) parent.setLeftChild(newChild);
        else parent.setRightChild(newChild);
    }

    private TreeNode<E> findSmallestValue(TreeNode<E> node){
        if(node.getLeftChild() != null) return findSmallestValue(node.getLeftChild());
        else return node;
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

    public E getValue(E value){
        TreeNode<E> node = binarySearch(this.root, value);
        return node == null ? null : node.getValue();
    }

    public E insert(E value){
        TreeNode<E> node = binaryTreeInsertion(this.root, value);
        return node == null ? null : node.getValue();
    }

    public E delete(E value){
        TreeNode<E> node = binaryTreeDeletion(this.root, value);
        return node == null ? null : node.getValue();
    }
}

class TreeNode<E extends Comparable<E>> implements Comparable<E>{
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

    public TreeNode(E val){
        this.value = val;
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

    public TreeNode<E> addLeftChild(TreeNode<E> leftChild){
        this.leftChild = new TreeNode<>(value, this);
        return this.leftChild;
    }

    public TreeNode<E> addRightChild(TreeNode<E> rightChild){
        this.rightChild = new TreeNode<>(value, this);
        return this.rightChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(E o) {
        return getValue().compareTo(o);
    }
}
