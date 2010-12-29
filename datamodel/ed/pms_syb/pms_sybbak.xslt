<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:cim="http://iec.ch/TC57/2003/CIM-schema-cim10#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
  <xsl:output method="xml" version="1.0" encoding="GBK" indent="yes"/>
  <xsl:template match="/rdf:RDF">
    <EQUIP>
      <TABLE_NAME>
         pms_syb
      </TABLE_NAME>
      <NO>
        '<xsl:value-of
        select="substring(cim:PowerTransformer/@rdf:ID,22,17)"/>'
      </NO>
      <SUBSTATIONNO>
        <xsl:for-each select='cim:Breaker/cim:Equipment.MemberOf_EquipmentContainer'>
        <xsl:if test='substring(@rdf:resource,6,3)=&apos;Sub&apos;'>
          '<xsl:value-of select='substring(@rdf:resource,17,17)'/>'
        </xsl:if>
      </xsl:for-each>
      </SUBSTATIONNO>
      <PARENTPSR>
        '<xsl:value-of
        select="substring(cim:PowerTransformer/cim:PowerSystemResource.ParentPSR/@rdf:resource,24,17)"/>'
      </PARENTPSR>
      <ITEM>
        <Property name="PSRTYPE">
          '<xsl:value-of
          select="substring(cim:PowerTransformer/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ORG">
          '<xsl:value-of
          select="substring-after(cim:TransformerAsset/cim:Asset.Organisations/@rdf:resource,'@')"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NAME">
          '<xsl:value-of
          select="cim:PowerTransformer/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MODEL">
          '<xsl:value-of
          select="cim:TransformerModel/cim:Naming.name"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="VOLTGRADE">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.voltGrade"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="RATEDVOLTS">
          '<xsl:value-of
          select="cim:TransformerModel/cim:ElectricalAssetModel.ratedVolts"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="RATEDMVA">
          '<xsl:value-of
          select="cim:TransformerModel/cim:ElectricalAssetModel.ratedMVA"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="VOLTRATIO">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:TransformerAsset.voltRatio"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="NUMBERPHASES">
          '<xsl:value-of
          select="cim:TransformerModel/cim:ElectricalAssetModel.numberPhases"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PHASES">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.phases"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="DISPATCHNO">
          '<xsl:value-of
          select="cim:PowerTransformer/cim:PowerSystemResource.dispatchNo"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MANUFACTUREDCOUNTRY">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.manufacturedCountry"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="FACTORY">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.factory"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="UTC">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.utc"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="CODENAME">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.codeName"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="MANUFACTUREDDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:TransformerAsset/cim:Asset.manufacturedDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="PLANTTRANSFERDATE">
          <xsl:value-of
          select='concat("to_date(&apos;",cim:TransformerAsset/cim:Asset.plantTransferDate,"&apos;,&apos;YYYY-MM-DD HH24:MI:SS&apos;)")'/>
        </Property>
      </ITEM>
      <ITEM>
        <Property name="INSTALLATIONENVIRON">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.installationEnviron"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ANTIPOLLUTIONGRADE">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.antipollutionGrade"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="CURRENTSTATUS">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.currentStatus"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="SERIALNUMBER">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.serialNumber"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="TRANSFCOOLINGTYPE">
          '<xsl:value-of
          select="cim:PowerTransformer/cim:PowerTransformer.transfCoolingType"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="IDLINGLOSS">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:TransformerAsset.idlingLoss"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="COPPERLOSS">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:TransformerAsset.copperLoss"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="ASSETUSAGE">
          '<xsl:value-of
          select="cim:TransformerAsset/cim:Asset.assetUsage"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="REMARKS">
          '<xsl:value-of
          select="cim:PowerTransformer/cim:PowerSystemResource.remarks"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="WEIGHTTOTAL">
          '<xsl:value-of
          select="cim:TransformerModel/cim:AssetModel.weightTotal"/>'
        </Property>
      </ITEM>
      <ITEM>
        <Property name="BIL">
          '<xsl:value-of
          select="cim:TransformerModel/cim:ElectricalAssetModel.bil"/>'
        </Property>
      </ITEM>
      <xsl:for-each select="cim:Property">
        <xsl:if test="string(cim:Property.propertyType) eq 'KZDL'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'YZ'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'QSZ'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'FJCM'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'FJXH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'WKQCJ'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'WKQXH'">
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
        <xsl:if test="string(cim:Property.propertyType) eq 'FZSH'">
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