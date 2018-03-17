package com.elyashevich.task1.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereDataValidation {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int COORDINATES_QUANTITY = 3;
    private static final String EMPTY_LINE_MESSAGE = "Empty line.";
    private static final String SUCCESSFUL_VALIDATION = "Validation of current sphere has been ended successfully.";

    private boolean isSphereCorrect(double radius) {
        return radius>0;
    }

    public boolean isDataCorrect(String data, String delimiter) {
        if (data.isEmpty()) {
            LOGGER.log(Level.INFO, EMPTY_LINE_MESSAGE);
            return false;
        }
        boolean result = false;
        String[] sphereParams = data.split(delimiter);
        int countParams = sphereParams.length;
        try {
            double radius = Double.parseDouble(sphereParams[0]);
            if (isSphereCorrect(radius) && isCorrectCoordinatesCount(countParams)) {
                if ((countParams - 1) == COORDINATES_QUANTITY) {
                    Double.parseDouble(sphereParams[1]);
                    Double.parseDouble(sphereParams[2]);
                    Double.parseDouble(sphereParams[3]);
                }
                result = true;
            }
            LOGGER.log(Level.INFO, SUCCESSFUL_VALIDATION);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
        }
        return result;
    }

    private boolean isCorrectCoordinatesCount(int count) {
        return (count - 1) == 0 || (count - 1) == COORDINATES_QUANTITY;
    }

}
