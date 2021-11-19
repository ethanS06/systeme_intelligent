public class Roulette {
    private int f;
    public int CalculSomme(Population P){
        int somme = 0;
        for(int i = 0; i < N; i++){
            somme = somme + P[i]*f;
        }
        return somme;
    }

    public Solution Roulette(Population P, int somme){
        int alea = aleatoire(0,somme);
        int cumul = 0;
        int index = 0;
        while(cumul + P[index]*f<alea){
            cumul = cumul + P[index]*f;
            index = index + 1;
        }
        return P[index];
    }
} 