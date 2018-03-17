package test.com.elyashevich.task1.input;

import com.elyashevich.task1.creator.CreatorSphereList;
import com.elyashevich.task1.entity.Point;
import com.elyashevich.task1.entity.Sphere;
import com.elyashevich.task1.exception.SphereTechnicalException;
import com.elyashevich.task1.input.ReadDataFromFile;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class ReadDataFromFileTest {
    private static final String SPACE_DELIMITER = "\\s";
    private static final String FILE_PATH = "text\\test.txt";
    private static final String EMPTY_FILE_PATH = "text\\empty.txt";
    private static final String[] SPHERES = {"fdfhgjhkjlhgvcbvh,j.hgfbchgh,j.k\n", "1.0 1 1 1\n",
            "3.0\n", "5.5 0\n", "6.5 9a 1 2\n", "\n", "-3.7 2 1 3\n", "0.5 1 0 0 5\n", "9 1 2 3\n", "10 10 10 10"};
    private static ArrayList<Sphere> spheres;
    private static File file;
    private static File emptyFile;

    @BeforeSuite
    public static void createFile() throws IOException {
        file = new File(FILE_PATH);
        emptyFile = new File(EMPTY_FILE_PATH);
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(SPHERES[0]);
        fileWriter.write(SPHERES[1]);
        fileWriter.write(SPHERES[2]);
        fileWriter.write(SPHERES[3]);
        fileWriter.write(SPHERES[4]);
        fileWriter.write(SPHERES[5]);
        fileWriter.write(SPHERES[6]);
        fileWriter.write(SPHERES[7]);
        fileWriter.write(SPHERES[8]);
        fileWriter.write(SPHERES[9]);

        fileWriter.close();
    }

    @BeforeClass
    public static void initSphericalList() {
        spheres = new ArrayList<>();
        spheres.add(new Sphere(1.0, new Point(1, 1, 1)));
        spheres.add(new Sphere(3.0, new Point()));
        spheres.add(new Sphere(9, new Point(1, 2, 3)));
        spheres.add(new Sphere(10, new Point(10, 10, 10)));
    }

    @Test
    public void checkSphereList() throws SphereTechnicalException {
        ArrayList<String> dataList = new ReadDataFromFile().readFromFile(file.getPath());
        ArrayList<Sphere> expected = new CreatorSphereList().createSpheresList(dataList, SPACE_DELIMITER);
        ArrayList<Sphere> actual = spheres;
        System.out.println(expected);
        System.out.println(actual);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = SphereTechnicalException.class)
    public void checkSphereEmptyList() throws SphereTechnicalException {
        ArrayList<String> dataList = new ReadDataFromFile().readFromFile(emptyFile.getPath());
        ArrayList<Sphere> expected = new CreatorSphereList().createSpheresList(dataList, SPACE_DELIMITER);
        ArrayList<Sphere> actual = spheres;
        assertEquals(actual, expected);
    }

    @AfterClass
    public void clearSphericalList() {
        spheres = null;
    }

    @AfterSuite
    public void deleteFile() {
        file.delete();
        emptyFile.delete();
    }
}
