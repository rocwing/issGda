

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
                    * @param queryData78
                
         */

         
                     public java.lang.String queryData(

                        java.lang.String token79,java.lang.String date80,java.lang.String flag81)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryData78
            
          */
        public void startqueryData(

            java.lang.String token79,java.lang.String date80,java.lang.String flag81,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryResourceEX84
                
         */

         
                     public java.lang.String queryResourceEX(

                        java.lang.String token85,java.lang.String uri86,java.lang.String props87,java.lang.String associations88)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryResourceEX84
            
          */
        public void startqueryResourceEX(

            java.lang.String token85,java.lang.String uri86,java.lang.String props87,java.lang.String associations88,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateResourceAppointQueue91
                
         */

         
                     public java.lang.String updateResourceAppointQueue(

                        java.lang.String token92,java.lang.String xmlResource93,java.lang.String queueNames94)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateResourceAppointQueue91
            
          */
        public void startupdateResourceAppointQueue(

            java.lang.String token92,java.lang.String xmlResource93,java.lang.String queueNames94,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertData97
                
         */

         
                     public java.lang.String insertData(

                        java.lang.String token98,java.lang.String xmlData99,java.lang.String flag100)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertData97
            
          */
        public void startinsertData(

            java.lang.String token98,java.lang.String xmlData99,java.lang.String flag100,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryResource103
                
         */

         
                     public java.lang.String queryResource(

                        java.lang.String token104,java.lang.String uris105,java.lang.String props106,java.lang.String associations107)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryResource103
            
          */
        public void startqueryResource(

            java.lang.String token104,java.lang.String uris105,java.lang.String props106,java.lang.String associations107,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param querySubscription110
                
         */

         
                     public java.lang.String querySubscription(

                        java.lang.String token111)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param querySubscription110
            
          */
        public void startquerySubscription(

            java.lang.String token111,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteData114
                
         */

         
                     public java.lang.String deleteData(

                        java.lang.String token115,java.lang.String xmlData116,java.lang.String flag117)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteData114
            
          */
        public void startdeleteData(

            java.lang.String token115,java.lang.String xmlData116,java.lang.String flag117,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param querySJZFData120
                
         */

         
                     public java.lang.String querySJZFData(

                        java.lang.String token121,java.lang.String orga122,java.lang.String date123,java.lang.String time124,java.lang.String flag125)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param querySJZFData120
            
          */
        public void startquerySJZFData(

            java.lang.String token121,java.lang.String orga122,java.lang.String date123,java.lang.String time124,java.lang.String flag125,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param subscribe128
                
         */

         
                     public java.lang.String subscribe(

                        java.lang.String token129,java.lang.String xml130)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param subscribe128
            
          */
        public void startsubscribe(

            java.lang.String token129,java.lang.String xml130,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateResourceExceptionQueue133
                
         */

         
                     public java.lang.String updateResourceExceptionQueue(

                        java.lang.String token134,java.lang.String xmlResource135,java.lang.String exceptionQueues136)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateResourceExceptionQueue133
            
          */
        public void startupdateResourceExceptionQueue(

            java.lang.String token134,java.lang.String xmlResource135,java.lang.String exceptionQueues136,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryDataByMessage139
                
         */

         
                     public java.lang.String queryDataByMessage(

                        java.lang.String token140,java.lang.String keywords141,java.lang.String flag142)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryDataByMessage139
            
          */
        public void startqueryDataByMessage(

            java.lang.String token140,java.lang.String keywords141,java.lang.String flag142,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryDataCondition145
                
         */

         
                     public java.lang.String queryDataCondition(

                        java.lang.String token146,java.lang.String condition147)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryDataCondition145
            
          */
        public void startqueryDataCondition(

            java.lang.String token146,java.lang.String condition147,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param appendResourceAppointQueue150
                
         */

         
                     public java.lang.String appendResourceAppointQueue(

                        java.lang.String token151,java.lang.String xmlResource152,java.lang.String queueNames153)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param appendResourceAppointQueue150
            
          */
        public void startappendResourceAppointQueue(

            java.lang.String token151,java.lang.String xmlResource152,java.lang.String queueNames153,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResource156
                
         */

         
                     public java.lang.String deleteResource(

                        java.lang.String token157,java.lang.String uris158)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResource156
            
          */
        public void startdeleteResource(

            java.lang.String token157,java.lang.String uris158,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertUriMapping161
                
         */

         
                     public void insertUriMapping(

                        java.lang.String token162,java.lang.String dcuri163,java.lang.String uri164)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertUriMapping161
            
          */
        public void startinsertUriMapping(

            java.lang.String token162,java.lang.String dcuri163,java.lang.String uri164,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryAllResource166
                
         */

         
                     public java.lang.String queryAllResource(

                        java.lang.String token167,java.lang.String message168)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryAllResource166
            
          */
        public void startqueryAllResource(

            java.lang.String token167,java.lang.String message168,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryMISCode171
                
         */

         
                     public java.lang.String queryMISCode(

                        java.lang.String yxCode172)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryMISCode171
            
          */
        public void startqueryMISCode(

            java.lang.String yxCode172,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResourceAppointQueue175
                
         */

         
                     public java.lang.String deleteResourceAppointQueue(

                        java.lang.String token176,java.lang.String uris177,java.lang.String queueNames178)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResourceAppointQueue175
            
          */
        public void startdeleteResourceAppointQueue(

            java.lang.String token176,java.lang.String uris177,java.lang.String queueNames178,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResourceForDistributed181
                
         */

         
                     public java.lang.String deleteResourceForDistributed(

                        java.lang.String token182,java.lang.String uris183,java.lang.String apanage184)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResourceForDistributed181
            
          */
        public void startdeleteResourceForDistributed(

            java.lang.String token182,java.lang.String uris183,java.lang.String apanage184,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param appendResource187
                
         */

         
                     public java.lang.String appendResource(

                        java.lang.String token188,java.lang.String xmlResource189)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param appendResource187
            
          */
        public void startappendResource(

            java.lang.String token188,java.lang.String xmlResource189,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteSubscription192
                
         */

         
                     public java.lang.String deleteSubscription(

                        java.lang.String token193,java.lang.String classNames194)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteSubscription192
            
          */
        public void startdeleteSubscription(

            java.lang.String token193,java.lang.String classNames194,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteResourceExceptionQueue197
                
         */

         
                     public java.lang.String deleteResourceExceptionQueue(

                        java.lang.String token198,java.lang.String uris199,java.lang.String exceptionQueues200)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteResourceExceptionQueue197
            
          */
        public void startdeleteResourceExceptionQueue(

            java.lang.String token198,java.lang.String uris199,java.lang.String exceptionQueues200,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryCSData203
                
         */

         
                     public java.lang.String queryCSData(

                        java.lang.String token204,java.lang.String orga205,java.lang.String startDate206,java.lang.String endDate207,java.lang.String flag208)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryCSData203
            
          */
        public void startqueryCSData(

            java.lang.String token204,java.lang.String orga205,java.lang.String startDate206,java.lang.String endDate207,java.lang.String flag208,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param appendResourceExceptionQueue211
                
         */

         
                     public java.lang.String appendResourceExceptionQueue(

                        java.lang.String token212,java.lang.String xmlResource213,java.lang.String exceptionQueues214)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param appendResourceExceptionQueue211
            
          */
        public void startappendResourceExceptionQueue(

            java.lang.String token212,java.lang.String xmlResource213,java.lang.String exceptionQueues214,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateResource217
                
         */

         
                     public java.lang.String updateResource(

                        java.lang.String token218,java.lang.String xmlResource219)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateResource217
            
          */
        public void startupdateResource(

            java.lang.String token218,java.lang.String xmlResource219,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param insertMessage222
                
         */

         
                     public java.lang.String insertMessage(

                        java.lang.String token223,java.lang.String queueName224,java.lang.String xmlString225)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param insertMessage222
            
          */
        public void startinsertMessage(

            java.lang.String token223,java.lang.String queueName224,java.lang.String xmlString225,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getToken228
                
         */

         
                     public java.lang.String getToken(

                        java.lang.String userId229,java.lang.String password230)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getToken228
            
          */
        public void startgetToken(

            java.lang.String userId229,java.lang.String password230,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryDataByKey233
                
         */

         
                     public java.lang.String queryDataByKey(

                        java.lang.String token234,java.lang.String keyWordsValue235,java.lang.String flag236)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryDataByKey233
            
          */
        public void startqueryDataByKey(

            java.lang.String token234,java.lang.String keyWordsValue235,java.lang.String flag236,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateData239
                
         */

         
                     public java.lang.String updateData(

                        java.lang.String token240,java.lang.String xmlData241,java.lang.String flag242)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateData239
            
          */
        public void startupdateData(

            java.lang.String token240,java.lang.String xmlData241,java.lang.String flag242,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param queryResourceByKey245
                
         */

         
                     public java.lang.String queryResourceByKey(

                        java.lang.String token246,java.lang.String pmsUri247)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param queryResourceByKey245
            
          */
        public void startqueryResourceByKey(

            java.lang.String token246,java.lang.String pmsUri247,

            final com.iss.gda.GdaServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    