## For open ejb

> cp target/prem-ejb-1.0.jar /Volumes/data/apps/devtools/apache-openejb-7.0.4/apps

> /Volumes/data/apps/devtools/apache-openejb-7.0.4/bin/openejb start

run integration junit for openejb

## For jboss EAP 7.1 ejb

> cp target/prem-ejb-1.0.jar /Volumes/data/apps/devtools/jboss-eap-7.1.0/standalone/deployments

run integration junit for jboss ejb

# For liberty ejb - DOES NOT WORK

cp target/prem-ejb-1.0.jar /Volumes/data/apps/devtools/ibm/wlp-webProfile7-8.5.5.9/usr/servers/defaultServer/dropins


Test class: src/test/java/esp.ejb.ibmliberty.LibertyHelloRemoteTest.java

[docs/CallEJBAtLibeerty_DoesNOTwork.png]


#================ Trial 1 liberty =====
rmic target/prem-ejb.jar
D:\apps\IBM\WebSphere\AppServer\profiles\AppSrv01\bin\ejbDeploy -keep -trace target/prem-ejb.jar ./outdir prem-ejb-out.jar


#======================= WAS deplly cmd =========
AdminApp.uninstall('bpcs-integ-1_0_war')
AdminApp.install('D:/pers_proj/bpcs_verify_compile/health-hns-bpcs-int/bpcs_integration/target/bpcs-integ-1.0.war', '[ -nopreCompileJSPs -distributeApp -nouseMetaDataFromBinary -appname bpcs-integ-1_0_war -createMBeansForResources -noreloadEnabled -nodeployws -validateinstall warn -noprocessEmbeddedConfig -filepermission .*\.dll=755#.*\.so=755#.*\.a=755#.*\.sl=755 -noallowDispatchRemoteInclude -noallowServiceRemoteInclude -asyncRequestDispatchType DISABLED -nouseAutoLink -noenableClientModule -clientMode isolated -novalidateSchema -contextroot bpcs-integ -MapModulesToServers [[ bpcs-integ bpcs-integ-1.0.war,WEB-INF/web.xml WebSphere:cell=dapodsi3Node01Cell,node=dapodsi3Node01,server=server1 ]] -MapWebModToVH [[ bpcs-integ bpcs-integ-1.0.war,WEB-INF/web.xml default_host ]]]' )

# For prem laptop
AdminApp.install('C:/fakepath/bpcs-integ-1.0.war', '[ -nopreCompileJSPs -distributeApp -nouseMetaDataFromBinary -appname bpcs-integ-1_0_war -createMBeansForResources -noreloadEnabled -nodeployws -validateinstall warn -noprocessEmbeddedConfig -filepermission .*\.dll=755#.*\.so=755#.*\.a=755#.*\.sl=755 -noallowDispatchRemoteInclude -noallowServiceRemoteInclude -asyncRequestDispatchType DISABLED -useAutoLink -noenableClientModule -clientMode isolated -novalidateSchema -contextroot bpcs-integ -MapModulesToServers [[ bpcs-integ bpcs-integ-1.0.war,WEB-INF/web.xml WebSphere:cell=L070492Node01Cell,node=Node01,server=server1 ]] -MapWebModToVH [[ bpcs-integ bpcs-integ-1.0.war,WEB-INF/web.xml default_host ]]]' )
# Liberty server log showing corba-up, ejb deployed

[AUDIT   ] CWWKI0001I: The CORBA name server is now available at ** corbaloc:iiop:localhost:2809/NameService. **
[INFO    ] CWWKZ0018I: Starting application prem-ejb.
[INFO    ] CNTR4000I: The prem-ejb.jar EJB module in the prem-ejb application is starting.
[INFO    ] SRVE0169I: Loading Web Module: IBMJMXConnectorREST.
[INFO    ] SRVE0169I: Loading Web Module: ibm/api.
[INFO    ] SRVE0250I: Web Module IBMJMXConnectorREST has been bound to default_host.
[INFO    ] SRVE0250I: Web Module ibm/api has been bound to default_host.
[AUDIT   ] CWWKT0016I: Web application available (default_host): http://localhost:9080/IBMJMXConnectorREST/
[INFO    ] CWWKX0103I: The JMX REST connector is running and is available at the following service URL: service:jmx:rest://localhost:9443/IBMJMXConnectorREST
[INFO    ] CWWKX0103I: The JMX REST connector is running and is available at the following service URL: service:jmx:rest://localhost:9443/IBMJMXConnectorREST
[AUDIT   ] CWWKT0016I: Web application available (default_host): http://localhost:9080/ibm/api/
[INFO    ] SRVE0169I: Loading Web Module: The Liberty Server Config Tool.
[INFO    ] SRVE0250I: Web Module The Liberty Server Config Tool has been bound to default_host.
[AUDIT   ] CWWKT0016I: Web application available (default_host): http://localhost:9080/ibm/adminCenter/serverConfig-1.0/
[INFO    ] CNTR0167I: The server is binding the esp.ejb.HelloRemote interface of the HelloBean enterprise bean in the prem-ejb.jar module of the prem-ejb application.  The binding location is:** java:global/prem-ejb/HelloBean!esp.ejb.HelloRemote **
[INFO    ] CNTR4001I: The prem-ejb.jar EJB module in the prem-ejb application has started successfully.
[AUDIT   ] CWWKZ0001I: Application prem-ejb started in 0.312 seconds.
[AUDIT   ] CWWKF0012I: The server installed the following features: [jsp-2.3, ejbLite-3.2, jsf-2.2, servlet-3.1, ssl-1.0, jndi-1.0, ejbHome-3.2, jca-1.7, ejbPersistentTimer-3.2, localConnector-1.0, jdbc-4.1, appSecurity-2.0, jaxrs-2.0, restConnector-1.0, jaxrsClient-2.0, el-3.0, ejbRemote-3.2, mdb-3.2, ejb-3.2, json-1.0, adminCenter-1.0, distributedMap-1.0].
[INFO    ] CWWKF0008I: Feature update completed in 2.573 seconds.