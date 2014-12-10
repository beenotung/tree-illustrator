package treeillustrator.gui;

import myutils.gui.CanvasJFrame;
import treeillustrator.StaticStuff;
import treeillustrator.core.Tree;

import java.awt.*;
import java.util.Stack;

/**
 * Created by beenotung on 12/7/14.
 */
public class TreeIllustratorJFrame extends CanvasJFrame {
    private Tree treeRoot;

    public TreeIllustratorJFrame(double widthRate, double heightRate, int scale) {
        super((int) Math.round(screenSize.getWidth() * widthRate), (int) Math.round(screenSize.getHeight() * heightRate), scale, StaticStuff.APP_NAME, DEFAULT_NS_PER_TICK, DEFAULT_NS_PER_RENDER);
        frame.setBackground(Color.white);
    }

    public TreeIllustratorJFrame() {
        this(0.8, 0.8, 1);
    }

    @Override
    protected void init() {
    }

    public void init(Tree treeRoot) {
        this.treeRoot = treeRoot;
    }

    @Override
    protected void myTick() {
        System.out.println();
        Stack<Tree> treeStack = new Stack<>();
        treeStack.push(treeRoot.root);
        while (!treeStack.isEmpty()) {
            Tree tree = treeStack.pop();
            System.out.println(tree.toString());
            for (int i = 0; i < tree.getDegree(); i++) {
                treeStack.push(tree.getChild(i));
            }
        }
    }

    @Override
    protected void myRender() {
        clearScreen();
    }

    @Override
    protected void myDebugInfo() {

    }

    @Override
    protected void myKeyHandling() {

    }

    @Override
    protected void myMouseHandling() {

    }
}
