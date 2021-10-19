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
	


	public static void main(String[] args) {

		Echiquier testechiquier = new Echiquier(8);
		testechiquier.initialiserEchiquier();
		testechiquier.modifierCellule(5,5,0);
		//System.out.println((testechiquier.getCellule(5,5)).getOccupation());
		testechiquier.placerReine(2,4);
		testechiquier.placerReine(2,4);
		/*System.out.println((testechiquier.getCellule(0,2)).getOccupation());		
		System.out.println((testechiquier.getCellule(1,3)).getOccupation());
		System.out.println((testechiquier.getCellule(2,4)).getOccupation());
		System.out.println((testechiquier.getCellule(3,5)).getOccupation());
		System.out.println((testechiquier.getCellule(4,6)).getOccupation());
		System.out.println((testechiquier.getCellule(5,7)).getOccupation());*/

		System.out.println(testechiquier);
		
		
	}

	
	


}