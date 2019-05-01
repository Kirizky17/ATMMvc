/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmappmvc.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rizky Wahyudi
 */
public class ATMModel {
    
    private List<Account> accounts; 
    private Account currentAccount;
    private CashDispenser cashDispenser;
    
    public ATMModel() {
        accounts = new ArrayList<Account>();
        accounts.add(new Account(1234, 4321, 1000, 1500));
        accounts.add(new Account(8765, 5678, 1500, 2000));
        accounts.add(new Account(12345, 54321, 200, 500));
        cashDispenser = new CashDispenser();
    }
    
//    public void 
    
    public CashDispenser getCashDispenser(){
        return cashDispenser;
    }
    
    public void setCurrentAccount(Account acc){
        this.currentAccount = acc;
    }
    
    public Account getCurrentAccount(){
        return currentAccount;
    }

    public Account getAccount(int accountNumber) {
        for(Account ac : accounts){
            if(ac.getAccountNumber() == accountNumber){
                return ac;
            }
        }
        return null;
    } 
    
    public boolean authenticateUser(int accountNumber, int userPIN) {
        Account userAccount = getAccount(accountNumber);
        
        if (userAccount != null) {
            return userAccount.validatePIN(userPIN);
        }
        else {
            return false;
        }
    }

    public boolean searchAccount(int accountNumber){
        Account userAccount = getAccount(accountNumber);
        if (userAccount != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getAvailableBalance() {
        return currentAccount.getAvailableBalance();
    } 

    public double getTotalBalance() {
        return currentAccount.getTotalBalance();
    } 

    public void credit(int accountNumber, double amount) {
        getAccount(accountNumber).credit(amount);
    }

    public void debit(int accountNumber, double amount) {
        getAccount(accountNumber).debit(amount);
    } 
     
}
