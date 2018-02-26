package com.example.wahle.stuff;

public class Path {
    private static final double ROBOT_WIDTH = 17.2;
    private static final double WHEEL_DIAMETER = 4.0;
    private static final double CIRCUMFRENCE = Math.PI * WHEEL_DIAMETER;
    public static final double COUNTS_PER_MOTOR_REV = 374;
    public static final double DRIVE_GEAR_REDUCTION = 2.0;
    public static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER * 3.1415);

    public static double leftDistance1, leftDistance2, leftDistance3;
    public static double rightDistance1, rightDistance2, rightDistance3;
    public double leftSpeed;
    public double rightSpeed;

    public double convertDistance(double distance) {
        distance = Math.abs(distance);
        return distance * COUNTS_PER_INCH;
    }

    public void addLeftTurn(double angle, double radius, double speed) {
        double distance = convertDistance(angle, radius);

        double innerScale = innerScale(radius);

        leftDistance3 = (distance * Math.abs(innerScale));
        leftSpeed = (speed * innerScale);
        rightDistance3 = (distance);
        rightSpeed = (speed);

    }

    public void addRightTurn(double angle, double radius, double speed) {
        double distance = convertDistance(angle, radius);

        double innerScale = innerScale(radius);

        rightDistance2 = (distance * Math.abs(innerScale));
        rightSpeed = (speed * innerScale);
        leftDistance2 = (distance);
        leftSpeed = (speed);

    }

    public void addStraight(double distance, double speed) {
        //distance = convertDistance(distance);

        leftDistance1 = distance;
        rightDistance1 = distance;
        leftSpeed = speed;
        rightSpeed = speed;
    }

    public double convertDistance(double angle, double radius) {
        angle *= Math.PI / 180.0; //convert to radians
        double distance = radius * angle;
        return distance; // convert to revolutions
    }

    public double innerScale(double radius) {
        radius = Math.abs(radius);
        double innerRadius = radius - ROBOT_WIDTH;
        if (radius > 0.0) innerRadius /= radius;
        return innerRadius;
    }
}
