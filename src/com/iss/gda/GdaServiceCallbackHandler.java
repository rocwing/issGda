
/**
 * GdaServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.iss.gda;

    /**
     *  GdaServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GdaServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GdaServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GdaServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for queryData method
            * override this method for handling normal response from queryData operation
            */
           public void receiveResultqueryData(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryData operation
           */
            public void receiveErrorqueryData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryResourceEX method
            * override this method for handling normal response from queryResourceEX operation
            */
           public void receiveResultqueryResourceEX(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryResourceEX operation
           */
            public void receiveErrorqueryResourceEX(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateResourceAppointQueue method
            * override this method for handling normal response from updateResourceAppointQueue operation
            */
           public void receiveResultupdateResourceAppointQueue(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateResourceAppointQueue operation
           */
            public void receiveErrorupdateResourceAppointQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertData method
            * override this method for handling normal response from insertData operation
            */
           public void receiveResultinsertData(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertData operation
           */
            public void receiveErrorinsertData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryResource method
            * override this method for handling normal response from queryResource operation
            */
           public void receiveResultqueryResource(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryResource operation
           */
            public void receiveErrorqueryResource(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for querySubscription method
            * override this method for handling normal response from querySubscription operation
            */
           public void receiveResultquerySubscription(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from querySubscription operation
           */
            public void receiveErrorquerySubscription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteData method
            * override this method for handling normal response from deleteData operation
            */
           public void receiveResultdeleteData(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteData operation
           */
            public void receiveErrordeleteData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for querySJZFData method
            * override this method for handling normal response from querySJZFData operation
            */
           public void receiveResultquerySJZFData(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from querySJZFData operation
           */
            public void receiveErrorquerySJZFData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for subscribe method
            * override this method for handling normal response from subscribe operation
            */
           public void receiveResultsubscribe(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from subscribe operation
           */
            public void receiveErrorsubscribe(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateResourceExceptionQueue method
            * override this method for handling normal response from updateResourceExceptionQueue operation
            */
           public void receiveResultupdateResourceExceptionQueue(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateResourceExceptionQueue operation
           */
            public void receiveErrorupdateResourceExceptionQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryDataByMessage method
            * override this method for handling normal response from queryDataByMessage operation
            */
           public void receiveResultqueryDataByMessage(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryDataByMessage operation
           */
            public void receiveErrorqueryDataByMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryDataCondition method
            * override this method for handling normal response from queryDataCondition operation
            */
           public void receiveResultqueryDataCondition(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryDataCondition operation
           */
            public void receiveErrorqueryDataCondition(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for appendResourceAppointQueue method
            * override this method for handling normal response from appendResourceAppointQueue operation
            */
           public void receiveResultappendResourceAppointQueue(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from appendResourceAppointQueue operation
           */
            public void receiveErrorappendResourceAppointQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteResource method
            * override this method for handling normal response from deleteResource operation
            */
           public void receiveResultdeleteResource(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteResource operation
           */
            public void receiveErrordeleteResource(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertUriMapping method
            * override this method for handling normal response from insertUriMapping operation
            */
           public void receiveResultinsertUriMapping(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertUriMapping operation
           */
            public void receiveErrorinsertUriMapping(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAllResource method
            * override this method for handling normal response from queryAllResource operation
            */
           public void receiveResultqueryAllResource(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAllResource operation
           */
            public void receiveErrorqueryAllResource(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryMISCode method
            * override this method for handling normal response from queryMISCode operation
            */
           public void receiveResultqueryMISCode(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryMISCode operation
           */
            public void receiveErrorqueryMISCode(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteResourceAppointQueue method
            * override this method for handling normal response from deleteResourceAppointQueue operation
            */
           public void receiveResultdeleteResourceAppointQueue(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteResourceAppointQueue operation
           */
            public void receiveErrordeleteResourceAppointQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteResourceForDistributed method
            * override this method for handling normal response from deleteResourceForDistributed operation
            */
           public void receiveResultdeleteResourceForDistributed(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteResourceForDistributed operation
           */
            public void receiveErrordeleteResourceForDistributed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for appendResource method
            * override this method for handling normal response from appendResource operation
            */
           public void receiveResultappendResource(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from appendResource operation
           */
            public void receiveErrorappendResource(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteSubscription method
            * override this method for handling normal response from deleteSubscription operation
            */
           public void receiveResultdeleteSubscription(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteSubscription operation
           */
            public void receiveErrordeleteSubscription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteResourceExceptionQueue method
            * override this method for handling normal response from deleteResourceExceptionQueue operation
            */
           public void receiveResultdeleteResourceExceptionQueue(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteResourceExceptionQueue operation
           */
            public void receiveErrordeleteResourceExceptionQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryCSData method
            * override this method for handling normal response from queryCSData operation
            */
           public void receiveResultqueryCSData(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryCSData operation
           */
            public void receiveErrorqueryCSData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for appendResourceExceptionQueue method
            * override this method for handling normal response from appendResourceExceptionQueue operation
            */
           public void receiveResultappendResourceExceptionQueue(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from appendResourceExceptionQueue operation
           */
            public void receiveErrorappendResourceExceptionQueue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateResource method
            * override this method for handling normal response from updateResource operation
            */
           public void receiveResultupdateResource(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateResource operation
           */
            public void receiveErrorupdateResource(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertMessage method
            * override this method for handling normal response from insertMessage operation
            */
           public void receiveResultinsertMessage(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertMessage operation
           */
            public void receiveErrorinsertMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getToken method
            * override this method for handling normal response from getToken operation
            */
           public void receiveResultgetToken(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getToken operation
           */
            public void receiveErrorgetToken(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryDataByKey method
            * override this method for handling normal response from queryDataByKey operation
            */
           public void receiveResultqueryDataByKey(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryDataByKey operation
           */
            public void receiveErrorqueryDataByKey(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateData method
            * override this method for handling normal response from updateData operation
            */
           public void receiveResultupdateData(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateData operation
           */
            public void receiveErrorupdateData(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryResourceByKey method
            * override this method for handling normal response from queryResourceByKey operation
            */
           public void receiveResultqueryResourceByKey(
                    java.lang.String result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryResourceByKey operation
           */
            public void receiveErrorqueryResourceByKey(java.lang.Exception e) {
            }
                


    }
    