package tw.edu.pu.s1071486.trafficlight;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        setContentView(R.layout.activity_main);
    }
    public void StartGame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity.class);
        EditText A = (EditText) findViewById(R.id.btnA);
        it.putExtra("A", A.getText().toString());
        EditText B = (EditText) findViewById(R.id.btnB);
        it.putExtra("B", B.getText().toString());
        EditText C = (EditText) findViewById(R.id.btnC);
        it.putExtra("C", C.getText().toString());
        if(A.getText().toString().matches("0")||B.getText().toString().matches("0")||C.getText().toString().matches("0")) {
            Toast.makeText(this, "燈號的秒數不能為0",Toast.LENGTH_LONG).show();
        } else if(A.getText().toString().matches("")||B.getText().toString().matches("")||C.getText().toString().matches("0")) {
            Toast.makeText(this, "燈號的秒數不能為空白",Toast.LENGTH_LONG).show();
        }
        else {
            startActivity(it);
            finish();
        }
    }

    public void EndApp(View v){
        finish();
    }

}
