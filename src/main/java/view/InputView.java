package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputFunctionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return SCANNER.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return SCANNER.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return SCANNER.nextInt();
    }

    public static int inputQuantityOfMenu() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return SCANNER.nextInt();
    }

    public static int inputPaymentNumber(final int number) {
        System.out.println("## " + number + "번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return SCANNER.nextInt();
    }
}
