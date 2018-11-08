/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BDTAXCalculator {
    
    public float calculateVATAmount(double total){
		float taxpercentage = 0.15f;
		return (float) Math.round(total * taxpercentage);
	}
}
