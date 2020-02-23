package com.irinakolbun;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner csvFilePath = new Scanner(System.in);
        System.out.println("Enter the path to your file: ");
        String pathStr = csvFilePath.nextLine();
        System.out.println("The path is: " + pathStr);

        //String csvFilePath = "inputs/file1.csv";
        FileParser parser = new FileParser(pathStr);
        FootballTeam[] footballTeams = parser.getFootballTeamsFromFile();

        String text = getFinalScoresTable(footballTeams);
        writeResultsFile(text);
    }

    /*private static String getPathToFile(Scanner csvFilePath) {
        return csvFilePath.nextLine();
    }*/

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
