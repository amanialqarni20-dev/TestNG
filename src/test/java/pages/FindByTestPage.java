package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FindByTestPage {

    public FindByTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "p1")
    public WebElement paragraph1;

    @FindAll({//Or Operator
            @FindBy(id = "p2"),
            @FindBy(className = "normal")
    })
    public WebElement paragraph2;


    @FindAll({//And operator
            @FindBy(id = "p3"),
            @FindBy(className = "normal"),
            @FindBy(name = "pName3")
    })
    public WebElement paragraph3;


}
/*
@FindBy
Single WebElement

@FindBy(id = "username")
private WebElement element;

Single Criterion

@FindBys
AND Operator

@FindBys({
  @FindBy(id = "A"),
  @FindBy(class = "B")
})
WebElement element;

ALL criteria must match

@FindAll
OR Operator

@FindAll({
  @FindBy(id = "A"),
  @FindBy(class = "B")
})
List<WebElement> elements;

ANY criteria can match
 */