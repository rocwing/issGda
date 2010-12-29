<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<xsl:output method="text" encoding="GBK" indent="yes"/>
    <xsl:template match="/Datas">
         <xsl:for-each select="ITEM">
         	  insert into bdxsjl(
         	  JLID
         	  <xsl:if test="not(string(GZRQ) eq '')">,GZRQ</xsl:if>
         	  <xsl:if test="not(string(YSRQ) eq '')">,YSRQ</xsl:if>         	  
         	  <xsl:for-each select="*">
         	  	 <xsl:if test="not(string(node()) eq '') and name()!='JLID' and name()!='GZRQ' and name()!='YSRQ'">,<xsl:value-of select="name()"/>
         	   	 </xsl:if>
     	      </xsl:for-each>)
     	      values(
     	      '<xsl:value-of select="JLID"/>'
     	      <xsl:if test="not(string(GZRQ) eq '')">,<xsl:value-of select='concat("to_date(&apos;",GZRQ,"&apos;,&apos;YYYY-MM-DD&apos;)")'/></xsl:if>
     	      <xsl:if test="not(string(YSRQ) eq '')">,<xsl:value-of select='concat("to_date(&apos;",YSRQ,"&apos;,&apos;YYYY-MM-DD&apos;)")'/></xsl:if>
     	      <xsl:for-each select="*">
     	          <xsl:if test="not(string(node()) eq '') and name()!='JLID' and name()!='GZRQ' and name()!='YSRQ'">,'<xsl:value-of select="."/>'</xsl:if>
     	      </xsl:for-each>);         	  
         </xsl:for-each>	
    </xsl:template>	
    
</xsl:stylesheet>