package ZakaatreminderMachine;


import java.util.Scanner;
import java.util.Stack;

public class ZakaatCalculator {

    static ZakaatAmountTobeDeducted ZakaattobeDeducted  = new ZakaatAmountTobeDeducted();
Scanner inp= new Scanner(System.in);

    static Stack<Integer> silverRateStack = new Stack<>();
    static   public void setSilverRatesStacks( ) {
        silverRateStack.push(1428);
        silverRateStack.push(1447);
        silverRateStack.push(1480);
    }


    static Stack<Integer> YearStack= new Stack<>();
    //  ----------------setYearStack------------
    static   public void setYearStack(  int newYear) {
        YearStack.push(2020);
        YearStack.push(2021);
        YearStack.push(newYear);
    }



   private static void setSilverRatesStacks( int silverratePerTola) {
        silverRateStack.push(1428);
        silverRateStack.push(1447);
        silverRateStack.push(1480);
    }
    //--------isEligibleToZakaat-----

    static boolean isBalanceEligible( double bal  ){
        return  bal>=calZakaatNisaab();
    }


    static  double  calZakaatNisaab( ) {

        setSilverRatesStacks( );
        return  silverRateStack.peek()*52.5;
    }

    static  double  calZakaatAmmount( SavingAccount a ) {
        return a.getSavingBalance()*0.025;
    }


    static  void ZakaatDebited( SavingAccount a ) {
        System.out.println(" \t dear user ");
        System.out.println(" total saving Balance= " + a.getSavingBalance());

        System.out.println("calculated amount of Zakaat=  " + ZakaattobeDeducted.peek());

        if (ZakaattobeDeducted.peek() >= 0) {
            a.setSavingBalance(((a.getSavingBalance() - ZakaattobeDeducted.pop())));

            System.out.println(" remaining balance is " + a.getSavingBalance());
        }
        else
            System.out.println(" nothing left in Queue ");
    }

    static  void ZakaatCalling( SavingAccount a ){
        System.out.println(" \t dear user ");
       if (a.zakaatFlag==true) {

            System.out.println(" your  balance  have met both two conditions ");

            System.out.println(" total saving Balance= " + a.getSavingBalance()

                    + "  exceeds zakaatNisaab " + ZakaatCalculator.calZakaatNisaab());
            System.out.println( "  have been  storing    for 12 months ");

            //dont set in saving balance//add  calculated amount in queue
           System.out.print("calculated amount of Zakaat= ");

         ZakaattobeDeducted.push( calZakaatAmmount(a));
    }
       else
        System.out.println(" your  balance  have not met both two conditions ");
    }


    static  double  getcalZakaatNisaab( double silverRate ) {
        return  silverRate*52.5;
    }



 }



