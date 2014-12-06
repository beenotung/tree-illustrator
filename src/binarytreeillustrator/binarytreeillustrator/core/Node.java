package binarytreeillustrator.core;

import java.util.Vector;

/**
 * Created by beenotung on 12/6/14.
 */
public class Node {
    public static Vector<Integer> keys = new Vector<Integer>();
    public int key;
    public Object value;

    private Node(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    public static boolean isExist(int key) {
        boolean found = false;
        for (Integer deltaKey : keys) {
            if (found = deltaKey.equals(key)) break;
        }
        return found;
    }

    public static Node getNewNode(Object value) {
        int newKey = keys.lastElement();
        do {
            newKey++;
        } while (isExist(newKey));
        keys.add(newKey);
        return new Node(newKey, value);
    }
}
