package treeillustrator.gui;

import myutils.gui.CanvasJFrame;
import treeillustrator.StaticStuff;

/**
 * Created by beenotung on 12/7/14.
 */
public class TreeIllustratorJFrame extends CanvasJFrame {

    public TreeIllustratorJFrame(double widthRate, double heightRate, int scale) {
        super((int) Math.round(screenSize.getWidth() * widthRate), (int) Math.round(screenSize.getHeight() * heightRate), scale, StaticStuff.APP_NAME, DEFAULT_NS_PER_TICK, DEFAULT_NS_PER_RENDER);
    }

    public TreeIllustratorJFrame() {
        this(1d, 1d, 1);
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
