/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AcademicExcellenceDiscount implements IDiscountStrategy {
    double percentage = 0.5;

    @Override
    public int getTotal(Registration regi) {
        return (int) (regi.getTotal() * percentage);
        
    }
    
}
