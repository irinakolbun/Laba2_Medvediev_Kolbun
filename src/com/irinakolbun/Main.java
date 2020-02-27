package com.irinakolbun;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = getPathToDirectory();
        FileParser parser = new FileParser(path);
        ArrayList<FootballTeam> footballTeams = parser.getFootballTeamsFromFile();

        String text = getFinalScoresTable(footballTeams);
        writeResultsFile(text);
    }

    private static String getPathToDirectory() {
        Scanner scanPath = new Scanner(System.in);
        System.out.print("Enter the path to your directory: ");
        String pathStr = scanPath.nextLine();
        scanPath.close();
        return pathStr;
    }

    private static String getFinalScoresTable(ArrayList<FootballTeam> teams) {
        teams = FootballTeam.sortTeamsArray(teams);
        StringBuilder outputText = new StringBuilder("Rating table: \n");
        for (int i = 0; i < teams.size(); i++) {
            outputText.append(i + 1).append(" place: ").append(teams.get(i).getTeamName()).append(" with score ").append(teams.get(i).getTeamTotalScore()).append("\n");
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
