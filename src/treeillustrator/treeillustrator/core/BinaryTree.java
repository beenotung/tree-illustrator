package treeillustrator.core;

/**
 * Created by beenotung on 12/7/14.
 */
public class BinaryTree<T> extends Tree<T> {
    public BinaryTree(T[] values) {
        super();
        if (values == null) return;
        setRoot(values[0]);
        BinaryTree<T> tree = this;
        for (int i = 1; i < values.length; i++) {
            if (tree.getDegree() >= 2)
                tree = (BinaryTree) tree.getSmallestChild();
            tree.addChildren(values[i]);
        }
    }
}
