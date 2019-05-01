/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmappmvc.Controller;

import atmappmvc.Model.ATMModel;
import atmappmvc.Model.CashDispenser;
import atmappmvc.View.ATMView;
import atmappmvc.View.MainView;
import java.util.Scanner;
import sun.applet.Main;

/**
 *
 * @author Rizky Wahyudi
 */
public class ATMController {
    
    ATMModel model;
    MainView view;
    public TransactionController transactionController;
    public AccountController accountController;
    public Scanner scanner;
    
    public ATMController(ATMModel model, MainView view){
        this.model = model;
        this.view = view;
        this.transactionController = new TransactionController(this);
        this.accountController = new AccountController(this);
        this.scanner = new Scanner(System.in);
    }
    
    public MainView getATMView(){
        return view;
    }
    
    public ATMModel getATMModel(){
        return model;
    }
    
//    public TransactionController getTransactionController(){
//        return this.transactionController;
//    }
//    
//    public AccountController getAccountController(){
//        return this.accountController;
//    }
    
    public int UserChoice() throws InterruptedException{
        int choice;
        this.view.aTMView.diplayATMMenu();
        choice = scanner.nextInt();
        switch(choice){
            case 1: {
                this.transactionController.balanceInquiry();
                break;
            }
            case 2: {
                this.transactionController.withdrawal();
                break;
            }
            case 3: {
                this.transactionController.deposit();
                break;
            }
            case 4: {
                break;
            }
        }
        return choice;
    }
    
}
