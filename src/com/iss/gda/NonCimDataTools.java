package com.iss.gda;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMText;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import oracle.jdbc.pool.OracleDataSource;

public class NonCimDataTools extends DataTools{
	
	
	public static void main(String[] args)throws Exception{
		
		ClientTools.config = ClientTools.getBundleInfoMap("info");
		ClientTools.logger = Logger.getLogger("logger");
		
        
        //statement.execute("truncate table pms_bdqxjl");
        //System.out.println("缺陷记录已删除!");
        //statement.execute("truncate table pms_bdxsjl");
        //System.out.println("修试记录已删除!");
        
        GdaServiceStub gdaClient = new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
		
		String token = gdaClient.getToken("bdpt", "bdptneu");
		
		NonCimDataTools nonCimDataTools = new NonCimDataTools();
		// nonCimDataTools.getYJXJHsql(token, gdaClient);
	    //nonCimDataTools.getRJXJHsql(token, gdaClient);
		//nonCimDataTools.getRJXJH(token, gdaClient);
		nonCimDataTools.getYJXJH(token, gdaClient);
		nonCimDataTools.getRJXJH(token, gdaClient);
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
	  
	       // statement.execute(nonCimDataTools.getQXJLsql(token, gdaClient));  
	       // System.out.println("缺陷记录已成功导入!");
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
	        //statement.execute(nonCimDataTools.getXSJLsql(token, gdaClient));
	        //System.out.println("修试记录已成功导入!");	
	        
	        //statement.execute(nonCimDataTools.getYJXJHsql(token, gdaClient));
	        //System.out.println("月计划已成功导入!");	
	        
	        //statement.execute(nonCimDataTools.getRJXJHsql(token, gdaClient));
	        //System.out.println("日计划已成功导入!");	
	        
	        //statement.close();
	        //conn.close();
		   
		
	}
public boolean deleteOperation(String jmsMessage){
		
		try{
        StringReader stringReader = new StringReader(jmsMessage);
	    
	    XMLInputFactory xif = XMLInputFactory.newInstance();
	    
	    XMLStreamReader reader = xif.createXMLStreamReader(stringReader);
	    
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		
		String operation = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("operation"));
		
		
		//String equipmentType = getEquipmentType(jmsMessage);
		
		
		//equipmentType = equipmentType + "ForDelete";
		
		//System.out.println(equipmentType);
		//String tableName = ClientTools.config.get(equipmentType);
		if(operation.equals("d"))
		  {	
			String flag = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("flag"));
			String keywordsValue = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("keywordsvalue"));
			String keywords = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("keywords"));
			
			int i = keywordsValue.indexOf("(");
			int j = keywordsValue.lastIndexOf("=");
			
			keywordsValue = keywordsValue.substring(i+1, j-1);
			
			OracleDataSource ods = new OracleDataSource();
	        ods.setDriverType ( "thin" ); // type of driver
	        ods.setNetworkProtocol("tcp"); // tcp is the default anyway
	        ods.setServerName ( ClientTools.config.get("dataBaseServerName")); // database server name
	        ods.setDatabaseName(ClientTools.config.get("dataBaseSID")); // Oracle SID
	        ods.setPortNumber(1521); // listener port number
	        ods.setUser(ClientTools.config.get("dataBaseUser")); // username
	        ods.setPassword(ClientTools.config.get("dataBasePSW")); // password
	        Connection conn=ods.getConnection();
	        Statement statement=conn.createStatement();
			
	        
	        
	        //int beginIndex = value.indexOf("@")+1;
	        //int endIndex = beginIndex+17;
	        //String no = value.substring(beginIndex, endIndex);
	        ClientTools.logger.log(Level.INFO, flag+operation);
	        //String sql = "delete from " + tableName + " where NO='"+no+"'";
	        String sql = "delete from " + flag + " where "+keywordsValue+"="+"'"+keywords+"'";
	        ClientTools.logger.log(Level.INFO, sql);
	        //System.out.println(sql);
	        statement.execute(sql);
			
	        System.out.println(flag+" "+operation+ " 成功!");
	        	        
	        statement.close();
	        conn.close();
	        
			return true;
			
		  }
		
		}catch(Exception e){
			e.printStackTrace();
			ClientTools.logger.log(Level.WARNING, null, e);
		}
		
		return false;
	}

