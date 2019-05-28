package com.company.Enviornment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

import javax.swing.*;

public class GUI extends Application implements EventHandler<ActionEvent>, Runnable{

    boolean appStatus;

    public GUI()
    {

    }

    @Override
    public void run()
    {
        launch();
    }

    @Override
    public void start(Stage mainStage) throws Exception
    {

        mainStage.setTitle("Physics 0.0"); //Names the Stage
//        mainStage.setResizable(false);

        Background shade1 = new Background(new BackgroundFill(Color.rgb(60, 53, 65) , null, null));
        Background shade2 = new Background(new BackgroundFill(Color.rgb(49, 51, 53), null, null));
        Background shade3 = new Background(new BackgroundFill(Color.rgb(43, 43, 43), null, null));

        SplitPane layout = new SplitPane();
        SplitPane interactables = new SplitPane();

        Menu file = new Menu("File");
        Menu help = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file, help);
        layout.getItems().add(menuBar);

        TitledPane settingTitle = new TitledPane("Body", new Button("Test"));
        settingTitle.setBackground(shade1);
        settingTitle.setScaleShape(true);
        TitledPane worldTitle = new TitledPane("2D World", new Button("Test"));
        TitledPane consoleTitle = new TitledPane("Console", new Button("Test"));
        consoleTitle.setBackground(shade2);
        consoleTitle.setScaleShape(true);


        layout.setOrientation(Orientation.VERTICAL);
        layout.getItems().addAll(interactables, consoleTitle);
        layout.setDividerPositions(0.85);

        interactables.setOrientation(Orientation.HORIZONTAL);
        interactables.getItems().addAll(settingTitle, worldTitle);
        interactables.setDividerPositions(0.25);

        Scene mainScene = new Scene(layout, 800, 500);
        mainStage.setScene(mainScene);

        mainStage.show();


    }

    @Override
    public void handle(ActionEvent event)
    {
    }
}
