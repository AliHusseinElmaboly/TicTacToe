package twins.game.activities;


import twins.game.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
public class option extends Activity implements OnClickListener{
	
	String [] colors;
	Spinner s1;
	Spinner s2;
	Spinner s3;
	Spinner s4;

	public static final int red=0;
	public static final int blue=1;
	public static final int green=2;
	public static final int yellow=3;
	public static final int black=4;
	public static final int white=5;
	public static int Ocolor=blue;
	public static int Xcolor=green;
	public static int bkcolor=red;
	public static int lcolor=white;
	public static int prev_Ocolor=blue;
	public static int prev_Xcolor=green;
	public static int prev_bkcolor=red;
	public static int prev_lcolor=white;
	public static boolean option;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	
	     setContentView(R.layout.option);
	     intializeUI();
			View cancel = findViewById(R.id.cancel);
			cancel.setOnClickListener(this);
			View ok = findViewById(R.id.ok);
			ok.setOnClickListener(this);
			
	}

	private void intializeUI() {
	colors=getResources().getStringArray(R.array.string_array);
	 s1=(Spinner)findViewById(R.id.spinner1);
	intializeSpinner(s1);
	 s2=(Spinner)findViewById(R.id.spinner2);
	intializeSpinner(s2);
	 s3=(Spinner)findViewById(R.id.spinner3);
	intializeSpinner(s3);
     s4=(Spinner)findViewById(R.id.spinner4);
	intializeSpinner(s4);

	}
	

	private void intializeSpinner( final Spinner s) {
		//ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,colors);
		ArrayAdapter<CharSequence>  adapter = ArrayAdapter.createFromResource(this,R.array.string_array, android.R.layout.simple_spinner_item);
		//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		s.setAdapter(adapter);
		if(s==s1)
		s.setSelection(prev_bkcolor);
		else if(s==s2)
			s.setSelection(prev_lcolor);
		else if(s==s3)
			s.setSelection(prev_Ocolor);
		else if	(s==s4)
			s.setSelection(prev_Xcolor);
		
		s.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				int index=arg0.getSelectedItemPosition();
				
				Toast.makeText(getBaseContext(),"you select :"+colors[index],
				Toast.LENGTH_SHORT).show();
				
				if(s==s1){
					if(index==red){
						
						bkcolor=red;
					}
					else if(index==blue){
						bkcolor=blue;
					}
					else if(index==green){
						bkcolor=green;
					}
					else if(index==yellow){
						bkcolor=yellow;
					}
					else if(index==black){
						bkcolor=black;
					}

					else if(index==white){
						bkcolor=white;
					}
				}
				else  if(s==s2){
					
						if(index==red){
							
							
							lcolor=red;
			
						}
						else if(index==blue){
							lcolor=blue;
						}
						else if(index==green){
							lcolor=green;
						}
						else if(index==yellow){
							lcolor=yellow;
						}
						else if(index==black){
							lcolor=black;
						}

						else if(index==white){
							lcolor=white;
						}
					}
				
				else  if(s==s3){
					if(index==red){
						
						Ocolor=red;
					}
					else if(index==blue){
						Ocolor=blue;
					}
					else if(index==green){
						Ocolor=green;
					}
					else if(index==yellow){
						Ocolor=yellow;
					}
					else if(index==black){
						Ocolor=black;
					}

					else if(index==white){
						Ocolor=white;
					}
					
				}
				else if(s==s4){
					if(index==red){
						
						Xcolor=red;
					}
					else if(index==blue){
						Xcolor=blue;
					}
					else if(index==green){
						Xcolor=green;
					
					}
					else if(index==yellow){
						Xcolor=yellow;
					}
					else if(index==black){
						Xcolor=black;
					}

					else if(index==white){
						Xcolor=white;
					}
					
				}
				
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ok: {
			 prev_Ocolor=Ocolor;
			 prev_Xcolor=Xcolor;
			 prev_bkcolor=bkcolor;
			prev_lcolor=lcolor;
			
			
		}
		
		case R.id.cancel:{
		 Ocolor=prev_Ocolor;
		 Xcolor=prev_Xcolor;
		 bkcolor=prev_bkcolor;
		 lcolor=prev_lcolor;
		}
		
	}
		if(option)
			startActivity(new Intent(this,TicTacToe.class));
			else
				startActivity(new Intent(this,Game.class));
	}
	
}