public void rdfToConsole(String jmsMessage){
	
	
	
	try{
    StringReader stringReader = new StringReader(jmsMessage);
    
    XMLInputFactory xif = XMLInputFactory.newInstance();
    
    XMLStreamReader reader = xif.createXMLStreamReader(stringReader);
    
	StAXOMBuilder builder = new StAXOMBuilder(reader);
	
	String operation = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("operation"));
	String flag = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("flag"));
	
	//String equipmentType = getEquipmentType(jmsMessage);
	
	//System.out.println(equipmentType);
	
	TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
	
	ClientTools.logger.log(Level.INFO, flag);
	 Transformer transformerForAssetModel =
         tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get(flag+"For"+operation))));
	 
	 StringWriter stringWriter = new StringWriter();
	 transformerForAssetModel.transform(new StreamSource(new StringReader(ClientTools.getDataAsString(jmsMessage))),
			 new StreamResult(stringWriter));
	 
	 String sql = new String(stringWriter.toString());
	 
	 
	 
	 
	 //String sql = "select * from breaker where no='02M10000000008772'";
	 //System.out.println(sql);
	 ClientTools.logger.log(Level.INFO, sql);
	 OracleDataSource ods = new OracleDataSource();
        ods.setDriverType ( "thin" ); // type of driver
        ods.setNetworkProtocol("tcp"); // tcp is the default anyway
        ods.setServerName ( ClientTools.config.get("dataBaseServerName")); // database server name
        ods.setDatabaseName(ClientTools.config.get("dataBaseSID")); // Oracle SID
        ods.setPortNumber(1521); // listener port number
        ods.setUser(ClientTools.config.get("dataBaseUser")); // username
        ods.setPassword(ClientTools.config.get("dataBasePSW")); // password
        Connection conn=ods.getConnection();
        Statement statement=conn.createStatement();
       
       
        if(operation=="m"){
        statement.executeUpdate(sql);}
        else{
        	statement.execute(sql);
        }
       
        System.out.println(flag+" "+operation+ " 成功!");
        /*
        if(rs.next())
        System.out.println((rs.getString(10)));
        System.out.println("OK");
        rs.close();
        */
        
        statement.close();
        conn.close();
	}catch(Exception e){
		
		e.printStackTrace();
		ClientTools.logger.log(Level.WARNING, null, e);
	}
	
	
}

