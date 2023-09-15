import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PrintInOut {

    // 저장
    void save(List<Word> words) throws IOException;

    // 불러오기
    List<Word> load() throws IOException;

}