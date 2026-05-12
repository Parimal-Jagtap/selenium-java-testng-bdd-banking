package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

/**
 * AccountPage — Page Object for account management
 * Covers: balance view, transaction history, statement download
 */
public class AccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By accountMenuLink =
        By.xpath("//a[contains(text(),'Account')]");
    private final By accountBalanceLabel =
        By.xpath("//span[@data-testid='account-balance']");
    private final By accountNumberLabel =
        By.xpath("//span[@data-testid='account-number']");
    private final By transactionHistoryLink =
        By.xpath("//a[contains(text(),'Transaction History')]");
    private final By transactionRows =
        By.xpath("//table[@data-testid='transactions']//tr[not(thead)]");
    private final By transactionTypeFilter =
        By.id("transaction-type-filter");
    private final By downloadStatementButton =
        By.xpath("//button[@data-testid='download-statement']");
    private final By statementPeriodDropdown =
        By.id("statement-period");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToAccountSummary() {
        wait.until(ExpectedConditions
            .elementToBeClickable(accountMenuLink)).click();
    }

    public String getAccountBalance() {
        return wait.until(ExpectedConditions
            .visibilityOfElementLocated(accountBalanceLabel)).getText();
    }

    public String getAccountNumber() {
        return wait.until(ExpectedConditions
            .visibilityOfElementLocated(accountNumberLabel)).getText();
    }

    public void navigateToTransactionHistory() {
        wait.until(ExpectedConditions
            .elementToBeClickable(transactionHistoryLink)).click();
    }

    public List<WebElement> getTransactionRows() {
        return wait.until(ExpectedConditions
            .visibilityOfAllElementsLocatedBy(transactionRows));
    }

    public void filterByTransactionType(String type) {
        WebElement dropdown = wait.until(ExpectedConditions
            .visibilityOfElementLocated(transactionTypeFilter));
        new Select(dropdown).selectByVisibleText(type);
    }

    public void downloadStatement(String period) {
        WebElement dropdown = wait.until(ExpectedConditions
            .visibilityOfElementLocated(statementPeriodDropdown));
        new Select(dropdown).selectByVisibleText(period);
        wait.until(ExpectedConditions
            .elementToBeClickable(downloadStatementButton)).click();
    }
}
