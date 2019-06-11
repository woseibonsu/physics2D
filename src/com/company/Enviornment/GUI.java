package com.company.Enviornment;

import com.company.Simulation.Body2D;
import com.company.Simulation.UpdateListener;
import com.company.Simulation.WorldEngine;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application implements EventHandler<ActionEvent>, UpdateListener, Runnable{

    //APPLICATION UTILITY
    private SplitPane app;

    //WORLD
    private Canvas canvas;
    private static double width;
    private static double height;
    private GraphicsContext gc;

    //CONSOLE OUTPUT
    private Text console;

    public GUI(){}

    private SplitPane buildApplt()
    {
        //CONSTRUCTS THREE SPLIT LAYOUT
        SplitPane layout = new SplitPane();
        SplitPane interactables = new SplitPane();

        //CONSTRUCTS MENU BAR
        Menu file = new Menu("File");
        Menu help = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file, help);
        layout.getItems().add(menuBar);

        //CONSTRUCTS CONTENT FOR BODY SETTINGS
        Label bodyList = new Label("Body List: ");
        ComboBox<Body2D> items = new ComboBox<Body2D>();
        Label massLabel = new Label("Mass: ");
        TextField mass = new TextField("0.00 kg");
        Label XLabel = new Label("Pos X: ");
        TextField postionX = new TextField("0.00");
        Label YLabel = new Label("Pos Y: ");
        TextField postionY = new TextField("0.00");
        CheckBox Friction = new CheckBox("Friction");
        CheckBox Rigid = new CheckBox("Rigid");
        Button addBody = new Button("Add");
        Button removeBody = new Button("Remove");

        GridPane gridpaneS = new GridPane();
        GridPane.setConstraints(massLabel, 0, 0);
        GridPane.setConstraints(mass, 1, 0);
        GridPane.setConstraints(XLabel, 0, 1);
        GridPane.setConstraints(postionX, 1, 1);
        GridPane.setConstraints(YLabel, 0, 2);
        GridPane.setConstraints(postionY, 1, 2);
        GridPane.setConstraints(Friction, 0, 3);
        GridPane.setConstraints(Rigid, 0, 4);
        GridPane.setConstraints(addBody, 0, 5);
        GridPane.setConstraints(removeBody, 0, 6);
        GridPane.setConstraints(bodyList, 0, 7);
        GridPane.setConstraints(items, 1, 7);

        gridpaneS.getChildren().addAll(items, massLabel, mass, XLabel, postionX, YLabel, postionY, Friction, addBody, removeBody, bodyList, Rigid);

        //IMPLEMENTS CONTENT FOR SETTINGS
        Accordion settingsAccordion = new Accordion();
        TitledPane settingsB = new TitledPane("Bodies", gridpaneS);
        TitledPane settingsW = new TitledPane("World", new Button("Simulate"));
        settingsAccordion.getPanes().addAll(settingsB, settingsW);

        //CONSTRUCTS CONTENT FOR SIMULATION
        Accordion worldAccordion = new Accordion();
        TitledPane world = new TitledPane("2D World", null);
        worldAccordion.getPanes().addAll(world);
        worldAccordion.setExpandedPane(world);
        world.setCollapsible(false);


        //CONSTRUCTS CONTENT FOR CONSOLE
        TitledPane consoleTitle = new TitledPane("Console", console);

        //FILLS LAYOUT WITH CONSTRUCTED CONTENT
        layout.setOrientation(Orientation.VERTICAL);
        layout.getItems().addAll(interactables, consoleTitle);
        layout.setDividerPositions(0.85);
        interactables.setOrientation(Orientation.HORIZONTAL);
        interactables.getItems().addAll(settingsAccordion, worldAccordion);
        interactables.setDividerPositions(0.25);

        //RETURNS APPLICATION SCENE AS A SINGLE ITEM
        return layout;
    }

    private void updateGraphics(double x, double y)
    {
        if(WorldEngine.isPopulated())
        {
            System.out.println("I MADE IT");
            System.out.println(width + " " + height);
            gc.clearRect(0, 0, width, height);
            gc.fillOval(x, y, 10, 10);
        }
    }

    public void postBuildUpdate()
    {
        //CREATES THE CANVAS BASED ON THE SIZE OF THE WORLD WINDOW
        width = ((Accordion)((SplitPane)(app.getItems().get(1))).getItems().get(1)).getPanes().get(0).getWidth(); //SIDE NOTE
        height = ((Accordion)((SplitPane)(app.getItems().get(1))).getItems().get(1)).getPanes().get(0).getHeight(); //THINKING ABOUT THIS HURT
        canvas = new Canvas(width, height);
        System.out.println(width); //DEBUG
        System.out.println(height); //DEBUG
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
    }

    @Override
    public void bodyUpdated(Body2D b)
    {
        updateGraphics(b.getPosition().getComponent(0), b.getPosition().getComponent(1));
    }

    @Override
    public void start(Stage primaryStage) {

        //CONSTRUCTS STAGE/APPLICATION WINDOW
        primaryStage.setTitle("Physics 0.0");
        primaryStage.setResizable(false);

        app = buildApplt();

        //CONSTRUCTS APPLICATION
        Scene primaryScene = new Scene(app,950, 500);
        primaryStage.setScene(primaryScene);

        primaryStage.show();

        postBuildUpdate();

    }

    @Override
    public void run() {
        launch();
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
