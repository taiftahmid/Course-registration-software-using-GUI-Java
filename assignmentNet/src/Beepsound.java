/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.midi.Soundbank;
import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Beepsound implements Listener{
	
	//private int gt;
	
	void register(Registration rgr){
		rgr.addListener(this);
		
	}

	@Override
	public void update(double gt) {

		//Toolkit.getDefaultToolkit().beep();
		sound();

		
		
	}
	public void sound(){
	    InputStream in;
	    try{
	        in = new FileInputStream(new File("D:\\Coding\\assignmentNet\\censor-beep-01.wav"));
	        AudioStream audio = new AudioStream(in);
	        AudioPlayer.player.start(audio);
	    }
	    catch(Exception e){
	    JOptionPane.showMessageDialog(null, e);
	    }
		
	}

}


