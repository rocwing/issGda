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

public class YJXJH extends NonCimData {

	public YJXJH() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void run(){
		String yjxjh =null;
		String queryCondition = queryCondition("oms_yjxjh","UPDATE_TIME");
		try {
			yjxjh = gdaClient.queryDataCondition(token,queryCondition);
			ClientTools.logger.log(Level.INFO, yjxjh);
			
		
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
	        	ClientTools.logger.log(Level.INFO, updateSql);
	        	//System.out.println(updateSql);
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
	        	ClientTools.logger.log(Level.INFO, insertSql);
	        	//System.out.println(insertSql);
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
}
