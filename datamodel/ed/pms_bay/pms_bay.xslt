<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
  <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes"/>
  <xsl:template match="/rdf:RDF">
    <EQUIP>
      <TABLE_NAME>
         pms_bay
      </TABLE_NAME>
      <NO>
        '<xsl:value-of
        select="substring(cim:Bay/cim:PowerSystemResource.Asset/@rdf:resource,12,17)"/>'
      </NO>
      <ITEM>
        <Property name="SUBSTATION">     
        '<xsl:for-each select='cim:Bay/cim:Equipment.MemberOf_EquipmentContainer'>
        <xsl:if test='substring(@rdf:resource,6,3)=&apos;Sub&apos;'>
          <xsl:value-of select='substring(@rdf:resource,17,17)'/>
        </xsl:if>
      </xsl:for-each>'     
      </Property>
      </ITEM>
      <ITEM>
        <Property name="PSRTYPE">
          '<xsl:value-of
          select="substring(cim:Bay/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="BAYTYPE">
          '<xsl:value-of
          select="cim:Bay/cim:Bay.bayType"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NAME">
          '<xsl:value-of
          select="cim:Bay/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="DISPATCHNO">
          '<xsl:value-of
          select="cim:Bay/cim:PowerSystemResource.dispatchNo"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="VOLTGRADE">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.voltGrade"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PLANTTRANSFERDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.plantTransferDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
    </EQUIP>
  </xsl:template>
</xsl:stylesheet>