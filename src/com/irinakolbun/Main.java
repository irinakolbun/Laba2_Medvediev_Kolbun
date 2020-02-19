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
         FootballTeam [] footballTeams = parser.getFootballTeamsFromFile();

    }

    private String getFinalScoresTable(FootballTeam [] teams){
        teams = FootballTeam.sortTeamsArray(teams);
        return "Kukusiki";
    }

}
