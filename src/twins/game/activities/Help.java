package twins.game.activities;

import twins.game.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Help extends Activity implements OnClickListener {
	private Button btnBack;
	public static boolean help;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
	
		btnBack=(Button) findViewById(R.id.backHelp);
		btnBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		if(help)
		startActivity(new Intent(this,TicTacToe.class));
		else
			startActivity(new Intent(this,Game.class));
	}


	
}
