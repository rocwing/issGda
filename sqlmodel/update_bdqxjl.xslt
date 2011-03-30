<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<xsl:output method="text" encoding="GBK" indent="yes"/>
    <xsl:template match="/Datas">
         <xsl:for-each select="ITEM">
         	  update pms_bdqxjl set
         	  JLID='<xsl:value-of select="JLID"/>'
         	  <xsl:if test="not(string(FXRQ) eq '')">,FXRQ=</xsl:if><xsl:if test="not(string(FXRQ) eq '')"><xsl:value-of select='concat("to_date(&apos;",FXRQ,"&apos;,&apos;YYYY-MM-DD&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(SBSJ) eq '')">,SBSJ=</xsl:if><xsl:if test="not(string(SBSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",SBSJ,"&apos;,&apos;YYYY-MM-DD&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(XQRQ) eq '')">,XQRQ=</xsl:if><xsl:if test="not(string(XQRQ) eq '')"><xsl:value-of select='concat("to_date(&apos;",XQRQ,"&apos;,&apos;YYYY-MM-DD&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(JHXQRQ) eq '')">,JHXQRQ=</xsl:if><xsl:if test="not(string(JHXQRQ) eq '')"><xsl:value-of select='concat("to_date(&apos;",JHXQRQ,"&apos;,&apos;YYYY-MM-DD&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(SYSTEMDATE) eq '')">,SYSTEMDATE=</xsl:if><xsl:if test="not(string(SYSTEMDATE) eq '')"><xsl:value-of select='concat("to_date(&apos;",SYSTEMDATE,"&apos;,&apos;YYYY-MM-DD&apos;)")'/></xsl:if>
         	  <xsl:for-each select="*">
         	  	 <xsl:if test="not(string(node()) eq '') and name()!='JLID' and name()!='FXRQ' and name()!='SBSJ' and name()!='XQRQ' and name()!='JHXQRQ' and name()!='SYSTEMDATE'">,<xsl:value-of select="name()"/>='<xsl:value-of select="."/>'
         	   	 </xsl:if>
     	      </xsl:for-each>WHERE JLID='<xsl:value-of select="JLID"/>'     	  
         </xsl:for-each> 	
    </xsl:template>	   
</xsl:stylesheet>