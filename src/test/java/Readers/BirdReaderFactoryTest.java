package Readers;

import Exeptions.FileNotRecognizedException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.testng.Assert.*;

public class BirdReaderFactoryTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void testGetReaderShouldThrowWhenFIleNotFound() throws FileNotRecognizedException, FileNotFoundException {
       BirdReaderFactory.getReader(new File("unexistent"));
    }

    @Test(expectedExceptions = FileNotRecognizedException.class)
    public void testGetReaderShouldThrowWhenExtensionNotFound() throws FileNotRecognizedException, FileNotFoundException {
        BirdReaderFactory.getReader(new File("src\\main\\resources\\testDummy.not"));
    }

    @Test
    public void testGetReaderShouldReturnJsonReader() throws FileNotRecognizedException, FileNotFoundException {
        assertEquals(BirdReaderFactory.getReader(new File("src\\main\\resources\\savedBirds.json")).getClass(), BirdJsonReader.class);
    }

    @Test
    public void testGetReaderShouldReturnTxtReader() throws FileNotRecognizedException, FileNotFoundException {
        assertEquals(BirdReaderFactory.getReader(new File("src\\main\\resources\\savedBirds.txt")).getClass(), BirdTextReader.class);
    }
}