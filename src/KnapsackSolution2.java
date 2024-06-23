import java.util.Scanner;

public class KnapsackSolution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String res[] = s.replaceAll("[^0-9.]+",";").split(";");
        double target = Integer.parseInt(res[0]);
        int n = (res.length-1) / 3;
        int[] Index = new int[20];
        double[] P = new double[20];
        double[] W = new double[20];
        int jj = 0;
        for(int i = 1; i < res.length; i +=3){
            Index[jj] = Integer.parseInt(res[i]);
            W[jj] = Double.parseDouble(res[i+1]);
            P[jj++] = Double.parseDouble(res[i+2]);
        }
        double result = 0;
        int track = 0;
        double resSum = 0;
        for(int i =0; i< (1<<n); i++){
            double sum = 0;
            double weight = 0;
            for(int j=0; j < n; j++){
                if(((1<<j)&i) > 0){
                    sum+= P[j];
                    weight+=W[j];
                }
            }
            if(weight <= target){
                if(sum > resSum){
                    result = weight;
                    track = i;
                    resSum = sum;
                }else if(sum == resSum && weight < result){
                    result = weight;
                    track = i;
                }
            }
        }
        jj = 0;
        for(int i = 0; i < n; i++){
            if(((1<<i)&track) > 0){
                if(jj > 0){
                    System.out.print(",");
                }
                jj = 1;
                System.out.print(Index[i]);
            }
        }
        if(track == 0){
            System.out.println("-");
        }else {
            System.out.println();
        }
    }
}
