package com.example.wahle.stuff;

import static com.example.wahle.stuff.TestActivity.ball;

class Path {
    private static final double ROBOT_WIDTH = 17.2;
    static double leftDistance1, leftDistance2, leftDistance3;
    static double rightDistance1, rightDistance2, rightDistance3;

    void addLeftTurn(double angle, double radius) {
        double distance = convertDistance(angle, radius);

        double innerScale = innerScale(radius);

        leftDistance3 = (distance * Math.abs(innerScale));
        rightDistance3 = (distance);
    }

    void addRightTurn(double angle, double radius) {
        double distance = convertDistance(angle, radius);

        double innerScale = innerScale(radius);

        rightDistance2 = (distance * Math.abs(innerScale));
        leftDistance2 = (distance);

    }

    void addStraight(double distance) {
        //distance = convertDistance(distance);
        switch (ball){
            case IS_RED_BALL:
                leftDistance1 = distance - 4;
                rightDistance1 =distance - 4;
                break;
            default:
                leftDistance1 = distance;
                rightDistance1 = distance;
        }
    }

    double convertDistance(double angle, double radius) {
        angle *= Math.PI / 180.0; //convert to radians
        return radius * angle; // convert to revolutions
    }

    double innerScale(double radius) {
        radius = Math.abs(radius);
        double innerRadius = radius - ROBOT_WIDTH;
        if (radius > 0.0) innerRadius /= radius;
        return innerRadius;
    }
}
