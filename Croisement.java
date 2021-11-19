import Math;
public class Croisement {
    public void Croisement2(int[] parent1, int[] parent2){
        int x1;
        int x2;
        while(x1 <= x2){
            x1 = (int)(Math.random()*parent1.length);
            x2 = (int)(Math.random()*parent1.length);

        }
        enfant1 = new int[parent1.length];
        enfant2 = new int[parent1.length];
        for(int i = 0; i < x1; i++){
            enfant1[i] = parent1[i];
            enfant2[i] = parent2[i];
        }
        for(int i = x1; i < x2; i++){
            enfant1[i] = parent2[i];
            enfant2[i] = parent1[i];
        }
        for(int i = x2; i < parent1.length; i++){
            enfant1[i] = parent1[i];
            enfant2[i] = parent2[i];
        }
    } 
    public static void main(String[] args){
        int[] parent;
        int[] parentautre;
    }

}