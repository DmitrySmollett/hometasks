package framework.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import framework.page.GoogleCloudHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GooglePricingCalculatorTests extends CommonConditions {
  @Test(description = "Hardcore Test", invocationCount = 1)
  public void googleCloudCalculatorEstimateTotalPriceMatchesTheOneFromEmail() {
    String estimateTotalPriceFromEmail =
        new GoogleCloudHomePage(driver)
            .openPage()
            .searchForGoogleCloudPlatformPricingCalculator()
            .switchToTheGoogleCloudPlatformPricingCalculatorPage()
            .clickComputeEngineButton()
            .inputNumberOfInstances(4)
            .pickFreeOperatingSystem()
            .pickRegularMachineClass()
            .pickStandardEightMachineType()
            .addGpus()
            .pickLocalSsd()
            .pickDatacenterLocation()
            .pickCommittedUsage()
            .addToEstimate()
            .clickEmailEstimate()
            .registerNewEmailAddress()
            .confirmEstimateWithTemporaryEmailAddress()
            .getTotalPriceFromTheEmail();
    assertThat(estimateTotalPriceFromEmail, containsString("USD 1,082.77"));
  }

  @Test(description = "Hurt Me Plenty Test")
  public void googleCloudCalculatorEstimateFieldsContainDataThatWasEnteredPreviously() {
    boolean estimateMatchesTheChosenData =
        new GoogleCloudHomePage(driver)
            .openPage()
            .searchForGoogleCloudPlatformPricingCalculator()
            .switchToTheGoogleCloudPlatformPricingCalculatorPage()
            .clickComputeEngineButton()
            .inputNumberOfInstances(4)
            .pickFreeOperatingSystem()
            .pickRegularMachineClass()
            .pickStandardEightMachineType()
            .addGpus()
            .pickLocalSsd()
            .pickDatacenterLocation()
            .pickCommittedUsage()
            .addToEstimate()
            .checkEstimateFields();
    Assert.assertTrue(
        estimateMatchesTheChosenData, "Estimate fields data doesn't match the original one");
  }
}
