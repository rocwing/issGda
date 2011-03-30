<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
  <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes"/>
  <xsl:template match="/rdf:RDF">
    <EQUIP>
      <TABLE_NAME>
      	pms_zdh
      </TABLE_NAME>
      <MAPPING_URI>
        '<xsl:value-of
        select="substring(cim:AutomaticEquipment/cim:PowerSystemResource.Asset/@rdf:resource,12,17)"/>'
      </MAPPING_URI>
      <EQUIPMENT_CONTAINER>
        '<xsl:value-of
        select="substring(cim:AutomaticEquipment/cim:Equipment.MemberOf_EquipmentContainer/@rdf:resource,17,17)"/>'
      </EQUIPMENT_CONTAINER>
      <ITEM>
        <Property name="PSRTYPE">
          '<xsl:value-of
          select="substring(cim:AutomaticEquipment/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ORG_NAME">
          '<xsl:value-of
          select="substring-after(cim:AutomaticEquipment/cim:PowerSystemResource.Organisations/@rdf:resource,'@')"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ALIASNAME">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:Naming.aliasName"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="DISPATCHNO">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:PowerSystemResource.dispatchNo"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="INSTALLATIONPLACE">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.installationPlace"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NAME">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MODEL">
          '<xsl:value-of
          select="cim:ElectricalAssetModel/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="EQUIPMENTTYPE">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.equipmentType"/>'
        </Property>
      </ITEM>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'DDFW'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <ITEM>
        <Property name="PLANTTRANSFERDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.plantTransferDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="FACTORY">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.factory"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MANUFACTUREDDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.manufacturedDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="UTC">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.utc"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="CURRENTSTATUS">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.currentStatus"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MANUFACTUREDCOUNTRY">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.manufacturedCountry"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="INSTALLATIONDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.installationDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="VOLTGRADE">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.voltGrade"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="RATEDVOLTS">
          '<xsl:value-of
          select="cim:ElectricalAssetModel/cim:ElectricalAssetModel.ratedVolts"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="GRADING">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.grading"/>'
        </Property>
      </ITEM>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'ZXDDY'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'SFBF'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <ITEM>
        <Property name="ENDDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.endDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MAINTAINORGANISATION">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.maintainOrganisation"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="GOODSSOURCE">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.goodsSource"/>'
        </Property>
      </ITEM>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'DXZQ'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'XXZQ'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <ITEM>
        <Property name="OVERHAULCYCLE">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.overhaulCycle"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="STATIONTYPE">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.stationType"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PARENTID">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.parentId"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PARENTNAME">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.parentName"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PARSYSTEM">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:AutomaticEquipment.parSystem"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="REMARKS">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:PowerSystemResource.remarks"/>'
        </Property>
      </ITEM>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'CZDYDJ'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <ITEM>
        <Property name="LASTOVERHAULDATE">
          '<xsl:value-of
          select="cim:AutomaticEquipment/cim:PowerSystemResource.lastOverhaulDate"/>'
        </Property>
      </ITEM>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'CZLB'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'SCTDSJ'">
          <ITEM>
            <Property>
              <xsl:attribute name="name">
                <xsl:value-of select="cim:Property.propertyType"/>
              </xsl:attribute>
              '<xsl:value-of
              select="cim:Property.propertyValue"/>'
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
    </EQUIP>
  </xsl:template>
</xsl:stylesheet>