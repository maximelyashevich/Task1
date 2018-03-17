package com.elyashevich.task1.creator;

import com.elyashevich.task1.entity.Sphere;
import com.elyashevich.task1.exception.SphereTechnicalException;
import com.elyashevich.task1.parser.SphereParser;
import com.elyashevich.task1.validation.SphereDataValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CreatorSphereList {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String NO_INITIALIZATION_DATA = "No data for initializing data.";

    public ArrayList<Sphere> createSpheresList(ArrayList<String> spheresDataList, String delimiter) throws SphereTechnicalException {
        SphereDataValidation validationData = new SphereDataValidation();
        ArrayList<Sphere> spheres = new ArrayList<>();
        for (String sphereDataLine: spheresDataList){
            if (!validationData.isDataCorrect(sphereDataLine, delimiter)){
                LOGGER.log(Level.INFO, "Incorrect data for initializing.");
            }else {
                spheres.add(SphereParser.parseSphere(sphereDataLine, delimiter));
            }
        }
        if (spheres.isEmpty()) {
            throw new SphereTechnicalException(NO_INITIALIZATION_DATA);
        }
        return spheres;
    }
}
