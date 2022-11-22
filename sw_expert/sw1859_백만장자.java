import java.util.Scanner;

public class sw1859 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test;
        test = sc.nextInt();
        int[][] price;
        price = new int[test][];

        for(int i = 0;i < test;i++){
            int predict;
            predict = sc.nextInt();
            price[i] = new int[predict];
            for(int j = 0;j < predict;j++){
                price[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i < test;i++){
            int max = 0;
            int sum = 0;
            for(int k = price[i].length - 1;k >= 0;k--){
                if(max < price[i][k]){
                    max = price[i][k];
                }else{
                    int num = max - price[i][k];
                    sum += num;
                }
            }
            System.out.println("# "+(i+1)+" "+sum);
        }
    }
}
