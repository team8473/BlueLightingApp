package com.example.wahle.stuff;

import java.util.ArrayList;

public class Path {
    private static final double ROBOT_WIDTH = 17.2;
    private static final double WHEEL_DIAMETER = 4;
    private static final double CIRCUMFRENCE = Math.PI * WHEEL_DIAMETER;

    double leftDistance;
    double rightDistance;
    double leftSpeed;
    double rightSpeed;

    public double convertDistance(double distance) {
        distance = Math.abs(distance);
        return distance / CIRCUMFRENCE;
    }

    public void addLeftTurn(double angle, double radius, double speed) {
        double distance = convertDistance(angle, radius);

        double innerScale = innerScale(radius);

        leftDistance = (distance * Math.abs(innerScale));
        leftSpeed = (speed * innerScale);
        rightDistance = (distance);
        rightSpeed = (speed);
    }
    public void addRightTurn(double angle, double radius, double speed) {
        double distance = convertDistance(angle, radius);

        double innerScale = innerScale(radius);

        rightDistance = (distance * Math.abs(innerScale));
        rightSpeed = (speed * innerScale);
        leftDistance = (distance);
        leftSpeed = (speed);

    }

    public double convertDistance(double angle, double radius) {
        angle *= Math.PI / 180.0; //convert to radians
        double distance = radius * angle;
        return convertDistance(distance); // convert to revolutions
    }
    public double innerScale(double radius) {
        radius = Math.abs(radius);
        double innerRadius = radius - ROBOT_WIDTH;
        if (radius > 0.0) innerRadius /= radius;
        return innerRadius;
    }
}
