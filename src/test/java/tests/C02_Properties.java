package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_Properties {

    @Test
    void propertiesTest() {
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        System.out.println(ConfigReader.getProperty("cl_email"));
        System.out.println(ConfigReader.getProperty("cl_password"));
        System.out.println(ConfigReader.getProperty("browser"));
        Driver.closeDriver();
    }

}