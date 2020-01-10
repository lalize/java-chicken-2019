package view;

import domain.Menu;
import domain.Order;
import domain.Quantity;
import domain.Table;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDER = "└ W ┘";

    public static void printMainScreen() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        for (final Table table : tables) {
            printBottomLine(table);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printOrders(final Collection<Order> orders) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (final Order order : orders) {
            System.out.println(order);
        }
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(Table table) {
        if (table.hasOrder()) {
            System.out.print(BOTTOM_LINE_ORDER);
        } else {
            System.out.print(BOTTOM_LINE);
        }
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
