import java.util.Random;
public class BankAccount {
    String holderName;
    int pinForAccess;
    double balanceInCAD;
    int accountNumber;
    AccountType accountType;

    public BankAccount() {
        holderName = "";
        pinForAccess = 0;
        balanceInCAD = 0;
        accountNumber = 0;
        accountType = AccountType.valueOf("CHEQUING");
    }

    public BankAccount(String holderName, int pinForAccess, double balanceInCAD){
        this.holderName = holderName;
        this.pinForAccess = pinForAccess;
        this.balanceInCAD = balanceInCAD;
        accountNumber = 0;
        accountType = AccountType.valueOf("CHEQUING");

    }


    public BankAccount(String holderName, int pinForAccess, double balanceInCAD, AccountType accountType){
        this.holderName = holderName;
        this.pinForAccess = pinForAccess;
        this.balanceInCAD = balanceInCAD;
        accountNumber = 0;
        this.accountType = accountType;
    }


    public double maximumLoanAmount(AccountType accountType) {
        if (accountType == AccountType.CHEQUING || accountType == AccountType.SAVINGS) {
            return balanceInCAD*0.3;
        }
        else if (accountType == AccountType.TFSA) {
            return balanceInCAD*0.4;
        }
        else {
            return 0;
        }
    }

    public void deposit(double amount) {
        balanceInCAD = balanceInCAD + amount;
    }

    public void withdraw(double amount) {
        balanceInCAD = balanceInCAD - amount;
    }

    public void getAccountDetails() {
        System.out.println("Account Holder Name: " + holderName + "\nAccount Pin For Access: " + pinForAccess +
                "\nAccount Balance in CAD: " + balanceInCAD + "\nAccount Number: " + accountNumber + "\nAccount Type: " +
                accountType + "\nMaximum Loan Amount: " + maximumLoanAmount(accountType));
    }

    public String getHolderName() {
        return holderName;
    }

    public int getPinForAccess() {
        return pinForAccess;
    }

    public double getBalanceInCAD() {
        return balanceInCAD;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setPinForAccess(int pinForAccess) {
        this.pinForAccess = pinForAccess;
    }

    public void setBalanceInCAD(double balanceInCAD) {
        this.balanceInCAD = balanceInCAD;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}

