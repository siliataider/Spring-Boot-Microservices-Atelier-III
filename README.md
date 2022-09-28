# Compte Rendu Spring-Boot-Microservices-Junit-Mockito-Unit-Testing-Atelier-III

## Demo video  :

https://youtu.be/DVqqUt6DV7M

Elements du cahier des charges réalisés:
===================================================

Nous avons divisé le travail principalement en deux parties, un binôme
s'occupe de la partie user, et un binôme s'occupe de la partie card et
market.

* Mise en place du microservice user (inscription/ authentification).
* Réalisation de tests unitaires pour le microservice user.
* Utilisation de sonar/ jacoco pour l'analyse du microservice user.
* Communication entre les microservices (user, Market et Card) en utilisant FeignClient.
* Implémentation des méthodes des microservices Market et Card comme la génération des 5 cartes aléatoires à chaque inscription d'un utilisateur.
* Couverture de tests à l'aide de l'application jacoco (L'installation et la mise en place de sonar sur windows sans Docker était très compliquée)
* Mise en place du reverse proxy nginx  (pour le microservice user).
* Mise en place des microservices cards et market.
* Deboggage des problèmes de mapping entre les deux applications.
