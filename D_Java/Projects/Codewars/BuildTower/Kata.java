package BuildTower;

public class Kata {
    public static String[] towerBuilder(int nFloors){
        String[] tower = new String[nFloors];
        for(int i = nFloors-1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            int repsA = 2*i+1;
            int repsE = ((2*(nFloors-1) + 1) - repsA) / 2;
            for(int j = 0; j < repsE; j++) sb.append(" ");
            for(int j = 0; j < repsA; j++) sb.append("*");
            for(int j = 0; j < repsE; j++) sb.append(" ");
            tower[i] = sb.toString();
        }
        return tower;
    }
}
