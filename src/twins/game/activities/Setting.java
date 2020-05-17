package twins.game.activities;

import twins.game.R;
import twins.game.models.TicTacToeModel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class Setting extends Activity {

	private void initButton() {
		Button start = (Button)findViewById(R.id.next);
		start.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goNext();
				
			}

		
		});
		RadioButton easy = (RadioButton) findViewById(R.id.easy_radiobutton);
		easy.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.EASY_DIF);
			}
		});
		
		RadioButton medium = (RadioButton) findViewById(R.id.medium_radiobutton);
		medium.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.MEDIUM_DIF);
			}
		});
		
		RadioButton hard = (RadioButton) findViewById(R.id.hard_radiobutton);
		hard.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.HARD_DIF);
			}
		});
		
		switch (TicTacToeModel.getInstance().getDifficulty()) {
		case TicTacToeModel.EASY_DIF:
			easy.setChecked(true);
			break;
		case TicTacToeModel.MEDIUM_DIF:
			medium.setChecked(true);
			break;
		case TicTacToeModel.HARD_DIF:
			hard.setChecked(true);
			break;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		initButton();
	}

	private void goNext() {
		startActivity(new Intent(this,Game.class));
		
	}
}
