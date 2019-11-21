package workshop_9;

public class DepositMoney extends Thread{

    private SharedAccount sharedAccount;

    private double[] balance;
    private String[] currency;
    private int i = 0;
    private int threadInUse = 0;


    //Constructor

    public DepositMoney(SharedAccount sharedAccount, double[] balance, String[] currency) {
        this.sharedAccount = sharedAccount;
        this.balance = balance;
        this.currency = currency;
    }

    public void run() {
        // infinite loop to add balance
        while(threadInUse == 0) {
            // to make sure that thread runs at a time
            synchronized(sharedAccount) {
                while(sharedAccount.getBalance() != 0) {
                    try {
                        sharedAccount.wait();
                    } catch(InterruptedException ie) {
                        System.out.println(ie.getMessage());
                    }
                }

                if(sharedAccount.getBalance() == 0 && i < 3) {
                    double dummy = 0 ;
                    while(balance[i] != dummy){
                        sharedAccount.depositBalance(1);
                        System.out.println("\n**** Deposit complete ****");
                        if(balance[i]> dummy){
                            dummy++;
                        }
                    }
                    System.out.println("\n     -----ACCOUNT-----    ");
                    sharedAccount.setCurrency(currency[i]);
                    System.out.println("Balance is 0 Add Balance: " + sharedAccount.getBalance() + " Currency is  " +  sharedAccount.getCurrency() + "\n");
                    i++;
                    System.out.println(sharedAccount.toString() + "\n");
                    sharedAccount.notify();
                } else {
                    Thread.currentThread().interrupt();
                    threadInUse = -1;
                }
            }
        }
        Thread.currentThread().interrupt();
    }
}