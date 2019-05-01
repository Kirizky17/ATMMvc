/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmappmvc.View;

/**
 *
 * @author Rizky Wahyudi
 */
public class ATMView {
    
    public void welcome(){
        System.out.println("Welcome!!");
    }
    
    public void exit(){
        System.out.println("Thank you! Goodbye..");
    }
    
    public void diplayATMMenu(){
      System.out.println("\nMain menu:");
      System.out.println("1 - View my balance");
      System.out.println("2 - Withdraw cash");
      System.out.println("3 - Deposit funds");
      System.out.println("4 - Transfer");
      System.out.println("5 - Exit\n");
      System.out.print("Enter a choice: ");
    }
    
}
