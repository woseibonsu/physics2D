package com.company;
import com.company.Enviornment.GUI;
import com.company.Simulation.WorldEngine;
import com.company.Utility.Vector;


public class Physics2D {

    public static Thread applicationThread;
    public static Thread engineThread;

    public static void main(String[] args) {
        Sy

        //Credits
        System.out.println("Created by: Winston Osei-Bonsu\nLaunching Physics 2D...");

        //APPLICATION THREAD
        GUI application = new GUI();
        applicationThread = new Thread(application);
        applicationThread.start();


        //WORLD ENGINE THREAD
        WorldEngine world = new WorldEngine();
        engineThread = new Thread(world);
        //CONNECTS GUI TO PHYSICS ENGINE
        WorldEngine.addListener(application);
        engineThread.start();


        WorldEngine.addBody(10);

    }

}
