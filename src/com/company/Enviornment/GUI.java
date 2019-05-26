package com.company.Enviornment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


        StackPane layout = new StackPane();

        Scene mainScene = new Scene(layout, 400, 400, Color.BLACK);
        mainStage.setScene(mainScene);

        mainStage.show();

        System.out.println("show");

    }

    @Override
    public void handle(ActionEvent event)
    {
    }
}
