# Quasar-app hilab test

O teste consiste em um card que responde a uma api em java, ele deve mudar de cor e texto conforme o status,
o teste foi feito usando Java + Spring + JPA(Hibernate) e banco Postgres. o front usa vue js + quasar + vuex

## Para testar

Clone o repositório, entre na pasta do front com seu console e use npm install.
Para rodar a api será necessário abrir o projeto com eclipse ou intellij e esperar até que o mavem baixe as dependências,
será necessário um banco postgres rodando na sua porta 5432, não esqueça de alterar os dados em resources/application.properties.
feito isso, rode a api uma vez para que o ORM crie a entidade Cards no banco, logo em seguinda rode o seguinte script no banco:

```
INSERT INTO public.card
(name, status_action, "text", title)
VALUES('Card', 0, 'Este é um card de teste', 'Hi-teste');

```

Com o banco populado, use sua IDE java para rodar a api, use *quasar dev* na raiz do front para rodar, se seu apache não estiver rodando a api na porta 8080
aponte no arquivo *quasar.conf* a porta correta para que o front possa consumi-la e pronto!
