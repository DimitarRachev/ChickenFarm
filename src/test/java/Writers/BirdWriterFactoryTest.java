package Writers;

import Entities.Bird;
import Exeptions.FileNotRecognizedException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;

import static org.testng.Assert.*;

public class BirdWriterFactoryTest {
File file;
TreeSet<Bird> birds;

    @Test
    public void testGetWriterShouldReturnJsonWriter() throws FileNotRecognizedException, FileNotFoundException {
         file = new File("someThing\\.json");
           Assert.assertEquals(BirdWriterFactory.getWriter(file, birds).getClass(), BirdJsonWriter.class);
    }

    @Test
    public void testGetWriterShouldReturnTextWriter() throws FileNotRecognizedException, FileNotFoundException {
        file = new File("someThing\\.txt");
        Assert.assertEquals(BirdWriterFactory.getWriter(file, birds).getClass(), BirdTextWriter.class);
    }

    @Test(expectedExceptions = FileNotRecognizedException.class)
    public void testGetWriterShouldThrow() throws FileNotRecognizedException, FileNotFoundException {
        file = new File("someThing\\.non");
        BirdWriterFactory.getWriter(file, birds);
    }



}