package com.elyashevich.task1.observer;

import com.elyashevich.task1.entity.Sphere;
import com.elyashevich.task1.observer.impl.SquareObserver;
import com.elyashevich.task1.observer.impl.VolumeObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SphereList {
    private static final SphereList INSTANCE = new SphereList();
    private List<Sphere> sphereList;

    private SphereList(){
        sphereList = new ArrayList<>();
    }

    public static SphereList getInstance() {
        return INSTANCE;
    }

    public List<Sphere> getSphereList(){
        return Collections.unmodifiableList(sphereList);
    }

    public Sphere getSphere(int index){
        return sphereList.get(index);
    }

    public void addSphere(Sphere sphere){
        INSTANCE.sphereList.add(sphere);
        sphere.addObserver(new SquareObserver());
        sphere.addObserver(new VolumeObserver());
    }
}
