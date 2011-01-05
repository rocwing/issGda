package com.iss.gda;







public class ClientForGda {
	
	
	
	public static void main(String[] args) {
		
		
		//ClientTools clientTools = new ClientTools();
		
		//clientTools.test();
		
		//clientTools.xsltTransformer = clientTools.getBundleInfoMap("info");
		
		//System.out.println(clientTools.xsltTransformer.get("Breaker"));
		
		DataTools dataTools = new DataTools();
		
		String jmsMessage = "<?xml version=\"1.0\" encoding=\"GBK\"?><message><uri operation=\"a\" value=\"PMS-Property@02M10000002254189-JYLX/CT\"/></message>";
		
		dataTools.rdfToConsole(jmsMessage);
		
		
		
		
		/*
		ConsumerTool consumerTool = new ConsumerTool();
		
		consumerTool.setUrl("tcp://localhost:61616");
		
		consumerTool.setSubject("jmsTest");
		consumerTool.setQueue(true);
		
		consumerTool.run();
		*/
	
		
	}	 
		

}
