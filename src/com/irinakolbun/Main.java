package com.irinakolbun;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        return pathStr;
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
