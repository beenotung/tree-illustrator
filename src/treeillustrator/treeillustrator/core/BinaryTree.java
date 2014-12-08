package treeillustrator.core;

/**
 * Created by beenotung on 12/7/14.
 */
public class BinaryTree<T> extends Tree<T> {
    public BinaryTree(T[] values) {
        super();
        if (values == null) return;
        setRoot(values[0]);
        BinaryTree<T> tree = (BinaryTree<T>) root;
        for (int i = 1; i < values.length; i++) {
            if (tree.getDegree() >= 2)
                tree = (BinaryTree<T>) tree.getSmallestChild();
            tree.addChildren(new BinaryTree<T>(values[i]));
        }
    }

    public BinaryTree(T value) {
        super(value);
    }
}
