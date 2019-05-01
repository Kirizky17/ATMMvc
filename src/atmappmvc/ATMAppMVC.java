/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmappmvc;

import atmappmvc.Controller.ATMController;
import atmappmvc.Model.ATMModel;
import atmappmvc.Model.Account;
import atmappmvc.View.ATMView;
import atmappmvc.View.MainView;

/**
 *
 * @author Rizky Wahyudi
 */
public class ATMAppMVC {
    
    public static void main(String[] args) {
        ATMModel model;
        MainView view;
        ATMController controller;       
        model = new ATMModel();
        view = new MainView();
        controller = new ATMController(model, view);
        int choice;
        
        while(true){
            boolean authenticated = false;
            
            controller.getATMView().aTMView.welcome();
            controller.accountController.authenticateUser();

            do{
                choice  = controller.UserChoice();
            }while (choice != 5);
        }

    }
    
}
