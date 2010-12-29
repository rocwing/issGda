<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
  <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes"/>
  <xsl:template match="/rdf:RDF">
    <EQUIP>
      <TABLE_NAME>
         pms_ohdrq
      </TABLE_NAME>
      <NO>
        '<xsl:value-of
        select="substring(cim:StaticVarCompensator/cim:PowerSystemResource.Asset/@rdf:resource,12,17)"/>'
      </NO>
      <ITEM>
        <Property name="SUBSTATIONNO">
        '<xsl:for-each select='cim:Breaker/cim:Equipment.MemberOf_EquipmentContainer'>
        <xsl:if test='substring(@rdf:resource,6,3)=&apos;Sub&apos;'>
          <xsl:value-of select='substring(@rdf:resource,17,17)'/>
        </xsl:if>
      </xsl:for-each>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PARENTPSR">
        '<xsl:value-of
        select="substring(cim:StaticVarCompensator/cim:PowerSystemResource.ParentPSR/@rdf:resource,24,17)"/>'
      </Property>
      </ITEM>
      <ITEM>
        <Property name="PSRTYPE">
          '<xsl:value-of
          select="substring(cim:StaticVarCompensator/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ORG">
          '<xsl:value-of
          select="substring-after(cim:Asset/cim:Asset.Organisations/@rdf:resource,'@')"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NAME">
          '<xsl:value-of
          select="cim:StaticVarCompensator/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MODEL">
          '<xsl:value-of
          select="cim:ElectricalAssetModel/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="UNITNAME">
          '<xsl:value-of
          select="cim:StaticVarCompensator/cim:PowerSystemResource.unitName"/>'
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
        <Property name="RATEDAMPS">
          '<xsl:value-of
          select="cim:ElectricalAssetModel/cim:ElectricalAssetModel.ratedAmps"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NUMBERPHASES">
          '<xsl:value-of
          select="cim:ElectricalAssetModel/cim:ElectricalAssetModel.numberPhases"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PHASES">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.phases"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="DISPATCHNO">
          '<xsl:value-of
          select="cim:StaticVarCompensator/cim:PowerSystemResource.dispatchNo"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MANUFACTUREDCOUNTRY">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.manufacturedCountry"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="FACTORY">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.factory"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="UTC">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.utc"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="CODENAME">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.codeName"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MANUFACTUREDDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.manufacturedDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PLANTTRANSFERDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:Asset/cim:Asset.plantTransferDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="INSTALLATIONENVIRON">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.installationEnviron"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ANTIPOLLUTIONGRADE">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.antipollutionGrade"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="CURRENTSTATUS">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.currentStatus"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="SERIALNUMBER">
          '<xsl:value-of
          select="cim:Asset/cim:Asset.serialNumber"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="REMARKS">
          '<xsl:value-of
          select="cim:StaticVarCompensator/cim:PowerSystemResource.remarks"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="INSULATEMEDIUM">
          '<xsl:value-of
          select="cim:ElectricalAssetModel/cim:ElectricalAssetModel.insulateMedium"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="LEAKAGEDISTANCE">
          '<xsl:value-of
          select="cim:ElectricalAssetModel/cim:ElectricalAssetModel.leakageDistance"/>'
        </Property>
      </ITEM>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'ZEDDRL'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'SJXH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'SJMPDRL'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'SJCCBH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'ZJXH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'ZJMPDRL'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'ZJCCBH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'XJXH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'XJMPDRL'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'XJCCBH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'AZJS'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'GD'">
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