public class Pattern2 {

  public static void main(String[] args) {
    System.out.println("\033[2J\033[1;1H");

    Checkout checkout = new Checkout();
    try {
      checkout.processCheckout(new CreditCardPayment());
      checkout.processCheckout(new DebitCardPayment());
      checkout.processCheckout(new UPIPayment());
      checkout.processCheckout(new WalletPayment());
      //teste de error
      checkout.processCheckout(new FailurePayment());
    } catch (Exception e) {
      // Log exception or handle specific cases
      System.err.println("Error processing payment: " + e.getMessage());
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
 * InnerPattern2
 */
class Checkout {

  void processCheckout(PaymentStrategy paymentStrategy) throws Exception {
    // logica para o processo de pagamento feito pela interface
    paymentStrategy.processPayment();

    System.out.println("Checkout process completed");
  }
}

/**
 * InnerPattern2
 */
interface PaymentStrategy {
  void processPayment();
}

class CreditCardPayment implements PaymentStrategy {

  @Override
  public void processPayment() {
    System.out.println("Processing payment using " + PaymentType.CREDIT_CARD);
  }
}

class DebitCardPayment implements PaymentStrategy {

  @Override
  public void processPayment() {
    System.out.println("Processing payment using " + PaymentType.DEBIT_CARD);
  }
}

class UPIPayment implements PaymentStrategy {

  @Override
  public void processPayment() {
    System.out.println("Processing payment using " + PaymentType.UPI);
  }
}

class WalletPayment implements PaymentStrategy {

  @Override
  public void processPayment() {
    System.out.println("Processing payment using " + PaymentType.WALLET);
  }
}

//nova classe para simular erro

/**
 * InnerPattern2
 */
class FailurePayment implements PaymentStrategy {

  @Override
  public void processPayment() {
    //erro simulado
    throw new RuntimeException(
      "Payment processing failed due to insufficent found."
    );
  }
}
