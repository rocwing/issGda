<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<xsl:output method="text" encoding="GBK" indent="yes"/>
    <xsl:template match="/Datas">
         <xsl:for-each select="ITEM">
         	  insert into oms_rjxjh(
         	  PLAN_ID
         	  <xsl:if test="not(string(APPLY_TIME) eq '')">,APPLY_TIME</xsl:if>
         	  <xsl:if test="not(string(APPLY_START_TIME) eq '')">,APPLY_START_TIME</xsl:if>
         	  <xsl:if test="not(string(APPLY_END_TIME) eq '')">,APPLY_END_TIME</xsl:if>
         	  <xsl:if test="not(string(CUT_START_TIME) eq '')">,CUT_START_TIME</xsl:if>
         	  <xsl:if test="not(string(CUT_END_TIME) eq '')">,CUT_END_TIME</xsl:if>
         	  <xsl:if test="not(string(CANCEL_TIME) eq '')">,CANCEL_TIME</xsl:if>
         	  <xsl:if test="not(string(REPORT_TIME) eq '')">,REPORT_TIME</xsl:if>
         	  <xsl:if test="not(string(CHECK_TIME) eq '')">,CHECK_TIME</xsl:if>
         	  <xsl:if test="not(string(CURRENT_TIME) eq '')">,CURRENT_TIME</xsl:if>           	  
         	  <xsl:for-each select="*">
         	  	 <xsl:if test="not(string(node()) eq '') and name()!='PLAN_ID' and name()!='APPLY_TIME' and name()!='APPLY_START_TIME' and name()!='APPLY_END_TIME' and name()!='CUT_START_TIME' and name()!='CUT_END_TIME' and name()!='CANCEL_TIME' and name()!='REPORT_TIME' and name()!='CHECK_TIME' and name()!='CURRENT_TIME'">,<xsl:value-of select="name()"/>
         	   	 </xsl:if>
     	      </xsl:for-each>)
     	      values(
     	      '<xsl:value-of select="PLAN_ID"/>'
     	      <xsl:if test="not(string(APPLY_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",APPLY_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(APPLY_START_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",APPLY_START_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(APPLY_END_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",APPLY_END_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(CUT_START_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",CUT_START_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(CUT_END_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",CUT_END_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(CANCEL_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",CANCEL_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(REPORT_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",REPORT_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(CHECK_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",CHECK_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(CURRENT_TIME) eq '')">,<xsl:value-of select='concat("to_date(&apos;",CURRENT_TIME,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
     	      <xsl:for-each select="*">
     	          <xsl:if test="not(string(node()) eq '') and name()!='PLAN_ID' and name()!='APPLY_TIME' and name()!='APPLY_START_TIME' and name()!='APPLY_END_TIME' and name()!='CUT_START_TIME' and name()!='CUT_END_TIME' and name()!='CANCEL_TIME' and name()!='REPORT_TIME' and name()!='CHECK_TIME' and name()!='CURRENT_TIME'">,'<xsl:value-of select="."/>'</xsl:if>
     	      </xsl:for-each>);         	  
         </xsl:for-each>	
    </xsl:template>	
    
</xsl:stylesheet>