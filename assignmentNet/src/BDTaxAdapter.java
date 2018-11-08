/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BDTaxAdapter implements IExtraFeeCalculator {
	
	private BDTAXCalculator bdtc;
	

	
	public int getExtraAmount(double total) {
		bdtc = new BDTAXCalculator(); 
		return Math.round(bdtc.calculateVATAmount(total));
		
	}

    
}
