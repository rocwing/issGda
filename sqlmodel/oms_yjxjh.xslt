<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<xsl:output method="text" encoding="GBK" indent="yes"/>
    <xsl:template match="/Datas">
         <xsl:for-each select="ITEM">
         	  insert into oms_yjxjh(
         	  PM_PRIMARYKEY
         	  <xsl:if test="not(string(FSTARTTIME) eq '')">,FSTARTTIME</xsl:if>
         	  <xsl:if test="not(string(FENDTIME) eq '')">,FENDTIME</xsl:if>
         	  <xsl:if test="not(string(FAPPLYTIME) eq '')">,FAPPLYTIME</xsl:if>
         	  <xsl:if test="not(string(UPDATE_TIME) eq '')">,UPDATE_TIME</xsl:if>         	  
         	  <xsl:for-each select="*">
         	  	 <xsl:if test="not(string(node()) eq '') and name()!='PM_PRIMARYKEY' and name()!='FSTARTTIME' and name()!='FENDTIME' and name()!='FAPPLYTIME' and name()!='UPDATE_TIME'">,<xsl:value-of select="name()"/>
         	   	 </xsl:if>
     	      </xsl:for-each>)
     	      values(
     	      '<xsl:value-of select="PM_PRIMARYKEY"/>'
     	      <xsl:if test="not(string(FSTARTTIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",FSTARTTIME,"&apos;,&apos;YYYY-MM-DD&#x0020;HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(FENDTIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",FENDTIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(FAPPLYTIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",FAPPLYTIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(UPDATE_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",UPDATE_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:for-each select="*">
     	          <xsl:if test="not(string(node()) eq '') and name()!='PM_PRIMARYKEY' and name()!='FSTARTTIME' and name()!='FENDTIME' and name()!='FAPPLYTIME' and name()!='UPDATE_TIME'">,'<xsl:value-of select="."/>'</xsl:if>
     	      </xsl:for-each>);         	  
         </xsl:for-each>	
    </xsl:template>	
    
</xsl:stylesheet>