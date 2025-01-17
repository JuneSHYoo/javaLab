package javaPJ;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exercise {
    private String name;  // 운동 이름
    private int exerciseTime; // 운동 소요시간
    private int exerciseEnergy; // 운동 소모 칼로리
    private String exerciseDate; // Format: YYYY-MM-DD
}