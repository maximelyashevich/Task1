package com.elyashevich.task1.observer;

public class SphereParameter {
    double square;
    double volume;

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    SphereParameter(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Sphere parameters{" +
                "square=" + square +
                ", volume=" + volume +
                '}';
    }
}
