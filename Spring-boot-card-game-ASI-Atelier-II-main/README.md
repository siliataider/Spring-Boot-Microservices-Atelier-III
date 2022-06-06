# ASI1-Visual-Content

# Spring-boot-card-game-ASI-Atelier-II

lien du github : https://github.com/siliataider/Spring-boot-card-game-ASI-Atelier-II.git

## Membres du groupe
1. TAIDER Silia
2. BEN SALAH Mariem
3. Boiteux Baptiste
4. MESSIE Louis
## Les éléments réalisés du cahier des charges
1. Architecture __Web Javascript__ + __Web Services Full Rest__

![image](https://user-images.githubusercontent.com/69010419/168466922-d5e126da-530b-4d4d-9996-6bf331546a90.png)

2. Séparation de la réalisation des fonctionnalités :
  * Un binôme s'est chargé de la création d’utilisateur et connexion
  * Un binôme s'est chargé de l'achat/vente de cartes sur la plateforme
3. Partie utilisateurs et connexion 
      * Formulaire d'inscription : enregistrement d'un utilisateur dans la bases de données 
      * Formulaire de connexion : non relié à la base de données 
4. Partie Market
## Les éléments non-réalisés du cahier des charges
1. Partie utilisateurs et connexion
   * L'authentification n'est pas finie
2. Partie Market
   * L'affichage des cartes possédée par l'utilisateur pour les vendre

## Des éléments éventuels réalisés en plus du cahier des charges
* Nada

## Elements de la partie cartes : 
Nous avons choisi d'ignorer l'aspect "échange entre joueurs", les cartes sont soit possédées par un joueur, soit une banque centrale de cartes. Les cartes ont donc un attribut : `Boolean owned` qui permet de savoir si la carte est possédée ou non.

Pour afficher les cartes mises en vente, il suffit donc de parcourir les cartes de la BDD et de récupérer les cartes avec l'attribut `owned = False`.
