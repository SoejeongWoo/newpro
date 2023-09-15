import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePrintInOut implements PrintInOut {

    @Override
    public void save(List<Word> words) throws IOException {
        // 파일에 저장한다
        BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"));
        for (int i=0; i<words.size(); i++) {
            writer.write((i+1) + " " + words.get(i) + "\n");
        }
        writer.flush();
    }

    @Override
    public List<Word> load() throws IOException {
        // 파일에서 읽어온다
        BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
        List<Word> words = new ArrayList<>();
        while (true) {
            String line = reader.readLine(); // ** panda 푸바오
            if (line == null) { // 파일 끝났다
                break;
            }
            line = line.substring(line.indexOf('*'));

            // ** executive 경영 간부, 임원
            int firstSpace = line.indexOf(' ');
            int secondSpace = line.indexOf(' ', firstSpace + 1);

            Word word = new Word();
            word.level = line.substring(0, firstSpace).length();
            word.word = line.substring(firstSpace + 1, secondSpace);
            word.meaning = line.substring(secondSpace + 1);

            words.add(word);
        }
        return words;
    }

}
