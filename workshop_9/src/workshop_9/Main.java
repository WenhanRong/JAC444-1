package workshop_9;

public class Main {

    public static void main(String[] args) {
        double[] balance = {1.0, 2.0, 3.0};
        String[] currency = {"$", "€", "£"};

        SharedAccount shAccount = new SharedAccount(0, "");

        Thread deposit = new Thread(new DepositMoney(shAccount, balance, currency));
        Thread withdraw = new Thread(new WithdrawMoney(shAccount));

        deposit.start();
        withdraw.start();

        try {
            deposit.join();
            withdraw.join();
        } catch(InterruptedException ie) {
            System.out.println(ie.getMessage());
        }

    }

}

