package com.irinakolbun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {
    File [] files;
    FileParser(String directoryPath){
        File folder = new File(directoryPath);
        files = folder.listFiles();
    }

    public ArrayList<FootballTeam> getFootballTeamsFromFile() throws FileNotFoundException {
        ArrayList<FootballTeam> teams = new ArrayList<>();
        for(int i=0;i<files.length;i++) {
            Scanner fileScanner = new Scanner(this.files[i]);
            int numberOfTeams = Integer.parseInt(fileScanner.nextLine());

            //Loop through the FootballTeam array
            for (int j = 0; j < numberOfTeams; j++)
                teams.add(new FootballTeam(fileScanner.nextLine()));
            fileScanner.close();
        }

        return teams;
    }


}
