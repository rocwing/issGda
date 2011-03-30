require 'rexml/document'
include REXML
require 'win32ole'
excel = WIN32OLE::new('excel.Application')
workbook = excel.Workbooks.Open('F:\wpy\Dropbox\github\issGda\datamodel\pms_zdh.xls')
worksheet = workbook.Worksheets(1)
worksheet.Select
file1 = File.new("pms_zdh.xslt","w+")

#doc1 = Document.new "<v_breaker/>"
doc1 = Document.new
root_node = doc1.add_element "xsl:stylesheet", {"version"=>"2.0","xmlns:xsl"=>"http://www.w3.org/1999/XSL/Transform",
"xmlns:xs"=>"http://www.w3.org/2001/XMLSchema","xmlns:fn"=>"http://www.w3.org/2005/xpath-functions",
"xmlns:cim"=>"http://iec.ch/TC57/2003/CIM-schema-cim10#","xmlns:rdf"=>"http://www.w3.org/1999/02/22-rdf-syntax-ns#"
}
xsl_output = root_node.add_element "xsl:output",{"method"=>"xml","version"=>"1.0","encoding"=>"GBK","indent"=>"yes"}
xsl_template = root_node.add_element "xsl:template",{"match"=>"/rdf:RDF"}
equip = xsl_template.add_element "EQUIP"

equip.add_element "TABLE_NAME"

no = equip.add_element "NO"
#no.add_element "xsl:value-of", {"select"=>"substring(cim:Breaker/cim:PowerSystemResource.Asset/@rdf:resource,12,5)" }
no.add_text "'<xsl:value-of select=\"substring(cim:BusbarSection/cim:PowerSystemResource.Asset/@rdf:resource,12,17)\"/>'"
substation_no = equip.add_element "SUBSTATIONNO"
substation_no.add_text "'<xsl:value-of select=\"substring(cim:Breaker/cim:Equipment.MemberOf_EquipmentContainer/@rdf:resource,17,17)\"/>'"
parentpsr = equip.add_element "PARENTPSR"
parentpsr.add_text "'<xsl:value-of select=\"substring(cim:Breaker/cim:PowerSystemResource.ParentPSR/@rdf:resource,24,17)\"/>'"
psrtype_item = equip.add_element "ITEM"
psrtype_property = psrtype_item.add_element "Property", {"name"=>"PSRTYPE"}
psrtype_property.add_text "'<xsl:value-of select=\"substring(cim:Breaker/cim:PowerSystemResource.PSRType/@rdf:resource,14,9)\"/>'"
org_item = equip.add_element "ITEM"
org_property = org_item.add_element "Property",{"name"=>"ORG"} 
org_property.add_text "'<xsl:value-of select=\"substring-after(cim:Asset/cim:Asset.Organisations/@rdf:resource,'@')\"/>'"
line = 1
while worksheet.Range("a#{line}").value
	puts worksheet.Range("a#{line}").value
    row_name = worksheet.Range("a#{line}").value
    row_name = row_name.delete " "
    row_name_exist = true
file = File.new('pms_zdh.xml')
doc = Document.new(file)
#file = File.new(Dir.pwd+"/BDYCSB/"+entry)

=begin
bdz =root_node.add_element "ITEM"
bdzProperty = bdz.add_element "Property", {"name"=>"BDZ"}
xslForeach = bdzProperty.add_element "xsl:for-each", {"select"=>"cim:Breaker/cim:Equipment.MemberOf_EquipmentContainer"}
xslIf = xslForeach.add_element "xsl:if", {"test"=>"@rdf:resource='#PMS-Substation@SUBPMSID#/Substation'"}
xslIf.add_element "xsl:value-of", {"select"=>"substring(@rdf:resource,17,8)"}

ck =root_node.add_element "ITEM"
ckProperty = ck.add_element "Property", {"name"=>"CK"}
xslForeach1 = ckProperty.add_element "xsl:for-each", {"select"=>"cim:Breaker/cim:Equipment.MemberOf_EquipmentContainer"}
xslIf1 = xslForeach1.add_element "xsl:if", {"test"=>"@rdf:resource='@rdf:resource='#PMS-Storage@CKPMSID#/Storage'"}
xslIf1.add_element "xsl:value-of", {"select"=>"substring(@rdf:resource,14,7)"}
=end


