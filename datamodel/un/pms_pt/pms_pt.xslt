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
          select=&quot;cim:PT/cim:Naming.name&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='NAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:Naming.name&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <TYPENAME/>
      <ITEM>
        <Property name='VOLTGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.voltGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='RATEDVOLTS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.ratedVolts&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <MODEL/>
      <ITEM>
        <Property name='NUMBERPHASES'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.numberPhases&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='PHASES'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.phases&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='DISPATCHNO'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PT/cim:PowerSystemResource.dispatchNo&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='MANUFACTUREDCOUNTRY'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.manufacturedCountry&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='FACTORY'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.factory&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='UTC'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.utc&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='CODENAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.codeName&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='MANUFACTUREDDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.manufacturedDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='PLANTTRANSFERDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.plantTransferDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='INSTALLATIONENVIRON'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.installationEnviron&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='ANTIPOLLUTIONGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.antipollutionGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='CURRENTSTATUS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.currentStatus&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='SERIALNUMBER'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PTAsset/cim:Asset.serialNumber&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='REMARKS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PT/cim:PowerSystemResource.remarks&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='IFCOEQUIPMENT'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PT/cim:PowerSystemResource.ifCoEquipment&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='COEQUIPMENTNUMBER'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PT/cim:PowerSystemResource.coEquipmentNumber&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='INSULATEMEDIUM'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.insulateMedium&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='BIL'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.bil&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <SEALALL/>
      <ITEM>
        <Property name='PTTYPE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PT/cim:PT.ptType&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='CONSTRUCTIONTYPE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PT/cim:PT.constructionType&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='PTRATIO'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:PT/cim:PT.ptRatio&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='LEAKAGEDISTANCE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.leakageDistance&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='WEIGHTTOTAL'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.weightTotal&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <xsl:for-each select='cim:Property'>
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ECRZZSL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ECRZSLCL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ECRZSLBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZEDDRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;DRQJS&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SJDRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SJDRQBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SJDRQSXHDX&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZJDRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZJDRQBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZJDRQSXHDX&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJC1DRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJC1DRQBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJC1DRQSXHDX&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJC2DRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJC2DRQBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJC2DRQSXHDX&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;MFJG&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;YCJ&apos;'>
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
    </EQUIP>
  </xsl:template>
</xsl:stylesheet>