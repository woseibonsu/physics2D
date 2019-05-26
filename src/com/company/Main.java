package com.company;
import com.company.Enviornment.Body2D;
import com.company.Enviornment.WorldEngine;
import com.company.Utility.Vector;
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

public class Main extends Application implements EventHandler<ActionEvent> {

    Button button;
    Canvas world;

    public static void main(String[] args) {


        //Runs World Engine
        WorldEngine world = new WorldEngine();
        Thread engineThread = new Thread(world);
        engineThread.start();

        System.out.println("Launching...");
        Application.launch(args);
        System.out.println("Closed...");



    }



    @Override
    public void start(Stage mainStage) throws Exception
    {
        mainStage.setTitle("Physics 0.0"); //Names the Stage

        button = new Button();

        button.setText("Test Button 1");
        button.setOnAction(this::handle);

        Group root = new Group();
        world = new Canvas(200, 200);
        GraphicsContext gc = world.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 50, 50 );
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, 25, 25 );



        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.getChildren().add(world);

        Scene mainScene = new Scene(layout, 400, 400, Color.BLACK);
        mainStage.setScene(mainScene);

        mainStage.show();

        System.out.println("show");
    }

    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource()==button)
        {
            System.out.println("Button has been clicked");
        }
    }
}
