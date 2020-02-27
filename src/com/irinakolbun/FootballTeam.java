package com.irinakolbun;

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
            int teamScore = Integer.parseInt(score[0]);
            int opponentScore = Integer.parseInt(score[1]);
            if (teamScore > opponentScore)
                this.teamTotalScore += 3;

            else if (teamScore == opponentScore)
                this.teamTotalScore += 1;

        }
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


