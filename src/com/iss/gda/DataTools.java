package com.iss.gda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMText;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import oracle.jdbc.pool.OracleDataSource;

import net.sf.saxon.Transform;

public class DataTools {
	
	
/*	
public static void main(String[] args) throws Exception{
		
	
	TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
	
	 Transformer transformer =
         tFactory.newTransformer(new StreamSource(new File("./issGda_xslt/datamodel/pms_main_transformer.xslt")));
	 
	 
	 StringWriter stringWriter = new StringWriter();
	 //StringReader stringReader = new StringReader("<?xml version=\"1.0\" encoding=\"GBK\"?><rdf:RDF xmlns:cim=\"http://iec.ch/TC57/2003/CIM-schema-cim10#\" xmlns:rdf=\"http://www.w3.org/2000/01/rdf-schema#\"><cim:Breaker rdf:ID=\"PMS-Breaker@PMSID#/Breaker\"><cim:ConductingEquipment.heatCurrent>RWDDL#</cim:ConductingEquipment.heatCurrent></cim:Breaker></rdf:RDF>");
	 
	 //transformer.transform(new StreamSource(new File("E:\\iESBtest\\saxonhe9-3-0-1j\\assetmodel\\BDYCSB\\DLQ-0305000B0.xml")),
            //new StreamResult(System.out));
	transformer.transform(new StreamSource(new File("D:/datamodel/ed/pms_main_transformer/20101203161336.rdf")),
		 new StreamResult(stringWriter));
	
	String dataModel = new String(stringWriter.toString());
	
	System.out.println(dataModel);
	Transformer transformer1 =
        tFactory.newTransformer(new StreamSource(new File("./issGda_xslt/sqlmodel/delete_sql.xslt")));
			 //new StreamResult(System.out));
	StringWriter stringWriterForSql = new StringWriter();
	 transformer1.transform(new StreamSource(new StringReader(dataModel)), new StreamResult(stringWriterForSql));
			//new StreamResult(new File("E:\\iESBtest\\saxonhe9-3-0-1j\\data\\20101123091208.xml")));
	 String sql = new String(stringWriterForSql.toString());
	 
	 System.out.println(sql);
	
	 
	 OracleDataSource ods = new OracleDataSource();
     ods.setDriverType ( "thin" ); // type of driver
     ods.setNetworkProtocol("tcp"); // tcp is the default anyway
     ods.setServerName ( "172.20.43.179" ); // database server name
     ods.setDatabaseName("orcl"); // Oracle SID
     ods.setPortNumber(1521); // listener port number
     ods.setUser("xopens"); // username
     ods.setPassword("ytdf000"); // password
     Connection conn=ods.getConnection();
     Statement statement=conn.createStatement();
     
     
     statement.execute(sql);
     
    
     statement.close();
     conn.close();
	 
	}
*/
	
