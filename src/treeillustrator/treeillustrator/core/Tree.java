package treeillustrator.core;

import java.util.Vector;

/**
 * Created by beenotung on 12/7/14.
 */
public class Tree<T> {
    public static final String MODE_POSTFIX = "Mode Postfix";
    protected Tree root, parent;
    protected Node node;
    private Vector<Tree> children = new Vector<>();

    public Tree() {
        root = this;
        parent = null;
        node = null;
    }

    public Tree(T value) {
        super();
        node = Node.getNewNode(value);
    }

    public Tree(T value, Tree parent) {
        this(value);
        this.parent = parent;
    }

    public void setNode(T value) {
        this.node = Node.<T>getNewNode(value);
    }

    public void setRoot(T value) {
        this.root.setNode(value);
    }

    public void setChildren(Vector<Tree> children) {
        this.children = children;
    }

    public void removeChildren() {
        this.children = new Vector<>();
    }

    public void addChildren(Tree child) {
        child.root = this.root;
        child.parent = this;
        children.add(child);
    }

    public void addChildren(T value) {
        addChildren(new Tree<T>(value, this));
    }

    public int getDegree() {
        return children.size();
    }

    public int getHeight() {
        int maxHeight = 1;
        for (Tree child : children)
            if (child.getHeight() >= maxHeight)
                maxHeight = child.getHeight() + 1;
        return maxHeight;
    }

    public Tree getChild(int indexChild) {
        if (children.size() > indexChild)
            return children.get(indexChild);
        else return null;
    }

    public Tree getSmallestChild() {
        if (getDegree() == 0) return null;
        Tree smallestChild = children.get(0);
        for (Tree child : children)
            if (smallestChild.getHeight() > child.getHeight())
                smallestChild = child;
        return smallestChild;
    }

    public Tree getLargestChild() {
        if (getDegree() == 0) return null;
        Tree largestChild = children.get(0);
        for (Tree child : children)
            if (largestChild.getHeight() < child.getHeight())
                largestChild = child;
        return largestChild;
    }

    public Vector<T> dumpToVector(String mode) {
        Vector<T> values = new Vector<>();
        switch (mode) {
            case MODE_POSTFIX:
                for (Tree<T> child : children)
                    values.addAll(child.dumpToVector(mode));
                if (node != null) values.add((T) node.value);
                break;
        }
        return values;
    }

    @Override
    public String toString() {
        Vector<T> values = dumpToVector(MODE_POSTFIX);
        return values.toString();
    }
}
