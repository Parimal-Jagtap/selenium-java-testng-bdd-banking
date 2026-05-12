package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PaymentPage;

/**
 * PaymentSteps — BDD step definitions for payment module
 */
public class PaymentSteps {

    private PaymentPage paymentPage;

    @When("the user navigates to payments module")
    public void userNavigatesToPayments() {
        paymentPage = new PaymentPage(Hooks.driver);
        paymentPage.navigateToPayments();
    }

    @And("the user selects bill type {string}")
    public void userSelectsBillType(String type) {
        paymentPage.selectBillType(type);
    }

    @And("the user enters consumer number {string}")
    public void userEntersConsumerNumber(String number) {
        paymentPage.enterConsumerNumber(number);
    }

    @And("the user fetches the bill")
    public void userFetchesBill() {
        paymentPage.fetchBill();
    }

    @Then("the bill amount should be displayed")
    public void billAmountShouldBeDisplayed() {
        String amount = paymentPage.getBillAmount();
        Assert.assertNotNull(amount, "Bill amount should not be null");
        Assert.assertFalse(amount.isEmpty(),
            "Bill amount should be displayed");
    }

    @When("the user pays the bill")
    public void userPaysBill() {
        paymentPage.payBill();
    }

    @Then("the payment should be successful")
    public void paymentShouldBeSuccessful() {
        Assert.assertTrue(paymentPage.isPaymentSuccessful(),
            "Payment should be successful");
    }

    @And("a transaction reference should be generated")
    public void transactionReferenceShouldBeGenerated() {
        String ref = paymentPage.getTransactionRef();
        Assert.assertNotNull(ref,
            "Transaction reference should be generated");
        Assert.assertFalse(ref.isEmpty(),
            "Transaction reference should not be empty");
    }

    @And("the user enters mobile number {string}")
    public void userEntersMobileNumber(String mobile) {
        paymentPage.rechargePhone(mobile, "");
    }

    @And("the user enters recharge amount {string}")
    public void userEntersRechargeAmount(String amount) {
        paymentPage.rechargePhone("", amount);
    }

    @And("the user submits the recharge")
    public void userSubmitsRecharge() {
        paymentPage.payBill();
    }
}
