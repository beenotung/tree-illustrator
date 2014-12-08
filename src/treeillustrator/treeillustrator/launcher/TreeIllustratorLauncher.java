package treeillustrator.launcher;

import treeillustrator.core.BinaryTree;
import treeillustrator.core.Tree;

public class TreeIllustratorLauncher<T> {
    public static final String MODE_BINARY_TREE = "Mode Binary Tree";
    private final String mode;
    Tree tree;

    @SuppressWarnings("SameParameterValue")
    public TreeIllustratorLauncher(String mode) {
        this.mode = mode;
    }

    public void init(T[] values) {
        switch (mode) {
            case MODE_BINARY_TREE:
                tree = new BinaryTree<>(values);
        }
    }

    public void start() {
        //TODO load content into GUI component
        TreeIllustratorJFrame
        System.out.println(tree.toString());
    }
}
