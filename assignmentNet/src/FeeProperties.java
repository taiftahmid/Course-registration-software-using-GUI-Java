/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author User
 */
public class FeeProperties {
    Properties fps;
    FileInputStream file;
    
    public void setProperty() throws IOException{
		file = new FileInputStream("Fee properties.txt");
		fps = new Properties(System.getProperties());
		fps.load(file);
		System.setProperties(fps);

	}
    
}
