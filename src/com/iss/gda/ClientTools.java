package com.iss.gda;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;



public class ClientTools {
	
	public static Map<String,String> config = new HashMap<String,String>();
	
	

	public static Logger logger;
	public static Map<String, String> getBundleInfoMap(String bundleName) {
	    
	    
        ResourceBundle rb = ResourceBundle.getBundle(bundleName);
        
       
        Map<String, String> map = new HashMap<String, String>();   
           
        Enumeration<String> en = rb.getKeys();   
           
        while(en.hasMoreElements()) {   
            String key = en.nextElement();   
            map.put(key, rb.getString(key));   
        }   
        return map;   
    }   
  
	public static void test()
	{
		try{
		GdaServiceStub gdaClient = new GdaServiceStub("");
		
		String token = gdaClient.getToken("a", "a");
		
		
		System.out.println(token);
		
		//gdaClient.querySubscription(token);
		
		}
		catch(Exception e){
			
			
			e.printStackTrace();
		}
	}
	
	public static void getRequestAsFile(String jmsMessage){
		
		try{
			
            DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			
			String formatDate = format.format(new Date());
			
			FileWriter out = new FileWriter(ClientTools.config.get("temp")+formatDate+".txt", false);
			out.write(jmsMessage);
			out.close();
			
		}
		catch(Exception e){
			
			
			e.printStackTrace();
		}
		
	}
	
	public static String getResourceAsString(String jmsMessage) throws Exception{
		
		GdaServiceStub gdaClient = new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
		
		String token = gdaClient.getToken(ClientTools.config.get("gdaUser"), ClientTools.config.get("gdaPSW"));
		
		String resource = gdaClient.queryAllResource(token, jmsMessage);
		
		return resource;
		
	}
	
	public  static void getResourceAsFile(String jmsMessage){
		
		
		try{
			
			GdaServiceStub gdaClient = new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
			
			String token = gdaClient.getToken(ClientTools.config.get("gdaUser"), ClientTools.config.get("gdaPSW"));
			
			String resource = gdaClient.queryAllResource(token, jmsMessage);
			
            DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			
			String formatDate = format.format(new Date());
			
			FileWriter out = new FileWriter(ClientTools.config.get("temp")+formatDate+".rdf", false);
			out.write(resource);
			out.close();
			
			/*
			String resource = "<?xml version=\"1.0\" encoding=\"GBK\"?><rdf:RDF xmlns:cim=\"http://iec.ch/TC57/2003/CIM-schema-cim10#\" xmlns:rdf=\"http://www.w3.org/2000/01/rdf-schema#\"></rdf:RDF>";
			
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			
			String formatDate = format.format(new Date());
			
			FileWriter out = new FileWriter("D:/temp/"+formatDate+".rdf", false);
			out.write(resource);
			out.close();
			*/
			}
			catch(Exception e){
				
				
				e.printStackTrace();
			}
		
	}

}
