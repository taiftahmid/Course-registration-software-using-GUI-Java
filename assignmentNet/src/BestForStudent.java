/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BestForStudent extends CompositeDiscountStrategy {

    @Override
    public int getTotal(Registration regi) {
        int highest = 0;
        for(IDiscountStrategy strat : dstrat){
            int total = strat.getTotal(regi);
            highest = Math.max(highest, total);
        }
        return highest;
    }
    
}
