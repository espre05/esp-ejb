Annotate @Webservice HelloBean
http://127.0.0.1:4204/esp-ejb/HelloBean?wsdl

Annotate @Webservice(name = "HelloService")

#liberty
http://localhost:9080/esp-ejb/CalculatorBeanService?wsdl

PendingIssue: 
- InputData minoccur should be 2
- Result minOccur should be 1
- Check falut mapping.
	add : throws CalculatorException that's it.
- name the result object
	@WebMethod( operationName = "getItems" )
   	@WebResult( name = "item" )
   	public List<Item> getItems(
     	@WebParam( name = "itemType" ) 
     	@XmlElement( required = true )  //To make minOccurs=1..*
     	String itemType 
    ){};