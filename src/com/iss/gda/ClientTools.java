package com.iss.gda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.BufferedInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;



public class ClientTools {
	
	public static Map<String,String> config = new HashMap<String,String>();
	
	

	public static Logger logger;
	public static Map<String, String> getBundleInfoMap(String bundleName) throws Exception{
	    
	    //String path = "D:\\iESBtest\\axis2-1.5.2\\bin\\src\\config"+"\\"+bundleName+".properties";
        ResourceBundle rb = ResourceBundle.getBundle(bundleName);
        
	    //InputStream in = new BufferedInputStream(new FileInputStream(path));
	    
	   
	    //ResourceBundle rb = new PropertyResourceBundle(in);
	    	
	    
        Map<String, String> map = new HashMap<String, String>();   
           
        Enumeration<String> en = rb.getKeys();   
           
        while(en.hasMoreElements()) {   
            String key = en.nextElement();   
            map.put(key, rb.getString(key));   
        }   
        return map;   
    }   
	
	public static void writeProperties(String filePath, Map<String, String> map) {  
        Properties prop = new Properties();  
        InputStream fis = null;  
        OutputStream fos = null;  
        try {  
            fis = new FileInputStream(filePath);  
            prop.load(fis);  
            fos = new FileOutputStream(filePath);  
              
            Set set = map.entrySet();  
            Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);  
              
            for (int i = 0; i < entries.length; i++) {  
                String key = (String)entries[i].getKey();  
                String value = (String)entries[i].getValue();  
                prop.setProperty(key, value);  
                prop.store(fos, "Update '" + value + "' value");  
            }  
            fos.flush();  
        } catch (IOException e) {  
            System.err.println("error occurred");  
        } finally {  
            try {  
                fos.close();  
                fis.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
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
	public static String getDataAsString(String jmsMessage) throws Exception{
		GdaServiceStub gdaClient = new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
		String token = gdaClient.getToken(ClientTools.config.get("gdaUser"), ClientTools.config.get("gdaPSW"));
        StringReader stringReader = new StringReader(jmsMessage);
	    
	    XMLInputFactory xif = XMLInputFactory.newInstance();
	    
	    XMLStreamReader reader = xif.createXMLStreamReader(stringReader);
	    
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		String flag = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("flag"));
		String keywordsValue = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("keywordsvalue"));
		String datas = gdaClient.queryDataByMessage(token, keywordsValue, flag);
		return datas;
	}
	public static String getResourceAsString(String jmsMessage) throws Exception{
		
		GdaServiceStub gdaClient = new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
		
		String token = gdaClient.getToken(ClientTools.config.get("gdaUser"), ClientTools.config.get("gdaPSW"));
		
		String resource = gdaClient.queryAllResource(token, jmsMessage);
		
		return resource;
		
	}
	public static void getDataAsFile(String jmsMessage){
		
		try{
		GdaServiceStub gdaClient = new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
		
		String token = gdaClient.getToken(ClientTools.config.get("gdaUser"), ClientTools.config.get("gdaPSW"));
		
        StringReader stringReader = new StringReader(jmsMessage);
	    
	    XMLInputFactory xif = XMLInputFactory.newInstance();
	    
	    XMLStreamReader reader = xif.createXMLStreamReader(stringReader);
	    
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		
		String keywordsValue = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("keywordsvalue"));
		String flag =  builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("flag"));
		
		String datas = gdaClient.queryDataByMessage(token, keywordsValue, flag);
		
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String formatDate = format.format(new Date());
		
		FileWriter out = new FileWriter(ClientTools.config.get("temp")+formatDate+".xml", false);
		out.write(datas);
		out.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
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
