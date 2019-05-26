package com.company;
import com.company.Enviornment.GUI;
import com.company.Simulation.WorldEngine;


public class Main {

    public static Thread applicationThread;
    public static Thread engineThread;

    public static void main(String[] args) {

        //Runs Application
        GUI application = new GUI();
        applicationThread = new Thread(application);
        applicationThread.start();

        //Runs World Engine
        WorldEngine world = new WorldEngine();
        engineThread = new Thread(world);
        engineThread.start();


    }

}
