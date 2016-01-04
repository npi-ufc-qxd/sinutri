# SISAT - Sistema de Atendimento
Sistema de atendimento a serviços de psicologia, nutrição para a comunidade acadêmica da UFC.

## Fornecer nome JNDI do datasource (sinutri), LDAP e Mail (arquivos server.xml e context.xml)

No arquivo server.xml...
```xml
  ...
  <GlobalNamingResources>
    <Resource auth="Container" driverClassName="org.postgresql.Driver" maxActive="10" maxIdle="3" maxWait="10000" name="sinutri" password="senha" type="javax.sql.DataSource" url="jdbc:postgresql://localhost/sinutri" username="usuario"/>
    <Environment name="ldap/url" type="java.lang.String" value="ldap://endereco-ldap:389"/>
    <Environment name="ldap/base" type="java.lang.String" value="dc=quixada,dc=ufc,dc=br"/>
    <Environment name="ldap/userdn" type="java.lang.String" value="cn=admin_npi,ou=people_teste,dc=quixada,dc=ufc,dc=br"/>
    <Environment name="ldap/password" type="java.lang.String" value="senha"/>
    <Environment name="ldapou" type="java.lang.String" value="ou=people_teste"/>
    <Resource auth="Container" mail.smtp.host="ip-smtp-server" mail.smtp.port="587" mail.transport.protocol="smtp" name="mail/Session" type="javax.mail.Session"/>
  </GlobalNamingResources>
  ...
```

No arquivo context.xml...
```xml
  ...
  <Context>
    <ResourceLink global="sinutri" name="sinutri" type="javax.sql.DataSource"/>
    <ResourceLink global="ldap/url" name="ldap/url" type="java.lang.String"/>
    <ResourceLink global="ldap/base" name="ldap/base" type="java.lang.String"/>
    <ResourceLink global="ldap/userdn" name="ldap/userdn" type="java.lang.String"/>
    <ResourceLink global="ldap/password" name="ldap/password" type="java.lang.String"/>
    <ResourceLink global="ldapou" name="ldapou" type="java.lang.String"/>
    <ResourceLink global="mail/Session" name="mail/Session" type="javax.mail.Session"/>
  </Context>
  ...
```

Importante: Copiar o driver do PostgreSQL (postgresql-xxx.jar - http://mvnrepository.com/artifact/org.postgresql/postgresql) e javax.mail-xxx.jar (http://mvnrepository.com/artifact/com.sun.mail/javax.mail) para o diretório de libs do Tomcat.
