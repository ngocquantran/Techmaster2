public class Main {
    public static void main(String[] args) {

    }
    public int maximumPopulation(int[][] logs) {
        int[] years=new int[2051];
        for (int i=0;i< logs.length;i++){
            int start=logs[i][0];
            while (start<=logs[i][1]){
                years[start]++;
                start++;
            }
        }
        int max=years[0];
        int result=0;
        for (int i=1;i< years.length;i++){
            if (years[i]>max){
                max=years[i];
                result=i;
            }
        }
        return result;
    }
}
