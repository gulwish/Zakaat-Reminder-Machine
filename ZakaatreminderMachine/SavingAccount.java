package ZakaatreminderMachine;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SavingAccount {
    private  int accountNo;
   private int pinNo;
    private double savingBalance;
    boolean zakaatFlag=false;
  //  boolean isPrimary;

    static GregorianCalendar gcalendar = new GregorianCalendar();

    DecimalFormat moneyFormat = new DecimalFormat(" ' $'###,##0.00");

    Scanner keyboard_Input = new Scanner(System.in);


    private  int countWithdrawTimes = 0;

    public SavingAccount(){
    }
  public SavingAccount(int accountNo, int pinNo, double bal) {
        setAccountNo( accountNo);
        setPinNo(pinNo);
        setSavingBalance(bal);
    }

void setbalance(double bal){
    this.savingBalance=bal;
}

    public double getSavingBalance() {
        return savingBalance;
    }

    public double setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
        return savingBalance;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }

    public int getPinNo() {
        return pinNo;
    }


    //----------------------------Withdraw---------------------

    /* customer saving account withdraw i/p */
    public void getSavingWithdrawInput() {

        System.out.println(" saving  account balance is :"
                + moneyFormat.format(getSavingBalance()));
        System.out.println(" enter amount to withdraw  >>");

            try {

                double amount = keyboard_Input.nextDouble();
                System.out.println();
                if ((savingBalance - amount) >= 0) {
                    calSavingWithdraw(amount);
                    System.out.println(" new  saving  account balance is :" +
                            moneyFormat.format(getSavingBalance()));
                                  } }catch (Exception error) {
                System.out.println("INVALID INPUT !!!" + error.getMessage());
                System.out.println();
            }
    }


    /*  calculate  saving account  withdrawal */
    public double calSavingWithdraw(double amount) {
        setSavingBalance(getSavingBalance() - amount);
        return savingBalance;
    }

    //-----------Deposit------------------

    /* customer saving account deposit i/p */
    public void getSavingDepositInput() {
        System.out.println(" saving  account balance is :"
                + moneyFormat.format(this.getSavingBalance()));
        System.out.println(" enter amount to deposit>>");
        try {
            double amount = keyboard_Input.nextDouble();

            //  if ((getSavingBalance() + amount) >= 0)
            if (amount >= 0) {
                this.cal_SavingDeposit(amount);
                System.out.println(" new  saving  account balance is :"
                        + moneyFormat.format(getSavingBalance()));
                // if (tempBalance==0.00) {
                    if ( flag==false ){
                    startMonth = gcalendar.get(Calendar.MONTH);
                    countMonths = 1;
                } while (countMonths <= 12) {
                    tempBalance += getSavingBalance();
                    countMonths++;
                }startMonth = gcalendar.get(Calendar.MONTH);//forever
                  if ( ZakaatCalculator.isBalanceEligible(tempBalance)){
                      zakaatFlag=true;
                      flag=true;
                      //tempBalance=0.00;
                  }
                      //call method to call user to pay zakaat  on just they login
                }
            else {
                System.out.println("invalid  deposit ");
            }
        }

         catch (Exception error) {
            System.out.println("INVALID INPUT !!!" + error.getMessage());
            System.out.println();
        }
    }


    /* calculate  saving account  deposit */
    public double cal_SavingDeposit(double amount) {
        return  setSavingBalance( this.savingBalance + amount);
    }
//----------gettingZkaatFirstDate---------------
int startMonth=0;
    int countMonths=0;
    double tempBalance = 0;
    boolean flag=false;

}
