package BO;

import beans.Match;
import beans.Team;

public class MatchBO {
	
	public Match createMatch(String data, Team[] teamList)
	{
		String details[]=data.split(",");
		Team t1=null;
		Team t2=null;
		for(int i=0; i<teamList.length; i++)
		{
			if(teamList[i].getName().equalsIgnoreCase(details[1]))
				t1=teamList[i];
			else if(teamList[i].getName().equalsIgnoreCase(details[2]))
				t2=teamList[i];	
		}
		Match match=new Match(details[0] , t1 , t2 , details[3]);
		return match;
	}
	
	public Team[] findTeam(String matchDate, Match[] matchList)
	{
		Team team[]=new Team[2];
		for(int i=0; i<matchList.length; i++)
		{
			if(matchList[i].getDate().equalsIgnoreCase(matchDate))
			{
				team[0]=matchList[i].getTeamone();
				team[1]=matchList[i].getTeamtwo();
			}
		}
		return team;
	}
	
	public void findAllMatchesOfTeam(String teamName, Match[] matchList)
	{
		String s=String.format("%-15s %-15s %-15s %s","Date","TeamOne", "TeamTwo", "Venue");
		System.out.println(s);
		for(int i=0 ; i<matchList.length ; i++)
		{
			if( (matchList[i].getTeamone().getName().equals(teamName)) || (matchList[i].getTeamtwo().getName().equals(teamName)) )
			{
				System.out.println(matchList[i]);
			}
		}
	}
}
