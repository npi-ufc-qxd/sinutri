# SISAT - Sistema de Atendimento
Sistema de atendimento a serviços de psicologia, nutrição para a comunidade acadêmica da UFC.

## Criando usuários no banco de dados para realização de testes
```
senha: teste1234 - sha256: "97e7ae26dd76600646701e97840d52b6ab7cb23cd03f8fa8e50640d84b52b5e1"
````

```sql
insert into pessoa (nome, email, habilitado, login, password) values ('Usuário Nutrição', nutri@ufc.br', true, 'nutri', '97e7ae26dd76600646701e97840d52b6ab7cb23cd03f8fa8e50640d84b52b5e1');
insert into pessoa (nome, email, habilitado, login, password) values ('Usuário Psicologia', 'psico@ufc.br', true, 'psico', '97e7ae26dd76600646701e97840d52b6ab7cb23cd03f8fa8e50640d84b52b5e1');

insert into papel (nome) values ('ROLE_NUTRICAO');
insert into papel (nome) values ('ROLE_PSICOLOGIA');

insert into papel_pessoa (pessoa_id, papel_id) values ((select id from pessoa where login='nutri' limit 1),(select id from papel where nome='ROLE_NUTRICAO' limit 1));
insert into papel_pessoa (pessoa_id, papel_id) values ((select id from pessoa where login='psico' limit 1),(select id from papel where nome='ROLE_PSICOLOGIA' limit 1));

select * from pessoa;
select * from papel;
select * from papel_pessoa;
```

## Criando senha SHA256 no PostgreSQL
```sql
CREATE EXTENSION pgcrypto;
SELECT encode(digest('teste1234', 'sha256'), 'hex');
```
