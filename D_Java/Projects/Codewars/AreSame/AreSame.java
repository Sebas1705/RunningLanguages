package AreSame;

public class AreSame {
	
	public static boolean comp(int[] a, int[] b) {
        for(int i=0;i<b.length;i++){
            boolean is=false;
            for(int j=0;i<a.length;j++){
                if(a[j]*a[j]==b[i]){
                    is=true;
                    break;
                }
            }
            if(!is)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11},new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361}));
    }
}