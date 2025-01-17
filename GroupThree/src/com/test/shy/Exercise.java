package com.test.shy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exercise {
    private String name;  // 운동 이름
    private int exerciseTime; // 운동 소요시간
    private int exerciseEnergy; // 운동 소모 칼로리
    private String exerciseDate; // Format: YYYY-MM-DD
    
    @Override
    public String toString() {
    	return "[ 운동 종목: " + name + " 운동 시간: " + exerciseTime + " 운동 소모 칼로리: " + exerciseEnergy 
    			+ " 운동 일자: " + exerciseDate + " ]";
    }
}