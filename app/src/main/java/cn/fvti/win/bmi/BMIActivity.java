package cn.fvti.win.bmi;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class BMIActivity extends Activity {
	final static int ABOUT = Menu.FIRST;
	final static int END = Menu.FIRST + 1;

	EditText high, weight;
	Button bmi;
	RadioButton man, woman;
	float numberHigh = 0;
	float numberWeight = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		high = (EditText) findViewById(R.id.editTextHigh);
		weight = (EditText) findViewById(R.id.editTextWeight);
		man = (RadioButton) findViewById(R.id.radioButtonMan);
		woman = (RadioButton) findViewById(R.id.radioButtonWoman);
		bmi = (Button) findViewById(R.id.buttonBmi);
		bmi.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if ("".equals(high.getText().toString())
						|| "".equals(weight.getText().toString())) {
					Toast.makeText(getBaseContext(), "身高体重不能为空！请重新输入！",
							Toast.LENGTH_SHORT).show();

				} else {
					Intent i = new Intent(getBaseContext(),
							ResultActivity.class);
					numberHigh = Float.parseFloat(high.getText().toString());
					numberWeight = Float
							.parseFloat(weight.getText().toString());
					i.putExtra("high", numberHigh);
					i.putExtra("weight", numberWeight);
					if (man.isChecked()) {
						i.putExtra("sex", man.getText());
					} else if (woman.isChecked()) {
						i.putExtra("sex", woman.getText());
					}
					startActivity(i);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// MenuInflater inflater = getMenuInflater();
		// inflater.inflate(R.menu.bmi_menu, menu);
		menu.add(0, R.id.new_input, 0, "重新载入");
		menu.add(0, ABOUT, 0, "关于");
		menu.add(0, END, 0, "结束");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.new_input:
			high.setText("");
			weight.setText("");
			break;
		case ABOUT:
			showDialog(0);
			break;
		case END:
			finish();
			break;
		default:
			break;
		}

		return true;

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		return new AlertDialog.Builder(this).setTitle("关于BMI程序")
				.setMessage("这是Win的android程序")
				.setPositiveButton("确认", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface arg0, int arg1) {

					}
				})
				.setNegativeButton("返回", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {

					}
				}).create();
	}
}