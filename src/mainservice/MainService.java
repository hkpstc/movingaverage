package mainservice;

import java.sql.ResultSet;
import java.sql.SQLException;

import tobacooService.dataBase.sql.Sql;

import jdbc.JDBC;

public class MainService {
              public static void getOneCustMoveAverage() throws SQLException{
            	  
            	  ResultSet rs = JDBC.ExecuteSQLAndReturnResultSet(
          				JDBC.ConnectToOralce_TPM(), Sql.getSql1("100000000003"));
            	  double[] demandArray_orderByWeek_2007_2011= new double[332];
            	  double[] demandArray_orderByWeek_2012= new double[53];

            	  int i=0;
            	  while(rs.next()){
            		  if(i<265){
            			  demandArray_orderByWeek_2007_2011[i] =rs.getDouble(1); 
            		  }
            		  if(i>=265 &&i<318){
            			  
            			  demandArray_orderByWeek_2012[i-265] =rs.getDouble(1); 
            		  }
            		  
            		i=i+1;  
            	  }
           double[] moveaverage_weight_array=MovingAverage.movingaverage_foreachweight(demandArray_orderByWeek_2007_2011);
           
           



            	  MovingAverage.movingaverage(demandArray_orderByWeek_2012, moveaverage_weight_array);
              }
              public static void main(String args[]) throws SQLException{
            	  
            	  getOneCustMoveAverage();
            	  
              }
}
