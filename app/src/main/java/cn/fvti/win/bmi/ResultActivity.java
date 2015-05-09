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

		if ("��".equals(sex)) {
			if (bmi < 20) {
				tishi.setText("�������ع��ᣬ��ע��Ӫ��");
			} else if (bmi < 25) {
				tishi.setText("�������̫���ˣ���Ľ����");
			} else if (bmi < 30) {
				tishi.setText("���� �������أ���ע����ʳ");
			} else if (bmi < 35) {
				tishi.setText("���� ���ؽ��أ����ʵ�����");
			} else if (bmi > 35) {
				tishi.setText("�����ڷ��֣�����ҽ����̼��ʷ���");
			}
		} else if ("Ů".equals(sex)) {
			if (bmi < 19) {
				tishi.setText("�������ع��ᣬ��ע��Ӫ��");
			} else if (bmi < 24) {
				tishi.setText("�������̫���ˣ���Ľ����");
			} else if (bmi < 29) {
				tishi.setText("���� �������أ���ע����ʳ");
			} else if (bmi < 34) {
				tishi.setText("���� ���ؽ��أ����ʵ�����");
			} else if (bmi > 34) {
				tishi.setText("�����ڷ��֣�����ҽ����̼��ʷ���");
			}
		} else {
			tishi.setText("�Ա�δѡ��");
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
