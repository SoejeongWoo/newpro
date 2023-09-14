import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    // main 함수는 프로그램의 시작점이다
    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        BufferedWriter writer;
        Scanner scanner = new Scanner(System.in);

        // cout << "*** 영단어 마스터 ***");
        System.out.println("*** 영단어 마스터 ***");
        System.out.println();

        int menuNumber = 1;

        while (menuNumber > 0 && menuNumber < 8) {
            printMenu();

            menuNumber = scanner.nextInt();

            if (menuNumber == 0) { // 나가기
                System.out.println();
                System.out.println("프로그램 종료! 다음에 만나요~");
            } else if (menuNumber == 1) { // 모든 단어 보기
                System.out.println();
                System.out.println("--------------------");
                // 이 사이에?
                List<String> lines = readAllLines();
                for (int i=0; i<lines.size(); i++) {
                    System.out.println(lines.get(i));
                }

                System.out.println("--------------------");
                System.out.println();
            } else if (menuNumber == 4) { // 단어 추가
                // 단어장 만들기
                FileReader fileReader = new FileReader("dictionary.txt");
                reader = new BufferedReader(fileReader);

                List<String> lines = new ArrayList<>();
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    lines.add(line.substring(line.indexOf('*')));
                }

                // 단어 입력받기
                System.out.println();
                System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
                scanner.nextLine(); // 앞에 남아있는 엔터 버리기
                String levelAndWord = scanner.nextLine(); // 난이도 + 단어
                String[] split = levelAndWord.split(" "); // 3 hello => [3, hello]
                int level = Integer.parseInt(split[0]);
                String word = split[1];

                System.out.print("뜻 입력 : ");
                String meaning = scanner.nextLine(); // 뜻

                // 단어장에 단어 추가하기
                String newLine = "";
                for (int i=0; i<level; i++) {
                    newLine += "*";
                }
                newLine += " " + word + " " + meaning;
                lines.add(newLine);

                // 다시 파일에 쓰기
                writer = new BufferedWriter(new FileWriter("dictionary.txt", false));
                for (int i=0; i<lines.size(); i++) {
                    writer.write((i+1) + " " + lines.get(i) + "\n");
                }
                writer.flush(); // 버스 출발

                System.out.println();
                System.out.println("새 단어가 단어장에 추가되었습니다.");
                System.out.println();
            } else if (menuNumber == 6) { // 단어 삭제
                System.out.print("=> 삭제할 단어 검색 : ");
                String keyword = scanner.next();
                List<String> lines = readAllLines();

                writer = new BufferedWriter(new FileWriter("dictionary.txt", false));

                System.out.println("----------------------");
                int number = 1;
                for (int i=0; i<lines.size(); i++) {
                    String line = lines.get(i); // lines[i]
                    if (line.contains(keyword)) { // 삭제할 단어는 화면에는 출력하고, 파일에는 쓰지 않는다
                        System.out.println(line);
                    } else { // 삭제하지 않을 단어는 출력하지 않고, 파일에 쓴다
                        line = line.substring(line.indexOf('*')); // 숫자 자르기
                        writer.write((number++) + " " + line + "\n");
                    }
                }
                System.out.println("----------------------");
                System.out.println();
                writer.flush(); // 버스 출발
            }
        }
    }

    private static List<String> readAllLines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) { // 파일 끝났다
                break;
            }
            lines.add(line);
        }
        return lines;
    }

    private static void printMenu() {
        System.out.println("****************");
        System.out.println("1. 모든 단어 보기"); // => reader
        System.out.println("2. 수준별 단어 보기");
        System.out.println("3. 단어 검색");
        System.out.println("4. 단어 추가"); // => writer
        System.out.println("5. 단어 수정");
        System.out.println("6. 단어 삭제");
        System.out.println("7. 파일 저장");
        System.out.println("0. 나가기");
        System.out.println("****************");
        System.out.print("=> 원하는 메뉴는? ");
    }

}
