
public class entry {
	private	String txt;
	private String dt;
	private int sortpos;
	private int unsortpos;
	private int actpos=-1;
	

	entry(String text, String date, int sortposition,int unsortposition){
		txt = text;
		dt = date;
		sortpos = sortposition;
		unsortpos = unsortposition;
	}
	
	String getText(){
		return txt;
	}

	String getDate(){
		return dt;
	}
	
	int getSortPos(){
		return sortpos;
	}
	int getUnSortPos(){
		return unsortpos;
	}
	int getActPos(){
		return actpos;
	}
	
	void setActPos(int n){
		actpos = n;
		
	}
};
