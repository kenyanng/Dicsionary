package sample;
import java.io.IOException;
import java.util.List;
public class Main {
    public static void main (String[] args) throws IOException {
        DictionaryCommandline moi = new DictionaryCommandline();
        moi.dictionaryBasic();
        moi.dictionaryAdvanced();
        moi.showAllWord();
    }
}
