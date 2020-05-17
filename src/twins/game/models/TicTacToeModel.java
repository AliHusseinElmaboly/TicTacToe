package twins.game.models;

import java.util.Arrays;
import java.util.Random;

public class TicTacToeModel {
	private static TicTacToeModel instance;

	private TicTacToeModel() {
	}

	public static synchronized TicTacToeModel getInstance() {
		if (instance == null)
			instance = new TicTacToeModel();
		return instance;
	}

	public static final int EMPTY = 0;
	public static final int O= 1;
	public static final int X= 2;

	public static final int STATE_NONE = 3;
	public static final int STATE_TIE = 4;
	public static final int STATE_WIN = 5;

	public static final int EASY_DIF = 6;
	public static final int MEDIUM_DIF = 7;
	public static final int HARD_DIF = 8;
	
	public static final int ONE_PLAYER=9;
	public static final int TWO_PLAYER=10;
	
	public static final int turnX=11;
	public static final int turnO=12;
	
	public static final int ORed=13;
	public static final int OBlue=14;
	public static final int OGreen=15;
	
	public static final int XRed=16;
	public static final int XBlue=17;
	public static final int XGreen=18;
	
	private static int[][] gameField = new int[3][3];

	
	//default settings
	
	private int turn=turnX;
	private int playerChoice=ONE_PLAYER;
	private int state = STATE_NONE;
	private int winner = EMPTY;
	private int difficulty = HARD_DIF;

	private int humanScore;
	private int droidScore;
	private int TieScore;
	
	public void clearField() {
		for (int i = 0; i < 3; i++) { 
			Arrays.fill(gameField[i], EMPTY);
		}
		winner = EMPTY;
	}

	private boolean isWinner(int element) {
		return /* horizontal */
		       (gameField[0][0] == element && gameField[0][1] == element && gameField[0][2] == element)
				|| (gameField[1][0] == element && gameField[1][1] == element && gameField[1][2] == element)
				|| (gameField[2][0] == element && gameField[2][1] == element && gameField[2][2] == element)
				/* vertical */
				|| (gameField[0][0] == element && gameField[1][0] == element && gameField[2][0] == element)
				|| (gameField[0][1] == element && gameField[1][1] == element && gameField[2][1] == element)
				|| (gameField[0][2] == element && gameField[1][2] == element && gameField[2][2] == element)
				/* diagonal */
				|| (gameField[0][0] == element && gameField[1][1] == element && gameField[2][2] == element)
				|| (gameField[0][2] == element && gameField[1][1] == element && gameField[2][0] == element);
	}

	private boolean isTie() {
		boolean isTie = state != STATE_WIN;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				isTie = isTie && (gameField[i][j] != EMPTY);
		return isTie;
	}

	private boolean doWinOrBlockMove(int element) {
		// horizontal 1st line
		if (gameField[0][0] == EMPTY && gameField[0][1] == element && gameField[0][2] == element) {
			gameField[0][0] = O;
			return true;
		}
		if (gameField[0][0] == element && gameField[0][1] == EMPTY && gameField[0][2] == element) {
			gameField[0][1] = O	;
			return true;
		}
		if (gameField[0][0] == element && gameField[0][1] == element && gameField[0][2] == EMPTY) {
			gameField[0][2] = O;
			return true;
		}
		// horizontal 2nd line
		if (gameField[1][0] == EMPTY && gameField[1][1] == element && gameField[1][2] == element) {
			gameField[1][0] =O;
			return true;
		}
		if (gameField[1][0] == element && gameField[1][1] == EMPTY && gameField[1][2] == element) {
			gameField[1][1] = O;
			return true;
		}
		if (gameField[1][0] == element && gameField[1][1] == element && gameField[1][2] == EMPTY) {
			gameField[1][2] = O;
			return true;
		}
		// horizontal 3rd line
		if (gameField[2][0] == EMPTY && gameField[2][1] == element && gameField[2][2] == element) {
			gameField[2][0] = O;
			return true;
		}
		if (gameField[2][0] == element && gameField[2][1] == EMPTY && gameField[2][2] == element) {
			gameField[2][1] = O;
			return true;
		}
		if (gameField[2][0] == element && gameField[2][1] == element && gameField[2][2] == EMPTY) {
			gameField[2][2] =O;
			return true; 
		}
		
		// vertical 1st line
		if (gameField[0][0] == EMPTY && gameField[1][0] == element && gameField[2][0] == element) {
			gameField[0][0] = O;
			return true;
		}
		if (gameField[0][0] == element && gameField[1][0] == EMPTY && gameField[2][0] == element) {
			gameField[1][0] = O;
			return true;
		}
		if (gameField[0][0] == element && gameField[1][0] == element && gameField[2][0] == EMPTY) {
			gameField[2][0] = O;
			return true;
		}
		// vertical 2nd line
		if (gameField[0][1] == EMPTY && gameField[1][1] == element && gameField[2][1] == element) {
			gameField[0][1] = O;
			return true;
		}
		if (gameField[0][1] == element && gameField[1][1] == EMPTY && gameField[2][1] == element) {
			gameField[1][1] = O;
			return true;
		}
		if (gameField[0][1] == element && gameField[1][1] == element && gameField[2][1] == EMPTY) {
			gameField[2][1] = O;
			return true;
		}
		// vertical 3rd line
		if (gameField[0][2] == EMPTY && gameField[1][2] == element && gameField[2][2] == element) {
			gameField[0][2] = O;
			return true;
		}
		if (gameField[0][2] == element && gameField[1][2] == EMPTY && gameField[2][2] == element) {
			gameField[1][2] = O;
			return true;
		}
		if (gameField[0][2] == element && gameField[1][2] == element && gameField[2][2] == EMPTY) {
			gameField[2][2] =O;
			return true;
		}
		
		// 1st diagonal 
		if (gameField[0][0] == EMPTY && gameField[1][1] == element && gameField[2][2] == element) {
			gameField[0][0] = O;
		return true;
		}
		if (gameField[0][0] == element && gameField[1][1] == EMPTY && gameField[2][2] == element) {
			gameField[1][1] = O;
			return true;
		}
		if (gameField[0][0] == element && gameField[1][1] == element && gameField[2][2] == EMPTY) {
			gameField[2][2] = O;
			return true;
		}
		// 2nd diagonal 
		if (gameField[0][2] == EMPTY && gameField[1][1] == element && gameField[2][0] == element) {
			gameField[0][2] = O;
			return true;
		}
		if (gameField[0][2] == element && gameField[1][1] == EMPTY && gameField[2][0] == element) {
			gameField[1][1] = O;
			return true;
		}
		if (gameField[0][2] == element && gameField[1][1] == element && gameField[2][0] == EMPTY) {
			gameField[2][0] = O;
			return true;
		}
		return false;
	}
	
