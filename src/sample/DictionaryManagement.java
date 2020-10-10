package sample;
import java.io.*;
import java.util.List;
import  java.util.Scanner;

public  class DictionaryManagement extends Dictionary {
    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so n :");
        int n = sc.nextInt();
        Scanner sv = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String target = sv.nextLine();
            String explain = sv.nextLine();
            Word newWord = new Word(target, explain);
            dic.add(newWord);
        }
    }

    public static void insertFromFile() throws IOException,
            FileNotFoundException, UnsupportedEncodingException {
        FileInputStream file = new FileInputStream("C:\\Users\\LENOVO\\IdeaProjects\\Dictinary\\base.txt");
        Reader re = new InputStreamReader(file, "UTF-8");
        Scanner x = new Scanner(re);
        String target = "";
        String explain = "";
        while (x.hasNext()) {
            String fulltext = x.nextLine();
            int index = fulltext.indexOf(' ');
            target = fulltext.substring(0, index).trim();
            explain = fulltext.substring(index).trim();
            Word newWord = new Word(target, explain);
            dic.add(newWord);
        }
        x.close();
    }

    public void dictionaryLookup(String target) throws IOException {
        int index = 0;
        for (int i = 0; i < dic.size(); i++) {
            if (dic.get(i).word_target.equals(target)) {
                System.out.println("giai nghia " + dic.get(i).word_explain);
                index++;
            }
        }
        if (index == 0) {
            System.out.println("Not Find!!!");
        }
    }

    public void add() {
        Scanner sv = new Scanner(System.in);
        String target = sv.nextLine();
        String explain = sv.nextLine();
        Word newWord = new Word(target, explain);
        dic.add(newWord);

    }

    public void remove(String target) {
        for (int i = 0; i < dic.size(); i++) {
            if (dic.get(i).word_target.equals(target)) {
                dic.remove(i);
            }
        }
    }

    public void edit(String target) {
        Scanner sv = new Scanner(System.in);
        for (int i = 0; i < dic.size(); i++) {
            if (dic.get(i).word_target.equals(target)) {
                System.out.print("EDIT Target : ");
                String newtarget = sv.nextLine();
                dic.get(i).word_target = newtarget;
                System.out.print("EDIT Explain : ");
                String newexplain = sv.nextLine();
                dic.get(i).word_explain = newexplain;
            }
        }
    }

    public void dictionaryExportToFile() throws IOException {
       FileOutputStream  file = new
                FileOutputStream("C:\\Users\\LENOVO\\IdeaProjects\\Dictinary\\NewDictionary.txt");
        System.out.println("No\t\t|English\t\t|Vietnamese");
        String str;
        for (int i = 0; i < dic.size(); i++) {
            str = dic.get(i).getword() + "\n" ;
            byte[] strfile = str.getBytes();
           file.write(strfile);
        }
        file.close();
    }
}

