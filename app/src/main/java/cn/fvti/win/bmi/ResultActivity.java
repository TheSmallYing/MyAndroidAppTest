package cn.fvti.win.bmi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {
	TextView highTextView, weightTextView;
	TextView result;
	TextView tishi;
	Button fanhui;

	@SuppressLint("ShowToast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		highTextView = (TextView) findViewById(R.id.textViewresultHigh);
		weightTextView = (TextView) findViewById(R.id.textViewresultweight);
		result = (TextView) findViewById(R.id.textViewresult);
		tishi = (TextView) findViewById(R.id.textView5);
		fanhui = (Button) findViewById(R.id.fanhui);

		float h, w, bmi;
		String sex;
		sex = getIntent().getStringExtra("sex");
		h = getIntent().getFloatExtra("high", 0);
		w = getIntent().getFloatExtra("weight", 0);
		bmi = w / (h / 100 * h / 100);

		if ("男".equals(sex)) {
			if (bmi < 20) {
				tishi.setText("您的体重过轻，请注意营养");
			} else if (bmi < 25) {
				tishi.setText("您的身材太好了！羡慕啊！");
			} else if (bmi < 30) {
				tishi.setText("您的 体重略重，请注意饮食");
			} else if (bmi < 35) {
				tishi.setText("您的 体重较重，请适当减肥");
			} else if (bmi > 35) {
				tishi.setText("您过于肥胖，请向医生请教减肥方法");
			}
		} else if ("女".equals(sex)) {
			if (bmi < 19) {
				tishi.setText("您的体重过轻，请注意营养");
			} else if (bmi < 24) {
				tishi.setText("您的身材太好了！羡慕啊！");
			} else if (bmi < 29) {
				tishi.setText("您的 体重略重，请注意饮食");
			} else if (bmi < 34) {
				tishi.setText("您的 体重较重，请适当减肥");
			} else if (bmi > 34) {
				tishi.setText("您过于肥胖，请向医生请教减肥方法");
			}
		} else {
			tishi.setText("性别未选择");
		}
		highTextView.setText(((Float) h).toString());
		weightTextView.setText(((Float) w).toString());
		result.setText("Your BMI is :" + bmi);

		fanhui.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				finish();
			}
		});
	}
}
