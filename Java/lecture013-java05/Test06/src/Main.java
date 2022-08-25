import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào số hàng của mảng hai chiều");
        int row= scanner.nextInt();
        System.out.println("Nhập vào số cột của mảng hai chiều");
        int col=scanner.nextInt();

        int[][] inputArray=new int[row][col];

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.printf("Nhập giá trị phần tử [%d][%d]\n",i,j);

                inputArray[i][j]= scanner.nextInt();
            }
        }

        System.out.println("\nMảng vừa nhập là");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(inputArray[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.println("Các phần tử nằm trên đường chéo chính là");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (i==j){
                    System.out.print(inputArray[i][j]+"  ");
                }

            }

        }

    }
}
