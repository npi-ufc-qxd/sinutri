# SISAT - Sistema de Atendimento
Sistema de atendimento a serviços de psicologia, nutrição para a comunidade acadêmica da UFC.

- Fornecer nome JNDI sinutri (arquivos server.xml e context.xml)

No arquivo server.xml...
```xml
  ...
  <GlobalNamingResources>
    <Resource auth="Container" driverClassName="org.postgresql.Driver" maxActive="10" maxIdle="3" maxWait="10000" name="sinutri" password="senha" type="javax.sql.DataSource" url="jdbc:postgresql://localhost/sinutri" username="usuario"/>
  </GlobalNamingResources>
  ...
```

No arquivo context.xml...
```xml
  ...
  <Context>
    <ResourceLink global="sinutri" name="sinutri" type="javax.sql.DataSource"/>
  </Context>
  ...
```
