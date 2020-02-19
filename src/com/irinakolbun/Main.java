package com.irinakolbun;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String csvFilePath = "inputs/file1.csv";
        FileParser parser = new FileParser(csvFilePath);
        FootballTeam[] footballTeams = parser.getFootballTeamsFromFile();
        String text = getFinalScoresTable(footballTeams);
        System.out.println(text);
    }

    private static String getFinalScoresTable(FootballTeam[] teams) {
        teams = FootballTeam.sortTeamsArray(teams);
        String outputText = "Rating table: \n";
        for (int i = 0; i < teams.length; i++) {
            outputText += (i + 1) + " place: " + teams[i].getTeamName() + " with score " + teams[i].getTeamTotalScore() + "\n";
        }
        return outputText;
    }

}
