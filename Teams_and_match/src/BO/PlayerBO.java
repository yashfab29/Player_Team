package BO;

import beans.Player;

public class PlayerBO {
	
	
	public  Player createPlayer(String data)
	{
		String details[]=data.split(",");
		Player player=new Player(details[0] , details[1] , details[2]);
		return player;
	}

}
