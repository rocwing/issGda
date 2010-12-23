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
          select=&quot;cim:StaticVarCompensator/cim:Naming.name&quot;/&gt;&apos;
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
        <Property name='UNITNAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:StaticVarCompensator/cim:PowerSystemResource.unitName&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='VOLTGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.voltGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='RATEDVOLTS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.ratedVolts&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='RATEDAMPS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.ratedAmps&quot;/&gt;&apos;
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
          select=&quot;cim:Asset/cim:Asset.phases&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='DISPATCHNO'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:StaticVarCompensator/cim:PowerSystemResource.dispatchNo&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='MANUFACTUREDCOUNTRY'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.manufacturedCountry&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='FACTORY'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.factory&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='UTC'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.utc&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='CODENAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.codeName&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='MANUFACTUREDDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.manufacturedDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='PLANTTRANSFERDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.plantTransferDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='INSTALLATIONENVIRON'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.installationEnviron&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='ANTIPOLLUTIONGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.antipollutionGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='CURRENTSTATUS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.currentStatus&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='SERIALNUMBER'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.serialNumber&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='REMARKS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:StaticVarCompensator/cim:PowerSystemResource.remarks&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='INSULATEMEDIUM'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.insulateMedium&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='LEAKAGEDISTANCE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:ElectricalAssetModel/cim:ElectricalAssetModel.leakageDistance&quot;/&gt;&apos;
        </Property>
      </ITEM>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SJXH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SJMPDRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;SJCCBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZJXH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZJMPDRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;ZJCCBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJXH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJMPDRL&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;XJCCBH&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;AZJS&apos;'>
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
        <xsl:if test='string(cim:Property.propertyType) eq &apos;GD&apos;'>
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