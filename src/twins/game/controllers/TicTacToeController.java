package twins.game.controllers;


import twins.game.R;
import twins.game.activities.option;
import twins.game.models.TicTacToeModel;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeController {
	
	private static TicTacToeController instance;

	private TicTacToeController() {
	}

	public static synchronized TicTacToeController getInstance() {
		if (instance == null)
			instance = new TicTacToeController();
		return instance;
	} 

	private static TicTacToeModel model = TicTacToeModel.getInstance();

	private Button[] buttons;
	private TextView humanScore;
	private TextView droidScore;
	private TextView tieScore;
	private TextView turn;
	private void drawButton(Button btn, int state) {
     setBackgroundColor(btn,option.bkcolor);
    
		if ( TicTacToeModel.O == state){
			setColor(btn,option.Ocolor);
			btn.setText("O");
		}
		else if (TicTacToeModel.X == state)
		{
			setColor(btn,option.Xcolor);
			btn.setText("X");
		
		}
		else
			btn.setText("");
	}
	private void setBackgroundColor(Button btn,int color) {
		
		switch(color){
		case option.red:{
	        btn.setBackgroundResource(R.drawable.red);

		}break;
		case option.blue:{
			btn.setBackgroundResource(R.drawable.blue);
		}break;
		case option.green:{
			btn.setBackgroundResource(R.drawable.green);
		}break;
		case option.yellow:{
			btn.setBackgroundResource(R.drawable.yellow);
		}break;
		case option.black:{
			btn.setBackgroundResource(R.drawable.black);
		}break;
		
		case option.white:{
			btn.setBackgroundResource(R.drawable.white);
		}break;
		}
		
		
		
	}
	
	private void setColor(Button btn,int color) {
		
		switch(color){
		
		case option.red:{
			btn.setTextColor(Color.RED);
		}break;
		case option.blue:{
			btn.setTextColor(Color.BLUE);
		}break;
		case option.green:{
			btn.setTextColor(Color.GREEN);
		}break;
		case option.yellow:{
			btn.setTextColor(Color.YELLOW);
		}break;
		case option.black:{
			btn.setTextColor(Color.BLACK);
		}break;
	
		case option.white:{
			btn.setTextColor(Color.WHITE);
		}break;
		
		}
		
		
		
	}

	public void refreshGame() {
		
		for (int i = 0; i < buttons.length; i++)
		{
			drawButton(buttons[i], model.getGameField()[i / 3][i % 3]);
			
		}
		humanScore.setText(model.getHumanScore()+"");
		droidScore.setText(model.getDroidScore()+"");
		tieScore.setText(model.getTileScore()+"");
		if(model.getTurn()==model.turnX)
			turn.setText("X");
		else if(model.getTurn()==model.turnO)
			turn.setText("O");
			
	}

	public void setButtons(Button[] buttons) {
		this.buttons = buttons;
	}

	public void setScores(TextView humanScore, TextView droidScore,TextView tieScore) {
		this.humanScore = humanScore;
		this.droidScore = droidScore;
		this.tieScore = tieScore;
	}

	public void setTurn(TextView turn) {
		this.turn=turn;
		
	}

}
