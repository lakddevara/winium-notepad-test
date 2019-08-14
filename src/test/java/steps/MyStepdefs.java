package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;

public class MyStepdefs {

    private WebDriver driver = null;

    @Given("^user opened the notepad plus$")
    public void userOpenedTheNotepadPlus() throws InterruptedException {

        String notepadAppPath = "C:\\Program Files (x86)\\Notepad++\\notepad++.exe";
        String winiumDriverPath = ".\\Winium.Desktop.Driver.exe";
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(notepadAppPath);
        WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable
                (new File(winiumDriverPath)).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
        Thread.sleep(5000);
        driver = new WiniumDriver(service, options);
        Thread.sleep(10000);
    }

    @When("^user entered some random text$")
    public void userEnteredSomeRandomText() {
        driver.findElement(By.id("Item 41001")).click();
        driver.findElement(By.className("Scintilla")).sendKeys("This is an sample winium Test");
        driver.findElement(By.id("Item 41006")).click();

    }

    @Then("^user saved the notepad file$")
    public void userSavedTheNotepadFile() throws AWTException {
        Robot robo = new Robot();
        robo.mouseMove(82,191);
        robo.delay(2000);
        robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        driver.findElement(By.id("1001")).sendKeys("testingFile");
        driver.findElement(By.name("Save")).click();
        driver.close();
        driver.quit();
    }


}
