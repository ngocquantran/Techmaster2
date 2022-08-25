import javax.imageio.IIOException;
import java.io.*;

public class Main {
    public static void main(String[] args) {
//        BufferedReader reader=new BufferedReader(new InputStreamReader((System.in)));
//        System.out.println("Enter your name: ");
//
//        try {
//            String name=reader.readLine();
//            System.out.println("Your name is: "+name);
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }

        String dirPath = "C:/Study/IT/Others/05. F8/thuchanh/HTML_CSS/vocabme/front_end/asset/img_backup/word_thumb";
        File dir = new File(dirPath);
        String[] files = dir.list();
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (String aFile : files) {
                System.out.println(aFile);
            }
        }

        System.out.println("-----------------------");
        File[] medias = dir.listFiles();
        if (medias.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (File aFile : medias) {
                System.out.println(aFile.getName() + " - " + aFile.getAbsolutePath());
            }
        }

        FilenameFilter mp3Filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        };



        File[] media2=dir.listFiles(mp3Filter);
        if (media2.length==0){
            System.out.println("Không có file đuôi mp3 trong thư mục");
        } else {
            for (File aFile : media2) {
                System.out.println(aFile.getName() + " - " + aFile.getAbsolutePath());
            }
        }

        System.out.println("++++++++++++++++++++++++++");
        String dirPath2 = "C:/Study/IT/Others/05. F8/thuchanh/HTML_CSS/vocabme/front_end/asset";
        File dir2=new File(dirPath2);
        File[] directs=dir2.listFiles();
        if (directs!=null && directs.length>0){
            for (File file:directs){
                if (file.isDirectory()){
                    System.out.println("["+file.getName()+"]");
                }else {
                    System.out.println(file.getName());
                }
            }
        }



    }
}
