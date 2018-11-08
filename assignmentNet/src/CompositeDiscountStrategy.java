
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public abstract class CompositeDiscountStrategy implements IDiscountStrategy {
    protected LinkedList<IDiscountStrategy> dstrat = new LinkedList<IDiscountStrategy>();
    
    
    
    public void add(IDiscountStrategy d){
        dstrat.add(d); 
    }

    @Override
    public abstract int getTotal(Registration regi);
    
}
