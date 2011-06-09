
import java.awt.Color;

public class logik {
	
	int runde = 0;
	int spieler = 0;
	gui myGui;
	round spiel[]; 
	
	void setGui(gui refGui){
		myGui = refGui;
	}
	
	logik(){

		spiel = new round[4];
		
		spiel[0] = new round(3,"Bundeskanzler in Deutschland","früher","später");
		spiel[0].setEntry("Kohl","1982",1,2);
		spiel[0].setEntry("Schröder","1996",2,1);
		spiel[0].setEntry("Märkel","2004",3,0);
		
		spiel[1] = new round(8,"Nummer 1 Hits","mehr","weniger");
		spiel[1].setEntry("eins","14",1,2);
		spiel[1].setEntry("zwei","12",2,7);
		spiel[1].setEntry("drei","7",3,1);
		spiel[1].setEntry("vier","14",4,6);
		spiel[1].setEntry("fünf","12",5,3);
		spiel[1].setEntry("sechs","7",6,4);
		spiel[1].setEntry("sieben","14",7,5);
		spiel[1].setEntry("acht","12",8,0);
		
		
		
	}
	
	void action(int entry,int pos){
		spiel[1].setActPos(entry,pos);
	}
	
	void updateGui(){
		int runde = 1;
		
		for (int i = 0; i < spiel[runde].entries+1; i++)
			if (i <=  spiel[runde].nset){
				myGui.JPosNr[i].setVisible(true);
				//myGui.JPosition[i].setVisible(true);
			}
			else{
				myGui.JPosNr[i].setVisible(false);
				//myGui.JPosition[i].setVisible(false);
			}
				
		
		myGui.JFrage.setText(spiel[runde].getTask()); 
		
		// set antwort text in GUI
		for (int j = 0; j < 8; j++){
			
			if (spiel[runde].getEntryActPos(j) == -1){
				myGui.JAntwort[j].setText(spiel[runde].getEntryText(j));
				myGui.JAntwort[j].setVisible(true);
				myGui.JAntNr[j].setVisible(true);
				
			}
			else {
				myGui.JAntwort[j].setText("");
				myGui.JAntwort[j].setVisible(false);
				myGui.JAntNr[j].setVisible(false);
			}
				
		}
		// set Position Text in Gui
		for (int ant = 0; ant < 8; ant++){
			myGui.JPosition[ant].setText(""+ant);
			myGui.JPosition[ant].setVisible(false);
			for (int i = 0; i < 8; i++){
			
				if (spiel[runde].getEntryActPos(i) == ant){
					myGui.JPosition[ant].setText(spiel[runde].getEntryText(i));
					myGui.JPosition[ant].setVisible(true);
				}

				//else 
					//myGui.JPosition[j].setText(""+j);
			}
			
		}
		if  (spiel[runde].lastset != -1){
			switch (spiel[runde].lastsetstat){
				
				case 0:{
					//System.out.println(myGui.JPosition[spiel[runde].lastset].getBackground());
					myGui.JPosition[spiel[runde].lastset].setBackground(new Color(255,160,0));	
					spiel[runde].lastsetstat = 1;
				}
				break;
				case 1:{
					
					// if check status ok --> green
					// else --> red
					if (spiel[runde].checkPos()== 0)
						myGui.JPosition[spiel[runde].lastset].setBackground(new Color(50,255,0));
					else if (spiel[runde].checkPos()== 1){
						myGui.JPosition[spiel[runde].lastset].setBackground(new Color(250,0,0));
						spiel[runde].solve();
					}
						
					
					spiel[runde].lastsetstat = 2;
					//spiel[runde].lastset = -1;
				}
				break;
				case 2:{
					
					myGui.JPosition[spiel[runde].lastset].setBackground(new Color(128,128,128));	
					spiel[runde].lastsetstat = 0;
					spiel[runde].lastset = -1;
				}
				break;
			}
			
				
		}
	}
	
	void setAnswer(){
		
	}
	
	void setPos(){
		
	}
	
}
