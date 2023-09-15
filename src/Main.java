import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        List<Word> words = readAllWords(); // 난이도(*), 단어, 뜻

        Scanner scanner = new Scanner(System.in);

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
                for (int i=0; i<words.size(); i++) {
                    System.out.println((i+1) + " " + words.get(i));
                }
                System.out.println("--------------------");
                System.out.println();

            } else if (menuNumber == 4) { // 단어 추가
                // 단어 입력받기
                System.out.println();
                System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
                scanner.nextLine(); // 앞에 남아있는 엔터 버리기
                String levelAndWord = scanner.nextLine(); // 난이도 + 단어
                String[] split = levelAndWord.split(" "); // 3 hello => [3, hello]
                int level = Integer.parseInt(split[0]);
                String wordString = split[1];

                System.out.print("뜻 입력 : ");
                String meaning = scanner.nextLine(); // 뜻

                // 단어장에 단어 추가하기
                Word word = new Word();
                word.meaning = meaning;
                word.word = wordString;
                word.level = level;

                words.add(word);

                System.out.println();
                System.out.println("새 단어가 단어장에 추가되었습니다.");
                System.out.println();
            } else if (menuNumber == 6) { // 단어 삭제
                System.out.print("=> 삭제할 단어 검색 : ");
                String keyword = scanner.next();

                System.out.println("----------------------");
                for (int i=0; i<words.size(); i++) {
                    Word word = words.get(i); // words[i]
                    if (word.word.contains(keyword)) {
                        System.out.println((i+1) + " " + word);
                    }
                }
                System.out.println("----------------------");
                System.out.print("삭제할 번호 선택 : ");
                int number = scanner.nextInt();
                System.out.print("정말로 삭제하실래요?(Y/n) : ");
                String yN = scanner.next();

                if (yN.equalsIgnoreCase("Y")) {
                    // 삭제
                    words.remove(number - 1);
                    System.out.println();
                    System.out.println("선택한 단어 삭제 완료 !!!");
                } else {
                    // 삭제하지 않는다
                    System.out.println();
                    System.out.println("선택한 단어 삭제 취소 !!!");
                }
                System.out.println();
            } else if (menuNumber == 7) { // 단어 저장
                BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"));
                for (int i=0; i<words.size(); i++) {
                    writer.write((i+1) + " " + words.get(i) + "\n");
                }
                writer.flush();
                System.out.println();
                System.out.println("모든 단어 파일 저장 완료 !!!");
                System.out.println();
            }
        }
    }

    private static List<Word> readAllWords() throws IOException {
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
