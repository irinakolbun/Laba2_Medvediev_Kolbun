package com.irinakolbun;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String csvFilePath = "inputs/file1.csv";
        FileParser parser = new FileParser(csvFilePath);
        FootballTeam[] footballTeams = parser.getFootballTeamsFromFile();

        String text = getFinalScoresTable(footballTeams);
        writeResultsFile(text);
    }

    private static String getFinalScoresTable(FootballTeam[] teams) {
        teams = FootballTeam.sortTeamsArray(teams);
        String outputText = "Rating table: \n";
        for (int i = 0; i < teams.length; i++) {
            outputText += (i + 1) + " place: " + teams[i].getTeamName() + " with score " + teams[i].getTeamTotalScore() + "\n";
        }
        return outputText;
    }

    private static void writeResultsFile(String text) throws IOException {
        File file = new File("outputs/results.csv");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }

}
