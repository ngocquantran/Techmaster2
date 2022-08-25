import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Team team=new Team();
    static ArrayList<Player> players=team.getAllPlayer();


    public static void menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("1 - In toàn bộ danh sách cầu thủ");
        System.out.println("2 - Chọn đội hình ngẫu nhiên 1GK - 4DF - 4MF - 2FW");
        System.out.println("3 - Chọn đội hình ngẫu nhiên 1GK - 4DF - 3MF - 3FW");
        System.out.println("4 - Chọn đội hình ngẫu nhiên 1GK - 3DF - 5MF - 2FW");
        System.out.println("0 - Thoát chương trình");
        System.out.println("Lựa chọn của bạn là");

    }

    public static void mainMenu(){
        Scanner scanner=new Scanner(System.in);


        boolean isContinue=true;
        while (isContinue){
            menu();
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Danh tách toàn bộ cầu thủ là");
                    team.showAll(players);
                    break;
                case 2:
                    int df1=4;
                    int mf1=4;
                    int fw1=2;
                    ArrayList<Player> choiceTeam1=team.buildTeam(df1,mf1,fw1,players);
                    team.showAll(choiceTeam1);
                    break;
                case 3:
                    int df2=4;
                    int mf2=3;
                    int fw2=3;
                    ArrayList<Player> choiceTeam2=team.buildTeam(df2,mf2,fw2,players);
                    team.showAll(choiceTeam2);
                    break;
                case 4:
                    int df3=3;
                    int mf3=5;
                    int fw3=2;
                    ArrayList<Player> choiceTeam3=team.buildTeam(df3,mf3,fw3,players);
                    team.showAll(choiceTeam3);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;

            }
        }

    }
}
