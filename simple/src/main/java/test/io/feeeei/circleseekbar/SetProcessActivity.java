package test.io.feeeei.circleseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.incallui.CircleSeekBar;

public class SetProcessActivity extends AppCompatActivity implements CircleSeekBar.OnSeekBarChangeListener {

    private CircleSeekBar mSeekbar;
    private TextView mProgressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_process);

        mProgressText = (TextView) findViewById(R.id.progress_text);
        mSeekbar = (CircleSeekBar) findViewById(R.id.seekbar);
        mSeekbar.setOnSeekBarChangeListener(this);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int process = mSeekbar.getCurProcess();
                mSeekbar.setCurProcess(process += 10);
            }
        });
    }

    @Override
    public void onChanged(CircleSeekBar seekbar, int curValue) {
        mProgressText.setText("" + curValue);
    }
}
