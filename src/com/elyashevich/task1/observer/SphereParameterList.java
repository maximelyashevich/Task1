package com.elyashevich.task1.observer;

import com.elyashevich.task1.action.ActionSphere;
import com.elyashevich.task1.entity.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereParameterList {
    private final static SphereParameterList INSTANCE = new SphereParameterList();
    private List<SphereParameter> parameterList;

    public static SphereParameterList getInstance() {
        return INSTANCE;
    }

    private SphereParameterList() {
        parameterList = new ArrayList<>();
    }

    public void addParameter(Sphere sphere){
        double square;
        double volume;
        ActionSphere actionSphere = new ActionSphere();
        square = actionSphere.defineSurfaceSquare(sphere);
        volume = actionSphere.defineVolume(sphere);
        SphereParameter sphereParam = new SphereParameter(square, volume);
        parameterList.add(sphereParam);
    }

    public void changeSquare(int index, double square){
        parameterList.get(index).setSquare(square);
    }

    public void changeVolume(int index, double volume){
        parameterList.get(index).setVolume(volume);
    }

    public SphereParameter getSphereParameter(int index){
        return parameterList.get(index);
    }
    @Override
    public String toString() {
        return "Sphere parameter list: " + parameterList;
    }
}
