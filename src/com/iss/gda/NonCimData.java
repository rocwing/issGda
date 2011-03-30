package com.iss.gda;

import java.io.StringWriter;
import java.util.TimerTask;
import java.util.logging.Level;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMText;

public class NonCimData extends TimerTask{
	
	protected GdaServiceStub gdaClient;
	protected String token;
	
	public NonCimData(){
		try{
		this.gdaClient =  new GdaServiceStub(ClientTools.config.get("ServiceAdd"));
		this.token = gdaClient.getToken("bdpt", "bdptneu");
		}catch(Exception e){
			e.printStackTrace();
			ClientTools.logger.log(Level.WARNING, null, e);
		}
		
		
	}
	public void data(String resource){
		
		System.out.println(resource);
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
		
        cal.add(java.util.Calendar.DAY_OF_MONTH, -1);
		
		columnValue.setText(cal.getTime().toLocaleString());
		//columnValue.setText("2011-1-24 12:32:22");
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


	
	public void run(){
		
	}

}
