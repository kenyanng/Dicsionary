package sample;

import java.io.*;
import java.util.Scanner;


public class demo {
    public  void  main  (String[] args ) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fi = new FileInputStream("C:\\Users\\LENOVO\\IdeaProjects\\Dictinary\\base.txt");
        Reader re = new InputStreamReader(fi,"UTF-8");
        Scanner x = new  Scanner(re);
        String target = "";
        String ex = "";
        while (x.hasNext()) {
            String fulltext = x.nextLine();
            int index = fulltext.indexOf(' ');
            int index2 = fulltext.indexOf(' ');
            target = fulltext.substring(0,index);
            ex = fulltext.substring(index);
        }
        System.out.println(target);
        System.out.println(ex);
    }
}