public String getQXJLsql(String token,GdaServiceStub gdaClient){
	
	
	String bdqxjl = null;
	try {
		bdqxjl = gdaClient.queryData(token, "2011/03/06 00:00:00", "pms_bdqxjl");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ClientTools.logger.log(Level.WARNING, null, e);
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
		ClientTools.logger.log(Level.WARNING, null, e);
	}
	
	
	 String sql = new String(stringWriter.toString());
	
	 
	 sql = "begin "+sql+"end;";
	
	
	return sql;
}
public String getXSJLsql(String token,GdaServiceStub gdaClient){
	   String bdxsjl = null;
	
	try {
		bdxsjl = gdaClient.queryData(token, "2011/03/06 00:00:00", "pms_bdxsjl");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ClientTools.logger.log(Level.WARNING, null, e);
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
		ClientTools.logger.log(Level.WARNING, null, e);
	}
   
   String sql = new String(stringWriter.toString());
   	
   sql = "begin "+sql+"end;";
	return sql;
}
public void getYJXJH(String token,GdaServiceStub gdaClient){
	//得到月检修计划的数据
	String yjxjh =null;
	String queryCondition = queryCondition("oms_yjxjh","UPDATE_TIME");
	try {
		yjxjh = gdaClient.queryDataCondition(token,queryCondition);
		System.out.println(yjxjh);
		
	
		OracleDataSource ods = new OracleDataSource();
        ods.setDriverType ( "thin" ); // type of driver
        ods.setNetworkProtocol("tcp"); // tcp is the default anyway
        ods.setServerName ( ClientTools.config.get("dataBaseServerName")); // database server name
        ods.setDatabaseName(ClientTools.config.get("dataBaseSID")); // Oracle SID
        ods.setPortNumber(1521); // listener port number
        ods.setUser(ClientTools.config.get("dataBaseUser")); // username
        ods.setPassword(ClientTools.config.get("dataBasePSW")); // password
        Connection conn=ods.getConnection();
        Statement statement=conn.createStatement();
        StringReader stringReader = new StringReader(yjxjh);
      //序列化为xml    
	    XMLInputFactory xif = XMLInputFactory.newInstance();
	    
	    XMLStreamReader reader = xif.createXMLStreamReader(stringReader);
	    
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		
	//遍历操作
		
		Iterator iterator = builder.getDocument().getFirstChildWithName(new QName("Datas")).getChildrenWithName(new QName("ITEM"));
		
		
		
		while(iterator.hasNext()){
			    OMNode node = (OMNode)iterator.next();
				OMElement element = (OMElement)node;				
				
				
				
				
			
			
	//得到主键FMONTHPLANNO
	
		String fMonthPlanNo = element.getFirstChildWithName(new QName("FMONTHPLANNO")).getText();
		
	//查询库中是否有此主键的项
		
        ResultSet rs = statement.executeQuery("select * from oms_yjxjh where FMONTHPLANNO = '"+fMonthPlanNo+"'");
        Iterator ite = element.getChildElements();
        
        ite.next();
        
        if(rs.next())
        {
        	String updateSql = "update oms_yjxjh set FMONTHPLANNO='"+fMonthPlanNo+"'";
        	while(ite.hasNext())
        	{
        	OMNode itemNode = (OMNode)ite.next();
        	if(itemNode.getType()==OMNode.ELEMENT_NODE)
        	{
        	   OMElement itemElement = (OMElement)itemNode;
        	
        	   String itemElementText = itemElement.getText();
        	   String itemElementName = itemElement.getLocalName();
        	   if (!itemElementText.isEmpty())
        	   {
        		   if(itemElementName.equals("FSTARTTIME")||itemElementName.equals("FENDTIME")||itemElementName.equals("FAPPLYTIME")
        				   ||itemElementName.equals("UPDATE_TIME")
        				   )
        		   {
        			   updateSql = updateSql+","+itemElementName+"=to_date('"+itemElementText+"','YYYY-MM-DD HH24:Mi:SS')";
        		   }
        		   else
        		   {
        		        updateSql = updateSql+","+itemElementName+"='"+itemElementText+"'";
        		   }
        	   }
        	}
        	}
        	updateSql = updateSql+ " where FMONTHPLANNO='"+fMonthPlanNo+"'";
        	System.out.println(updateSql);
        	//有的话构造更新语句
        	statement.executeUpdate(updateSql);
        }
	
        else{
        	
        	String insertSql1 = "insert into oms_yjxjh(FMONTHPLANNO";
        	String insertSql2 = "values('"+fMonthPlanNo+"'";
        	while(ite.hasNext())
        	{
        		
        	OMNode itemNode = (OMNode)ite.next();
        	if(itemNode.getType()==OMNode.ELEMENT_NODE)
        	{
        	   OMElement itemElement = (OMElement)itemNode;
        	   String itemElementText = itemElement.getText();
        	   String itemElementName = itemElement.getLocalName();
        	   if (!itemElementText.isEmpty())
        	  {
        		   if(itemElementName.equals("FSTARTTIME")||itemElementName.equals("FENDTIME")||itemElementName.equals("FAPPLYTIME")
        				   ||itemElementName.equals("UPDATE_TIME")
        				   )
        		   {
        			   insertSql1 = insertSql1+","+itemElementName;
               		   insertSql2 = insertSql2+",to_date('"+itemElementText+"','YYYY-MM-DD HH24:Mi:SS')";
        		   }
        		   else{
        			   
        			   insertSql1 = insertSql1+","+itemElementName;
               		   insertSql2 = insertSql2+",'"+itemElementText+"'";
        		   }
        		
        	  }
        	}
        	}
        	insertSql1=insertSql1+")";
        	insertSql2=insertSql2+")";
        	String insertSql = insertSql1+insertSql2;
        	System.out.println(insertSql);
        	//没有的话构造插入语句
        	statement.execute(insertSql);
        }
	
	//执行操作
		
		
		
	}
		statement.close();
        conn.close();
        System.out.println("月计划同步成功！");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ClientTools.logger.log(Level.WARNING, null, e);
	}
}
public void getRJXJH(String token,GdaServiceStub gdaClient){
	
	//得到日检修计划的数据
	String rjxjh =null;
	String queryCondition = queryCondition("oms_rjxjh","CURRENT_TIME");
	try {
		rjxjh = gdaClient.queryDataCondition(token,queryCondition);
		System.out.println(rjxjh);
		/*
	    FileWriter fileWriter = new FileWriter("rjxjh.txt",false);
	 
	    fileWriter.write(rjxjh);
	    fileWriter.close();
	    */
	//序列化为xml
		OracleDataSource ods = new OracleDataSource();
        ods.setDriverType ( "thin" ); // type of driver
        ods.setNetworkProtocol("tcp"); // tcp is the default anyway
        ods.setServerName ( ClientTools.config.get("dataBaseServerName")); // database server name
        ods.setDatabaseName(ClientTools.config.get("dataBaseSID")); // Oracle SID
        ods.setPortNumber(1521); // listener port number
        ods.setUser(ClientTools.config.get("dataBaseUser")); // username
        ods.setPassword(ClientTools.config.get("dataBasePSW")); // password
        Connection conn=ods.getConnection();
        Statement statement=conn.createStatement();
        StringReader stringReader = new StringReader(rjxjh);
	    
	    XMLInputFactory xif = XMLInputFactory.newInstance();
	    
	    XMLStreamReader reader = xif.createXMLStreamReader(stringReader);
	    
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		/*
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
		*/
	//遍历操作
		//Iterator iterator = builder.getDocument().getFirstChildWithName(new QName("Datas")).getChildren();
		Iterator iterator = builder.getDocument().getFirstChildWithName(new QName("Datas")).getChildrenWithName(new QName("ITEM"));
		//OMElement conditionNode  = builder.getDocument().getFirstChildWithName(new QName("Datas")).getFirstChildWithName(new QName("ITEM"));
		
		
		while(iterator.hasNext()){
			    OMNode node = (OMNode)iterator.next();
				OMElement element = (OMElement)node;				
				
				
				
				
			
			
	//得到主键plan_id
	
		String planId = element.getFirstChildWithName(new QName("PLAN_ID")).getText();
		//System.out.println(planId);
	//查询库中是否有此主键的项
		
        ResultSet rs = statement.executeQuery("select * from oms_rjxjh where PLAN_ID = '"+planId+"'");
        Iterator ite = element.getChildElements();
        /*
        ite.next();
        while(ite.hasNext())
        {
        	OMNode on = (OMNode)ite.next();
        	if(on.getType()==OMNode.ELEMENT_NODE)
        	{
        		OMElement ele =(OMElement)on;
        	System.out.println(ele.getLocalName());
        	System.out.println(ele.getText());
        	}
        }
        
        */
        ite.next();
        
        if(rs.next())
        {
        	String updateSql = "update oms_rjxjh set PLAN_ID='"+planId+"'";
        	while(ite.hasNext())
        	{
        	OMNode itemNode = (OMNode)ite.next();
        	if(itemNode.getType()==OMNode.ELEMENT_NODE)
        	{
        	   OMElement itemElement = (OMElement)itemNode;
        	//System.out.println(itemElement.getText());
        	   String itemElementText = itemElement.getText();
        	   String itemElementName = itemElement.getLocalName();
        	   if (!itemElementText.isEmpty())
        	   {
        		   if(itemElementName.equals("APPLY_TIME")||itemElementName.equals("APPLY_START_TIME")||itemElementName.equals("APPLY_END_TIME")
        				   ||itemElementName.equals("CUT_START_TIME")||itemElementName.equals("CUT_END_TIME")||itemElementName.equals("CANCEL_TIME")
        				   ||itemElementName.equals("REPORT_TIME")||itemElementName.equals("CHECK_TIME")||itemElementName.equals("CURRENT_TIME")
        				   ||itemElementName.equals("START_TIME")||itemElementName.equals("END_TIME")
        				   )
        		   {
        			   updateSql = updateSql+","+itemElementName+"=to_date('"+itemElementText+"','YYYY-MM-DD HH24:Mi:SS')";
        		   }
        		   else
        		   {
        		        updateSql = updateSql+","+itemElementName+"='"+itemElementText+"'";
        		   }
        	   }
        	}
        	}
        	updateSql = updateSql+ " where PLAN_ID='"+planId+"'";
        	System.out.println(updateSql);
        	//有的话构造更新语句
        	statement.executeUpdate(updateSql);
        }
	
        else{
        	
        	String insertSql1 = "insert into oms_rjxjh(PLAN_ID";
        	String insertSql2 = "values('"+planId+"'";
        	while(ite.hasNext())
        	{
        		
        	OMNode itemNode = (OMNode)ite.next();
        	if(itemNode.getType()==OMNode.ELEMENT_NODE)
        	{
        	   OMElement itemElement = (OMElement)itemNode;
        	   String itemElementText = itemElement.getText();
        	   String itemElementName = itemElement.getLocalName();
        	   if (!itemElementText.isEmpty())
        	  {
        		   if(itemElementName.equals("APPLY_TIME")||itemElementName.equals("APPLY_START_TIME")||itemElementName.equals("APPLY_END_TIME")
        				   ||itemElementName.equals("CUT_START_TIME")||itemElementName.equals("CUT_END_TIME")||itemElementName.equals("CANCEL_TIME")
        				   ||itemElementName.equals("REPORT_TIME")||itemElementName.equals("CHECK_TIME")||itemElementName.equals("CURRENT_TIME")
        				   ||itemElementName.equals("START_TIME")||itemElementName.equals("END_TIME")
        				   )
        		   {
        			   insertSql1 = insertSql1+","+itemElementName;
               		   insertSql2 = insertSql2+",to_date('"+itemElementText+"','YYYY-MM-DD HH24:Mi:SS')";
        		   }
        		   else{
        			   
        			   insertSql1 = insertSql1+","+itemElementName;
               		   insertSql2 = insertSql2+",'"+itemElementText+"'";
        		   }
        		
        	  }
        	}
        	}
        	insertSql1=insertSql1+")";
        	insertSql2=insertSql2+")";
        	String insertSql = insertSql1+insertSql2;
        	System.out.println(insertSql);
        	//没有的话构造插入语句
        	statement.execute(insertSql);
        }
	
	//执行操作
		
		
		
	}
		statement.close();
        conn.close();
        System.out.println("日计划同步成功！");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ClientTools.logger.log(Level.WARNING, null, e);
	}
}
public String getRJXJHsql(String token,GdaServiceStub gdaClient){
	String rjxjh =null;
	
	String queryCondition = queryCondition("oms_rjxjh","CURRENT_TIME");
	
	try {
		rjxjh = gdaClient.queryDataCondition(token,queryCondition);
		//FileWriter fileWriter = new FileWriter("rjxjh.txt",false);
		//fileWriter.write(rjxjh);
		//fileWriter.close();
		System.out.println(rjxjh);
		return "OK";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ClientTools.logger.log(Level.WARNING, null, e);
	}
	
	StringWriter stringWriter = new StringWriter();
	StringReader stringReader = new StringReader(rjxjh);
    TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
    try{
     Transformer transformerForAssetModel =
      tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get("rjxjh"))));   
     transformerForAssetModel.transform(new StreamSource(stringReader),
		 new StreamResult(stringWriter));
     //new StreamResult(new File("rjxjh1.txt")));
    }catch(Exception e){
	     e.printStackTrace();
	     ClientTools.logger.log(Level.WARNING, null, e);
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
		ClientTools.logger.log(Level.WARNING, null, e);
	}
	//System.out.println(yjxjh);
	StringWriter stringWriter = new StringWriter();
	StringReader stringReader = new StringReader(yjxjh);
    TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
    try{
     Transformer transformerForAssetModel =
      tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get("yjxjh"))));   
     transformerForAssetModel.transform(new StreamSource(stringReader),
		 new StreamResult(stringWriter));
     //new StreamResult(new File("yjxjh.txt")));
    }catch(Exception e){
	     e.printStackTrace();
	     ClientTools.logger.log(Level.WARNING, null, e);
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
		//java.util.Calendar cal = java.util.Calendar.getInstance();
		
		//cal.add(java.util.Calendar.DAY_OF_MONTH, -1);
		
		//columnValue.setText(cal.getTime().toLocaleString());
	  
		columnValue.setText("2011-3-28 12:32:22");
		OMElement compare = factory.createOMElement(new QName("Compare"));
		
		OMText cd = factory.createOMText(">",XMLStreamConstants.CDATA);
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
			ClientTools.logger.log(Level.WARNING, null, e);
		}
	    String queryString = new String(stringWriter.toString());
	    queryString = "<?xml version=\"1.0\" encoding=\"GBK\" ?>"+queryString;
		System.out.println(queryString);
		return queryString;
		
	}

}
