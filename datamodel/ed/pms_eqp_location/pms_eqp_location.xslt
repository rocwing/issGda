<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
  <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes"/>
  <xsl:template match="/rdf:RDF">
    <EQUIP>
      <TABLE_NAME>
         pms_eqp_location
      </TABLE_NAME>
      <NO>
        '<xsl:value-of
        select="substring(cim:EquipmentLocation/cim:PowerSystemResource.Asset/@rdf:resource,12,17)"/>'
      </NO>
      <SUBSTATION>
        '<xsl:value-of
        select="substring(cim:EquipmentLocation/cim:Equipment.MemberOf_EquipmentContainer/@rdf:resource,17,17)"/>'
      </SUBSTATION>
      <BAY>
        '<xsl:value-of
        select="substring(cim:EquipmentLocation/cim:PowerSystemResource.ParentPSR/@rdf:resource,10,17)"/>'
      </BAY>
      <ITEM>
        <Property name="PSRTYPE">
          '<xsl:value-of
          select="substring(cim:EquipmentLocation/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NAME">
          '<xsl:value-of
          select="cim:EquipmentLocation/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="CHILDTYPE">
          '<xsl:value-of
          select="cim:EquipmentLocation/cim:EquipmentLocation.ChildType"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="DISPATCHNO">
          '<xsl:value-of
          select="cim:EquipmentLocation/cim:PowerSystemResource.dispatchNo"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="VOLTGRADE">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.voltGrade"/>'
        </Property>
      </ITEM>
    </EQUIP>
  </xsl:template>
</xsl:stylesheet>