package com.irinakolbun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
    File file;
    FileParser(String filePath){
        file = new File(filePath);
    }

    public FootballTeam [] getFootballTeamsFromFile() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(this.file);
        int numberOfTeams = fileScanner.nextInt();

        FootballTeam [] teams = new FootballTeam[numberOfTeams];
        for(int i=0;i<numberOfTeams;i++)
            teams[i] = new FootballTeam(fileScanner.nextLine());

        return teams;
    }


}
