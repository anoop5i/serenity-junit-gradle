package com.ocular;

/*
 * GoogleSnap Type
 *
 */

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;

@Snap(value = "Annotated-Google.png", similarity = 95)
public class GoogleSnap {
   private WebDriver webDriver;

   public GoogleSnap(WebDriver driver) {
      this.webDriver = driver;
   }

   public OcularResult compare() {
      return Ocular.snapshot()
            .from(this)
            .sample()
            .using(webDriver)
            .compare();
   }
}
