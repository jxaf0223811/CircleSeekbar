package test.io.feeeei.circleseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.android.incallui.CircleSeekBar;

public class InflateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CircleSeekBar(this));
    }
}
