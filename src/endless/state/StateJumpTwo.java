package endless.state;

import endless.character.Character;
import endless.model.Game;

public class StateJumpTwo extends State{

	public StateJumpTwo(Character player) {
		super(player);
	}

	@Override
	public void pressJump() {
	}

	@Override
	public void pressCrawl() {
	}
	
	@Override
	public void update() {
		float t = (System.currentTimeMillis() - player.getJumpTime()) / 1000.0f;
		player.setY((int) (player.getJumpY() + player.getJumpSpeed() * t + 0.5f * Game.GRAVITY * t * t));
		
		if(player.getY() <= 0 && !player.getIsFloor()){
			StateDrop dop = new StateDrop(player);
			player.setState(dop);
		}
		else if(player.getY() <= 0 && player.getIsFloor()){
			player.setY(0);
			StateNormal nor = new StateNormal(player);
			player.setState(nor);
		}
	}

}