root = doc.root

puts "-----------------------------------------------------------------------"
puts "parsing"
puts "-----------------------------------------------------------------------"
root.each_element() { |item| 
	
	#puts "#{item.name}"
	

if(item.name != "Property")    

item.elements.each(){ |element|
	
	
	#if(element.text != nil) 
	#puts "#{element.name}"
	
	#node = equip.add_element "ITEM"
	
	
	
	elementName = element.name.to_s
	
	nameIndex = elementName.index(".")
	
	#puts "#{nameIndex}"
	
	nameLength = elementName.length()
	
	#puts "#{nameLength}"
	
	#property = node.add_element "Property", {"name"=>"#{element.name.to_s.index(".")}"}
	#property = node.add_element "Property", {"name"=>"#{elementName[nameIndex+1,nameLength]}"}
	
	
	if (row_name == elementName[nameIndex+1,nameLength].upcase)
		
		puts elementName[nameIndex+1,nameLength].upcase
		row_name_exist = false
		node = equip.add_element "ITEM"
		puts "OK!"
	    property = node.add_element "Property", {"name"=>"#{row_name}"}
	#property.add_element "xsl:value-of", {"select"=>"cim:"+item.name.to_s+"/"+"cim:"+element.name.to_s}
        xslValue = "'<xsl:value-of select=\""+"cim:"+item.name.to_s+"/"+"cim:"+element.name.to_s+"\"/>'"
        puts xslValue
        property.add_text xslValue
    end
	#end	
	
}
else
	
	#puts "#{item.name}"
	
	item.elements.each(){ |element|
	
	#if(element.name=="Property.propertyType") 
		
		if(row_name == element.text)
			puts row_name
			row_name_exist = false
		    nodeProperty = equip.add_element "xsl:for-each",{"select"=>"cim:Property"}
		    test = "string(cim:Property.propertyType) eq "+ "\'"+element.text+"\'"
		    ifProperty = nodeProperty.add_element "xsl:if",{"test"=>test}
		    itemProperty = ifProperty.add_element "ITEM"
		    propertyNode = itemProperty.add_element "Property"
	        attributeProperty = propertyNode.add_element "xsl:attribute", {"name"=>"name"}
		    attributeProperty.add_element "xsl:value-of", {"select"=>"cim:Property.propertyType"}
		    propertyNode.add_text "'<xsl:value-of select=\"cim:Property.propertyValue\"/>'"
        end
  #end

 }
end
#puts ""

=begin
if(item.name == "Property") then
	
	item.elements.each(){ |element|
	
	if(element.name=="cim:Property.propertyType") then
		
		nodeProperty = root_node.add_element "xsl:for-each",{"select"=>"cim:Property"}
		test = "string(cim:Property.propertyType) eq "+ "\'"+element.name+"\'"
		puts test
		ifProperty = nodeProperty.add_element "xsl:if",{"test"=>"#{test}"}
	end	
	
}
end
=end
}
if row_name_exist
	equip.add_element "#{row_name}"
end
line=line+1
end
=begin
xslForeach2 = root_node.add_element "xsl:for-each", {"select"=>"cim:Property"}
node1 = xslForeach2.add_element "ITEM"
property1 = node1.add_element "Property"
xslAttribute = property1.add_element "xsl:attribute", {"name"=>"name"} 
xslAttribute.add_element "xsl:value-of", {"select"=>"cim:Property.propertyType"}
property1.add_element "xsl:value-of", {"select"=>"cim:Property.propertyValue"}
puts "-----------------------------------------------------------------------"
puts "\t\t\t\t\t\t   "  
puts "-----------------------------------------------------------------------"
=end
#doc1.write
#file1.puts doc1.write
excel.Quit
fmt = Formatters::Pretty.new
fmt.write(doc1,file1)
puts doc1.to_s 





