package treeillustrator.gui;

import myutils.gui.CanvasJFrame;
import treeillustrator.core.Tree;

/**
 * Created by beenotung on 12/7/14.
 */
public class TreeIllustratorJFrame extends CanvasJFrame {

    public TreeIllustratorJFrame(int width, int height, int scale, String title, double nsPerTick, double nsPerRender) {
        super(width, height, scale, title, nsPerTick, nsPerRender);
    }

    public void loadTree(Tree tree) {
    }

    @Override
    protected void init() {
    }

    @Override
    protected void myTick() {
    }

    @Override
    protected void myRender() {
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
