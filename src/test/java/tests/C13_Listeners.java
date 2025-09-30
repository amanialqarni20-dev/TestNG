package tests;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.MyTestListener;

@Listeners(MyTestListener.class)
public class C13_Listeners {

    @Test
    void successTest() {
    }

    @Test
    void failedTest() throws Exception {
        throw new Exception("This is an issue!!!");
    }


    @Test
    void skippedTest() {
        throw new SkipException("Test skipped!!!");
    }

    @Test
    void assertionErrorTest() {
        assert false;
    }

}