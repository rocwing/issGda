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
        <Property name='CORETYPE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:TransformerModel.coreType&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='TRANSFCOOLINGTYPE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PowerTransformer/cim:PowerTransformer.transfCoolingType&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='LINEGROUP'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:TransformerAsset.lineGroup&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='VOLTRATIO'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:TransformerAsset.voltRatio&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='IDLINGLOSS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerAsset/cim:TransformerAsset.idlingLoss&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <IMPEDANCEH_X/>
      <IMPEDANCEH_Y/>
      <IMPEDANCEX_Y/>
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
      <ITEM>
        <Property name='REMARKS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PowerTransformer/cim:PowerSystemResource.remarks&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='INSULATEMEDIUM'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:ElectricalAssetModel.insulateMedium&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='BIL'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:ElectricalAssetModel.bil&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='WEIGHTTOTAL'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:TransformerModel/cim:AssetModel.weightTotal&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;TYFS&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;AZWZ&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;RZXS&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YZMFFS&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YWRHX&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZLQRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;FZSHZYDY&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;FZSHGYZY&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;FZSHGYDY&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;LQSZ&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YSZ&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SJYXZ&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YQXJG&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YQXQD&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YQXZKCY&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YCD&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SF6QZBT&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SF6QZDLC&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SF6QZYZKG&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SF6QTYLBT&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SF6QTYLDLC&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SF6QTYLYZKG&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SF6CJ&apos;'>
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