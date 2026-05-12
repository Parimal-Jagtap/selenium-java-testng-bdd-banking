package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * PaymentPage — Page Object for bill payment workflows
 * Covers: electricity, mobile recharge, utility payments
 */
public class PaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By paymentsMenuLink =
        By.xpath("//a[contains(text(),'Payments')]");
    private final By billTypeDropdown =
        By.id("bill-type");
    private final By consumerNumberInput =
        By.id("consumer-number");
    private final By fetchBillButton =
        By.xpath("//button[@data-testid='fetch-bill']");
    private final By billAmountLabel =
        By.xpath("//span[@data-testid='bill-amount']");
    private final By payNowButton =
        By.xpath("//button[@data-testid='pay-now']");
    private final By successMessage =
        By.xpath("//div[@data-testid='payment-success']");
    private final By transactionRefLabel =
        By.xpath("//span[@data-testid='transaction-ref']");
    private final By mobileNumberInput =
        By.id("mobile-number");
    private final By rechargeAmountInput =
        By.id("recharge-amount");
    private final By rechargeButton =
        By.xpath("//button[@data-testid='recharge-now']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToPayments() {
        wait.until(ExpectedConditions
            .elementToBeClickable(paymentsMenuLink)).click();
    }

    public void selectBillType(String type) {
        WebElement dropdown = wait.until(ExpectedConditions
            .visibilityOfElementLocated(billTypeDropdown));
        new Select(dropdown).selectByVisibleText(type);
    }

    public void enterConsumerNumber(String number) {
        WebElement field = wait.until(ExpectedConditions
            .visibilityOfElementLocated(consumerNumberInput));
        field.clear();
        field.sendKeys(number);
    }

    public void fetchBill() {
        wait.until(ExpectedConditions
            .elementToBeClickable(fetchBillButton)).click();
    }

    public String getBillAmount() {
        return wait.until(ExpectedConditions
            .visibilityOfElementLocated(billAmountLabel)).getText();
    }

    public void payBill() {
        wait.until(ExpectedConditions
            .elementToBeClickable(payNowButton)).click();
    }

    public boolean isPaymentSuccessful() {
        try {
            return wait.until(ExpectedConditions
                .visibilityOfElementLocated(successMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTransactionRef() {
        return wait.until(ExpectedConditions
            .visibilityOfElementLocated(transactionRefLabel)).getText();
    }

    public void rechargePhone(String mobile, String amount) {
        WebElement mobileField = wait.until(ExpectedConditions
            .visibilityOfElementLocated(mobileNumberInput));
        mobileField.clear();
        mobileField.sendKeys(mobile);
        WebElement amountField = wait.until(ExpectedConditions
            .visibilityOfElementLocated(rechargeAmountInput));
        amountField.clear();
        amountField.sendKeys(amount);
        wait.until(ExpectedConditions
            .elementToBeClickable(rechargeButton)).click();
    }
}
