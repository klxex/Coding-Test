import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++){
            String splits[] = br.readLine().split("");
            for(int j=0;j<n;j++){
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
    }

    public static String quad(int a[][],int x1,int y1,int n){
        boolean check = true;
        int el = a[x1][y1];
        for(int i=x1;i<x1+n;i++){
            for(int j=y1;j<y1+n;j++){
                if(el != a[i][j]){
                    check=false;
                }
            }
        }
        if(check){
            return "1";
        }
        else{
         String s1=quad(a,x1,y1,n/2);
         String s2=quad(a,x1,y1+n/2,n/2);
         String s3=quad(a,x1+n/2,y1,n/2);
         String s4=quad(a,x1+n/2,y1+n/2,n/2);

         StringBuilder sb = new StringBuilder();
         sb.append("(");
         sb.append(s1);
         sb.append(s2);
         sb.append(s3);
         sb.append(s4);
         sb.append(")");
         return sb.toString();
        }
    }
}
