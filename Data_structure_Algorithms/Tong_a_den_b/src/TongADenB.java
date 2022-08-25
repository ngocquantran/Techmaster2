public class TongADenB {
    public static void main(String[] args) {
        System.out.println(sumBetween(2,5));
        System.out.println(sumBetween(5,2));
        System.out.println(sumBetween(-2,4));
        System.out.println(sumBetween(4,-2));
        System.out.println(sumBetween(2,2));
        System.out.println(sumBetween(-2,-2));

    }
    public static int sumBetween(int a, int b){
        return sum(Math.min(a,b),Math.max(a,b),0);
    }

    public static int sum(int a, int b,int sum){
        if (a>b) return sum;
        if (a==b) sum+=a;
        else sum+=a+b;
        return sum(a+1,b-1,sum);

    }
}
