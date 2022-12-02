package tp.model.agents;

import java.awt.Point;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 * 
 *
 */
public class Animal {
	/* attributs de classe */
	private static int currentId = 0;
	
	/* attributs d'instance*/
	/** identifiant unique de l'animal*/
	private int id;
	/** age en unité de temps*/
	private int age;
	/** position sur la carte*/
	private Point coord;
	/** état de santé de l'animal */
	private Etat etat=Etat.Normal;
	private Sexe sexe;
	
	/* 
	 * constructeurs 
	 */
	
	public Animal(Sexe sexe, Point coord) { /*Constructeur*/
		age = 0;
		id = Animal.getUniqueId();
		this.sexe=sexe;
		//this.coord=coord;
		this.coord=new Point(coord);
	}
	
	public Animal(Sexe sexe) {
		//TODO
		/* crée un animal avec le sexe passé en paramètre, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this.age=0;
		this.id = Animal.getUniqueId();
		this.sexe=sexe;
		this.coord=new Point(0,0);
	}
	

	public Animal() {
		//TODO
		/* crée un animal de sexe femelle, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this.age=0;
		this.id = Animal.getUniqueId();
		this.sexe=Sexe.Femelle;
		this.coord=new Point(0,0);
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	//TODO
	
	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public Point getCoord() {
		return coord;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	
	/*
	 * Redéfinitions de méthodes d'object
	 */
	//TODO
	public String toString() {
		return "Animal n° " + this.getId() + "("+this.getSexe()+", ("+this.getCoord().x+"; "+this.getCoord().y+")).";
	}
	

	/* 
	 * comportements d'instance
	 */
	
	

	
	/** Déplacement d'un animal*/
	public void seDeplacer() {
		//TODO utiliser Math.random() pour choisir une direction de déplacement
		int dx=(int)Math.round((Math.random()-0.5)*2);
		int dy=(int)Math.round((Math.random()-0.5)*2);
		coord.x+=dx;
		coord.y+=dy;
	}
	/**Incrémente l'age d'un animal*/
	public void vieillir() {
		//TODO fait vieillir l'animal d'une unité de temps
		//une bonne manière de faire, une moins bonne...
		this.age+=1;
	}
	
	public void rencontrer(Animal a) {
		//TODO
	}
	
	/* comportements de classe */ 
	/**
	 * Renvoie un identifiant unique non encore utilisé
	 * @return un identifiant entier unique d'animal
	 */
	private static int getUniqueId() {
		//TODO 
		int i=currentId;
		currentId+=1;
		return i;
	}
	

	public boolean equals(Animal obj) {
		// TODO Auto-generated method stub
		return ((this.age==obj.age)&&(this.sexe==obj.sexe)&&(this.etat==obj.etat));
	}

	public static void main(String args[]) {
		//tests unitaires de la classe Animal
		//TODO décommentez les lignes pour approfondir le test unitaire
		//complétez la méthode pour tester les nouvelles fonctionnalités que vous allez implémenter
		Animal a = new Animal();
		Animal b = new Animal(Sexe.Male);
		Animal c = new Animal(Sexe.Assexue);
		Animal d = new Animal(Sexe.Femelle,new Point(25,30));
		Animal e = new Animal(Sexe.Femelle,new Point(25,30));
		
		/*
		 * les lignes suivantes doivent afficher à terme: NomDeLaClasse n° id_animal(sexe, (position x; position y)).
		 * ex: 28 (FEMELLE, (25;30))
		 */
		System.out.println("*** Animaux créés: **********");
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		System.out.println("*** Getters et setters **********");
		
		System.out.println(d.getSexe());
		Sexe ss = d.getSexe();
		ss=Sexe.Male;
		System.out.println(d.getSexe());
		System.out.println(a.getAge());
		
		//les lignes suivantes devraient afficher la même chose....
		
		System.out.println(d.getCoord());
		Point pt = d.getCoord();
		pt.x=50;
		System.out.println(d.getCoord());
		
		
		
		//TODO ajoutez vos propres tests de getters et setters
		
		//TODO test vieillir
		
		
		//TODO test seDeplacer
		System.out.println(b.getCoord());
		b.seDeplacer();
		System.out.println(b.getCoord());
		
		//TODO test id
		System.out.println(a.getId());
		System.out.println(b.getId());
		//Print Animal
		System.out.println(c);
		System.out.println(a.getClass().getSimpleName());
		/*
		 * Test comparaison
		 */
		
		System.out.println(d==e);
		System.out.println(d.equals(e));
		System.out.println("Bonjour"=="Bonjour");
		System.out.println("Bonjour".equals("Bonjour"));
		
	}

}
