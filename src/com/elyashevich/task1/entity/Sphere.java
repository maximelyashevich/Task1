package com.elyashevich.task1.entity;

import com.elyashevich.task1.event.SphereEvent;
import com.elyashevich.task1.observer.SphereObserver;
import com.elyashevich.task1.util.IdGenerator;

import java.util.ArrayList;

public class Sphere {
    private int sphereId;
    private double radius;
    private Point center;

    private ArrayList<SphereObserver> observers = new ArrayList<>();

    public Sphere() {
        sphereId = IdGenerator.generateId();
    }

    public Sphere(double radius) {
        sphereId = IdGenerator.generateId();
        this.radius = radius;
        this.center = new Point();
    }

    public Sphere(double radius, Point center) {
        sphereId = IdGenerator.generateId();
        this.radius = radius;
        this.center = center;
    }

    public int getSphereId() {
        return sphereId;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObservers();
    }

    public void addObserver(SphereObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (SphereObserver observer : observers) {
            observer.valueChanged(new SphereEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        return Double.compare(sphere.radius, radius) == 0 && center.equals(sphere.center);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + center.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sphere: radius=" + radius +
                ", center: " + center + ";";
    }
}
