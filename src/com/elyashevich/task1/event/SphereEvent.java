package com.elyashevich.task1.event;

import com.elyashevich.task1.entity.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject{

    public SphereEvent(Sphere source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere) super.getSource();
    }
}
