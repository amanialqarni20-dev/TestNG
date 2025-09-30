package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class C12_ParallelTestingDataProvider {

    @Test(dataProvider = "data")
    public void personNames(String First_Name, String Last_Name) {
        System.out.println("Person Names: " + First_Name + " " + Last_Name + "||" + Thread.currentThread().getId());
    }

    // By default, parallel = false. To enable parallel execution, specify parallel = true
    @DataProvider(name = "data", parallel = true)
    public Object[][] myDataProvider() {
        Object data[][] = new Object[4][2];

        // First Person Names details
        data[0][0] = "John";
        data[0][1] = "Doe";

        // Second Person Names details
        data[1][0] = "Jane";
        data[1][1] = "Smith";

        // Third Person Names details
        data[2][0] = "Peter";
        data[2][1] = "Jones";

        // Forth Person Names details
        data[3][0] = "Tom";
        data[3][1] = "Hawk";

        return data;
    }

}