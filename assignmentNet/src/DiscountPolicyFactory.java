/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DiscountPolicyFactory {
    
    static DiscountPolicyFactory instance;
    IDiscountStrategy ids; 
    
    public static synchronized DiscountPolicyFactory getInstance(){
		if(instance==null){
			instance = new DiscountPolicyFactory();
		}
		return instance;
	}
    
    IDiscountStrategy getStrategy(String n) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        String className = n;
        ids = (IDiscountStrategy) Class.forName(className).newInstance();
        return ids;
    }
}
