package tests;

import org.testng.annotations.Test;
import pages.FindByTestPage;
import utilities.Driver;

public class C04_FindBysFindAll {

    @Test
    void findBysFindAllTest() {
        FindByTestPage testPage = new FindByTestPage();

        Driver.getDriver().get("https://testpages.eviltester.com/styled/find-by-playground-test.html");

        System.out.println(testPage.paragraph1.getText());
        System.out.println(testPage.paragraph2.getText());
        System.out.println(testPage.paragraph3.getText());

        Driver.closeDriver();

    }

}