package com.example.atm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<Button> buttons = new ArrayList<>();
    private TextView TV_passwdShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init some properties
        init();

        // set listener event
        View.OnClickListener listener = view -> {
            String showText = TV_passwdShow.getText().toString();

            switch (view.getId()) {
                case R.id.BTN_0:
                    showText += "0";
                    break;
                case R.id.BTN_1:
                    showText += "1";
                    break;
                case R.id.BTN_2:
                    showText += "2";
                    break;
                case R.id.BTN_3:
                    showText += "3";
                    break;
                case R.id.BTN_4:
                    showText += "4";
                    break;
                case R.id.BTN_5:
                    showText += "5";
                    break;
                case R.id.BTN_6:
                    showText += "6";
                    break;
                case R.id.BTN_7:
                    showText += "7";
                    break;
                case R.id.BTN_8:
                    showText += "8";
                    break;
                case R.id.BTN_9:
                    showText += "9";
                    break;
                case R.id.BTN_clear:
                    showText = "";
                    break;
                case R.id.BTN_confirm:
                    String currentPasswd = TV_passwdShow.getText().toString();
                    String message;

                    if (currentPasswd.equals("123456"))
                        message = "密碼正確";
                    else
                        message = "密碼錯誤";

                    Toast toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
                    toast.show();
                    showText = "";
                    break;
                case R.id.BTN_exit:
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("確認視窗");
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setMessage("確定要結束應用程式嗎?");
                    dialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                    break;
            }

            // check length
            if (showText.length() > 10)
                return;

            TV_passwdShow.setText(showText);
        };

        // set onClickButton listener
        for (Button button : buttons) {
            button.setOnClickListener(listener);
        }
    }

    private void init() {
        // init buttons
        this.buttons.add(findViewById(R.id.BTN_0));
        this.buttons.add(findViewById(R.id.BTN_1));
        this.buttons.add(findViewById(R.id.BTN_2));
        this.buttons.add(findViewById(R.id.BTN_3));
        this.buttons.add(findViewById(R.id.BTN_4));
        this.buttons.add(findViewById(R.id.BTN_5));
        this.buttons.add(findViewById(R.id.BTN_6));
        this.buttons.add(findViewById(R.id.BTN_7));
        this.buttons.add(findViewById(R.id.BTN_8));
        this.buttons.add(findViewById(R.id.BTN_9));
        this.buttons.add(findViewById(R.id.BTN_clear));
        this.buttons.add(findViewById(R.id.BTN_confirm));
        this.buttons.add(findViewById(R.id.BTN_exit));

        // init passwd show
        this.TV_passwdShow = findViewById(R.id.TV_passwdShow);
    }
}