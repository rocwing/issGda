package com.iss.gda;

import java.util.logging.Level;

public class JXJL extends NonCimData {

	private String jxjl;
	public JXJL(){
		super();
		this.jxjl="";
	}
	public void run(){
		
		try{
			 jxjl = gdaClient.queryData(token, "2011/03/21 00:00:00", "pms_bdqxjl");
			}catch(Exception e){
				
				e.printStackTrace();
				ClientTools.logger.log(Level.WARNING, null, e);
			}
	        
			 data(jxjl);
	}
	
   

}
