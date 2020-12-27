package tr.cobanse.batak.server.game.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tr.cobanse.batak.common.Player;
import tr.cobanse.batak.server.game.GameRoom;
import tr.cobanse.batak.server.game.HumanPlayer;
import tr.cobanse.batak.server.util.JsonUtil;

class CardDistributeServiceImplTest {

	private static final Integer STARTING_CARD_SIZE = 13;
	private CardDistributeServiceImpl cardDistributeService = new CardDistributeServiceImpl();
	
	@Test
	void distributeCards() {
		GameRoom gameRoom = new GameRoom("b7a5b3c6-6407-448e-9cbd-7cfcc3294896");
		gameRoom.registerPlayer(new HumanPlayer("1"));
		gameRoom.registerPlayer(new HumanPlayer("2"));
		gameRoom.registerPlayer(new HumanPlayer("3"));
		gameRoom.registerPlayer(new HumanPlayer("4"));
		cardDistributeService.distributeCards(gameRoom);
		for (Player player : gameRoom.getPlayers()) {
			//System.out.println(JsonUtil.toJson(player));
			System.out.println(player.cardSize());
		}
		assertEquals(gameRoom.getPlayers().get(0).cardSize(), STARTING_CARD_SIZE);
		assertEquals(gameRoom.getPlayers().get(1).cardSize(), STARTING_CARD_SIZE);
		assertEquals(gameRoom.getPlayers().get(2).cardSize(), STARTING_CARD_SIZE);
		assertEquals(gameRoom.getPlayers().get(3).cardSize(), STARTING_CARD_SIZE);
	}

}
