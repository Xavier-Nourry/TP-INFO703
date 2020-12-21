Camille Morand - Xavier Nourry

# TP Compilation : Génération de code pour un sous ensemble du langage λ-ada.

## Rendu:

Le fichier src/main/cup/AnalyseurSyntaxique.cup a été modifié par rapport aux TP2 pour coller à un changement de la structure de l'arbre abstrait généré.  
Les fichiers du dossier src/main/java/fr/usmb/m1isc/compilation/tp sont tous nouveaux ou modifiés depuis le TP2.

Pour faire tourner l'algorithme il faut build le projet avec gradle puis lancer le main.java. Le programme est plus rapide si on l'appelle directement avec un fichier source en argument.
En plus d'un fichier source, on peut passer le nom d'un fichier de destination pour l'assembleur (si on n'en passe pas le programme génèrera un dest.asm).  
On peut ensuite utiliser l'émulateur sur le fichier généré :  
`java -jar vm-0.9.jar dest.asm`
ou
`java -jar vm-0.9.jar dest.asm --debug`


# 

À partir de l'arbre abstrait construit lors du dernier TP, avec les outils JFlex et CUP, l'objectif consiste à générer du code pour la machine à registres décrite dans le cours, afin d'être en mesure d'exécuter les programmes reconnus par l'analyseur sur la machine à registres.

## Exercice 1 :

Dans la première partie du tp on pourra se limiter à la génération de code pour les expressions arithmétiques sur les nombres entiers.

Ainsi, l'expression

```
let prixHt = 200;
let prixTtc =  prixHt * 119 / 100 .
```
correspondant, par exemple, à l'arbre ci-dessous pourrait amener à la production du code suivant :

```
DATA SEGMENT
	prixHt DD
	prixTtc DD
DATA ENDS
CODE SEGMENT
	mov eax, 200
	mov prixHt, eax
	mov eax, prixHt
	push eax
	mov eax, 119
	pop ebx
	mul eax, ebx
	push eax
	mov eax, 100
	pop ebx
	div ebx, eax
	mov eax, ebx
	mov prixTtc, eax
CODE ENDS
```
```
; ──┬── LET ──┬── prixHt
    │         │   
    │         └── 200
    │   
    └── LET ──┬── prixTtc
              │   
              └── / ──┬── * ──┬── prixHt
                      │       │   
                      │       └── 119
                      │   
                      └── 100
```

## Exercice 2 :

Étendre la génération de code aux opérateurs booléens, de comparaison, aux boucles et aux conditionnelles, correspondant au sous-ensemble du langage **λ-ada** utilisé pour le TP précédent.

Exemple de code source pour le compilateur : calcul de PGCD.

```
let a = input;
let b = input;
while (0 < b)
do (let aux=(a mod b); let a=b; let b=aux );
output a
.
```
Et un exemple de code qui pourrait être produit :

```
DATA SEGMENT
	b DD
	a DD
	aux DD
DATA ENDS
CODE SEGMENT
	in eax
	mov a, eax
	in eax
	mov b, eax
debut_while_1:
	mov eax, 0
	push eax
	mov eax, b
	pop ebx
	sub eax,ebx
	jle faux_gt_1
	mov eax,1
	jmp sortie_gt_1
faux_gt_1:
	mov eax,0
sortie_gt_1:
	jz sortie_while_1
	mov eax, b
	push eax
	mov eax, a
	pop ebx
	mov ecx,eax
	div ecx,ebx
	mul ecx,ebx
	sub eax,ecx
	mov aux, eax
	mov eax, b
	mov a, eax
	mov eax, aux
	mov b, eax
	jmp debut_while_1
sortie_while_1:
	mov eax, a
	out eax
CODE ENDS
```

## Émulateur pour la machine à pile

Vous trouverez un émulateur pour la machine à registres ici : [vm-0.9.jar](./vm-0.9.jar).

Il s'utilise de la façon suivante :

`java -jar vm-0.9.jar pgcd.asm`

ou

`java -jar vm-0.9.jar pgcd.asm --debug`

## À rendre :

À la fin du tp, vous ferez une présentation intermédiaire de votre compilateur, de l'ordre de 5 minutes, à l'enseignant qui vous encadre en tp.

Avant le 4 janvier 2021, sous la forme d'un fichier d'un lien vers un dépot git, vous devez envoyer un petit compte-rendu avec des exemples bien choisis de génération de code et l'ensemble de vos fichiers source à l'enseignant qui vous encadre en tp (Stephane.Talbot@univ-smb.fr / Francois.Boussion@univ-smb.fr).