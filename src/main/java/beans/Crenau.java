package beans;


import java.sql.Time;
import java.util.*;

public class Crenau {
	    private int id;
	    private Time heureDeb;
	    private Time heureFin;
	    
//	    SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy , hh:mm:ss");
//        String s1=dtf.format(heureDeb);
//        String s2=dtf.format(heureFin);
        
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		
		
		public Crenau(Time heureDeb, Time heureFin) {
			super();
			this.heureDeb = heureDeb;
			this.heureFin = heureFin;
		}
		public Crenau(int id, Time heureDeb, Time heureFin) {
			super();
			this.id = id;
			this.heureDeb = heureDeb;
			this.heureFin = heureFin;
		}
		public Time getHeureDeb() {
			return heureDeb;
		}
		public void setHeureDeb(Time heureDeb) {
			this.heureDeb = heureDeb;
		}
		public Time getHeureFin() {
			return heureFin;
		}
		public void setHeureFin(Time heureFin) {
			this.heureFin = heureFin;
		}
		@Override
		public String toString() {
			//SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy , hh:mm:ss");
			//dtf.format(\
			
			return "Crenau [heureDeb=" + heureDeb + ", heureFin=" + heureFin + "]";
		}
	    

}
