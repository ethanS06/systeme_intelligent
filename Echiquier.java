public class Echiquier {

	private Cellule[][] echiquier ;
	private int taille ;

	
//CONSTRUCTEUR ECHIQUIER
	public Echiquier(int taille){
		this.taille = taille;
		this.echiquier = new Cellule[taille][taille];
		initialiserEchiquier();
	}
//INITIALISE ECHIQUIER
	public void initialiserEchiquier(){
		for (int x = 0; x< taille ; x++){
			for (int y =0 ; y < taille ; y++){
				this.echiquier[x][y] = new Cellule(x,y);
			}
		}
	}
//PERMET DE MODIFIER L'ETAT D'OCCUPATION D'UNE CELLULE
	public void modifierCellule(int x, int y, int valeur){
		echiquier[x][y].setOccupation(valeur);
	}

	public Cellule getCellule(int x, int y){
		return this.echiquier[x][y];
	}



//PERMET DE PLACER UNE REINE ET DE MARQUER LES CASES CIBLES PAR LA REINE
	public void placerReine( int x, int y){
		if (this.echiquier[x][y].getOccupation() == 0){
			
			for (int i=0 ; i<taille ; i++){
				if ( i != x){ 
					modifierCellule(i, y, 2);
				}
				
			}
			for (int j=0 ; j<taille ; j++){
				if ( j != y){ 
					modifierCellule(x, j, 2);
				}
			}
			int diagonale1 = x ;
			int diagonale2 = y ; 

			while (diagonale1>=0 && diagonale2>=0){
				modifierCellule(diagonale1 , diagonale2 , 2);
				diagonale1 = diagonale1-1;
				diagonale2 = diagonale2-1;
			}

			diagonale1 = x ;
			diagonale2 = y ; 

			while (diagonale1<taille && diagonale2<taille){
				modifierCellule(diagonale1 , diagonale2 , 2);
				diagonale1 = diagonale1+1;
				diagonale2 = diagonale2+1;
			}


			diagonale1 = x ;
			diagonale2 = y ; 

			while (diagonale1>=0 && diagonale2<taille){
				modifierCellule(diagonale1 , diagonale2 , 2);
				diagonale1 = diagonale1-1;
				diagonale2 = diagonale2+1;
			}

			diagonale1 = x ;
			diagonale2 = y ; 

			while (diagonale1<taille && diagonale2>=0){
				modifierCellule(diagonale1 , diagonale2 , 2);
				diagonale1 = diagonale1+1;
				diagonale2 = diagonale2-1;
			}
  
			modifierCellule(x , y ,1);

		}
		else 
			System.out.println("Erreur, la position ("+ x + "," + y +") est deja prise par une reine ou menacer par une reine, \n"+"veuillez ressayer");

	}

	//PERMET DE FACILITER L'AFFFICHAGE DE L'ECHIQUIER
	public String toString(){
		String ligne = "" ;
			for (int i =0; i<taille ; i++){
				for (int j =0 ; j<taille ; j++){
					ligne += echiquier[i][j] + "|" ;
				}
				ligne += "\n";
			}

		return ligne;
	}

	//clear le plateau
	public void ClearEchiquier(){
		for (int i = 0 ; i<=this.taille-1 ; i++){
			for (int j=0 ; j<= this.taille-1 ; j++){
				getCellule(i,j).setOccupation(0);
			}
		}
	}

	//compter le nb de cases prises par une reine
	public static int compter(int x, int y){
		if (x>=8 || y>=8){
			System.out.println("la case (" +x+"," + y + ") n'existe pas veuillez ressayer avec des coordonees comprises entre 0 et 7" );
			return -1;		
		}
		else { 
			Echiquier copietest = new Echiquier(8);
			copietest.initialiserEchiquier();
			copietest.placerReine(x,y);
			int somme =1;
			for (int i= 0 ; i<=7 ; i++){
				for (int j =0 ; j<=7; j++){
					if (copietest.getCellule(i,j).getOccupation() == 2){
						somme +=1;
					}
				}
			}
			//System.out.println(copietest);
			copietest.ClearEchiquier();

			return somme;
		}

		
	}

	//indique l'existence d'une csae libre dans le plateau

	public boolean case_libre(){
		for (int i = 0 ; i<this.taille ; i++){
			for (int j = 0 ; j<this.taille ; j++){
				if (this.echiquier[i][j].getOccupation() == 0 ){
					return true;
				}
			}
		}
		return false;
	}
	
//compter le nb de reine sur le plateau
	public int compter_reine(){
		int compteur = 0 ;
		for (int i = 0 ; i<this.taille ; i++){
			for (int j = 0 ; j<this.taille ; j++){
				if (this.echiquier[i][j].getOccupation() == 1 ){
					compteur+=1;
				}
			}
		}
		return compteur;
	}
//Algorithme de placement de reines
	public static void algoreineglouton(int n){
		Echiquier temporaire = new Echiquier(n);
		temporaire.initialiserEchiquier();
		Cellule cellule_a_placer = new Cellule(0,5);
		int nb_cases_menace = compter(0,5);
		
		while(temporaire.case_libre()){
			for (int i = 0 ;  i<=n-1; i++){
				for (int j = 0 ; j<=n-1 ; j++){
					if (temporaire.getCellule(i,j).getOccupation() == 0) {
						if (compter(i,j) < nb_cases_menace){
							cellule_a_placer = temporaire.getCellule(i,j);
							nb_cases_menace = compter(i,j);
						}
					}
				}
			}
			temporaire.placerReine(cellule_a_placer.getX() , cellule_a_placer.getY());
			nb_cases_menace = 64;

		
		}
		System.out.println(temporaire);
		System.out.println(temporaire.compter_reine());
	}

	public static void algoreineglouton2(int n){
		Echiquier temporaire = new Echiquier(n);
		temporaire.initialiserEchiquier();
		while (temporaire.case_libre()){ 
				for (int i = 0  ; i < n ; i++){
					for (int j = 0 ; j< n ; j++){
						if ( i <n/2 && j%2==1 ){
							temporaire.placerReine(i, j);
						}
						else if(i>=n/2 && j%2==0 ){
							temporaire.placerReine(i, j);
						}
					}
				}
			}
		System.out.println(temporaire);
		System.out.println(temporaire.compter_reine());
	

	}





	public static void main(String[] args) {

		Echiquier testechiquier = new Echiquier(8);
		testechiquier.initialiserEchiquier();
		algoreineglouton2(8);
		
		


		
	}

	
	


}