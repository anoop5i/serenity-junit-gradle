package com.ocular;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import java.nio.file.Paths;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;

/*
 * Sample Type
 *
 */
@RunWith(SerenityRunner.class)
public class Sample {

   @Managed
   WebDriver webDriver;

   private static final String basePath = System.getProperty("user.dir") + "/ocular/";

   @BeforeClass
   public static void setUp() {
      Ocular.config()
            .snapshotPath(Paths.get(basePath + "snapshots"))
            .resultPath(Paths.get(basePath + "results"))
            .globalSimilarity(50);
   }

   @Test
   public void testSnapshot() {
      webDriver.get("http://www.google.com");
      OcularResult ocularResult = Ocular.snapshot()
            .from(Paths.get(basePath + "snapshots/google.png"))
            .sample()
            .using(webDriver)
            .compare();
      Assert.assertTrue(ocularResult.isEqualsImages());
   }

   @Test
   public void testSnapAnnotation() {
      webDriver.get("http://www.google.co.uk");
      OcularResult result = new GoogleSnap(webDriver).compare();
      Assert.assertTrue(result.isEqualsImages());
   }
}
