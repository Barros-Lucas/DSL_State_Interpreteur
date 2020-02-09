# DSL_State_Interpreteur

Ce repos contient l'implémentation d'un interpreteur DSL ayant pour but de réprésenter le cas d'utilisation du patron "State". Il se base sur l'outil Gemoc : http://gemoc.org/

Cette implémentation ce situe dans le cadre d'un cours sur les DSL ("domain-specific language") et il met en avant le deuxieme type d'implémentation via un un interpreteur pré-généré.

L'utilisation de ce rendu ce fait en exécutant le fichier xmi du folder org.sample.k3project\src\fsm\aspects. (note: le jdk 12 est nécéssaire)

Le cas d'utilisation suit cette ordre :
on -> lancement de la machine à état
sTos -> passage de l'état s1 vers s2
off -> passage à l'état final depuis s2
