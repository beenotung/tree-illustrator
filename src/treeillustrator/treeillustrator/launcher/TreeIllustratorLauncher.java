package treeillustrator.launcher;

import treeillustrator.core.BinaryTree;
import treeillustrator.core.Tree;
import treeillustrator.gui.TreeIllustratorJFrame;

public class TreeIllustratorLauncher<T> {
    public static final String MODE_BINARY_TREE = "Mode Binary Tree";
    private final String mode;
    Tree tree;
    TreeIllustratorJFrame frame;

    @SuppressWarnings("SameParameterValue")
    public TreeIllustratorLauncher(String mode) {
        this.mode = mode;
        frame = new TreeIllustratorJFrame();
    }

    public void init(T[] values) {
        switch (mode) {
            case MODE_BINARY_TREE:
                tree = new BinaryTree<>(values);
        }
        frame.loadTree(tree);
    }

    public void start() {
        //TODO load content into GUI component
        frame.start();
        System.out.println(tree.toString());
    }
}
