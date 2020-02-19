package com.irinakolbun;

public class FootballTeam {
    private String teamName;
    //private int[][] scores = new int[10][2];
    private int teamTotalScore = 0;

    FootballTeam(String inputData) {
        parseData(inputData);

    }

    private void parseData(String inputData) {
        String[] data = inputData.split(",");
        this.teamName = data[0];
        for (int i = 1; i < data.length; i++) {
            String[] score = data[i].split(":");
            int teamScore = Integer.parseInt(score[0]);
            int opponentScore = Integer.parseInt(score[0]);
            if(teamScore > opponentScore)
                teamTotalScore += 3;

            else if(teamScore == opponentScore)
                teamTotalScore += 1;

        }
    }
}
