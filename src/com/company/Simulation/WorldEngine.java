package com.company.Simulation;

import com.company.Physics2D;
import com.company.Utility.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldEngine implements Runnable {

    private static List<Body2D> body2DList = new ArrayList<>();
    private static Vector gravity = new Vector(0, -9.8);

    public  WorldEngine(Body2D... body2DS)
    {
        body2DList = Arrays.asList(body2DS);
    }

    public  void run()
    {
        while(Physics2D.applicationThread.isAlive()) {
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

    public static void updateBody(Body2D body)
    {
        body.updateAcceleration(gravity);
        body.updateVelocity();
        body.updatePosition();

    }

    public static void setGravity(double g)
    {
        gravity.setComponent(1, g);
    }

    public static Vector getGravity ()
    {
        return gravity;
    }



}
