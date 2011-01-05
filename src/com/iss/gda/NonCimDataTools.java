package com.iss.gda;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

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
		 //System.out.println(sql);
		 //FileWriter out = new FileWriter("E:\\iESBtest\\saxonhe9-3-0-1j\\data\\bdqxtest.xml", false);
		// out.write(sql);
		// out.close();
		 
	  
	        statement.execute(sql);  
	        System.out.println("缺陷记录已成功导入!");
	        Transformer transformerForAssetModel1 =
		         tFactory.newTransformer(new StreamSource(ClientTools.config.get("xsjl")));
	       
	        String bdxsjl = gdaClient.queryData(token, "2009/05/25 00:00:00", "pms_bdxsjl");
	        
	        StringWriter stringWriter1 = new StringWriter();
			StringReader stringReader1 = new StringReader(bdxsjl);
			transformerForAssetModel1.transform(new StreamSource(stringReader1),
					 new StreamResult(stringWriter1));
	        
	        String sql1 = new String(stringWriter1.toString());
	        	
	        sql1 = "begin "+sql1+"end;";
	        
	        statement.execute(sql1);
	        System.out.println("修试记录已成功导入!");	
	        
	        /*
	        if(rs.next())
	        System.out.println((rs.getString(10)));
	        System.out.println("OK");
	        rs.close();
	        */
	        
	        statement.close();
	        conn.close();
		   
		
	}

}
