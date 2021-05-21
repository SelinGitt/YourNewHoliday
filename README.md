# YNH

Your New Holidays

### Introduction
Ce document portera sur :

-La liste des fonctionnalités indiquées dans le cahier des charges et celles ajoutées au cours des mois précédents présentes sur le site, classées selon le type d'utilisateur (client ou administrateur).

-Les équipes qui ont réalisé le projet ainsi que leurs rôles.

-La façon dont le site internet a été développé (sa description technique ainsi que les outils de développement utilisés).

Le site internet sera fourni avec un compte administrateur déjà complété afin de le déployer immédiatement.

### Description fonctionnelle du projet
Le site YNH permettra à **un client** :

* De se créer un compte sur le site (il pourra se connecter/déconnecter).
* De charger une image depuis son ordinateur comme "avatar" de son profil.
* De consulter un ou plusieurs article(s) présents sur le site.
* De l'ajouter à son panier.
* D'ajouter ou de retirer des articles de son panier.
* D'effectuer l'achat des articles précédents.
* De consulter ses anciens achats.

En plus des droits ci-dessus, ce site permettra à **un administrateur** :

* D'upgrader un compte client vers un compte administrateur.
* De consulter / créer / supprimer un/des comptes du site (clients comme administrateurs).
* De consulter / créer / supprimer un/des articles du site.
* De consulter la liste des achats effectués sur celui-ci.
* De consulter la liste des comptes clients/administrateurs

### Description organisationnelle du projet
4 équipes ont participé à la création de ce site :
* l'équipe utilisateur

Elle s'est chargée de la gestion des utilisateurs (droits utilisateurs/administrateurs).
* l'équipe commande

Elle s'est chargée de la gestion des commandes une fois un achat effectué.
* l'équipe panier

Elle s'est chargée de la gestion du panier utilisateur.
* l'équipe produit :

Elle s'est chargée de la gestion des articles du site.

### Description technique du projet

* Java 11
* Architecture 3-tiers
* BD MySql 5
* Serveur TomCat 9.0.X

### Outils de développement utilisés

* Framework utilisé : Spring MVC
* ORM utilisé : Hibernate

Pour obtenir plus d'informations techniques, il sera nécessaire de consulter le DAT.