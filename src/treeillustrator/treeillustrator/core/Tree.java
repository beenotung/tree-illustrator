package treeillustrator.core;

import java.util.Collections;
import java.util.Vector;

/**
 * Created by beenotung on 12/7/14.
 */
public class Tree<T> {
    public static final String MODE_POSTFIX = "Mode Postfix";
    public static final String MODE_PREFIX = "Mode Prefix";
    public static final String MODE_INFIX = "Mode Infix";
    protected final int MAX_DIRECT_CHILDREN;
    public Tree root;
    protected Tree parent;
    protected Node node;
    private Vector<Tree> children = new Vector<>();

    public Tree(int max_direct_children) {
        MAX_DIRECT_CHILDREN = max_direct_children;
        root = this;
        parent = null;
        node = null;
    }

    public Tree(int max_direct_children, T value) {
        this(max_direct_children);
        node = Node.getNewNode(value);
    }

    public Tree(int max_direct_children, T value, Tree parent) {
        this(max_direct_children, value);
        this.parent = parent;
    }

    public void setNode(T value) {
        this.node = Node.getNewNode(value);
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
        if (getDegree() < MAX_DIRECT_CHILDREN) {
            child.root = this.root;
            child.parent = this;
            children.add(child);
        } else {
            Tree<T> tree = getSmallestChild();
            tree.addChildren(child);
        }
    }

    public void addChildren(T value) {
        addChildren(new Tree<T>(MAX_DIRECT_CHILDREN, value, this));
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
            case MODE_PREFIX:
                if (node != null) values.add((T) node.value);
                for (Tree<T> child : children)
                    values.addAll(child.dumpToVector(mode));
                break;
            case MODE_INFIX:
                for (int i = 0; i < children.size() / 2; i++)
                    values.addAll(children.get(i).dumpToVector(mode));
                if (node != null) values.add((T) node.value);
                for (int i = children.size() / 2; i < children.size(); i++)
                    values.addAll(children.get(i).dumpToVector(mode));
                break;
        }
        return values;
    }

    public String toString(String mode) {
        Vector<T> values = dumpToVector(mode);
        return values.toString();
    }

    @Override
    public String toString() {
        Vector<T> values = dumpToVector(MODE_POSTFIX);
        Collections.reverse(values);
        return values.toString();
    }
}
