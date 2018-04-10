# AWS Lambdas et Java

Ce projet a pour but de montrer l'utilisation des labdas AWS avec Java et comment les lancer et debugger en local.

## Le SAM (Serverless Application Model)

Le SAM c'est le langage qui permet de décrire une lambda AWS.

https://github.com/awslabs/serverless-application-model/blob/develop/HOWTO.md


## Déployer en Local

Prérequis

### Docker

Installation classique:

Ubuntu - https://docs.docker.com/install/linux/docker-ce/ubuntu/

Linux - https://docs.docker.com/docker-for-windows/install/

Pour ne pas lancer votre docker avec sudo:

https://docs.docker.com/install/linux/linux-postinstall/

### Un Compte AWS

Si vous testez localement vous pouvez créer un compte AWS sans "billing" 
(pas de carte bleue nécessaire). Cela permet aux vos lambdas
de se lancer plus rapidement (pas de vérification des identifiants à chaque appel)

https://github.com/awslabs/aws-sam-local/issues/134

### SAM Local

https://github.com/awslabs/aws-sam-local

Installation avec NPM:

```
npm install -g aws-sam-local
```

### AWS Cli

```
sudo apt-get install awscli
```

Et pour les Windows Users:

https://docs.aws.amazon.com/cli/latest/userguide/awscli-install-windows.html

### Lancement

- Se positionner dans le répertoire du projet

```
cd <project-root>
```

- Builder avec maven

```
mvn clean package
```

- lancer le sam local

```
sam local start-api
```

- Tester avec curl / postman

```
curl -X POST \
  http://localhost:3000/hello \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: d6b6d0dc-8a0a-47ef-a9a4-0b5dbc159d64' \
  -d '{
	"name": "Mon prénom 1",
	"age": 29
}'
```

>![Alt text](doc/postman-aws.png?raw=true "Tester AWS en local avec Postman")

### Debugger

Pour débugger il suffit de lancer le sam local avec en argument un port de debug:

```
sam local start-api --debug-port 5005
```

Puis se connecter avec votre IDE préféré

**Attention** Le fonctionnement de SAM local est particulier. Il lance un container docker à chaque appel.
Par conséquence le debug ne sera disponible qu'après le moment d'appel vers le endpoint REST.

L'ordre des actions:

1) Je lance sam local en debug
2) Je fais mon appel depuis curl / Postman
3) Je démarre la session de debug depuis IntelliJ / Eclipse




