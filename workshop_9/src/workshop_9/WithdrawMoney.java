package workshop_9;

public class WithdrawMoney extends Thread {
    private SharedAccount sharedAccount;
    private int threadInUse = 0;


    //Constructor

    public WithdrawMoney(SharedAccount sharedAccount) {
        this.sharedAccount = sharedAccount;
    }

    public void run() {
        while(threadInUse == 0) {
            synchronized(sharedAccount) {
                while(sharedAccount.getBalance() != 0) {
                    sharedAccount.withdrawBalance(1.0);
                    System.out.println("Balance left in Account: " + sharedAccount.getBalance());
                    sharedAccount.notify();
                }

                try {
                    sharedAccount.wait();
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        }
    }
}