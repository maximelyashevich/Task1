package test.com.elyashevich.task1.action;

import com.elyashevich.task1.action.*;
import com.elyashevich.task1.entity.Point;
import com.elyashevich.task1.entity.Sphere;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ActionSphereTest {
    private static final String PROPORTION = "0.6006774902343752 : 0.11123657226562496 : 0.11123657226562496 : 0.020599365234374972 : 0.11123657226562496 : 0.020599365234374972 : 0.020599365234374972 : 0.0038146972656249918";
    private static ActionSphere actionSphere;
    private static Sphere sphere;

    @BeforeClass
    public static void initSphereActionTest() {
        sphere = new Sphere(2.0, new Point(1, 1, 1));
        actionSphere = new ActionSphere();
    }

    @Test
    public void testIsSphere() {
        boolean actual = actionSphere.isSphere(sphere);
        assertEquals(actual, true);
    }

    @Test
    public void testSurfaceArea() {
        double expected = 50.26548;
        double actual = actionSphere.defineSurfaceSquare(sphere);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testIsTrueVolume() {
        double expected = 33.51032;
        double actual = actionSphere.defineVolume(sphere);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testIsTangency() {
        boolean actual = actionSphere.isTangency(sphere);
        assertEquals(actual, false);
    }

    @Test
    public void testSphericalProportion() {
        String actual = actionSphere.defineSphericalProportion(sphere);
        assertEquals(actual, PROPORTION);
    }

    @AfterClass
    public static void clearSphere() {
        actionSphere = null;
        sphere = null;
    }
}
