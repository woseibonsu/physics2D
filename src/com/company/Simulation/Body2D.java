package com.company.Simulation;

import com.company.Utility.Vector;

public class Body2D {

    private double mass;
    private Vector position = new Vector(0, 0);
    private Vector velocity = new Vector(0, 0);
    private Vector acceleration = new Vector(0, 0);
    private double timeInterval = 0.1;

    public Body2D(int m)
    {
        mass = m;
        position = new Vector(0 , 0);
    }

    public Vector getForceApplied()
    {
        Vector force = new Vector(2);

        //Calculating X component
        force.setComponent(0, acceleration.getComponent(0) / mass);
        //Calculating Y component
        force.setComponent(1, acceleration.getComponent(1) / mass);

        return force;
    }

    public Vector updateAcceleration(Vector force)
    {
        Vector acc = new Vector(2);

        //Calculating for X
        acc.setComponent(0, force.getComponent(0) / mass);
//        System.out.println("X COMPONENT: " + acc.getComponent(0));
        //Calculating for Y
        acc.setComponent(1, force.getComponent(1) / mass);
//        System.out.println("Y COMPONENT: " + acc.getComponent(1));


        setAcceleration(acc);

        return acc;

    }

    public Vector updateVelocity()
    {
        Vector vel = new Vector(2);

        //Calculating for X
        double velX = velocity.getComponent(0) + (acceleration.getComponent(0) * timeInterval);
        vel.setComponent(0, velX);
        //Calculating for Y
        double velY = velocity.getComponent(1) + (acceleration.getComponent(1) * timeInterval);
        vel.setComponent(1, velY);

        setVelocity(vel);

        return vel;

    }

    public Vector updatePosition()
    {

        Vector disp = new Vector(2);

        //Calculate X component
        disp.setComponent(0,  (velocity.getComponent(0) * timeInterval) + (0.5 * acceleration.getComponent(0) * Math.pow(timeInterval, 2)));
        //Calculate Y component
        disp.setComponent(1,  (velocity.getComponent(1) * timeInterval) + (0.5 * acceleration.getComponent(1) * Math.pow(timeInterval, 2)));

        position = Vector.getSpan(disp, position);

        return disp;

    }

    public Vector getPosition() {
        return position;
    }

    public double getGPEnergy()
    {
        return mass * position.getComponent(1) * WorldEngine.getGravity().getComponent(1);
    }

    public double getEPEnergy(double k, double x)
    {
        return 0.5 * k * Math.pow(x, 2);
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    //GETS & SETS
}