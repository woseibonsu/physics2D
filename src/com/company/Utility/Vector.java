package com.company.Utility;

import java.util.Arrays;

public class Vector implements Comparable<Vector>{

    private double[] vector;
    private int size;

    //Create a Vector of given size
    public Vector(int size) {
        vector = new double[size];
        this.size = size;
    }

    //Create a Vector given values
    public Vector(double... n) {
        vector = n;
        size = vector.length;
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
                } catch (IndexOutOfBoundsException e)
                {
                    //Ignore difference in dimension
                }
            }


        }

        return new Vector(sum);


    }

    public static Vector multScalar(Vector v, double c) {
        Vector cv = new Vector(v.size);

        for(int i = 0; i < cv.size; i++)
        {
            cv.setComponent(i, c * v.getComponent(i));
        }

        return cv;
    }

    public static double dotProduct(Vector... v) {

        double dot = 0;
        int min = v[0].size;

        for (Vector temp : v) {
            if (temp.size < min) {
                min = temp.size;
            }
        }
        for (int j = 0; j < v.length; j++)
        {
            for (int k = 0; k < min; k++)
            {
                if (0 != j)
                {
//                        System.out.println("v[i]: " + v[0].getComponent(k) );
//                        System.out.println("v[j]: " + v[j].getComponent(k) );
                    dot += v[0].getComponent(k) * v[j].getComponent(k);
                }
            }

        }
        return dot;
    }

    public int compareMagnitude(Vector v)
    {
        return (int) (getMagnitude() - v.getMagnitude());
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

    @Override
    public int compareTo(Vector o) {
        return 0;
    }
}

