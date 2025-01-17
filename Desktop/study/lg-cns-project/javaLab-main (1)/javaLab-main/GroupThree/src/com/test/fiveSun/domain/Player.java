package com.test.fiveSun.domain;

import java.time.LocalDate;

public class Player {
    private String name;        // 이름
    private String position;    // 포지션
    /*
        투수: 1
        포수: 2
        내야수: 3
        외야수: 4
     */
    private int positionNum;    // 포지션 넘버
    /*
        투수: 1
        포수: 2
        1루수: 3
        2루수: 4
        3루수: 5
        유격수: 6
        좌익수: 7
        중견수: 8
        우익수: 9
        지명타자: 10
     */
    private int lineUpNum;      // 라인업 넘버
    private boolean isLineUp;   // 라인업 포함 여부

    public Player(String name, String position, int positionNum, int lineUpNum, boolean isLineUp) {
        this.name = name;
        this.position = position;
        this.positionNum = positionNum;
        this.lineUpNum = lineUpNum;
        this.isLineUp = isLineUp;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPositionNum() {
        return positionNum;
    }

    public int getLineUpNum() {
        return lineUpNum;
    }

    public boolean isLineUp() {
        return isLineUp;
    }

    public void setLineUpNum(int lineUpNum) {
        this.lineUpNum = lineUpNum;
    }

    public void setLineUp(boolean lineUp) {
        isLineUp = lineUp;
    }

    @Override
    public String toString() {
        return "[" + position + ": " + name + "]";
    }
}
