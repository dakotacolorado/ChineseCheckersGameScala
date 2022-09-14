package ChineseCheckersGame.GameState

class GameState(turn: Int, players: List[Player], boardSize: Int) {

  def getGameStateIndex(): String ={
    return players.map(
      (player: Player) => player.positions.map(
        (position: Position) => (position.i + position.j)
      )
  }

}
