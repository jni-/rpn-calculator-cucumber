# language: fr

Fonctionnalité: Calculateur RPN
	Afin de calculer plus rapidement
	En tant que mathématicien étrange
	Je désire utiliser une calculatrice RPN
					 
	Scénario: Faire un calcul valide
		Quand j'écris un calcul valide
		Alors la calculatrice me retourne la réponse

	Scénario: Faire un calcul invalide
		Quand j'écris un calcul invalide
		Alors la calculatrice me retourne une erreur

	Scénario: Additionner une liste de nombre
		Quand j'écris une liste de nombres à additionner
		Alors la calculatrice me retourne la somme