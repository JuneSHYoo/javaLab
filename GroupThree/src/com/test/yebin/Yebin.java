import java.util.Scanner;

public class Yebin {

    public static void printMenu(String name) {
        System.out.println("┌───────────────────────┐");
        System.out.printf("│ name : %s               \n", name);
        System.out.println("│ menu                  ");
        System.out.println("│ 1. 게임 시작         ");
        System.out.println("│ 2. 내 기록          ");
        System.out.println("│ 3. 랭킹            ");
        System.out.println("│ 4. 내 기록 삭제   ");
        System.out.println("│ 5. 유저 삭제        ");
        System.out.println("│ 0. 나가기               ");
        System.out.println("└───────────────────────┘");
    }

    public static void getName() {
        System.out.print("플레이어 이름을 입력하세요 : ");

    }

    public void start() {
        Game game = new Game();
        ScoreManager scoreManager = new ScoreManager();
        String name;
        Scanner scanner = new Scanner(System.in);


        getName();
        name = scanner.nextLine();

        while(true) {
            printMenu(name);
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    Game.gameStart();
                    int priorHighScore = scoreManager.getUserHighScore(name);
                    if (priorHighScore < Game.score) {
                        System.out.println("high record!");
                    }
                    System.out.println("Score: " + Game.score);

                    scoreManager.addScore(new Score(name, Game.score));
                    break;
                case 2:
                    scoreManager.getUserScores(name);
                    break;
                case 3:
                    scoreManager.getRank();
                    break;
                case 4:
                    scoreManager.deleteScore(name);
                    break;
                case 5:
                    scoreManager.deleteUser(name);
                    break;
                case 0:
                    System.out.println("게임을 종료합니다.");
                    scanner.close();
                    return;
            }
        }

    }
}
