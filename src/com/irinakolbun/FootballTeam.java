package com.irinakolbun;

public class FootballTeam {
    private String teamName;
    //private int[][] scores = new int[10][2];
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
            int teamScore = Integer.parseInt(score[0]);
            int opponentScore = Integer.parseInt(score[0]);
            if (teamScore > opponentScore)
                teamTotalScore += 3;

            else if (teamScore == opponentScore)
                teamTotalScore += 1;

        }
    }

    public static FootballTeam[] sortTeamsArray(FootballTeam[] teams) {
        for (int i = 0; i < teams.length - 1; i++) {
            for (int j = i + 1; j < teams.length; j++){
                if(teams[i].getTeamTotalScore() < teams[j].getTeamTotalScore()){
                    FootballTeam deltaTeam = teams[i];
                    teams[i] = teams[j];
                    teams[j] = deltaTeam;
                }
            }
        }
        return teams;
    }
}
