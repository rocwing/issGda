<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="text"  encoding="GBK" indent="no"/>
	
	<xsl:template match="/">
	     INSERT INTO <xsl:value-of select="EQUIP/TABLE_NAME"/>(
	         NO<xsl:for-each select="EQUIP/ITEM">,<xsl:value-of select="Property/@name"/></xsl:for-each>
	     )
	     VALUES(<xsl:value-of select="EQUIP/NO"/><xsl:for-each select="EQUIP/ITEM">,<xsl:value-of select="Property"/></xsl:for-each>)
	</xsl:template>
</xsl:stylesheet>