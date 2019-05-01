/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmappmvc.View;

import atmappmvc.ATMAppMVC;

/**
 *
 * @author Rizky Wahyudi
 */
public class MainView {
    public TransactionView transactionView;
    public AccountView accountView;
    public ATMView aTMView;
    
    public MainView(){
        this.transactionView = new TransactionView();
        this.accountView = new AccountView();
        this.aTMView = new ATMView();
    }
}
