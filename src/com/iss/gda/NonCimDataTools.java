package com.iss.gda;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Statement;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMText;

import oracle.jdbc.pool.OracleDataSource;

public class NonCimDataTools {
	
	
	public static void main(String[] args)throws Exception{
		
		ClientTools.config = ClientTools.getBundleInfoMap("info");
		OracleDataSource ods = new OracleDataSource();
        ods.setDriverType ( "thin" ); // type of driver
        ods.setNetworkProtocol("tcp"); // tcp is the default anyway
        ods.setServerName ( ClientTools.config.get("dataBaseServerName") ); // database server name
        ods.setDatabaseName(ClientTools.config.get("dataBaseSID")); // Oracle SID
        ods.setPortNumber(1521); // listener port number
        ods.setUser(ClientTools.config.get("dataBaseUser")); // username
        ods.setPassword(ClientTools.config.get("dataBasePSW")); // password
        Connection conn=ods.getConnection();
        Statement statement=conn.createStatement();
        
        statement.execute("truncate table bdqxjl");
        System.out.println("缺陷记录已删除!");
        statement.execute("truncate table bdxsjl");
        System.out.println("修试记录已删除!");
        
        GdaServiceStub gdaClient = new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
		
		String token = gdaClient.getToken("bdpt", "bdptneu");
		
		NonCimDataTools nonCimDataTools = new NonCimDataTools();
		/*
		String bdqxjl = gdaClient.queryData(token, "2009/05/25 00:00:00", "pms_bdqxjl");
		StringWriter stringWriter = new StringWriter();
		StringReader stringReader = new StringReader(bdqxjl);
		
		
		
		TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
		 Transformer transformerForAssetModel =
	         tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get("qxjl"))));
		
		 transformerForAssetModel.transform(new StreamSource(stringReader),
				 new StreamResult(stringWriter));
		
		 String sql = new String(stringWriter.toString());
		 sql = "begin "+sql+"end;";
	    */
	  
	        statement.execute(nonCimDataTools.getQXJLsql(token, gdaClient));  
	        System.out.println("缺陷记录已成功导入!");
	        /*
	        Transformer transformerForAssetModel1 =
		         tFactory.newTransformer(new StreamSource(ClientTools.config.get("xsjl")));
	       
	        String bdxsjl = gdaClient.queryData(token, "2009/05/25 00:00:00", "pms_bdxsjl");
	        
	        StringWriter stringWriter1 = new StringWriter();
			StringReader stringReader1 = new StringReader(bdxsjl);
			transformerForAssetModel1.transform(new StreamSource(stringReader1),
					 new StreamResult(stringWriter1));
	        
	        String sql1 = new String(stringWriter1.toString());
	        	
	        sql1 = "begin "+sql1+"end;";
	        */
	        statement.execute(nonCimDataTools.getXSJLsql(token, gdaClient));
	        System.out.println("修试记录已成功导入!");	
	        
	      
	        
	        statement.close();
	        conn.close();
		   
		
	}

public String getQXJLsql(String token,GdaServiceStub gdaClient){
	
	
	String bdqxjl = null;
	try {
		bdqxjl = gdaClient.queryData(token, "2009/05/25 00:00:00", "pms_bdqxjl");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	StringWriter stringWriter = new StringWriter();
	StringReader stringReader = new StringReader(bdqxjl);
	
	
	
	TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
	
	try {
		Transformer	transformerForAssetModel = 
			tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get("qxjl"))));
		 transformerForAssetModel.transform(new StreamSource(stringReader),
				 new StreamResult(stringWriter));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	 String sql = new String(stringWriter.toString());
	
	 
	 sql = "begin "+sql+"end;";
	
	
	return sql;
}
public String getXSJLsql(String token,GdaServiceStub gdaClient){
	   String bdxsjl = null;
	
	try {
		bdxsjl = gdaClient.queryData(token, "2009/05/25 00:00:00", "pms_bdxsjl");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 StringWriter stringWriter = new StringWriter();
		StringReader stringReader = new StringReader(bdxsjl);
	TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
	try{
	Transformer transformerForAssetModel =
        tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get("xsjl"))));   
	transformerForAssetModel.transform(new StreamSource(stringReader),
			 new StreamResult(stringWriter));
	}catch(Exception e){
		e.printStackTrace();
	}
   
   String sql = new String(stringWriter.toString());
   	
   sql = "begin "+sql+"end;";
	return sql;
}
public String getRJXJHsql(String token,GdaServiceStub gdaClient){
	String rjxjh =null;
	
	String queryCondition = queryCondition("oms_rjxjh","CURRENT_TIME");
	
	try {
		rjxjh = gdaClient.queryDataCondition(token,queryCondition);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	StringWriter stringWriter = new StringWriter();
	StringReader stringReader = new StringReader(rjxjh);
    TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
    try{
     Transformer transformerForAssetModel =
      tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get("rjxjh"))));   
     transformerForAssetModel.transform(new StreamSource(stringReader),
		 new StreamResult(stringWriter));
    }catch(Exception e){
	     e.printStackTrace();
    }

    String sql = new String(stringWriter.toString());
	
    sql = "begin "+sql+"end;";
    return sql;
}
public String getYJXJHsql(String token,GdaServiceStub gdaClient){
	String yjxjh = null;
	
	String queryCondition = queryCondition("oms_yjxjh","UPDATE_TIME");
	
	try {
		yjxjh = gdaClient.queryDataCondition(token,queryCondition);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	StringWriter stringWriter = new StringWriter();
	StringReader stringReader = new StringReader(yjxjh);
    TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
    try{
     Transformer transformerForAssetModel =
      tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get("yjxjh"))));   
     transformerForAssetModel.transform(new StreamSource(stringReader),
		 new StreamResult(stringWriter));
    }catch(Exception e){
	     e.printStackTrace();
    }

    String sql = new String(stringWriter.toString());
	
    sql = "begin "+sql+"end;";
    return sql;
}
public String queryCondition(String queryFlagValue, String columnNameValue){
		
	
		OMFactory factory = OMAbstractFactory.getOMFactory();
		
		OMElement query = factory.createOMElement(new QName("Query"));
		OMElement queryHead = factory.createOMElement(new QName("QueryHead"));
		
		OMElement queryFlag = factory.createOMElement(new QName("QueryFlag"));
		queryFlag.setText(queryFlagValue);
		queryHead.addChild(queryFlag);
		query.addChild(queryHead);
		OMElement queryConditions = factory.createOMElement(new QName("QueryConditions"));
		query.addChild(queryConditions);
		OMElement queryCondition = factory.createOMElement(new QName("QueryCondition"));
		queryConditions.addChild(queryCondition);
		OMElement columnName = factory.createOMElement(new QName("ColumnName"));
		columnName.setText(columnNameValue);
		OMElement columnValue = factory.createOMElement(new QName("ColumnValue"));
		java.util.Calendar cal = java.util.Calendar.getInstance();
		columnValue.setText(cal.getTime().toLocaleString());
	
		
		OMElement compare = factory.createOMElement(new QName("Compare"));
		
		OMText cd = factory.createOMText("<",XMLStreamConstants.CDATA);
		compare.addChild(cd);
		queryCondition.addChild(columnName);
		queryCondition.addChild(columnValue);
		queryCondition.addChild(compare);
		
		XMLOutputFactory xof = XMLOutputFactory.newInstance();
		StringWriter stringWriter = new StringWriter();
		try{
		XMLStreamWriter writer = xof.createXMLStreamWriter(stringWriter);
	    query.serialize(stringWriter);	   	    
		writer.flush();
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
	    String queryString = new String(stringWriter.toString());
	    queryString = "<?xml version=\"1.0\" encoding=\"GBK\" ?>"+queryString;
		System.out.println(queryString);
		return queryString;
		
	}

}
