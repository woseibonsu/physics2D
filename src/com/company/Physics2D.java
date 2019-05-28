package com.company;
import com.company.Enviornment.GUI;
import com.company.Simulation.WorldEngine;


public class Physics2D {

    public static Thread applicationThread;
    public static Thread engineThread;

    public static void main(String[] args) {

        //Credits
        System.out.println("Created by: Winston Osei-Bonsu\nLaunching Physics 2D...");

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
