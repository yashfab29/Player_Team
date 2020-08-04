package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import BO.MatchBO;
import BO.PlayerBO;
import BO.TeamBO;
import beans.Match;
import beans.Player;
import beans.Team;

public class Program {

	
	public static void main(String[] args)throws IOException {
		String data="";
	
		//Scanner sc=new Scanner(System.in);
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		// Enter player details
		System.out.println("Enter the player count.");
		int player_count=Integer.parseInt(br.readLine());
		Player players[]=new Player[player_count];
		PlayerBO playerDetail=new PlayerBO();
		for(int i=0; i<player_count ;i++)
		{
			System.out.println("Enter Player "+ (i+1) + " details.");
			data=br.readLine();
			players[i]=playerDetail.createPlayer(data);
		}

		// Enter team details
		System.out.println("Enter the team count.");
		int team_count=Integer.parseInt(br.readLine());
		Team teams[]=new Team[team_count];
		TeamBO teamDetail=new TeamBO();
		
		for(int i=0 ; i<team_count ; i++)
		{
			System.out.println("Enter team " + (i+1) + " details.");
			 data=br.readLine();
			teams[i]=teamDetail.createTeam(data, players);
		}
		
		// Enter match details
		System.out.println("Enter the match count.");
		int match_count=Integer.parseInt(br.readLine());;
		Match matches[]=new Match[match_count];
		
		MatchBO matchDetail=new MatchBO();
		
		for(int i=0 ; i<match_count ; i++)
		{
			System.out.println("Enter match " + (i+1) + " details.");
			data=br.readLine();
			matches[i]=matchDetail.createMatch(data, teams);
			
		}
		
		
		//Menu
		String choice;
		do {
			System.out.println("Menu : \n 1) Find Team \n 2) Find All Matches In A Specific Venue \n Type 1 or 2 \n Enter your choice" );
			int ch=Integer.parseInt(br.readLine());;
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter Match date.");
				String date=br.readLine();;
				Team teamList[]=matchDetail.findTeam(date, matches);
				System.out.println(teamList[0].getName() + " , " + teamList[1].getName());
				break;
			case 2: 
				System.out.println("Enter Team name.");
				String teamName=br.readLine();
				matchDetail.findAllMatchesOfTeam(teamName, matches);
				break;
			default:
				System.out.println("Wrong Input");
			}
			
		System.out.println("Do you want to continue? Yes or No.");
		choice=br.readLine();	
		}while(choice.equalsIgnoreCase("yes"));
		
	}

}
