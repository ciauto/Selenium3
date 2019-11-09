package twoPLUGS;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		fileName = fileName + ".png";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("./Screenshots/"+fileName));
  }
}