	private boolean isDoneWinMove() {
		return doWinOrBlockMove(O);
	}

	private boolean isDoneBlockMove() {
		return doWinOrBlockMove(X);
	}

	private int doOptimalMove() {
		if (gameField[1][1] == EMPTY) { 
			gameField[1][1] = O;
			return 0;
		} else {
			//check corner 
			if (gameField[0][0] == EMPTY) {
				gameField[0][0] = O;
				return 0;
			}
			if (gameField[0][2] == EMPTY) {
				gameField[0][2] = O;
				return 0;
			}
			if (gameField[2][0] == EMPTY) {
				gameField[2][0] = O;
				return 0;
			}
			if (gameField[2][2] == EMPTY) {
				gameField[2][2] = O;
				return 0;
			}
			/* check middles */
			if (gameField[0][1] == EMPTY) {
				gameField[0][1] = O;
				return 0;
			}
			if (gameField[1][2] == EMPTY) {
				gameField[1][2] = O;
				return 0;
			}
			if (gameField[1][0] == EMPTY) {
				gameField[1][0] = O;
				return 0;
			}
			if (gameField[2][1] == EMPTY) {
				gameField[2][1] = O;
				return 0;
			}
		}
		return 0;
	}

	private void doSmartMove() {
		if (!isDoneWinMove())
			if (!isDoneBlockMove())
				doOptimalMove();
	}

	private void doStupidMove() {
		int emptyCells = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (gameField[x][y] == EMPTY)
					emptyCells++;
			}
		} 

		if (emptyCells > 0) {
			int numberOfCell = new Random().nextInt(emptyCells) + 1;
			emptyCells = 0;
			for (int x = 0; x < 3 && emptyCells < numberOfCell; x++) 
				for (int y = 0; y < 3 && emptyCells < numberOfCell; y++) 
					if (gameField[x][y] == EMPTY) {
						emptyCells++;
						if (numberOfCell == emptyCells)
							gameField[x][y] = O;
					}
		}
	}

	private void doAutoMove() {
		switch (difficulty) {
		case EASY_DIF:
			doStupidMove();
			break;
		case MEDIUM_DIF:
			if (new Random().nextBoolean())
				doStupidMove();
			else
				doSmartMove();
			break;
		case HARD_DIF:
			doSmartMove();
			break;
		}
		analyzeState();
	}

	private void analyzeState() {
		if (isWinner(O)) {
			state = STATE_WIN;
			winner = O;
			droidScore++;
		} else if (isWinner(X)) {
			state = STATE_WIN;
			winner = X;
			humanScore++;
		} else if (isTie()) {
			state = STATE_TIE;
			winner = EMPTY;
			TieScore++;
		} else {
			state = STATE_NONE;
			winner = EMPTY;
		}
	}

	public int getWinner() {
		return winner;
	}

	public int getState() {
		return state;
	}

	public void Move_One(int x, int y) {
		if (x < 3 && y < 3)
			if (gameField[x][y] == EMPTY) {
				gameField[x][y] = X;
				analyzeState();
				if (getState() == STATE_NONE)
					doAutoMove();
			}
	}
	public void Move_Two(int x, int y) {
		if (x < 3 && y < 3)
			if (gameField[x][y] == EMPTY) {
				
				if(turn==turnX)
					gameField[x][y] = X;
				else if(turn==turnO)
					gameField[x][y] = O;
				analyzeState();
				switchUser();
		
			}
	}
	public int[][] getGameField() {
		return gameField;
	}

	public void newRound() {
		clearField();
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public int getHumanScore() {
		return humanScore;
	}
	
	public int getDroidScore() {
		return droidScore;
	}
	public int getTileScore() {
		return TieScore;
	}
	public void setPlayerChoice(int playerChoice) {
		this.playerChoice = playerChoice;
	}
	public int getPlayerChoice() {
		return playerChoice;
	}
	
	public void newGame() {
		humanScore = 0;
		droidScore = 0;
		TieScore = 0;
		clearField();
	}
	public void clearScore(){
		humanScore = 0;
		droidScore = 0;
		TieScore = 0;
	}

	public void switchUser() {
		if(turn==turnX)
			turn=turnO;
		else
			turn=turnX;
		
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
}
