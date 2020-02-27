package com.irinakolbun;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = getPathToFile();
        FileParser parser = new FileParser(path);
        FootballTeam[] footballTeams = parser.getFootballTeamsFromFile();

        String text = getFinalScoresTable(footballTeams);
        writeResultsFile(text);
    }

    private static String getPathToFile() {
        Scanner scanPath = new Scanner(System.in);
        System.out.print("Enter the path to your file: ");
        String pathStr = scanPath.nextLine();
        scanPath.close();
        return pathStr;
    }

    private static String getFinalScoresTable(FootballTeam[] teams) {
        teams = FootballTeam.sortTeamsArray(teams);
        StringBuilder outputText = new StringBuilder("Rating table: \n");
        for (int i = 0; i < teams.length; i++) {
            outputText.append(i + 1).append(" place: ").append(teams[i].getTeamName()).append(" with score ").append(teams[i].getTeamTotalScore()).append("\n");
        }
        return outputText.toString();
    }

    private static void writeResultsFile(String text) throws IOException {
        File file = new File("outputs/results.csv");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }

}
