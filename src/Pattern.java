public class Pattern {

  public static void main(String[] args) throws Exception {
    System.out.println("\033[2J\033[1;1H");

    Checkout checkout = new Checkout();

    // Test with different payment types
    // checkout.processCheckout(PaymentType.CREDIT_CARD);
    // checkout.processCheckout(PaymentType.DEBIT_CARD);
    // checkout.processCheckout(PaymentType.UPI);
    // checkout.processCheckout(PaymentType.WALLET);

    /* 
    Exception Handling: Wrapped each call to processCheckout() in a try-catch block, ensuring that all payment types are tested.
     */
    try {
      checkout.processCheckout(PaymentType.CREDIT_CARD);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      checkout.processCheckout(PaymentType.DEBIT_CARD);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      checkout.processCheckout(PaymentType.UPI);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      checkout.processCheckout(PaymentType.WALLET);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

enum PaymentType {
  CREDIT_CARD,
  DEBIT_CARD,
  UPI,
  WALLET,
}

/**
 * Checkout
 */
class Checkout {

  void processCheckout(PaymentType paymentType) throws Exception {
    if (paymentType == PaymentType.CREDIT_CARD) {
      System.out.println("Processing payment using " + PaymentType.CREDIT_CARD);
      processSuccessful();
    } else if (paymentType == PaymentType.DEBIT_CARD) {
      System.out.println("Processing payment using " + PaymentType.DEBIT_CARD);
      processSuccessful();
    } else if (paymentType == PaymentType.UPI) {
      System.out.println("Process payment using" + PaymentType.UPI);
      processSuccessful();
    } else if (paymentType == PaymentType.WALLET) {
      System.out.println("Processing payment using " + PaymentType.WALLET);
      processFailure();
    }
  }

  // with the process is successful
  private void processSuccessful() {
    System.out.println("Checkout process completed");
  }

  // with the process is failure
  private void processFailure() throws Exception {
    throw new Exception("***Checkout process failure!***");
  }
}
