<xsl:stylesheet version='2.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform' xmlns:xs='http://www.w3.org/2001/XMLSchema' xmlns:fn='http://www.w3.org/2005/xpath-functions' xmlns:cim='http://iec.ch/TC57/2003/CIM-schema-cim10#' xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'>
  <xsl:output method='xml' version='1.0' encoding='GBK' indent='yes'/>
  <xsl:template match='/rdf:RDF'>
    <EQUIP>
      <TABLE_NAME/>
      <NO>
        &apos;&lt;xsl:value-of
        select=&quot;substring(cim:BusbarSection/cim:PowerSystemResource.Asset/@rdf:resource,12,17)&quot;/&gt;&apos;
      </NO>
      <SUBSTATIONNO>
        &apos;&lt;xsl:value-of
        select=&quot;substring(cim:Breaker/cim:Equipment.MemberOf_EquipmentContainer/@rdf:resource,17,17)&quot;/&gt;&apos;
      </SUBSTATIONNO>
      <PARENTPSR>
        &apos;&lt;xsl:value-of
        select=&quot;substring(cim:Breaker/cim:PowerSystemResource.ParentPSR/@rdf:resource,24,17)&quot;/&gt;&apos;
      </PARENTPSR>
      <ITEM>
        <Property name='PSRTYPE'>
          &apos;&lt;xsl:value-of
          select=&quot;substring(cim:Breaker/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='ORG'>
          &apos;&lt;xsl:value-of
          select=&quot;substring-after(cim:Asset/cim:Asset.Organisations/@rdf:resource,&apos;@&apos;)&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='NAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PowerTransformer/cim:Naming.name&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='NAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:Naming.name&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <TYPENAME/>
      <ITEM>
        <Property name='VOLTGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.voltGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='RATEDVOLTS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:ElectricalAssetModel.ratedVolts&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='RATEDMVA'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:ElectricalAssetModel.ratedMVA&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='VOLTRATIO'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:TransformerAsset.voltRatio&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <MODEL/>
      <ITEM>
        <Property name='NUMBERPHASES'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:ElectricalAssetModel.numberPhases&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='PHASES'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.phases&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='DISPATCHNO'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PowerTransformer/cim:PowerSystemResource.dispatchNo&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='MANUFACTUREDCOUNTRY'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.manufacturedCountry&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='FACTORY'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.factory&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='UTC'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.utc&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='CODENAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.codeName&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='MANUFACTUREDDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.manufacturedDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='PLANTTRANSFERDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.plantTransferDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ENDDATE/>
      <ITEM>
        <Property name='INSTALLATIONENVIRON'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.installationEnviron&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='ANTIPOLLUTIONGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.antipollutionGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='CURRENTSTATUS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.currentStatus&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='SERIALNUMBER'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.serialNumber&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <INSULATEMEDIUM/>
      <ITEM>
        <Property name='TRANSFCOOLINGTYPE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PowerTransformer/cim:PowerTransformer.transfCoolingType&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <LINEGROUP/>
      <ITEM>
        <Property name='IDLINGLOSS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:TransformerAsset.idlingLoss&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='COPPERLOSS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:TransformerAsset.copperLoss&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='ASSETUSAGE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:Asset.assetUsage&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='REMARKS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PowerTransformer/cim:PowerSystemResource.remarks&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='WEIGHTTOTAL'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:AssetModel.weightTotal&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='BIL'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:ElectricalAssetModel.bil&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <TYFS/>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;KZDL&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YZ&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;QSZ&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;FJCM&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;FJXH&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;WKQCJ&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;WKQXH&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;FZSH&apos;'>
          <ITEM>
            <Property>
              <xsl:attribute name='name'>
                <xsl:value-of select='cim:Property.propertyType'/>
              </xsl:attribute>
              &apos;&lt;xsl:value-of
              select=&quot;cim:Property.propertyValue&quot;/&gt;&apos;
            </Property>
          </ITEM>
        </xsl:if>
      </xsl:for-each>
    </EQUIP>
  </xsl:template>
</xsl:stylesheet>