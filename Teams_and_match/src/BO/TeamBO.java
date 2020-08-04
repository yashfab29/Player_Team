package BO;

import beans.Player;
import beans.Team;

public class TeamBO {
	
	public Team createTeam(String data, Player[] playerList)
	{
		String details[]=data.split(",");
		Player player=null;
		for(int i=0; i<playerList.length;i++)
		{	
			if(playerList[i].getName().equalsIgnoreCase(details[1]))
			{
				player=playerList[i];
			}
		}
				
		Team team = new Team(details[0] , player);
		return team;
	}

}
