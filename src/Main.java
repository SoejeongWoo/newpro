import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        BufferedWriter writer;

        System.out.println("*** 영단어 마스터 ***");
        System.out.println();

        int input = 1;
        while (input > 0 && input < 8) {
            printMenu();

            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
            if (input == 0) { // 나가기
                System.out.println();
                System.out.println("프로그램 종료! 다음에 만나요~");
            } else if (input == 1) { // 모든 단어 보기
                reader = new BufferedReader(new FileReader("dictionary.txt"));

                System.out.println();
                System.out.println("--------------------");
                // 이 사이에?
                while (true) {
                    String line = reader.readLine();
                    if (line == null) { // 파일 끝났다
                        break;
                    }
                    System.out.println(line);
                }
                System.out.println("--------------------");
                System.out.println();
            } else if (input == 4) { // 단어 추가
                // 단어장 만들기
                reader = new BufferedReader(new FileReader("dictionary.txt"));
                List<String> lines = new ArrayList<>();
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    lines.add(line);
                }

                // 단어 입력받기
                System.out.println();
                System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
                scanner.nextLine(); // 앞에 남아있는 엔터 버리기
                String levelAndWord = scanner.nextLine(); // 난이도 + 단어

                System.out.print("뜻 입력 : ");
                String meaning = scanner.nextLine(); // 뜻

                // 단어장에 단어 추가하기
                lines.add(levelAndWord + " " + meaning);

                // TODO 정렬하기

                // 다시 파일에 쓰기
                writer = new BufferedWriter(new FileWriter("dictionary.txt", false));
                for (int i=0; i<lines.size(); i++) {
                    writer.write(lines.get(i) + "\n");
                }
                writer.flush(); // 버스 출발

                System.out.println();
                System.out.println("새 단어가 단어장에 추가되었습니다.");
                System.out.println();
            }
        }

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