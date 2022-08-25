public class Main {
    public static void main(String[] args) {

    }
    public String truncateSentence(String s, int k) {
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<k;i++){
            sb.append(arr[i]+" ");
        }
        return sb.toString().trim();

    }
}
