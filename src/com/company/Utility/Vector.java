package com.company.Utility;

import java.util.Arrays;

public class Vector {

    private double[] vector;
    private int size;

    public Vector(int size) //Create a Vector of given size
    {
        vector = new double[size];
        this.size = size;
    }

    public Vector(double... n) //Create a Vector given values
    {
        vector = n;
        size = vector.length;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (double temp : vector) {
            string.append("[ ");
            string.append(temp);
            string.append(" ]\n");
        }
        return string.toString();
    }

    public void setComponent(int i, double num) {
        vector[i] = num;
    }

    public double getComponent(int i) {
        return vector[i];
    }

    public int getSize() {
        return size;
    }

    public double getMagnitude() {
        double mag = 0.0;

        for (double component : vector) {
            mag += Math.pow(component, 2);
        }

        return Math.sqrt(mag);

    }

    public static Vector getSpan(Vector... v) {
        int sMax = 0;
        int sMin = 0;

        //DETERMINES WHICH VECTOR HAS A GREATER CAPACITY
        for (Vector tempV : v) {
            //FIND MAXIMUM CAPACITY
            if (tempV.size > sMax) {
                sMax = tempV.size;
            }

            //FIND MINIMUM CAPACITY
            if (tempV.size < sMin) {
                sMin = tempV.size;
            }

        }


        //CREATES VECTOR OF GREATEST CAPACITY
        double[] sum = new double[sMax];

        //ADDS NON-EMPTY INDICES OF THE GIVEN VECTOR
        for (int i = 0; i < sMax; i++) //CURRENT COMPONENT BEING EVALUATED
        {

            for (Vector givenVector : v) // FOR EACH VECTOR GIVEN IN THE PARAMETERS
            {
                try {
                    sum[i] += givenVector.getComponent(i);
                } catch (IndexOutOfBoundsException e) {
                }
            }


        }

        return new Vector(sum);


    }

    public static Vector multScalar(Vector v, double c)
    {
        Vector cv = new Vector(v.size);

        for(int i = 0; i < cv.size; i++)
        {
            cv.setComponent(i, c * v.getComponent(i));
        }

        return cv;
    }


}

