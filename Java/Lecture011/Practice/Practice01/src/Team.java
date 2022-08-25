import java.util.ArrayList;
import java.util.Random;

public class Team {

    public ArrayList<Player> getAllPlayer(){
        ArrayList<Player> players=new ArrayList<>();
        players.add(new Player(1,"Bùi Tấn Trường",Position.GK));
        players.add(new Player(2,"Nguyễn Văn Toản",Position.GK));
        players.add(new Player(3,"Nguyễn Văn Hoàng",Position.GK));
        players.add(new Player(4,"Đỗ Duy Mạnh",Position.DF));
        players.add(new Player(5,"Nguyễn Thành Chung",Position.DF));
        players.add(new Player(6,"Trần Đình Trọng",Position.DF));
        players.add(new Player(7,"Trần Văn Kiên",Position.DF));
        players.add(new Player(8,"Vũ Văn Thanh",Position.DF));
        players.add(new Player(9,"Hồ Tấn Tài",Position.DF));
        players.add(new Player(10,"Nguyễn Quang Hải",Position.MF));
        players.add(new Player(11,"Lương Xuân Trường",Position.MF));
        players.add(new Player(12,"Nguyễn Tuấn Anh",Position.MF));
        players.add(new Player(13,"Trần Minh Vương",Position.MF));
        players.add(new Player(14,"Phan Minh Đức",Position.MF));
        players.add(new Player(15,"Bùi Tấn Trường",Position.MF));
        players.add(new Player(16,"Phạm Tuấn Hải",Position.FW));
        players.add(new Player(17,"Nguyễn Văn Toàn",Position.FW));
        players.add(new Player(18,"Nguyễn Công Phượng",Position.FW));
        players.add(new Player(19,"Hà Đức Chinh",Position.FW));
        players.add(new Player(20,"Nguyễn Xuân Nam",Position.FW));
        return players;

    }

    public void showAll(ArrayList<Player> players){
        for (Player p:players){
            System.out.println(p);
        }
    }

////    public Player getRandomGK(ArrayList<Player> players){
//        Random rd=new Random();
//        int randomIndex=rd.nextInt(players.size());
//        while ()
//        if (players.get(randomIndex).getPosition()==Position.GK){
//            return players.get(randomIndex);
//        }
//        return null;
//    }
    public ArrayList<Player> buildTeam(int df, int mf, int fw,ArrayList<Player> allPlayer){
        ArrayList<Player> choiceTeam=new ArrayList<>();

        int teamNumber= allPlayer.size();

//        Chọn thủ môn
        Random random=new Random();


        int gkNumber=0;
        int dfNumber=0;
        int fwNumber=0;




        while (gkNumber<1){
            int gkrandom=random.nextInt(teamNumber);
            if (allPlayer.get(gkrandom).getPosition()==Position.GK){
                Player choicePlayer=allPlayer.get(gkrandom);
                choiceTeam.add(choicePlayer);
                gkNumber++;
            }
        }

//        Chọn hậu vệ
        while (dfNumber<df){
            int dfRandom= random.nextInt(teamNumber);
            if (allPlayer.get(dfRandom).getPosition()==Position.DF){
                if (!choiceTeam.contains(allPlayer.get(dfRandom))){
                    Player choicePlayer=allPlayer.get(dfRandom);
                    choiceTeam.add(choicePlayer);
                    dfNumber++;
                }
            }
        }

//        Chọn tiền vệ
        int mfNumber=0;
        while (mfNumber<mf){
            int mfRandom= random.nextInt(teamNumber);
            if(allPlayer.get(mfRandom).getPosition()==Position.MF){
                if (!choiceTeam.contains(allPlayer.get(mfRandom))){
                    Player choicePlayer=allPlayer.get(mfRandom);
                    choiceTeam.add(choicePlayer);
                    mfNumber++;
                }
            }
        }

        while (fwNumber<fw){
            int fwRandom=random.nextInt(teamNumber);
            if (allPlayer.get(fwRandom).getPosition()==Position.FW){
                if (!choiceTeam.contains(allPlayer.get(fwRandom))){
                    Player choicePlayer=allPlayer.get(fwRandom);
                    choiceTeam.add(choicePlayer);
                    fwNumber++;
                }
            }
        }




        return choiceTeam;

    }






}
