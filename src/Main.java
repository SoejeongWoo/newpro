import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("*** 영단어 마스터 ***");
        System.out.println();

        int input = 1;

        // 반복
        while (input > 0 && input < 8) {
            System.out.println("****************");
            System.out.println("1. 모든 단어 보기");
            System.out.println("2. 수준별 단어 보기");
            System.out.println("3. 단어 검색");
            System.out.println("4. 단어 추가");
            System.out.println("5. 단어 수정");
            System.out.println("6. 단어 삭제");
            System.out.println("7. 파일 저장");
            System.out.println("0. 나가기");
            System.out.println("****************");
            System.out.print("=> 원하는 메뉴는? ");

            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
            if (input == 0) {
                System.out.println();
                System.out.println("프로그램 종료! 다음에 만나요~");
            }
        }

    }

}