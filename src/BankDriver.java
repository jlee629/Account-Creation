import java.util.Scanner;
import java.security.SecureRandom;

public class BankDriver {
    static Scanner input;
    static SecureRandom random;

    public static void main(String[] args) {
        BankAccount[] bankAccountArray = new BankAccount[5];
        input = new Scanner(System.in);
        random = new SecureRandom();
        for (int i = 0; i < bankAccountArray.length; i++) {
            bankAccountArray[i] = takeUserInput();
            bankAccountArray[i].setAccountNumber(1000+random.nextInt(1001));
        }

        String[] welcomeMessage = {"Welcome to Centennial Bank!", "How can we help you today?",
                "How can we serve your needs today?", "Welcome to your own developed Bank!"};
        System.out.println("-------------------------");
        System.out.println(welcomeMessage[random.nextInt(welcomeMessage.length)]);
        System.out.println("-------------------------");

        printArray(bankAccountArray);

        int selectedNumber;
        do {
            boolean pinFound = false;
            System.out.println("Main Menu");
            System.out.println("1. Deposit Amount to an account");
            System.out.println("2. Withdraw an Amount from an account");
            System.out.println("3. Print Account Details");
            System.out.println("4. Print All Account Details");
            System.out.println("5. Print Max Loan Amount Details");
            System.out.println("6. Exit the app");
            System.out.println("Please select the menu: ");
            selectedNumber = input.nextInt();

            if (selectedNumber == 1) {
                System.out.println("---Account Authentication---");
                System.out.println("Please enter the PIN");
                int pin = input.nextInt();
                for (int i = 0; i < bankAccountArray.length; i++) {
                    if (pin == bankAccountArray[i].getPinForAccess()) {
                        System.out.println("---Account Deposit---");
                        System.out.println("Please enter the amount: ");
                        double amount = input.nextDouble();
                        bankAccountArray[i].deposit(amount);
                        pinFound = true;
                    }
                }
                if (!pinFound) {
                    System.out.println("Invalid Pin!");
                }
            }
            else if (selectedNumber == 2) {
                System.out.println("---Account Authentication---");
                System.out.println("Please enter the PIN");
                int pin = input.nextInt();
                for(int i = 0; i <bankAccountArray.length; i++){
                    if (pin == bankAccountArray[i].getPinForAccess()){
                        System.out.println("---Account Withdrawal---");
                        System.out.println("Please enter the amount");
                        double amount = input.nextDouble();
                        bankAccountArray[i].withdraw(amount);
                        pinFound = true;
                    }
                }
                if (!pinFound) {
                    System.out.println("Invalid Pin!");
                }
            }
            else if (selectedNumber == 3) {
                System.out.println("---Account Authentication---");
                System.out.println("Please enter the PIN");
                int pin = input.nextInt();
                for(int i = 0; i <bankAccountArray.length; i++){
                    if (pin == bankAccountArray[i].getPinForAccess()){
                        System.out.println("---Account Details---");
                        bankAccountArray[i].getAccountDetails();
                        pinFound = true;
                    }
                }
                if (!pinFound) {
                    System.out.println("Invalid Pin!");
                }
            }
            else if (selectedNumber == 4) {

                for(int i = 0; i<bankAccountArray.length; i++){
                    System.out.println("---All Account Details---");
                    bankAccountArray[i].getAccountDetails();
                    System.out.println("-------------------------");
                }
            }
            else if (selectedNumber == 5) {
                System.out.println("---Account Authentication---");
                System.out.println("Please enter the PIN");
                int pin = input.nextInt();
                for(int i = 0; i <bankAccountArray.length; i++){
                    if (pin == bankAccountArray[i].getPinForAccess()){
                        System.out.println("---Maximum Loan Amount---");
                        System.out.println(bankAccountArray[i].maximumLoanAmount(bankAccountArray[i].getAccountType()));
                        pinFound = true;
                    }
                }
                if (!pinFound) {
                    System.out.println("Invalid Pin!");
                }
            }
            else if (selectedNumber == 6){
                break;
            }
            else {
                System.out.print("Invalid Number! \n\n");
            }
        } while (selectedNumber != 6);

    }
    public static BankAccount takeUserInput(){
        System.out.println("---Account Creation---");
        System.out.println("Enter your name: ");
        String holderName = input.nextLine();
        System.out.println("Enter your pin (4 digits - no space): ");
        int pinForAccess = input.nextInt();
        System.out.println("Enter your balance in CAD: ");
        double balanceInCAD = input.nextDouble();

        System.out.println("Enter your account type: ");
        System.out.println("1. CHEQUING \n2. SAVINGS \n3. RRSP \n4. TFSA");
        AccountType accountType = null;
        int userChoice = input.nextInt();
        switch(userChoice){
            case 1:
                accountType = AccountType.CHEQUING;
                break;
            case 2:
                accountType = AccountType.SAVINGS;
                break;
            case 3:
                accountType = AccountType.RRSP;
                break;
            case 4:
                accountType = AccountType.TFSA;
                break;
        }

        BankAccount bankAccount = new BankAccount(holderName, pinForAccess, balanceInCAD, accountType);
        input.nextLine();
        return bankAccount;
    }

    public static void printArray(BankAccount[] bankAccounts){
        //PRINT THE ARRAY
        for(BankAccount bankAccount: bankAccounts){
            System.out.println("-------------------------");
            System.out.println("Name: "+bankAccount.getHolderName());
            System.out.println("Pin: "+bankAccount.getPinForAccess());
            System.out.println("Balance: "+bankAccount.getBalanceInCAD());
            System.out.println("Account Number: "+bankAccount.getAccountNumber());
            System.out.println("Account Type: "+bankAccount.getAccountType());
            System.out.println("Max Loan Amount: "+bankAccount.maximumLoanAmount(bankAccount.getAccountType()));
            System.out.println("-------------------------");
        }
    }

}
