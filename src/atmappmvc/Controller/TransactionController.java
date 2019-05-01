/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmappmvc.Controller;

import atmappmvc.Model.Account;
import atmappmvc.Model.CashDispenser;
import atmappmvc.View.TransactionView;
import java.util.Scanner;

/**
 *
 * @author Rizky Wahyudi
 */
public class TransactionController {
    private ATMController parentContoller;
    
    public TransactionController(ATMController parentController){
        this.parentContoller = parentController;
    }
    
    public void balanceInquiry(){
        this.parentContoller.view.transactionView.balanceInquiry(this.parentContoller.model.getCurrentAccount().getAvailableBalance(), this.parentContoller.model.getCurrentAccount().getTotalBalance());
    }
    
    public void withdrawal(){
        TransactionView view = this.parentContoller.view.transactionView;
        int userChoice = 0; // local variable to store return value
        int[] amounts = {0, 20, 40, 60, 100, 200};
        CashDispenser cashDispenser = this.parentContoller.model.getCashDispenser();
        
        while (userChoice == 0) {
            
            view.displayWithdrawalAmount();
            
            int input = parentContoller.scanner.nextInt(); // get user input through keypad

            switch (input) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:{
                    userChoice = amounts[input];
                    break;
                }       
                case 6: // the user chose to cancel
                    userChoice = 6; // save user's choice
                    break;
                default:
                    view.displayErrorInput();
            } 
        } 
        if(userChoice != 6){
            if (parentContoller.model.getCurrentAccount().isBalanceAvaiable(userChoice)) {
                if(cashDispenser.isSufficientCashAvailable(userChoice)){
                    cashDispenser.dispenseCash(userChoice);
                    parentContoller.model.getCurrentAccount().debit(userChoice);
                }else{
                    view.displayInsufficientCashDIspenser();
                }
            }else{
                view.displayInsufficientBalance();
            }
        }
    }
    
    public void deposit() throws InterruptedException{
        TransactionView view = this.parentContoller.view.transactionView;
        view.displayPromptForDepositAmount();
        
        int amount = parentContoller.scanner.nextInt(); // get user input through keypad
        
        if (amount != 0){
            view.displayInsertEnvelope(amount);
            this.parentContoller.getATMModel().getCurrentAccount().deposit(amount);
            Thread.sleep(2000);
            view.displayEnvelopeInserted();
        }        
    }
    
}
