import java.util.Scanner;

public class MultiArray {
    public static void createArray() {
        int[][] arr = new int[3][2];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;
        arr[2][0] = 5;
        arr[2][1] = 6;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng của mảng hai chiều");
        int row = scanner.nextInt();
        System.out.println("Nhập số cột của mảng hai chiều");
        int col = scanner.nextInt();

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập giá trị phần tử [%d][%d]", i, j);
                System.out.println();
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng vừa nhập là");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Đường chéo chính là");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    System.out.print(arr[i][j] + "\t");
                }
            }

        }

    }
}
