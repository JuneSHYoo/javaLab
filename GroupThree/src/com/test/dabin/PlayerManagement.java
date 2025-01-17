
import java.util.*;

public class PlayerManagement {
    //선수 정보
    private Map<String,Player> players = new HashMap<>(); //Key: 팀명_등번호

    public void initializePlayers() {
        // 초기 데이터 추가
        addPlayerDirectly("LG트윈스", new Player("홍창기", "LG트윈스", "RF", 51));
        addPlayerDirectly("LG트윈스", new Player("박해민", "LG트윈스", "MF", 17));
        addPlayerDirectly("LG트윈스", new Player("문성주", "LG트윈스", "LF", 8));
        addPlayerDirectly("LG트윈스", new Player("김현수", "LG트윈스", "LF", 22));
        addPlayerDirectly("LG트윈스", new Player("문보경", "LG트윈스", "3B", 2));
        addPlayerDirectly("LG트윈스", new Player("신민재", "LG트윈스", "2B", 4));
        addPlayerDirectly("LG트윈스", new Player("구본혁", "LG트윈스", "2B", 6));
        addPlayerDirectly("LG트윈스", new Player("이영빈", "LG트윈스", "SS", 7));
        addPlayerDirectly("LG트윈스", new Player("오지환", "LG트윈스", "SS", 10));
        addPlayerDirectly("LG트윈스", new Player("오스틴", "LG트윈스", "1B", 23));
        addPlayerDirectly("LG트윈스", new Player("박동원", "LG트윈스", "C", 27));
        addPlayerDirectly("LG트윈스", new Player("임찬규", "LG트윈스", "P", 1));
        addPlayerDirectly("LG트윈스", new Player("정우영", "LG트윈스", "P", 18));
        addPlayerDirectly("LG트윈스", new Player("유영찬", "LG트윈스", "P", 54));
        addPlayerDirectly("LG트윈스", new Player("백승현", "LG트윈스", "P", 61));
        addPlayerDirectly("LG트윈스", new Player("박명근", "LG트윈스", "P", 39));
        System.out.println("==== 초기 데이터 저장 완료 ====");
    }
    private void addPlayerDirectly(String team, Player player) {
        String key = team + "_" + player.getNumber();
        players.put(key, player);
    }

    //선수 등록
    public void addPlayer(Scanner scanner) {
        System.out.print("팀명을 입력하세요: ");
        String team = scanner.nextLine();

        System.out.print("선수 이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("포지션을 입력하세요: ");
        String position = scanner.nextLine();

        System.out.print("선수 등번호를 입력하세요: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        //객체 생성
        Player player = new Player(name, team, position, number);

        String key=team+"_"+player.getNumber();
        if (players.containsKey(key)) {
            System.out.printf("%s 팀의 등번호 %d 선수는 이미 등록되어 있습니다.\n", team,player.getNumber());
            return;
        }

        players.put(key,player);
        System.out.println("선수가 정상적으로 등록되었습니다: "+ player);

    }

    //전체 선수 명단 조회
    public void listPlayers() {
        if(players.isEmpty()) {
            System.out.println("등록된 선수가 없습니다.");
            return;
        }
        players.values().forEach(System.out::println);

    }



    //선수 검색 - 이름으로 검색
    public void searchPlayers(Scanner scanner) {
        System.out.print("검색할 선수 이름을 입력하세요: ");
        String keyword = scanner.nextLine().trim();
        boolean found=false;

        for (Player player :players.values()) {
            if(player.getName().contains(keyword)) {
                System.out.println(player);
                found=true;
            }
        }

        if (!found) {
            System.out.printf("'%s'와 일치하는 선수를 찾을 수 없습니다.\n", keyword);

        }

    }

    //선수 삭제 - 키값 '팀명_등번호'로 삭제
    public void deletePlayer(Scanner scanner ) {
        System.out.print("삭제할 선수의 팀명을 입력하세요: ");
        String team = scanner.nextLine().trim();

        System.out.print("삭제할 선수의 등번호를 입력하세요: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        String key=team+"_"+number;

        if(players.containsKey(key)) {
            players.remove(key);
            System.out.printf("%s 팀의 등번호 %d 선수를 삭제했습니다.\n", team,number);
        }else {
            System.out.printf("%s 팀의 등번호 %d 선수는 등록되어 있지 않습니다.\n",team,number);

        }

    }


}

