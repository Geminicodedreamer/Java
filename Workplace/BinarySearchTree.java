import java.util.*;
import java.io.*;

public class BinarySearchTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    /**
     * 查找某个节点
     * 
     * @param key
     */
    public Node search(int key) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.val == key) {
                return cur;
            } else if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * 插入元素
     * 
     * @param key
     * @return
     */
    public boolean insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            this.root = node;
            return true;
        }
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if (cur.val == key) {
                // 有相同的元素直接return
                return false;
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (parent.val > key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }

    /**
     * 删除元素
     * 
     * @param key
     */
    public boolean remove(int key) {
        if (this.root == null) {
            return false;
        }
        Node parent = null;
        Node cur = this.root;
        while (cur != null) {
            if (cur.val == key) {
                removeKey(parent, cur);
                return true;
            } else if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }

    public void removeKey(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == this.root) {
                this.root = this.root.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (this.root == cur) {
                this.root = this.root.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (targetParent.left == target) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }

    
}
