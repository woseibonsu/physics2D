package com.company.Simulation;

import com.company.Main;
import com.company.Utility.Vector;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldEngine implements Runnable {

    private List<Body2D> body2DList = new ArrayList<>();
    private Vector gravity = new Vector(0, -9.8);

    public WorldEngine(Body2D... body2DS)
    {
        body2DList = Arrays.asList(body2DS);
    }

    public void run()
    {
        while(Main.applicationThread.isAlive()) {
            if (body2DList.size() > 0) {
                {
                    body2DList.parallelStream().forEach(body2D ->
                            {
                                updateBody(body2D);
                                System.out.println(body2D.getPosition()); //DEBUG
                            }
                    );
                }
            }

//            System.out.println("ENGINE IS RUNNING"); //DEBUG
        }
    }

    public void updateBody(Body2D body)
    {
        body.updateAcceleration(gravity);
        body.updateVelocity();
        body.updatePosition();

    }



}
