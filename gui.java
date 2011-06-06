
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.BorderFactory; 
import javax.swing.border.Border;



public class gui implements KeyListener{

	JFrame myFrame;
	boolean markPos[] = new boolean[10];
	boolean markAns[]= new boolean[10];
	
	JLabel JAntwort[];
	JLabel JPosition[];
	JLabel JPosNr[] ;
	JLabel JAntNr[] ;
	
	JLabel JFrage;
	
	int aktAntwort = -1;
	int aktPosition = -1;
	
	logik myLogik;
	
	void setLogik(logik refLogik){
		myLogik = refLogik;
		//init
		myLogik.updateGui();
	}
	
	
	gui(){
		this.initWindow();
	}
	
	void initWindow(){
		try{
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
		}
	    catch (UnsupportedLookAndFeelException e) {
	        // handle exception
	     }
	     catch (ClassNotFoundException e) {
	        // handle exception
	     }
	     catch (InstantiationException e) {
	        // handle exception
	     }
	     catch (IllegalAccessException e) {
	        // handle exception
	     }

		
		myFrame = new JFrame("Chrono");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myFrame.getContentPane().setLayout(null);
		
		JFrage = new JLabel("FRAGE",JLabel.CENTER);
		JFrage.setFont(new Font("Courier New",Font.BOLD, 18));
	    JFrage.setForeground(Color.BLACK);
		JFrage.setBackground(Color.GRAY);
		JFrage.setOpaque(true);
		JFrage.setBounds(200,20,400,40);
		
		
		myFrame.add(JFrage);
		
		JAntwort = new JLabel[10];
		JPosition = new JLabel[10];
		JPosNr = new JLabel[11];
		JAntNr = new JLabel[10];
		
		JPosNr[8] = new JLabel("9" + " >",JLabel.CENTER);
		
		JPosNr[8].setFont(new Font("Courier New",Font.BOLD, 18));
		JPosNr[8].setForeground(Color.BLACK);
		//JPosNr[8].setBackground(Color.GRAY);
		JPosNr[8].setOpaque(true);
		JPosNr[8].setBounds(5,475,45,40);
		myFrame.add(JPosNr[8]);
		
		
		for(int j = 0;  j < 8;  ++j ){
			JAntwort[j] = new JLabel("Antwort " + (j + 1),JLabel.CENTER);
			
			JAntwort[j].setFont(new Font("Courier New",Font.BOLD, 18));
		    JAntwort[j].setForeground(Color.BLACK);
		    JAntwort[j].setBounds(450,100 +(j * 50),300,40);

// Hintergrund
		    JAntwort[j].setBackground(Color.GRAY);
			JAntwort[j].setOpaque(true);
// Rahmen
			
			Border blackline = BorderFactory.createLineBorder(Color.black);
			JAntwort[j].setBorder(blackline);
		   
			myFrame.add(JAntwort[j]);
			
			JPosition[j] = new JLabel("Position " + (j + 1),JLabel.CENTER);
			
			JPosition[j].setFont(new Font("Courier New",Font.BOLD, 18));
			JPosition[j].setForeground(Color.BLACK);
			JPosition[j].setBackground(Color.GRAY);
			JPosition[j].setOpaque(true);
			JPosition[j].setBounds(50,100 +(j * 50),300,40);
			myFrame.add(JPosition[j]);
			
			JPosNr[j] = new JLabel("" + (j + 1) + " >",JLabel.CENTER);
			
			JPosNr[j].setFont(new Font("Courier New",Font.BOLD, 18));
			JPosNr[j].setForeground(Color.BLACK);
			//JPosNr[j].setBackground(Color.GRAY);
			JPosNr[j].setOpaque(true);
			JPosNr[j].setBounds(5,75 +(j * 50),45,40);
			myFrame.add(JPosNr[j]);
			
			
			JAntNr[j] = new JLabel("" + (char)(j+65) + ")");
			
			JAntNr[j].setFont(new Font("Courier New",Font.BOLD, 18));
			JAntNr[j].setForeground(Color.BLACK);
			//JAntNr[j].setBackground(Color.GRAY);
			JAntNr[j].setOpaque(true);
			JAntNr[j].setBounds(425,100 +(j * 50),45,40);
			myFrame.add(JAntNr[j]);
			
		}
		

		myFrame.addKeyListener(this);
		
		myFrame.setSize(800,600);
		myFrame.setLocation(200, 200);
		
		myFrame.setVisible(true);

		
	}
	
	void checkStatus(){

		
		
		
		// check status markPosition
		for (int j = 0; j < 8; j++){
			if (markAns[j] == true)
				JAntwort[j].setBackground(Color.YELLOW);
			else
				JAntwort[j].setBackground(Color.GRAY);
		}
		// check status markAnswer
		for (int j = 0; j < 9; j++){
			if(markPos[j] == true)
				JPosNr[j].setForeground(Color.YELLOW);
			else
				JPosNr[j].setForeground(Color.BLACK);				
		}		
	}

	
	public void keyPressed(KeyEvent k) {
		
		System.out.println(k.getKeyChar() + " " + k.getKeyCode());		
		if ((k.getKeyCode() > 64)&&(k.getKeyCode() < 73)){
			
			System.out.println("char: " + (k.getKeyCode()-65));
			if (markAns[k.getKeyCode()-65] == false){
				markAns[k.getKeyCode()-65] = true;
				aktAntwort = k.getKeyCode()-65;
			}
			else{
				markAns[k.getKeyCode()-65] = false;
				aktAntwort = -1;
			}
		}
		else if ((k.getKeyCode() > 48)&&(k.getKeyCode() < 58)){
			System.out.println("nr: "  + (k.getKeyCode()-49));
			if(markPos[k.getKeyCode()-49] == false){
				markPos[k.getKeyCode()-49] = true;
				aktPosition = k.getKeyCode()-49;
			}
			else {
				markPos[k.getKeyCode()-49] = false;
				aktPosition = -1;
			}
		}
		else if ((k.getKeyCode() > 96)&&(k.getKeyCode() < 106)){
			System.out.println("nr :"  + (k.getKeyCode()-96));
			if (markPos[k.getKeyCode()-97] == false){
				markPos[k.getKeyCode()-97] = true;
				aktPosition = k.getKeyCode()-97;
				
			}
			else{
				markPos[k.getKeyCode()-97] = false;
				aktPosition = -1;
			}
		}	
		this.checkStatus();
		

		
		if (k.getKeyCode()== 32){
			
		
			if ( (aktAntwort != -1) && (aktPosition != -1) ){
				myLogik.action(aktAntwort,aktPosition);
				markAns[aktAntwort] = false;
				markPos[aktPosition] = false;
				aktAntwort = -1;
				aktPosition = -1;
				
				
			}
			this.checkStatus();
			myLogik.updateGui();
		
		}
		
		
	}

	
	public void keyReleased(KeyEvent arg0) {
	}

	
	public void keyTyped(KeyEvent arg0) {
	}
	
}
