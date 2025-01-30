package stepdef;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import baseclass.BaseClass;
import baseclass.Log;
import com.aventstack.extentreports.ExtentReports;

public class Hooks {

	@Before
	public static void setup() throws InterruptedException {
		Log.info("Setting Up");
		BaseClass.getBaseCllass("Firefox");
	}

	@AfterStep
	    public static void tearDown(Scenario scenario) throws IOException  {
		        if(scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
	            BufferedImage image = ImageIO.read(new ByteArrayInputStream(screenshot));
	            BufferedImage resizedImage = new BufferedImage(500, 325, image.getType());
	            Graphics2D graphics = resizedImage.createGraphics();
	            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	            graphics.drawImage(image, 0, 0, 1440, 1080, 0, 0, image.getWidth(), image.getHeight(), null);
	            graphics.dispose();
	            File screenshotFile = new File(scenario.getName());
	            ImageIO.write(resizedImage, "png", Files.newOutputStream(screenshotFile.toPath()));
	            scenario.attach(screenshot, "image/png", scenario.getName());
	        }
	}

	@After
	public void endReport() {
	ExtentReports extent = new ExtentReports();
	extent.flush();
		}
	}
