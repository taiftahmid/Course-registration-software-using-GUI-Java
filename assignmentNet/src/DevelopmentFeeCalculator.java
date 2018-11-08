/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DevelopmentFeeCalculator implements IExtraFeeCalculator{
	
	public int getExtraAmount(double total) {
		
		return (int) Math.round(total * 0.1);
	}
    
}
