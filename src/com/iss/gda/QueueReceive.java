package com.iss.gda;


import java.io.IOException;
import java.util.Hashtable;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;





public class QueueReceive implements MessageListener{
	
	static {
		LogManager logManager = LogManager.getLogManager();
		try {
			logManager.readConfiguration(QueueReceive.class.getResourceAsStream("logging.properties"));
			
		 
		} catch (IOException ex) {
			Logger.getLogger(QueueReceive.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (SecurityException ex) {
			Logger.getLogger(QueueReceive.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		
		

	}	
	
	
	// Defines the JNDI context factory.

	public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";

	// Defines the JNDI provider url.

	public final static String PROVIDER_URL="t3://10.157.43.138:7091";

	// Defines the JMS connection factory for the queue.

	public final static String JMS_FACTORY="BJConnectionFactory";

	// Defines the queue.

	public final static String QUEUE="pms-bdpt-queue";

	private QueueConnectionFactory qconFactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueReceiver qreceiver;
	private Queue queue;
	private boolean quit = false;

	/**
	* Message listener interface.
	* @param msg message
	*/
	public void onMessage(Message msg)
	{
	try {
	String msgText;
	if (msg instanceof TextMessage) {
	msgText = ((TextMessage)msg).getText();
	} else {
	msgText = msg.toString();
	}

	//System.out.println("Message Received: "+ msgText );
	//ClientTools clientTools = new ClientTools();
	
	//ClientTools.getRequestAsFile(msgText);
	DataTools dataTools = new DataTools();
	if(!dataTools.deleteOperation(msgText))
	{
	   //ClientTools.getResourceAsFile(msgText);	
	   dataTools.rdfToConsole(msgText);
	}
	//System.out.println("OK");
	

	if (msgText.equalsIgnoreCase("quit")) {
	synchronized(this) {
	quit = true;
	this.notifyAll(); // Notify main thread to quit

	}
	}
	} catch (JMSException jmse) {
	jmse.printStackTrace();
	}
	}

	/**
	* Creates all the necessary objects for receiving
	* messages from a JMS queue.
	*
	* @param ctx JNDI initial context
	* @param queueName name of queue
	* @exception NamingException if operation cannot be performed
	* @exception JMSException if JMS fails to initialize due to internal error
	*/
	public void init(Context ctx, String queueName)
	throws NamingException, JMSException
	{
	qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY);
	qcon = qconFactory.createQueueConnection();
	qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	queue = (Queue) ctx.lookup(queueName);
	qreceiver = qsession.createReceiver(queue);
	qreceiver.setMessageListener(this);
	qcon.start();
	}

	/**
	* Closes JMS objects.
	* @exception JMSException if JMS fails to close objects due to internal error
	*/
	public void close()throws JMSException
	{
	qreceiver.close();
	qsession.close();
	qcon.close();
	}
	/**
	* main() method.
	*
	* @param args WebLogic Server URL
	* @exception Exception if execution fails
	*/

	public static void main(String[] args) throws Exception {

	InitialContext ic = getInitialContext();
	QueueReceive qr = new QueueReceive();
	qr.init(ic, QUEUE);
	
	
	
	ClientTools.config = ClientTools.getBundleInfoMap("info");
	
	ClientTools.logger = Logger.getLogger("logger");
	

	System.out.println("JMS Ready To Receive Messages (To quit, send a \"quit\" message).");

	// Wait until a "quit" message has been received.

	synchronized(qr) {
	while (! qr.quit) {
	try {
	qr.wait();
	} catch (InterruptedException ie) {}
	}
	}
	qr.close();
	}

	private static InitialContext getInitialContext()
	throws NamingException
	{
	Hashtable env = new Hashtable();
	env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
	env.put(Context.PROVIDER_URL, PROVIDER_URL);
	return new InitialContext(env);
	}

	 





	

}
