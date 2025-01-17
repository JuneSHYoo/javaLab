package javaPJ;

import java.util.*;

public class ExerciseManager {
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseManager() {
        initializeDefaultExercises();
    }

    private void initializeDefaultExercises() {
        exercises.add(new Exercise("런닝", 30, 300, "2025-01-15"));
        exercises.add(new Exercise("자전거", 45, 400, "2025-01-16"));
        exercises.add(new Exercise("요가", 60, 200, "2025-01-17"));
        exercises.add(new Exercise("수영", 40, 350, "2025-01-16"));
        exercises.add(new Exercise("프리웨이트", 50, 500, "2025-01-15"));
    }

    public void addExercise(Scanner scanner) {
        System.out.print("운동 이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("운동 시간(분)을 입력하세요: ");
        int exerciseTime = scanner.nextInt();

        System.out.print("소모 칼로리를 입력하세요: ");
        int exerciseEnergy = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("운동 날짜를 입력하세요 (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getExerciseDate().equals(date)) {
                System.out.println("같은 날짜에 같은 운동 이름이 이미 등록되어 있습니다. 변경이 필요하다면 수정해주세요.");
                return;
            }
        }

        Exercise exercise = new Exercise(name, exerciseTime, exerciseEnergy, date);
        exercises.add(exercise);
        System.out.println("운동이 성공적으로 등록되었습니다: " + exercise);
    }

    public void listExercises() {
        if (exercises.isEmpty()) {
            System.out.println("등록된 운동이 없습니다.");
            return;
        }

        System.out.println("=== 운동 목록 ===");
        exercises.forEach(System.out::println);
    }

    public void listExercisesByDate(Scanner scanner) {
        System.out.print("운동 날짜를 입력하세요 (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        boolean found = false;
        int totalTime = 0;
        int toalEnergy = 0;

        System.out.println("=== " + date + " 운동 요약 ===");
        for (Exercise exercise : exercises) {
            if (exercise.getExerciseDate().equals(date)) {
                System.out.println(exercise);
                totalTime += exercise.getExerciseTime();
                toalEnergy += exercise.getExerciseEnergy();
                found = true;
            }
        }

        if (found) {
            System.out.println("--- 요약 ---");
            System.out.printf("총 운동 시간: %d분\n", totalTime);
            System.out.printf("총 소모 칼로리: %d\n", toalEnergy);
        } else {
            System.out.println("해당 날짜에 등록된 운동이 없습니다.");
        }
    }

    public void updateExercise(Scanner scanner) {
        System.out.print("수정할 운동 이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("수정할 운동 날짜를 입력하세요 (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getExerciseDate().equals(date)) {
                System.out.print("새 운동 시간(분)을 입력하세요: ");
                int newTime = scanner.nextInt();

                System.out.print("새 소모 칼로리를 입력하세요: ");
                int newEnergy = scanner.nextInt();
                scanner.nextLine();

                exercise.setExerciseTime(newEnergy);
                exercise.setExerciseEnergy(newEnergy);
                System.out.println("운동 정보가 성공적으로 수정되었습니다: " + exercise);
                return;
            }
        }

        System.out.println("해당 운동이 등록되어 있지 않습니다.");
    }

    public void deleteExercise(Scanner scanner) {
        System.out.print("삭제할 운동 이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("삭제할 운동 날짜를 입력하세요 (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Iterator<Exercise> iterator = exercises.iterator();
        while (iterator.hasNext()) {
            Exercise exercise = iterator.next();
            if (exercise.getName().equals(name) && exercise.getExerciseDate().equals(date)) {
                iterator.remove();
                System.out.println(name + " 운동이 성공적으로 삭제되었습니다.");
                return;
            }
        }

        System.out.println("해당 운동이 등록되어 있지 않습니다.");
    }
}