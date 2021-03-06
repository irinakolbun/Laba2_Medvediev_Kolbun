package com.irinakolbun;
import java.util.Arrays;

import java.util.ArrayList;

public class FootballTeam {
    private String teamName;
    private int teamTotalScore = 0;

    FootballTeam(String inputData) {
        parseData(inputData);
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamTotalScore() {
        return teamTotalScore;
    }

    private void parseData(String inputData) {
        String[] data = inputData.split(",");
        this.teamName = data[0];
        for (int i = 1; i < data.length; i++) {
            String[] score = data[i].split(":");

            float teamScore = strToFloat(score[0]);
            float opponentScore = strToFloat(score[1]);
            if (teamScore > opponentScore)
                this.teamTotalScore += 3;

            else if (teamScore == opponentScore)
                this.teamTotalScore += 1;

        }
    }


    private float strToFloat(String line){
        float result = 0;
        String[] curNum = line.split("\\.");
       // System.out.println(curNum.length);
        if (curNum.length == 1) {
            result = Integer.parseInt(line);
        }
        else{
            float num = 0;
            float power = (float) Math.pow(10, curNum[1].length());
            num = Integer.parseInt(curNum[1]);
            num = num/power;
            result += Integer.parseInt(curNum[0]) + num;
        }
        return result;
    }



    public static ArrayList<FootballTeam> sortTeamsArray(ArrayList<FootballTeam> teams) {
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                if (teams.get(i).getTeamTotalScore() < teams.get(j).getTeamTotalScore()) {
                    FootballTeam deltaTeam = teams.get(i);
                    teams.set(i, teams.get(j));
                    teams.set(j, deltaTeam);
                }
            }
        }
        return teams;
    }
}


