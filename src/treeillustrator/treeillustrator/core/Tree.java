package treeillustrator.core;

import java.util.Vector;

/**
 * Created by beenotung on 12/7/14.
 */
public class Tree<T> {
    protected Node root;
    protected Node current;
    private Vector<Tree> children;

    public Tree() {
        root = null;
        current = null;
        children = new Vector<>();
    }

    public Tree(T value) {
        super();
        current = Node.getNewNode(value);
        root = current;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void setRoot(T value) {
        this.root = Node.getNewNode(value);
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

    public void setCurrent(T value) {
        this.current = Node.getNewNode(value);
    }

    public void setChildren(Vector<Tree> children) {
        this.children = children;
    }

    public void removeChildren() {
        this.children = new Vector<>();
    }

    public void addChildren(Tree child) {
        children.add(child);
    }

    public void addChildren(T value) {
        addChildren(new Tree<T>(value));
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
}
