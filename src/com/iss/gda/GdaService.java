

/**
 * GdaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.iss.gda;

    /*
     *  GdaService java interface
     */

    public interface GdaService {
          

        /**
          * Auto generated method signature
          * 
                    * @param queryData76
                
         */

         
                     public java.lang.String queryData(

                        java.lang.String token77,java.lang.String date78,java.lang.String flag79)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryData76
            
          */
        public void startqueryData(

            java.lang.String token77,java.lang.String date78,java.lang.String flag79,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryResourceEX82
                
         */

         
                     public java.lang.String queryResourceEX(

                        java.lang.String token83,java.lang.String uri84,java.lang.String props85,java.lang.String associations86)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryResourceEX82
            
          */
        public void startqueryResourceEX(

            java.lang.String token83,java.lang.String uri84,java.lang.String props85,java.lang.String associations86,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateResourceAppointQueue89
                
         */

         
                     public java.lang.String updateResourceAppointQueue(

                        java.lang.String token90,java.lang.String xmlResource91,java.lang.String queueNames92)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateResourceAppointQueue89
            
          */
        public void startupdateResourceAppointQueue(

            java.lang.String token90,java.lang.String xmlResource91,java.lang.String queueNames92,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertData95
                
         */

         
                     public java.lang.String insertData(

                        java.lang.String token96,java.lang.String xmlData97,java.lang.String flag98)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertData95
            
          */
        public void startinsertData(

            java.lang.String token96,java.lang.String xmlData97,java.lang.String flag98,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryResource101
                
         */

         
                     public java.lang.String queryResource(

                        java.lang.String token102,java.lang.String uris103,java.lang.String props104,java.lang.String associations105)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryResource101
            
          */
        public void startqueryResource(

            java.lang.String token102,java.lang.String uris103,java.lang.String props104,java.lang.String associations105,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param querySubscription108
                
         */

         
                     public java.lang.String querySubscription(

                        java.lang.String token109)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param querySubscription108
            
          */
        public void startquerySubscription(

            java.lang.String token109,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteData112
                
         */

         
                     public java.lang.String deleteData(

                        java.lang.String token113,java.lang.String xmlData114,java.lang.String flag115)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteData112
            
          */
        public void startdeleteData(

            java.lang.String token113,java.lang.String xmlData114,java.lang.String flag115,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param querySJZFData118
                
         */

         
                     public java.lang.String querySJZFData(

                        java.lang.String token119,java.lang.String org120,java.lang.String date121,java.lang.String time122,java.lang.String flag123)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param querySJZFData118
            
          */
        public void startquerySJZFData(

            java.lang.String token119,java.lang.String org120,java.lang.String date121,java.lang.String time122,java.lang.String flag123,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param subscribe126
                
         */

         
                     public java.lang.String subscribe(

                        java.lang.String token127,java.lang.String xml128)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param subscribe126
            
          */
        public void startsubscribe(

            java.lang.String token127,java.lang.String xml128,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateResourceExceptionQueue131
                
         */

         
                     public java.lang.String updateResourceExceptionQueue(

                        java.lang.String token132,java.lang.String xmlResource133,java.lang.String exceptionQueues134)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateResourceExceptionQueue131
            
          */
        public void startupdateResourceExceptionQueue(

            java.lang.String token132,java.lang.String xmlResource133,java.lang.String exceptionQueues134,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param appendResourceAppointQueue137
                
         */

         
                     public java.lang.String appendResourceAppointQueue(

                        java.lang.String token138,java.lang.String xmlResource139,java.lang.String queueNames140)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param appendResourceAppointQueue137
            
          */
        public void startappendResourceAppointQueue(

            java.lang.String token138,java.lang.String xmlResource139,java.lang.String queueNames140,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResource143
                
         */

         
                     public java.lang.String deleteResource(

                        java.lang.String token144,java.lang.String uris145)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResource143
            
          */
        public void startdeleteResource(

            java.lang.String token144,java.lang.String uris145,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryDataByMessage148
                
         */

         
                     public java.lang.String queryDataByMessage(

                        java.lang.String token149,java.lang.String keywords150,java.lang.String flag151)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryDataByMessage148
            
          */
        public void startqueryDataByMessage(

            java.lang.String token149,java.lang.String keywords150,java.lang.String flag151,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertUriMapping154
                
         */

         
                     public void insertUriMapping(

                        java.lang.String token155,java.lang.String dcuri156,java.lang.String uri157)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertUriMapping154
            
          */
        public void startinsertUriMapping(

            java.lang.String token155,java.lang.String dcuri156,java.lang.String uri157,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryAllResource159
                
         */

         
                     public java.lang.String queryAllResource(

                        java.lang.String token160,java.lang.String message161)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryAllResource159
            
          */
        public void startqueryAllResource(

            java.lang.String token160,java.lang.String message161,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryMISCode164
                
         */

         
                     public java.lang.String queryMISCode(

                        java.lang.String yxCode165)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryMISCode164
            
          */
        public void startqueryMISCode(

            java.lang.String yxCode165,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResourceAppointQueue168
                
         */

         
                     public java.lang.String deleteResourceAppointQueue(

                        java.lang.String token169,java.lang.String uris170,java.lang.String queueNames171)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResourceAppointQueue168
            
          */
        public void startdeleteResourceAppointQueue(

            java.lang.String token169,java.lang.String uris170,java.lang.String queueNames171,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResourceForDistributed174
                
         */

         
                     public java.lang.String deleteResourceForDistributed(

                        java.lang.String token175,java.lang.String uris176,java.lang.String apanage177)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResourceForDistributed174
            
          */
        public void startdeleteResourceForDistributed(

            java.lang.String token175,java.lang.String uris176,java.lang.String apanage177,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param appendResource180
                
         */

         
                     public java.lang.String appendResource(

                        java.lang.String token181,java.lang.String xmlResource182)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param appendResource180
            
          */
        public void startappendResource(

            java.lang.String token181,java.lang.String xmlResource182,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteSubscription185
                
         */

         
                     public java.lang.String deleteSubscription(

                        java.lang.String token186,java.lang.String classNames187)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteSubscription185
            
          */
        public void startdeleteSubscription(

            java.lang.String token186,java.lang.String classNames187,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResourceExceptionQueue190
                
         */

         
                     public java.lang.String deleteResourceExceptionQueue(

                        java.lang.String token191,java.lang.String uris192,java.lang.String exceptionQueues193)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResourceExceptionQueue190
            
          */
        public void startdeleteResourceExceptionQueue(

            java.lang.String token191,java.lang.String uris192,java.lang.String exceptionQueues193,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryCSData196
                
         */

         
                     public java.lang.String queryCSData(

                        java.lang.String token197,java.lang.String org198,java.lang.String startDate199,java.lang.String endDate200,java.lang.String flag201)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryCSData196
            
          */
        public void startqueryCSData(

            java.lang.String token197,java.lang.String org198,java.lang.String startDate199,java.lang.String endDate200,java.lang.String flag201,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param appendResourceExceptionQueue204
                
         */

         
                     public java.lang.String appendResourceExceptionQueue(

                        java.lang.String token205,java.lang.String xmlResource206,java.lang.String exceptionQueues207)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param appendResourceExceptionQueue204
            
          */
        public void startappendResourceExceptionQueue(

            java.lang.String token205,java.lang.String xmlResource206,java.lang.String exceptionQueues207,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateResource210
                
         */

         
                     public java.lang.String updateResource(

                        java.lang.String token211,java.lang.String xmlResource212)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateResource210
            
          */
        public void startupdateResource(

            java.lang.String token211,java.lang.String xmlResource212,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertMessage215
                
         */

         
                     public java.lang.String insertMessage(

                        java.lang.String token216,java.lang.String queueName217,java.lang.String xmlString218)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertMessage215
            
          */
        public void startinsertMessage(

            java.lang.String token216,java.lang.String queueName217,java.lang.String xmlString218,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getToken221
                
         */

         
                     public java.lang.String getToken(

                        java.lang.String userId222,java.lang.String password223)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getToken221
            
          */
        public void startgetToken(

            java.lang.String userId222,java.lang.String password223,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryDataByKey226
                
         */

         
                     public java.lang.String queryDataByKey(

                        java.lang.String token227,java.lang.String keyWordsValue228,java.lang.String flag229)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryDataByKey226
            
          */
        public void startqueryDataByKey(

            java.lang.String token227,java.lang.String keyWordsValue228,java.lang.String flag229,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateData232
                
         */

         
                     public java.lang.String updateData(

                        java.lang.String token233,java.lang.String xmlData234,java.lang.String flag235)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateData232
            
          */
        public void startupdateData(

            java.lang.String token233,java.lang.String xmlData234,java.lang.String flag235,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryResourceByKey238
                
         */

         
                     public java.lang.String queryResourceByKey(

                        java.lang.String token239,java.lang.String pmsUri240)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryResourceByKey238
            
          */
        public void startqueryResourceByKey(

            java.lang.String token239,java.lang.String pmsUri240,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    