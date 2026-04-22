package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * TransferPage — Page Object for fund transfer workflows
 * Covers: NEFT, RTGS, IMPS, domestic transfer
 */
public class TransferPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By transferMenuLink = By.xpath("//a[contains(text(),'Fund Transfer')]");
    private final By transferTypeDropdown = By.id("transfer-type");
    private final By beneficiaryAccountInput = By.id("beneficiary-account");
    private final By amountInput = By.id("transfer-amount");
    private final By remarksInput = By.id("remarks");
    private final By submitButton = By.xpath("//button[@data-testid='submit-transfer']");
    private final By successMessage = By.xpath("//div[@data-testid='success-toast']");
    private final By transactionIdLabel = By.xpath("//span[@data-testid='transaction-id']");

    public TransferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToTransferModule() {
        wait.until(ExpectedConditions.elementToBeClickable(transferMenuLink)).click();
    }

    public void selectTransferType(String type) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(transferTypeDropdown));
        new Select(dropdown).selectByVisibleText(type);
    }

    public void enterBeneficiaryAccount(String accountNumber) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(beneficiaryAccountInput));
        field.clear();
        field.sendKeys(accountNumber);
    }

    public void enterAmount(String amount) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        field.clear();
        field.sendKeys(amount);
    }

    public void enterRemarks(String remarks) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksInput));
        field.clear();
        field.sendKeys(remarks);
    }

    public void submitTransfer() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isTransferSuccessful() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTransactionId() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(transactionIdLabel)).getText();
    }
}
