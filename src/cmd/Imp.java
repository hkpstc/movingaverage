package cmd;

public class Imp {
 public 	String username ; 
 public 	String password ;
 public 	String database ;
 public 	String tables ;
 public 	String file ;
	    public String  getImpString(){
	    	
	    String imp = "imp " + this.username + "/" + this.password + "@" + this.database +  " file=" + this.file +" tables=" 
    			+ this.tables+ " ;";
		return imp; 
	    }
}