	public static void main(String[] args)throws Exception{
		
		//equipmentTypeTest("D:/temp/20101203161331.txt");
		 OracleDataSource ods = new OracleDataSource();
	        ods.setDriverType ( "thin" ); // type of driver
	        ods.setNetworkProtocol("tcp"); // tcp is the default anyway
	        ods.setServerName ("172.20.43.179"); // database server name
	        ods.setDatabaseName("orcl"); // Oracle SID
	        ods.setPortNumber(1521); // listener port number
	        ods.setUser("xopens"); // username
	        ods.setPassword("ytdf000"); // password
	        Connection conn=ods.getConnection();
	        Statement statement=conn.createStatement();
	        String query = "select count(*) from pms_ct";
	        ResultSet rs = statement.executeQuery(query);
	        while(rs.next()){
	        	System.out.println("COUNT(*)"+rs.getInt("COUNT(*)"));
	        }
		    rs.close();
		    statement.close();
		    conn.close();
		//queryCondition("a","b");
		
	}
public static void queryCondition(String queryFlagValue, String columnNameValue){
		
		try{
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
		XMLStreamWriter writer = xof.createXMLStreamWriter(stringWriter);
	    query.serialize(stringWriter);	   	    
		writer.flush();	    
	    String queryString = new String(stringWriter.toString());
	    queryString = "<?xml version=\"1.0\" encoding=\"GBK\" ?>"+queryString;
		System.out.println(queryString);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


    public static void  equipmentTypeTest(String fileName){
    
        //StringReader stringReader = new StringReader(jmsMessage);
    	try{
    	File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
	    XMLInputFactory xif = XMLInputFactory.newInstance();
	    
	    XMLStreamReader reader = xif.createXMLStreamReader(fis);
	    
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		
		String operation = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("operation"));
		
		
	
		
		Iterator iterator = builder.getDocument().getFirstChildWithName(new QName("message")).getChildElements();		
		int nodeNum = 0;
		
	
		while(iterator.hasNext()){
			iterator.next();
			
			
			nodeNum = nodeNum+1;
		}
		
		
		System.out.println(nodeNum);
		
		String equipmentTypeRow = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("value"));
		
		int equipmentTypeIndex = equipmentTypeRow.indexOf("/")+1;
		
		//System.out.println(equipmentTypeIndex);
		
		String equipmentType = equipmentTypeRow.substring(equipmentTypeIndex);
		
		
		if(equipmentType.equals("PowerTransformer")){
			switch(nodeNum){
			
			case 16:
				equipmentType = "jdb";
				break;
			case 12:
				equipmentType = "syb";
				break;
			default:
				equipmentType = "main_transformer";
				break;
			
			}
			
		}else{
			if(equipmentType.equals("StaticVarCompensator")){
				switch(nodeNum){
				
				case 15:
					equipmentType = "ohdrq";
					break;				
				default:
					equipmentType = "dldrq";
					break;
				
				}	
			}
			else{
				if(equipmentType.equals("ConductingEquipment"))
				{
					switch(nodeNum){
					
					case 4:
						equipmentType = "kgg";
						break;
					case 18:
						equipmentType = "xhzz";
						break;
					case 7:
						equipmentType = "zbq";
						break;
					case 5:
						equipmentType = "zhhgq";
						break;
					default:
					    {
				
					    	Iterator iter = builder.getDocument().getFirstChildWithName(new QName("message")).getChildElements();		
					    	CharSequence property = "Property";
					    	
							List lst = new ArrayList();
						
							while(iter.hasNext()){
								OMElement uri = (OMElement)iter.next();
								
								String value = uri.getAttributeValue(new QName("value"));
							
								if(value.contains(property)){
								lst.add(value.substring(value.lastIndexOf("-")+1, value.indexOf("/")));
								
								}
								
							}
						    if(lst.contains("SH"))
						    {
						    	equipmentType = "fdxq";
						    }
						    else
						    {
						    	equipmentType = "blq";
						    }
						
					    }
						break;
					
					}	
				}
			}
			
		}
    	
    	System.out.println(equipmentType);
    	}
    	catch(Exception e){
    		
    		e.printStackTrace();
    	}
    }
	public void rdfToConsole(String jmsMessage){
		
		
	
		try{
	    StringReader stringReader = new StringReader(jmsMessage);
	    
	    XMLInputFactory xif = XMLInputFactory.newInstance();
	    
	    XMLStreamReader reader = xif.createXMLStreamReader(stringReader);
	    
		StAXOMBuilder builder = new StAXOMBuilder(reader);
		
		String operation = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("operation"));
		
		//System.out.println(operation);
		//String nodeNum = builder.getDocument().getFirstChildWithName(new QName("message"))
		Iterator iterator = builder.getDocument().getFirstChildWithName(new QName("message")).getChildElements();		
		int nodeNum = 0;
		while(iterator.hasNext()){
			iterator.next();
			nodeNum = nodeNum+1;
		}
		String equipmentTypeRow = builder.getDocument().getFirstChildWithName(new QName("message")).getFirstChildWithName(new QName("uri")).getAttributeValue(new QName("value"));
		
		int equipmentTypeIndex = equipmentTypeRow.indexOf("/")+1;
		
		//System.out.println(equipmentTypeIndex);
		
		String equipmentType = equipmentTypeRow.substring(equipmentTypeIndex);
		
		if(equipmentType.equals("PowerTransformer")){
			switch(nodeNum){
			
			case 16:
				equipmentType = "jdb";
				break;
			case 12:
				equipmentType = "syb";
				break;
			default:
				equipmentType = "main_transformer";
				break;
			
			}
			
		}else{
			if(equipmentType.equals("StaticVarCompensator")){
				switch(nodeNum){
				
				case 15:
					equipmentType = "ohdrq";
					break;				
				default:
					equipmentType = "dldrq";
					break;
				
				}	
			}
			else{
				if(equipmentType.equals("ConductingEquipment"))
				{
					switch(nodeNum){
					
					case 4:
						equipmentType = "kgg";
						break;
					case 18:
						equipmentType = "xhzz";
						break;
					case 7:
						equipmentType = "zbq";
						break;
					case 5:
						equipmentType = "zhhgq";
						break;
					default:
					    {
					    	Iterator iter = builder.getDocument().getFirstChildWithName(new QName("message")).getChildElements();		
					    	CharSequence property = "Property";
							List lst = new ArrayList();
						
							while(iter.hasNext()){
								OMElement uri = (OMElement)iter.next();
								
								String value = uri.getAttributeValue(new QName("value"));
								
								if(value.contains(property)){
								lst.add(value.substring(value.lastIndexOf("-")+1, value.indexOf("/")));
								
								}
								
							}
						    if(lst.contains("SH"))
						    {
						    	equipmentType = "fdxq";
						    }
						    else
						    {
						    	equipmentType = "blq";
						    }
						
					    }
						break;
					
					}	
				}
			}
			
		}
		
		//System.out.println(equipmentType);
		
		TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",null);
		
		ClientTools.logger.log(Level.INFO, equipmentType);
		 Transformer transformerForAssetModel =
	         tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get(equipmentType))));
		 
		 StringWriter stringWriter = new StringWriter();
		 transformerForAssetModel.transform(new StreamSource(new StringReader(ClientTools.getResourceAsString(jmsMessage))),
				 new StreamResult(stringWriter));
		 
		 String dataModel = new String(stringWriter.toString());
		 
		 Transformer transformerForDataModel =
	         tFactory.newTransformer(new StreamSource(new File(ClientTools.config.get(operation))));
		 
		 StringWriter stringWriterForSql = new StringWriter();
		 transformerForDataModel.transform(new StreamSource(new StringReader(dataModel)), new StreamResult(stringWriterForSql)) ;
		 
		 String sql = new String(stringWriterForSql.toString());
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
	       
	        System.out.println(equipmentType+" "+operation+ " �ɹ�!");
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
    

}
