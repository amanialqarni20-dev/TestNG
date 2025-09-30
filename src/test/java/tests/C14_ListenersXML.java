package tests;

import org.testng.SkipException;
import org.testng.annotations.Test;



public class C14_ListenersXML {

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
