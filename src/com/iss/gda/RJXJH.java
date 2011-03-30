package com.iss.gda;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

public class RJXJH extends NonCimData {

	public RJXJH() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void run(){
		String rjxjh =null;
		String queryCondition = queryCondition("oms_rjxjh","CURRENT_TIME");
		try {
			rjxjh = gdaClient.queryDataCondition(token,queryCondition);
			ClientTools.logger.log(Level.INFO, rjxjh);
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
	        	ClientTools.logger.log(Level.INFO, updateSql);
	        	//System.out.println(updateSql);
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
	        	ClientTools.logger.log(Level.INFO, insertSql);
	        	//System.out.println(insertSql);
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
}
