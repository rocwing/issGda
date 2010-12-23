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
      <TYPENAME/>
      <ITEM>
        <Property name='RUNINGCREW'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:PowerSystemResource.runingCrew&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='VOLTGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.voltGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='NAME'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Naming.name&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='DISPATCHNO'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:PowerSystemResource.dispatchNo&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='DISTRICT'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.district&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='PLANTTRANSFERDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.plantTransferDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='ENDDATE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Asset/cim:Asset.endDate&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <CURRENTSTATUS/>
      <ITEM>
        <Property name='WORKINGMODE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.workingMode&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='FIXINGMODE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.fixingMode&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <SINGLESOURCE/>
      <ITEM>
        <Property name='PIVOTSUBSTATION'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.pivotSubstation&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='FILTHGRADE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:PowerSystemResource.filthGrade&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='SUBTYPE'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.subType&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='SUBADDRESS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.subAddress&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='OCCUPYINGAREA'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.occupyingArea&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='BULDINGAREA'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.buldingArea&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <ITEM>
        <Property name='TELENUMBER'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:Substation.teleNumber&quot;/&gt;&apos;
        </Property>
      </ITEM>
      <DESCRIPTION/>
      <ITEM>
        <Property name='REMARKS'>
          &apos;&lt;xsl:value-of
          select=&quot;cim:Substation/cim:PowerSystemResource.remarks&quot;/&gt;&apos;
        </Property>
      </ITEM>
    </EQUIP>
  </xsl:template>
</xsl:stylesheet>