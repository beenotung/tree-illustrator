package treeillustrator.core;

import java.util.Vector;

/**
 * Created by beenotung on 12/6/14.
 */
public class Node<T> {
    private static Vector<Integer> keys = new Vector<>();
    private final int key;
    private T value;

    private Node(int key, T value) {
        this.key = key;
        this.value = value;
    }

    private static boolean isExist(int key) {
        boolean found = false;
        for (Integer deltaKey : keys) {
            if (found = deltaKey.equals(key)) break;
        }
        return found;
    }

    public static <T> Node<T> getNewNode(T value) {
        int newKey = keys.lastElement();
        do {
            newKey++;
        } while (isExist(newKey));
        keys.add(newKey);
        return new Node(newKey, value);
    }
}
