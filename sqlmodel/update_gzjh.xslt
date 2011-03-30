<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<xsl:output method="text" encoding="GBK" indent="yes"/>
    <xsl:template match="/Datas">
         <xsl:for-each select="ITEM">
         	  update pms_gzjh set
         	  OBJ_ID='<xsl:value-of select="OBJ_ID"/>'
         	  <xsl:if test="not(string(GZWCSJ) eq '')">,GZWCSJ=</xsl:if><xsl:if test="not(string(GZWCSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",GZWCSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(JHBGSJ) eq '')">,JHBGSJ=</xsl:if><xsl:if test="not(string(JHBGSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",JHBGSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(JHKGSJ) eq '')">,JHKGSJ=</xsl:if><xsl:if test="not(string(JHKGSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",JHKGSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(JHQXSJ) eq '')">,JHQXSJ=</xsl:if><xsl:if test="not(string(JHQXSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",JHQXSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(JHWGSJ) eq '')">,JHWGSJ=</xsl:if><xsl:if test="not(string(JHWGSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",JHWGSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(PZKGSJ) eq '')">,PZKGSJ=</xsl:if><xsl:if test="not(string(PZKGSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",PZKGSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(PZWGSJ) eq '')">,PZWGSJ=</xsl:if><xsl:if test="not(string(PZWGSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",PZWGSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(SBSJ) eq '')">,SBSJ=</xsl:if><xsl:if test="not(string(SBSJ) eq '')"><xsl:value-of select='concat("to_date(&apos;",SBSJ,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:if test="not(string(SYSTEMDATE) eq '')">,SYSTEMDATE=</xsl:if><xsl:if test="not(string(SYSTEMDATE) eq '')"><xsl:value-of select='concat("to_date(&apos;",SYSTEMDATE,"&apos;,&apos;YYYY-MM-DD HH24:Mi:SS&apos;)")'/></xsl:if>
         	  <xsl:for-each select="*">
         	  	 <xsl:if test="not(string(node()) eq '') and name()!='OBJ_ID' and name()!='GZWCSJ' and name()!='JHBGSJ' and name()!='JHKGSJ' and name()!='JHQXSJ' and name()!='JHWGSJ' and name()!='PZKGSJ' and name()!='PZWGSJ' and name()!='SBSJ' and name()!='SYSTEMDATE'">,<xsl:value-of select="name()"/>='<xsl:value-of select="."/>'
         	   	 </xsl:if>
     	      </xsl:for-each>WHERE OBJ_ID='<xsl:value-of select="OBJ_ID"/>'      	  
         </xsl:for-each> 	
    </xsl:template>	   
</xsl:stylesheet>