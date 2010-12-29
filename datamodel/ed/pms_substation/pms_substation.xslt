<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
  <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes"/>
  <xsl:template match="/rdf:RDF">
    <EQUIP>
      <TABLE_NAME>
         pms_substation
      </TABLE_NAME>
      <NO>
        '<xsl:value-of
        select="substring(cim:Substation/cim:PowerSystemResource.Asset/@rdf:resource,12,17)"/>'
      </NO>
      <ITEM>
        <Property name="PSRTYPE">
          '<xsl:value-of
          select="substring(cim:Substation/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ORG">
          '<xsl:value-of
          select="substring-after(cim:Asset/cim:Asset.Organisations/@rdf:resource,'@')"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="RUNINGCREW">
          '<xsl:value-of
          select="cim:Substation/cim:PowerSystemResource.runingCrew"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="VOLTGRADE">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.voltGrade"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NAME">
          '<xsl:value-of
          select="cim:Substation/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="DISPATCHNO">
          '<xsl:value-of
          select="cim:Substation/cim:PowerSystemResource.dispatchNo"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="DISTRICT">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.district"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PLANTTRANSFERDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.plantTransferDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ENDDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.endDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="WORKINGMODE">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.workingMode"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="FIXINGMODE">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.fixingMode"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PIVOTSUBSTATION">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.pivotSubstation"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="FILTHGRADE">
          '<xsl:value-of
          select="cim:Substation/cim:PowerSystemResource.filthGrade"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="SUBTYPE">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.subType"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="SUBADDRESS">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.subAddress"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="OCCUPYINGAREA">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.occupyingArea"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="BULDINGAREA">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.buldingArea"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="TELENUMBER">
          '<xsl:value-of
          select="cim:Substation/cim:Substation.teleNumber"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="REMARKS">
          '<xsl:value-of
          select="cim:Substation/cim:PowerSystemResource.remarks"/>'
        </Property>
      </ITEM>
    </EQUIP>
  </xsl:template>
</xsl:stylesheet>