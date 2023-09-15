public class MenuPrinter {
    public static void printMenu() {
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

    public static void printBanner() {
        System.out.println("*** 영단어 마스터 ***");
        System.out.println();
    }

    public static void printExitMessage() {
        System.out.println();
        System.out.println("프로그램 종료! 다음에 만나요~");
    }
}
