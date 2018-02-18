## For open ejb

> cp target/esp-ejb-1.0.jar /Volumes/data/apps/devtools/apache-openejb-7.0.4/apps

> /Volumes/data/apps/devtools/apache-openejb-7.0.4/bin/openejb start

run integration junit for openejb

## For jboss EAP 7.1 ejb

> cp target/esp-ejb-1.0.jar /Volumes/data/apps/devtools/jboss-eap-7.1.0/standalone/deployments

run integration junit for jboss ejb

# For liberty ejb - DOES NOT WORK

cp target/esp-ejb-1.0.jar /Volumes/data/apps/devtools/ibm/wlp-webProfile7-8.5.5.9/usr/servers/defaultServer/dropins


Test class: src/test/java/esp.ejb.ibmliberty.LibertyHelloRemoteTest.java

[docs/CallEJBAtLibeerty_DoesNOTwork.png]


#================ Trial 1 liberty =====
rmic target/esp-ejb.jar
D:\apps\IBM\WebSphere\AppServer\profiles\AppSrv01\bin\ejbDeploy -keep -trace target/esp-ejb.jar ./outdir esp-ejb-out.jar


#======================= WAS deplly cmd =========
AdminApp.uninstall('esp-orca-1_0_war')

# For prem laptop
AdminApp.install('C:/fakepath/esp-orca.war', '[ -nopreCompileJSPs -distributeApp -nouseMetaDataFromBinary -appname esp-orca-1_0_war -createMBeansForResources -noreloadEnabled -nodeployws -validateinstall warn -noprocessEmbeddedConfig -filepermission .*\.dll=755#.*\.so=755#.*\.a=755#.*\.sl=755 -noallowDispatchRemoteInclude -noallowServiceRemoteInclude -asyncRequestDispatchType DISABLED -useAutoLink -noenableClientModule -clientMode isolated -novalidateSchema -contextroot esp-orca -MapModulesToServers [[ esp-orca esp-orca-1.0.war,WEB-INF/web.xml WebSphere:cell=L070492Node01Cell,node=Node01,server=server1 ]] -MapWebModToVH [[ esp-orca esp-orca-1.0.war,WEB-INF/web.xml default_host ]]]' )

#======================= WAS ejb as WS cmd =========
D:\apps\IBM\WebSphere\AppServer\profiles\AppSrv01\bin\endptEnabler.bat -v -transport http -endpointType all D:\pers_proj\esp-ejb-bundle\esp-ejbEAR\target\esp-ejbEAR-1.0.ear


