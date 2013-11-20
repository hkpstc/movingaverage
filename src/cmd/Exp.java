package cmd;

public class Exp {
 public 	String username ; 
 public 	String password ;
 public 	String database ;
 public 	String tables ;
 public 	String file ;
	    public String  getExpString(){
	    	
	    String exp = "exp " + this.username + "/" + this.password + "@" + this.database + " tables=" 
	    			+ this.tables + " file=" + this.file+ " ;" ;
		return exp; 
	    }
}
