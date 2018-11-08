/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BestForNsu extends CompositeDiscountStrategy {

    @Override
    public int getTotal(Registration regi) {
        
        int lowest = 9999999;
        for(IDiscountStrategy strat: dstrat){
            int total = strat.getTotal(regi);
            lowest = Math.min(lowest, total);
        }
        return lowest;
    }
    
    
}
