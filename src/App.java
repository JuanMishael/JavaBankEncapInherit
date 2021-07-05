import java.util.Scanner;

public class App {
    static Scanner in= new Scanner(System.in);   // scanner as global variable so i dont have to create another object per class
        
    static class Data{                    // data class 
            private static int acNum;
            private static String name;
            private static int curBalance;

            //getters                        //getters to access the private variables by other class 
            static String getName(){
                return name;
            }
            static int getAcNum(){
                return acNum;
            }
            static int getCurBalance(){
                return curBalance;
            }
            //setters                       //to change the data 
            static void setCurBalance(int balance){
                curBalance = balance;
            }
            static void setName(String pangalan){
                name = pangalan;
            }
            static void setAcNum(int num){
                acNum = num;
            }
        }
    static class login extends Data{             //login class extends data so i can access the setters and getters 
            static void login(){
                System.out.println("Enter Account Number:");
                int accountnum = in.nextInt();
                if(accountnum == getAcNum()){            //verify if the number already exist
                    System.out.println("Welcome "+ getName());
                    System.out.println("[1]withdraw [2]deposit");      
                    int chs = in.nextInt();            //get the choice between withdraw and depost
                    switch (chs){
                        case 1:
                            withdraw wd = new withdraw();      //go to withdraw class
                            wd.withdraw();
                            break;
                        case 2:
                            deposit dp = new deposit();            //got to deposit class
                            dp.deposit();
                            break;
                        default:
                            run();               //reset the program
                    }
                }
                else{
                    System.out.println("Invalid number");
                    run();                 //reset the program
                }
            }
    }
    static class CreateAccount extends Data {    //createaccount class extends data so i can access the setters and getters

            static void cAccount(){
                System.out.println("Enter Name ");
                String pangalan = in.next();
                setName(pangalan);                  //access setter to set new name
                int accountnum = (int)(Math.random()*(999-0+1)+0);          //this will creata a random number between 999-0
                System.out.println("Your Account Number: " + accountnum);
                setAcNum(accountnum);               //access setter to set new account number
                System.out.println("Name: "+getName()+"\nAccountNumber: "+getAcNum());

                run();             
            }
    }
    static class withdraw extends Data{          //withdraw class extends data so i can access the setters and getters
            static void withdraw(){
                if(getCurBalance() == 0 ){                 //check if the account balance is empty
                    System.out.println("You account is empty");
                    System.out.println("Transaction Ended");
                    run();
                }
                System.out.print("Enter Amount: ");
                int toDed = in.nextInt();
                int finBal = getCurBalance() - toDed;       //deduct the amount inputed to the current balance
                setCurBalance(finBal);                      //set new balance                        
                System.out.println("\nYour Current Balance: "+ getCurBalance());
                run();
            }
    }
    static class deposit extends Data{             //deposit class extends data so i can access the setters and getters
        static void deposit(){
                System.out.print("Enter Ammount: ");          
                int toAdd = in.nextInt();
                int finBal = getCurBalance() + toAdd;     //add the amount inputed to the current balance
                setCurBalance(finBal);                     //set new balance
                System.out.println("\nCurrent Balance: "+ getCurBalance());
                run();
        }
    }
    public static void run(){                    //run method
        System.out.println("[1]Login [2]Create Account [3]Exit ");
        int chs = in.nextInt();                  // read choice
        switch (chs){                            
            case 1:
                login log = new login();             //this will go to login class
                log.login();
                break;
            case 2:
                CreateAccount CA = new CreateAccount();    //this will go to CreateAccount class
                CA.cAccount();
                break;
            default:
                System.exit(0);                            //terminate program 
        }
    }
    public static void main(String[] args) {
        run();                        //this will go to run method
        System.exit(0);               
    }
}
