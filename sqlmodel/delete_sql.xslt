<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="text" encoding="GBK" indent="yes"/>
	<xsl:template match="/">
       delete from <xsl:value-of select="EQUIP/TABLE_NAME"/> where NO=<xsl:value-of select="EQUIP/NO"/>
    </xsl:template>
</xsl:stylesheet>