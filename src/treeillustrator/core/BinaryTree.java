package treeillustrator.core;

/**
 * Created by beenotung on 12/7/14.
 */
public class BinaryTree<T> extends Tree<T> {
    protected static final int MAX_DIRECT_CHILDREN = 2;

    public BinaryTree(T[] values) {
        //if (values == null) return;
        this(values[0]);
        BinaryTree<T> tree = (BinaryTree<T>) root;
        for (int i = 1; i < values.length; i++)
            addChildren(values[i]);
    }

    public BinaryTree(T value) {
        super(MAX_DIRECT_CHILDREN, value);
    }


}
