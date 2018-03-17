package test.com.elyashevich.task1.observer;

import com.elyashevich.task1.entity.Point;
import com.elyashevich.task1.entity.Sphere;
import com.elyashevich.task1.observer.SphereList;
import com.elyashevich.task1.observer.SphereParameterList;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class SphereObserverTest {
    private static ArrayList<Sphere> spheres;
    private static SphereList sphereList;
    private static SphereParameterList sphereParameterList;

    @BeforeClass
    public static void initSphereObserverTest() {
        spheres = new ArrayList<Sphere>(){{
            add(new Sphere(1.0, new Point(1, 1, 1)));
            add(new Sphere(9, new Point(1, 2, 3)));
            add(new Sphere(10, new Point(10, 10, 10)));
        }};
        sphereList = SphereList.getInstance();
        sphereParameterList = SphereParameterList.getInstance();
        for (Sphere sphere : spheres) {
            sphereList.addSphere(sphere);
            sphereParameterList.addParameter(sphere);
        }
    }

    @Test
    public void checkSphereSquare() {
        double expected = 5026.5482;
        sphereList.getSphere(1).setRadius(20);
        double actual = sphereParameterList.getSphereParameter(1).getSquare();
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void checkNewSphereSquare() {
        double expected = 7853.9816;
        sphereList.getSphere(1).setRadius(25);
        double actual = sphereParameterList.getSphereParameter(1).getSquare();
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void checkSphereVolume() {
        double expected = 33510.3216;
        sphereList.getSphere(0).setRadius(20);
        double actual = sphereParameterList.getSphereParameter(0).getVolume();
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void checkNewSphereVolume() {
        double expected = 65449.8469;
        sphereList.getSphere(0).setRadius(25);
        double actual = sphereParameterList.getSphereParameter(0).getVolume();
        assertEquals(actual, expected, 0.001);
    }

    @AfterClass
    public void clearSphericalList() {
        spheres = null;
        sphereList = null;
        sphereParameterList = null;
    }

}
