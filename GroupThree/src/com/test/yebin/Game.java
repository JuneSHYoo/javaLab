import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static int[][] board = new int[4][4];
    private static List<Integer> newBlockSize = new LinkedList<>();
    private static List<position> emptySpaces = new LinkedList<>();
    public static int score = 0;

    private static void printBoard() {
        System.out.println("┌──────────────────────────┐");
        System.out.printf("│ Score: %5d             │\n", score);
        for (int row = 0; row < 4; row++) {
            System.out.print("│ ");
            for (int col = 0; col < 4; col++) {
                System.out.printf("%5d ", board[row][col]);
            }
            System.out.println(" │");
        }
        System.out.println("└──────────────────────────┘");
    }

    public static void gameStart() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = 0;
            }
        }
        int row = (int) (Math.random() * 4);
        int col = (int) (Math.random() * 4);
        board[row][col] = 2;
        newBlockSize.add(2);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            printBoard();
            System.out.print("움직일 방향을 입력하세요 ( L R U D ): ");
            input = scanner.nextLine();

            switch (input.trim().toLowerCase()) {
                case "u":
                    up();
                    if (isEnd()) {
                        System.out.println("GAME OVER");
                        return;
                    }
                    break;
                case "d":
                    down();
                    if (isEnd()) {
                        System.out.println("GAME OVER");
                        return;
                    }
                    break;
                case "l":
                    left();
                    if (isEnd()) {
                        System.out.println("GAME OVER");
                        return;
                    }
                    break;
                case "r":
                    right();
                    if (isEnd()) {
                        System.out.println("GAME OVER");
                        return;
                    }
                    break;
                case "exit":
                    System.out.println("GAME OVER");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.");
            }
            scoreManege();
        }
    }

    private static void getEmptySpace() {
        emptySpaces.clear();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == 0) {
                    emptySpaces.add(new position(row, col));
                }
            }
        }
    }

    private static void scoreManege() {
        if (score > 500 && newBlockSize.size() < 2) {
            newBlockSize.add(4);
        }
        if (score > 1500 && newBlockSize.size() < 3) {
            newBlockSize.add(8);
        }
        if (score > 3000 && newBlockSize.size() < 4) {
            newBlockSize.add(16);
        }
    }

    public int getScore() {
        return score;
    }

    private static boolean isEnd() {
        getEmptySpace();
        if (emptySpaces.isEmpty()) {
            return true;
        } else {
            int newBlockPosition = (int) (Math.random() * emptySpaces.size());
            position newPos = emptySpaces.get(newBlockPosition);
            int randomSize = (int) (Math.random() * newBlockSize.size());
            int newSize = newBlockSize.get(randomSize);

            board[newPos.row][newPos.col] = newSize;

            return false;
        }
    }

    private static void up() {
        int[][] tempBoard = new int[4][4];
        int[] y_idx = new int[4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (y == 3)
                    tempBoard[y_idx[x]][x] = board[y][x];
                else if (board[y][x] != 0) {
                    int y2 = y + 1;
                    while (y2 < 4 && board[y2][x] == 0) {
                        y2++;
                    }
                    if (y2 < 4 && board[y][x] == board[y2][x]) {
                        board[y2][x] = 0;
                        tempBoard[y_idx[x]][x] = board[y][x] * 2;
                        score += board[y][x] * 2;
                        y_idx[x]++;
                    }
                    else {
                        tempBoard[y_idx[x]][x] = board[y][x];
                        y_idx[x]++;
                    }
                }
            }
        }
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                board[y][x] = tempBoard[y][x];
            }
        }
    }

    private static void down() {
        int[][] tempBoard = new int[4][4];
        int[] y_idx = new int[4];
        for (int y = 0; y < 4; y++)
            y_idx[y] = 3;

        for (int y = 3; y >= 0; y--) {
            for (int x = 0; x < 4; x++) {
                if (y == 0)
                    tempBoard[y_idx[x]][x] = board[y][x];
                else if (board[y][x] != 0) {
                    int y2 = y - 1;
                    while (y2 >= 0 && board[y2][x] == 0) {
                        y2--;
                    }
                    if (y2 >= 0 && board[y][x] == board[y2][x]) {
                        board[y2][x] = 0;
                        tempBoard[y_idx[x]][x] = board[y][x] * 2;
                        y_idx[x]--;
                        score += board[y][x] * 2;
                    }
                    else {
                        tempBoard[y_idx[x]][x] = board[y][x];
                        y_idx[x]--;
                    }
                }
            }
        }
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                board[y][x] = tempBoard[y][x];
            }
        }
    }

    private static void left() {
        int[][] tempBoard = new int[4][4];
        int[] x_idx = new int[4];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (x == 3)
                    tempBoard[y][x_idx[y]] = board[y][x];
                else if (board[y][x] != 0) {
                    int x2 = x + 1;
                    while (x2 < 4 && board[y][x2] == 0) {
                        x2++;
                    }
                    if (x2 < 4 && board[y][x] == board[y][x2]) {
                        board[y][x2] = 0;
                        tempBoard[y][x_idx[y]] = board[y][x] * 2;
                        x_idx[y]++;
                        score += board[y][x] * 2;
                    }
                    else {
                        tempBoard[y][x_idx[y]] = board[y][x];
                        x_idx[y]++;
                    }
                }
            }
        }
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                board[y][x] = tempBoard[y][x];
            }
        }
    }

    private static void right() {
        int[][] tempBoard = new int[4][4];
        int[] x_idx = new int[4];
        for (int x = 0; x < 4; x++)
            x_idx[x] = 3;

        for (int y = 0; y < 4; y++) {
            for (int x = 3; x >= 0; x--) {
                if (x == 0)
                    tempBoard[y][x_idx[y]] = board[y][x];
                else if (board[y][x] != 0) {
                    int x2 = x - 1;
                    while (x2 >= 0 && board[y][x2] == 0) {
                        x2--;
                    }
                    if (x2 >= 0 && board[y][x] == board[y][x2]) {
                        board[y][x2] = 0;
                        tempBoard[y][x_idx[y]] = board[y][x] * 2;
                        x_idx[y]--;
                        score += board[y][x] * 2;
                    }
                    else {
                        tempBoard[y][x_idx[y]] = board[y][x];
                        x_idx[y]--;
                    }
                }
            }
        }
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                board[y][x] = tempBoard[y][x];
            }
        }
    }
}
