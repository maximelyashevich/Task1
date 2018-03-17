package com.elyashevich.task1.observer;

import com.elyashevich.task1.event.SphereEvent;

public interface SphereObserver {
    void valueChanged(SphereEvent observed);
}
