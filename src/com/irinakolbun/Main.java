package com.irinakolbun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
