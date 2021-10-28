public class Cellule {

	private int x;
	private int y;
	private int typeOccupation;

	final static int LIBRE = 0; 
	final static int REINE = 1;
	final static int MENACEE =2 ;

	public Cellule (int x, int y){
		this.x = x;
		this.y = y;
		this.typeOccupation = LIBRE ;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getOccupation() {
		return this.typeOccupation;
	}

	public void setX( int newX){
		this.x = newX;
	}

	public void setY (int newY){
		this.y = newY;
	}

	public void setOccupation (int newtypeOccupation){
		this.typeOccupation = newtypeOccupation; 
	}

	public String toString(){
		return this.typeOccupation + "" ;
	}

	public static void main(String[] args) {
	
	Cellule test = new Cellule(1,1);
	System.out.println(test.getX() );
	System.out.println(test.getY() );
	System.out.println(test.getOccupation() );

	test.setX(2);
	test.setY(2);
	test.setOccupation(REINE);
	System.out.println(test.getX() );
	System.out.println(test.getY() );
	System.out.println(test.getOccupation() );

	System.out.println(test);




    }
}