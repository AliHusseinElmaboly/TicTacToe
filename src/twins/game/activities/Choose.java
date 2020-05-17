package twins.game.activities;
import twins.game.R;
import twins.game.models.TicTacToeModel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class Choose extends Activity implements OnClickListener {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choice);
		
		View continueGameButton = findViewById(R.id.single_button);
		continueGameButton.setOnClickListener(this);
		View newGameButton = findViewById(R.id.two_button);
		newGameButton.setOnClickListener(this);
		

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.single_button: 
			TicTacToeModel.getInstance().newGame();
			TicTacToeModel.getInstance().setPlayerChoice(TicTacToeModel.ONE_PLAYER);
			startActivity(new Intent(this, Setting.class));
			break;
		case R.id.two_button: 
			TicTacToeModel.getInstance().newGame();
			TicTacToeModel.getInstance().setPlayerChoice(TicTacToeModel.TWO_PLAYER);
			startActivity(new Intent(this, Game.class));
			break;
		
		default:
			break;
		}
	}
	
		
	
	

}
