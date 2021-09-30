package main;

import controller.CommandController;
import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import controller.ShapeList;
import controller.shapes.ShapeRenderer;
import java.awt.Shape;
import model.persistence.UserChoicesImpl;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ShapeRenderer renderer = new ShapeRenderer();
        ShapeList shapeList = new ShapeList(renderer);
        PaintCanvas paintCanvas = new PaintCanvas(shapeList);
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoicesImpl appState = new UserChoicesImpl(uiModule);
        EventConnector controller = new EventConnectorImpl(uiModule, appState);
        CommandController commandController = new CommandController(appState, shapeList, paintCanvas, renderer);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();

        MouseHandler mouse = new MouseHandler(commandController);
        paintCanvas.addMouseListener(mouse);
        controller.setup();

        Thread.sleep(500);
    }
}
