package other;

public class SimpleBankingExample {

    public static void main(String[] args) {
      Account account1 = new Account(5000);
      Account account2 = new Account(1000);

      // deposit
      account1.deposit(500);
      System.out.println("Balance after deposit " + account1.getBalance());

      // withdraw
      account1.withdraw(200);
      System.out.println("Balance after withdrawal " + account1.getBalance());

      // transfer
      account1.transfer(account2, 1000);
      System.out.println("Balance after transfer from account 1 " + account1.getBalance());
      System.out.println("Balance after transfer to account 2 " + account2.getBalance());
    }


    static class Account {
        private double balance;

        public Account(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (balance < amount) {
                System.out.println("Insufficient funds");
                return;
            }
            balance -= amount;
        }

        public void transfer(Account toAccount, double amount) {
            if (balance < amount) {
                System.out.println("Insufficient funds");
                return;
            }
            withdraw(amount);
            toAccount.deposit(amount);
        }

        public double getBalance() {
            return balance;
        }
    }
}
