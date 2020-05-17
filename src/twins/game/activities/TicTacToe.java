package twins.game.activities;

import twins.game.R;
import twins.game.models.TicTacToeModel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class TicTacToe extends Activity implements OnClickListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Help.help=true;
		option.option=true;
		View newGameButton = findViewById(R.id.new_game_button);
		newGameButton.setOnClickListener(this);
		View optionsButton = findViewById(R.id.options_button);
		optionsButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.help_button);
		aboutButton.setOnClickListener(this);
	}
@Override
protected void onResume() {
	
	super.onResume();

	Help.help=true;
	option.option=true;
}
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.new_game_button: 
			startActivity(new Intent(this, Choose.class));
			break;
		case R.id.options_button: 
			startActivity(new Intent(this,option.class));
			break;
		case R.id.help_button: 
			startActivity(new Intent(this, Help.class));
			break;
		default:
			break;
		}
	}

}