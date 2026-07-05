import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        if(n==0){
            System.out.println(0);
            return;
        }
        System.out.println((n*(n+1))/2);
    }
}