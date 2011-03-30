package com.iss.gda;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;







public class ClientForGda {
	
	
	
	public static void main(String[] args) throws Exception{
		
        java.util.Calendar cal = java.util.Calendar.getInstance();
		
        java.util.Date  rDate = new java.util.Date(111,2,29,24,15,0);
        java.util.Date  yDate = new java.util.Date(111,2,30,5,0,0);
        
        System.out.println(yDate.toLocaleString());
        
		//cal.add(java.util.Calendar.DAY_OF_MONTH, -1);
		
		//System.out.println(cal.getTime().toLocaleString());
		
		ClientTools.config = ClientTools.getBundleInfoMap("info");
		ClientTools.logger = Logger.getLogger("logger");
		ClientTools.logger.log(Level.INFO, "OK");
		//Timer timer = new Timer();
		//System.out.println("定时任务已启动");
		//timer.schedule(new YJXJH(), 1000, 500000);
		//timer.schedule(new RJXJH(), rDate, 864000000);
		//timer.schedule(new YJXJH(), yDate, 864000000);
		/*
		String text = "(JLID = '3FDE3EFC-B0AC-4692-B0B5-072E9194D96A-05158')";
		int i = text.indexOf("(");
		int j = text.lastIndexOf("=");
		System.out.println(text.substring(i+1,j).length());
		System.out.println(text.substring(i+1, j-1).length());
		String text1 = "b";
		String text2 = "a";
		String text3 = "d";
		
		if(text1=="a"||text2=="b"||text3=="d")
		{
			System.out.println("OK");
		}
		*/
		
		//timer.schedule(new MyTask1(), 2000, 2000);
		
		//ClientTools clientTools = new ClientTools();
		
		//clientTools.test();
		
		//clientTools.xsltTransformer = clientTools.getBundleInfoMap("info");
		
		//System.out.println(clientTools.xsltTransformer.get("Breaker"));
		//ClientTools.config = ClientTools.getBundleInfoMap("info");
		//DataTools dataTools = new DataTools();
		
		//String jmsMessage = "<?xml version=\"1.0\" encoding=\"GBK\"?><message><uri operation=\"d\" value=\"PMS-Property@02M10000002254189-JYLX/CT\"/></message>";
		
		//dataTools.rdfToConsole(jmsMessage);
		
		//dataTools.deleteOperation(jmsMessage);
		
		
		/*
		ConsumerTool consumerTool = new ConsumerTool();
		
		consumerTool.setUrl("tcp://localhost:61616");
		
		consumerTool.setSubject("jmsTest");
		consumerTool.setQueue(true);
		
		consumerTool.run();
		*/
	
		
	}	 
		

}
