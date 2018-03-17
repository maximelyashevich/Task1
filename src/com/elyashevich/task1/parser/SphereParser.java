package com.elyashevich.task1.parser;

import com.elyashevich.task1.entity.Point;
import com.elyashevich.task1.entity.Sphere;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereParser {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Sphere parseSphere(String data, String delimiter) {
        String[] sphereParams = data.split(delimiter);
        int countParams = sphereParams.length;
        double radius = Double.parseDouble(sphereParams[0]);
        Sphere sphere = new Sphere(radius, (countParams - 1) == 0 ? new Point() :
                new Point(Double.parseDouble(sphereParams[1]), Double.parseDouble(sphereParams[2]),
                        Double.parseDouble(sphereParams[3])));
        LOGGER.log(Level.INFO, sphere);
        return sphere;
    }
}
