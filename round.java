

public class round {
	int entries;
	entry roundentries[];
	String task;
	String up;
	String down;
	int n = 0;
	int nset = 0;
	public int lastset = -1;
	public int lastsetstat = 0;
	int roundstat = 0;
	

	
	round(int n,String title,String oben,String unten ){
		entries = n;
		task = title;
		up = oben;
		down = unten;
		roundentries = new entry[n];
	}
	
	int checkPos(){
		int last = -1;
		for (int i = 0; i < n; i++ ){
			if (roundentries[i].getActPos() != -1){
				if (roundentries[i].getActPos() < last)
					return 1;
				last = roundentries[i].getActPos();				
			}

		}
		return 0;
	}
	
	void solve(){
		for (int i = 0; i < n; i++ ){
			roundentries[i].setActPos(roundentries[i].getSortPos());
		}
	}
	
	boolean setEntry(String txt,String dt, int pos,int unpos){
		if (n < entries){
			roundentries[n] = new entry(txt,dt,pos,unpos);
			++n;
			return true;
		}
		else
			return false;
	}
	
	int getEntryActPos(int n){
		return roundentries[n].getActPos();
	}

	int getEntryUnSortPos(int n){
		return roundentries[n].getUnSortPos();
	}
	
	String getEntryText(int n){
		return roundentries[n].getText();
	}
	
	String getTask(){
		return task;
	}
	
	void setActPos(int entryNr,int setPos){
		this.shiftup(setPos);
		if (setPos <= nset){ 
			++nset;
			roundentries[entryNr].setActPos(setPos);
		}
		lastset = setPos; 
	}
	

	
	void shiftup(int limit){
		for (int i = 0; i < entries; i++){
			if (roundentries[i].getActPos() >= limit)
				roundentries[i].setActPos(roundentries[i].getActPos() + 1); 
		}
	}
}
