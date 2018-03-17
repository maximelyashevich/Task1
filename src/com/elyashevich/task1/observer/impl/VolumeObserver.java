package com.elyashevich.task1.observer.impl;

import com.elyashevich.task1.action.ActionSphere;
import com.elyashevich.task1.entity.Sphere;
import com.elyashevich.task1.event.SphereEvent;
import com.elyashevich.task1.observer.SphereObserver;
import com.elyashevich.task1.observer.SphereParameterList;

public class VolumeObserver implements SphereObserver {

    @Override
    public void valueChanged(SphereEvent sphereEvent) {
        ActionSphere actionSphere = new ActionSphere();
        Sphere sphere = sphereEvent.getSource();
        double volume = actionSphere.defineVolume(sphere);
        SphereParameterList parameterList = SphereParameterList.getInstance();
        parameterList.changeVolume(sphere.getSphereId(), volume);
    }
}
