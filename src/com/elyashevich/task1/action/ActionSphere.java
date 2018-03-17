package com.elyashevich.task1.action;

import com.elyashevich.task1.entity.Sphere;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionSphere{
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PROPORTION = "Proportion: ";
    private static final String IS_SPHERE = "Is sphere? - ";
    private static final String AREA = "Area: ";
    private static final String TANGENCY = "Tangency? - ";
    private static final String VOLUME = "Volume: ";

    public double defineSurfaceSquare(Sphere sphere) {
        double sphereSurfaceArea = 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
        LOGGER.log(Level.INFO, AREA + sphereSurfaceArea);
        return sphereSurfaceArea;
    }

    public boolean isSphere(Sphere sphere) {
        boolean result = sphere.getRadius() > 0;
        LOGGER.log(Level.INFO, IS_SPHERE + result);
        return result;
    }

    public double defineVolume(Sphere sphere) {
        double sphereVolume;
        sphereVolume = 4 * Math.PI * Math.pow(sphere.getRadius(), 3) / 3;
        LOGGER.log(Level.INFO, VOLUME + sphereVolume);
        return sphereVolume;
    }

    public boolean isTangency(Sphere sphere) {
        boolean isSphericalTangency;
        isSphericalTangency = (sphere.getRadius() - Math.abs(sphere.getCenter().getX()) == 0 ||
                sphere.getRadius() - Math.abs(sphere.getCenter().getY()) == 0
                || sphere.getRadius() - Math.abs(sphere.getCenter().getZ()) == 0);
        LOGGER.log(Level.INFO, TANGENCY + isSphericalTangency);
        return isSphericalTangency;
    }

    public String defineSphericalProportion(Sphere sphere) {
        String sphericalProportion;
        double radius = sphere.getRadius();
        double volume = defineVolume(sphere);
        double pieces[] = {initRightSubTree(radius, volume, sphere.getCenter().getX()),
                initRightSubTree(radius, volume, sphere.getCenter().getY()),
                initRightSubTree(radius, volume, sphere.getCenter().getZ()),
                initLeftSubTree(radius, volume, sphere.getCenter().getX()),
                initLeftSubTree(radius, volume, sphere.getCenter().getY()),
                initLeftSubTree(radius, volume, sphere.getCenter().getZ())
        };
        sphericalProportion = defineFinalStringProportion(pieces);
        LOGGER.log(Level.INFO, PROPORTION + sphericalProportion);
        return sphericalProportion;
    }
    private double initLeftSubTree(double radius, double volume, double value) {
        double h = Math.abs(value) + radius;
        double piece = Math.PI * Math.pow(h, 2) * (radius - h / 3);
        return Math.abs(value) < radius ? (value > 0 ? (1 - piece / volume) : piece / volume) : (value <= 0 ? 1.0 : 0.0);
    }

    private double initRightSubTree(double radius, double volume, double value) {
        double h = Math.abs(value) + radius;
        double piece = Math.PI * Math.pow(h, 2) * (radius - h / 3);
        return Math.abs(value) < radius ? (value > 0 ? piece / volume : (1 - piece / volume)) : (value > 0 ? 1.0 : 0.0);
    }

    private String defineFinalStringProportion(double[] pieces) {
        double resultPiece;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pieces.length; i++) {
            for (int j = i + 1; j < pieces.length; j++) {
                for (int k = j + 1; k < pieces.length; k++) {
                    if (j != (i + 3) && k != (j + 3) && (k != i + 3)) {
                        resultPiece = pieces[i] * pieces[j] * pieces[k];
                        if (resultPiece != 0) {
                            result.append(Double.toString(resultPiece)).append(" : ");
                        }
                    }
                }
            }
        }
        return result.toString().substring(0, result.toString().length() - 3);
    }
}

