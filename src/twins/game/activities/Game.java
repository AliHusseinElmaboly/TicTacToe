package twins.game.activities;

import twins.game.R;
import twins.game.controllers.TicTacToeController;
import twins.game.models.TicTacToeModel;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener {

	private static TicTacToeModel model = TicTacToeModel.getInstance();
	private static TicTacToeController controller = TicTacToeController.getInstance();

	private Button[] buttons;
	private TableLayout lines;
	
	private void initListeners() {
		buttons = new Button[9];
		buttons[0] = (Button) findViewById(R.id.cell00);
		buttons[1] = (Button) findViewById(R.id.cell01);
		buttons[2] = (Button) findViewById(R.id.cell02);
		buttons[3] = (Button) findViewById(R.id.cell10);
		buttons[4] = (Button) findViewById(R.id.cell11);
		buttons[5] = (Button) findViewById(R.id.cell12);
		buttons[6] = (Button) findViewById(R.id.cell20);
		buttons[7] = (Button) findViewById(R.id.cell21);
		buttons[8] = (Button) findViewById(R.id.cell22);

		for (Button btn : buttons) {
			btn.setOnClickListener(this);
		}

		findViewById(R.id.human_vs_droid).setOnClickListener(this);
	}

	private void injectionController() {
		
		controller.setButtons(buttons);
		controller.setScores((TextView) findViewById(R.id.human_score),
				(TextView) findViewById(R.id.droid_score),(TextView) findViewById(R.id.tie_score));
		controller.setTurn((TextView) findViewById(R.id.turn));
	}

	private void twoPlayer(Button btn) {
		switch (btn.getId()) {
		case R.id.cell00:
			model.Move_Two(0, 0);
			break;
		case R.id.cell01:
			model.Move_Two(0, 1);
			break;
		case R.id.cell02:
			model.Move_Two(0, 2);
			break;
		case R.id.cell10:
			model.Move_Two(1, 0);
			break;
		case R.id.cell11:
			model.Move_Two(1, 1);
			break;
		case R.id.cell12:
			model.Move_Two(1, 2);
			break;
		case R.id.cell20:
			model.Move_Two(2, 0);
			break;
		case R.id.cell21:
			model.Move_Two(2, 1);
			break;
		case R.id.cell22:
			model.Move_Two(2, 2);
			break;
		}
	}
	private void onePlayer(Button btn) {
		switch (btn.getId()) {
		case R.id.cell00:
			model.Move_One(0, 0);
			break;
		case R.id.cell01:
			model.Move_One(0, 1);
			break;
		case R.id.cell02:
			model.Move_One(0, 2);
			break;
		case R.id.cell10:
			model.Move_One(1, 0);
			break;
		case R.id.cell11:
			model.Move_One(1, 1);
			break;
		case R.id.cell12:
			model.Move_One(1, 2);
			break;
		case R.id.cell20:
			model.Move_One(2, 0);
			break;
		case R.id.cell21:
			model.Move_One(2, 1);
			break;
		case R.id.cell22:
			model.Move_One(2, 2);
			break;
		}
	}

	private void newRound() {
		model.newRound();
		controller.refreshGame();
	}

	private void newGame() { 
		model.newGame();
		controller.refreshGame();
	}

	private void showAlertDialog(int status) {
		new AlertDialog.Builder(this).setTitle(R.string.message_title)
				.setMessage(status).setNeutralButton("Ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dlg, int sumthin) {
								newRound();
							}
						}).show();
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.game);	
		Help.help=false;
		option.option=false;
		initListeners();
		
		injectionController();
	lines=(TableLayout)findViewById(R.id.lines);
		
		controller.refreshGame();
		setlinesColor(option.lcolor);
	} 
	
	public void onClick(View v) {
		if (v instanceof Button) {
			if(model.getPlayerChoice()==model.ONE_PLAYER)
				onePlayer((Button) v);
			else if(model.getPlayerChoice()==model.TWO_PLAYER)
				{
				twoPlayer((Button) v);
				
				}
				
			controller.refreshGame();
			
			if (model.getState() == TicTacToeModel.STATE_TIE)
				showAlertDialog(R.string.Tie_game);
			else if (model.getState() == TicTacToeModel.STATE_WIN) {
				if (model.getWinner() == TicTacToeModel.O)
					{showAlertDialog(R.string.O_win_game);
					model.setTurn(model.turnO);
					}
				else if (model.getWinner() == TicTacToeModel.X)
					{showAlertDialog(R.string.X_win_game);
					model.setTurn(model.turnX);
					}
			}

		} 
	
	}
private void setlinesColor(int color) {
		
		switch(color){
		case option.red:{
		
			lines.setBackgroundColor(Color.RED);
		}break;
		case option.blue:{
			
			lines.setBackgroundColor(Color.BLUE);
		}break;
		case option.green:{
			
			lines.setBackgroundColor(Color.GREEN);
		}break;
		case option.yellow:{
			
			lines.setBackgroundColor(Color.YELLOW);
		}break;
		case option.black:{
			
			lines.setBackgroundColor(Color.BLACK);
		}break;
		case option.white:{
			
			lines.setBackgroundColor(Color.WHITE);
		}break;
		
		}
		
		
		
	}
@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	setlinesColor(option.lcolor);
	controller.refreshGame();
	Help.help=false;
	option.option=false;
}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.newgame:
	           model.clearField();
	       	   controller.refreshGame();
	            return true;
	        case R.id.clearScore:
	        	 model.clearScore();
	       	     controller.refreshGame();
	            return true;
	        case R.id.help:
	        	startActivity(new Intent(this,Help.class));
	            return true;
	        case R.id.options:
	        	startActivity(new Intent(this,option.class));
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_menu, menu);
	    return true;
	}

}
