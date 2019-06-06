package com.company.Simulation;

import com.company.Physics2D;
import com.company.Utility.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldEngine implements Runnable {

    private static List<Body2D> body2DList = new ArrayList<>();
    private static Vector gravity = new Vector(0, -9.8);


    public  void run()
    {
        while(Physics2D.applicationThread.isAlive()) {
            if (body2DList.size() > 0) {
                {
                    body2DList.parallelStream().forEach(body2D ->
                            {
                                updateBody(body2D);
//                                System.out.println(body2D.getPosition()); //DEBUG
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
        System.out.println(body.getPosition());

    }


    public static void addBody(Body2D... b2d)
    {
        for ( Body2D b : b2d )
        {
            body2DList.add(b);
        }
    }

    public static void addBody(double m)
    {
            body2DList.add(new Body2D(m));
    }

    public static void applyForce (Body2D b1, Body2D b2)
    {
        if (b1.getForceApplied().getMagnitude() < b2.getForceApplied().getMagnitude())
        {

        }
    }

    public static void addBody(double m , Vector p)
    {
        body2DList.add(new Body2D(m , p));
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
