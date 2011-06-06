
public class game {
	
	
	
	public static void main(String[] argsv){
		logik myLogik = new logik();
		gui myGui = new gui();
		myLogik.setGui(myGui);
		myGui.setLogik(myLogik);
		
	}

}
