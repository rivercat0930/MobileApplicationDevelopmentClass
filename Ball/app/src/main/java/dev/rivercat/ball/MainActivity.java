package dev.rivercat.ball;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CheckBox cbBasketball;
    private CheckBox cbFootball;
    private CheckBox cbBaseball;
    private TextView tvMessage;
    private RadioGroup rgBalls;
    private TextView tvRgMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCheckBox();
        createRg();
    }

    private void createCheckBox() {
        this.cbBasketball = findViewById(R.id.cb_basketball);
        this.cbFootball = findViewById(R.id.cb_football);
        this.cbBaseball = findViewById(R.id.cb_baseball);
        this.tvMessage = findViewById(R.id.tv_message);

        CompoundButton.OnCheckedChangeListener cbListener = (compoundButton, b) -> {
            String message = "最喜歡的球類有：";
            int count = 0;

            if (cbBasketball.isChecked()) {
                message += "籃球 ";
                count++;
            }

            if (cbFootball.isChecked()) {
                message += "足球 ";
                count++;
            }

            if (cbBaseball.isChecked()) {
                message += "棒球 ";
                count++;
            }

            tvMessage.setText(message + " 共 " + count + " 項");
        };

        cbBasketball.setOnCheckedChangeListener(cbListener);
        cbFootball.setOnCheckedChangeListener(cbListener);
        cbBaseball.setOnCheckedChangeListener(cbListener);
    }

    private void createRg() {
        this.rgBalls = findViewById(R.id.rg_ball);
        this.tvRgMessage = findViewById(R.id.tv_rg_message);

        RadioGroup.OnCheckedChangeListener rgListener = (radioGroup, id) -> {
            String message = "3項球類中，最喜歡第";

            switch (id) {
                case R.id.rb_basketball:
                    message += "1項 籃球";
                    break;
                case R.id.rb_football:
                    message += "2項 足球";
                    break;
                case R.id.rb_baseball:
                    message += "3項 棒球";
                    break;
            }

            tvRgMessage.setText(message);
        };

        rgBalls.setOnCheckedChangeListener(rgListener);
    }
}