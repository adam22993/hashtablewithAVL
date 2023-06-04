package Part2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class AVLTree {

    private Node root;
    private int size;
    private final String category;

    // private Node class for the AVL Tree nodes
    private class Node {
        private final Spell spell;
        private Node left;
        private Node right;
        private int height;

        private Node(Spell spell) {
            this.spell = spell;
            this.height = 0;
            this.left = null;
            this.right = null;
        }
        public String toString() {
            return String.valueOf(spell.getPowerLevel());
        }
    }

    // Constructor, getters, setters
    public AVLTree(Spell spell) {
        this.root = new Node(spell);
        this.size = 1;
        this.category = spell.getCategory();
    }

    public int getTreeHeight(){
        return this.root.height;
    }

    public int getSize(){
        return this.size;
    }

    public String getCategory() {
        return this.category;
    }

    public Spell search(String spellName, int powerLevel) {
        return spellSearch(spellName, powerLevel, this.root);
    }

    public Spell spellSearch(String spellName, int powerLevel, Node curr) {
        if (curr.spell.getPowerLevel() == powerLevel && curr.spell.getName().equals(spellName)) {
            return curr.spell;
        }
        if (curr.spell.getPowerLevel() > powerLevel && curr.left != null) {
            return spellSearch(spellName, powerLevel, curr.left);
        } else if (curr.spell.getPowerLevel() < powerLevel && curr.right != null) {
            return spellSearch(spellName, powerLevel, curr.right);
        } else {
            return null;
        }

    }

    private int height(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return leftHeight - rightHeight;
    }
    public void insert(Spell spell) {
        root = insertHelper(root, spell);
    }

    private Node leftRotate(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    private Node rightRotate(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    public Node insertHelper(Node node, Spell spell) {
        if (node == null) {
            size++;
            return new Node(spell);
        }

        if (spell.getPowerLevel() < node.spell.getPowerLevel())
            node.left = insertHelper(node.left, spell);
        else if (spell.getPowerLevel() > node.spell.getPowerLevel())
            node.right = insertHelper(node.right, spell);
        else
            return node; // Duplicate values are not allowed in AVL trees

        node.height = Math.max(checkHeight(node.left), checkHeight(node.right)) + 1;

        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && spell.getPowerLevel() < node.left.spell.getPowerLevel())
            return rightRotate(node);

        // RR Case
        if (balance < -1 && spell.getPowerLevel() > node.right.spell.getPowerLevel())
            return leftRotate(node);

        // LR Case
        if (balance > 1 && spell.getPowerLevel() > node.left.spell.getPowerLevel()) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && spell.getPowerLevel() < node.right.spell.getPowerLevel()) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }



    private int checkHeight( Node node){
        if (node == null){
            return -1;
        }
        else
        if (node.right == null && node.left == null){
            return 0;
        }
        else if (node.right == null){
            return node.left.height + 1;
        }
        else if (node.left == null){
            return node.right.height + 1;
        }
        else{
            return Math.max(node.left.height, node.right.height) + 1;
        }
    }

    public List<Spell> getTopK(int k) {
        return retTopK(k, this.root, new ArrayList<>());
    }

    public List<Spell> retTopK(int k, Node node, List<Spell> list) {
        if (node == null) {
            return list;
        }
        retTopK(k, node.right, list);
        if (list.size() < k) {
            list.add(node.spell);
        }
        retTopK(k, node.left, list);
        return list;
    }
}


