package tobacooService.dataBase.sql;

public class Sql {
public static String sql1 ="";

      
 			public static String getSql1(String custcode){
 
 			sql1 ="select t.demand_qty from week_13526157_zero t where cust_code = "+custcode +" order by yearweek";
 			return sql1;
 			}
 			
 			public static String getSql2(String custcode){
 				 
 	 		String	sql2 ="select t.demand_qty from week_13526157_zero t where cust_code = "
 	 		              +custcode +" and to_char(yearweek,0,4)=2013 order by yearweek";
 	 			return sql2;
 	 			}  
 			
}
