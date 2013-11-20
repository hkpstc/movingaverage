package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * 调用存储过程 使用方法 首先设置参数 然后调用主程序callprocedure
 * 
 * @author huangkaipeng
 * */

public class ProcedureCaller {
	private CallableStatement proc;
	private String callCommand;
	public String[] params;
	public void callProcedure(Connection conn,String procedureName) throws Exception {
		{
			try {
				
				this.setCallCommand(procedureName,
						this.getParamsLength(this.params));
				this.proc = conn.prepareCall(this.callCommand);
				System.out.println(this.callCommand);
				this.setAllStringParam(this.params);
				proc.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private int getParamsLength(String[] params) {
		int paramLength;
		 if(this.params==null){
			 paramLength=0; 
		 }
		 else{
			 paramLength=params.length;
		 }
		
 		return paramLength;
	}

	private void setCallCommand(String procedureName, int paramsCount) {
		callCommand = "{ call " + procedureName+"(";

		for (int i = 0; i < paramsCount; i++) {
			callCommand = callCommand + "?";
			if (i != (paramsCount - 1)) {
				callCommand = callCommand + ",";
			}
		}
		callCommand = callCommand + ")}";
	}

	private void setAllStringParam(String[] params) throws SQLException {
		if(params==null){
			return;
		}
		for (int i = 0; i < params.length; i++) {
			this.proc.setString(i+1, params[i]);
		}

	}
}
