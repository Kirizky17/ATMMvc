/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmappmvc.Controller;

/**
 *
 * @author Rizky Wahyudi
 */
public class AccountController {
    private ATMController parentContoller;
    
    public AccountController(ATMController parentController){
        this.parentContoller = parentController;
    }
    
    public void authenticateUser(){
        int accNumber;
        int PIN;
        boolean authenticated = false;
        do{
            parentContoller.getATMView().accountView.displayAccountNumberInput();
            accNumber = parentContoller.scanner.nextInt();
            parentContoller.getATMView().accountView.displayAccountPINInput();
            PIN = parentContoller.scanner.nextInt();
            if(parentContoller.getATMModel().authenticateUser(accNumber, PIN)){
                parentContoller.model.setCurrentAccount(parentContoller.model.getAccount(accNumber));
                authenticated = true;
            }
        }while(!authenticated);
        
    }
    
}
