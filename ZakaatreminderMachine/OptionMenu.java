package ZakaatreminderMachine;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends  SavingAccount {

    public OptionMenu() {
          }
    Scanner menuInput = new Scanner(System.in);
    static Hashtable<Integer, SavingAccount> loginCredentials  = new Hashtable<>();
    SavingAccount tempObj = new SavingAccount();
     void getLogin() throws IOException {
        int x = 1;
        int count = 0;
        int  setPinNo=0;

       //acounts creation
        SavingAccount a1 = new SavingAccount(3919, 1234, 90000);
           SavingAccount a2 = new SavingAccount(2491, 4321, 1000);
        SavingAccount a3 = new SavingAccount(7192, 6789, 45000);



        do {
            try {

                loginCredentials.put(3919,a1);
               loginCredentials.put(2491,a2);
                loginCredentials.put(7192,a3);

                System.out.println("======Welcome  to  Easy Pay Zakaat Machine======");

                System.out.print("Enter Account number");
               setAccountNo(menuInput.nextInt());

                System.out.print("Enter your pin Number");
                 setPinNo= menuInput.nextInt();
            }
            catch(Exception e) {
                System.out.println("\n"+"Incorrect pin(s)."+"\n");
                x=2;
            }
             for(Map.Entry<Integer , SavingAccount> entry:loginCredentials .entrySet()){
                  if ((entry.getKey() == this.getAccountNo()))  {
                 //  && (entry.getValue() == this.getPinNo()))
                          tempObj= entry.getValue();
                                     if( tempObj.getPinNo()==setPinNo) {
                                                                 getOptionMenu();
                                                                    count++;
                                     }
                 }
             }
            if(count==0) {
                System.out.println("\n"+"Wrong user number or password."+"\n"	);
            }
        }
        while( x== 1);
        //do while loop
    }

    public   void getOptionMenu() {
        System.out.println("Enter 1-view Balance");
        System.out.println("Enter 2-Withdraw  saving Balance ");
        System.out.println("Enter 3-Deposit Saving Balance");
        System.out.println("Enter 4-Pay Zakaat");
        System.out.println("Enter 5 - calculate Zakaat Nsisab)");
        System.out.println("Enter 6 -Exit");

        System.out.println("choice>>");

        int Selection = menuInput.nextInt();

        switch (Selection) {
            case 1:
                System.out.println("  total saving  account balance is :"
                        + moneyFormat.format(tempObj.getSavingBalance()));
                getOptionMenu();
                break;
            case 2:
                tempObj.getSavingWithdrawInput();
                getOptionMenu();
                break;

            case 3:
                tempObj.getSavingDepositInput();
                if (tempObj.zakaatFlag == true) ZakaatCalculator.ZakaatCalling(tempObj);
                getOptionMenu();
                break;

            case 4:
                System.out.println();
                ZakaatCalculator.ZakaatDebited(tempObj);
                getOptionMenu();
                break;
            case 5:
                System.out.println(ZakaatCalculator.getcalZakaatNisaab(menuInput.nextDouble()));
                getOptionMenu();
                break;
            case 6:
                System.out.println();
                System.out.println(" thanks for your coming ");
                break;

            default:
                System.out.println("\n" + "Invalid input ." + "\n");
                System.out.println();
                getOptionMenu();


        }


    }
}
