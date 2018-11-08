/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FreedomFighterDiscount implements IDiscountStrategy {
    
    int discountAmount = 2000;
    @Override
    public int getTotal(Registration regi) {
        
        double toreturn = regi.getTotal() - discountAmount;
        return (int) toreturn;
    }
    
}
