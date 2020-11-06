package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cbCuong, cbTai , cbTien;
    SeekBar sbCuong, sbTai , sbTien;
    ImageButton ibtnPlay;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Display display =
                ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        switch (display.getRotation()) {
//            case Surface.ROTATION_0:
//                break;

            case Surface.ROTATION_90:
                break;

//            case Surface.ROTATION_180:
//                break;

            case Surface.ROTATION_270:
                break;
        }

        AnhXa();
        DisableSeekBar();
        CountDownTimer countDownTimer = new CountDownTimer(60000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 10;
                Random random = new Random();
                int cuong = random.nextInt(number);
                int tai = random.nextInt(number);
                int tien = random.nextInt(number);

                if(sbCuong.getProgress() >= sbCuong.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    //Toast.makeText(MainActivity.this, "Cường thắng mẹ rồi", Toast.LENGTH_SHORT).show();
                    if (cbCuong.isChecked()){
                        Toast.makeText(MainActivity.this, "Quá đã quá đã!", Toast.LENGTH_SHORT).show();
                    }else if (cbTai.isChecked()){
                        Toast.makeText(MainActivity.this, "Không sao game sau làm lại", Toast.LENGTH_SHORT).show();
                    }else if (cbTien.isChecked()){
                        Toast.makeText(MainActivity.this, "Dòng thứ cheat game", Toast.LENGTH_SHORT).show();
                    }
                    EnableCheckBox();
                }
                if(sbTai.getProgress() >= sbTai.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    //Toast.makeText(MainActivity.this, "Tài lồn thắng kìa", Toast.LENGTH_SHORT).show();
                    if (cbTai.isChecked()){
                        Toast.makeText(MainActivity.this, "Sứ giả công lý!", Toast.LENGTH_SHORT).show();
                    }else if (cbCuong.isChecked()){
                        Toast.makeText(MainActivity.this, "Dữ ta dữ ta", Toast.LENGTH_SHORT).show();
                    }else if (cbTien.isChecked()){
                        Toast.makeText(MainActivity.this, "Má chơi game nạp tiền", Toast.LENGTH_SHORT).show();
                    }
                    EnableCheckBox();
                }
                if(sbTien.getProgress() >= sbTien.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    //Toast.makeText(MainActivity.this, "Ăn cắp vặt muôn năm", Toast.LENGTH_SHORT).show();
                    if (cbTien.isChecked()){
                        Toast.makeText(MainActivity.this, "Trời ơi! Tuổi lol", Toast.LENGTH_SHORT).show();
                    }else if (cbTai.isChecked()){
                        Toast.makeText(MainActivity.this, "Tao không thích chạy thôi", Toast.LENGTH_SHORT).show();
                    }else if (cbCuong.isChecked()){
                        Toast.makeText(MainActivity.this, "Lỗi quá lỗi quá", Toast.LENGTH_SHORT).show();
                    }
                    EnableCheckBox();
                }



                sbCuong.setProgress(sbCuong.getProgress() + cuong);
                sbTai.setProgress(sbTai.getProgress() + tai);
                sbTien.setProgress(sbTien.getProgress() + tien);
            }

            @Override
            public void onFinish() {

            }


        };
         ibtnPlay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (cbCuong.isChecked() || cbTai.isChecked() || cbTien.isChecked()){
                     sbCuong.setProgress(0);
                     sbTai.setProgress(0);
                     sbTien.setProgress(0);

                     ibtnPlay.setVisibility(View.INVISIBLE);
                     countDownTimer.start();
                     DisableCheckBox();
                 }else {
                     Toast.makeText(MainActivity.this, "Click chọn rồi mới bấm nút mầy!!!", Toast.LENGTH_SHORT).show();
                 }



             }
         });

         cbCuong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked){
                     cbTai.setChecked(false);
                     cbTien.setChecked(false);
                 }
             }
         });
        cbTai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbCuong.setChecked(false);
                    cbTien.setChecked(false);
                }
            }
        });
        cbTien.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbTai.setChecked(false);
                    cbCuong.setChecked(false);
                }
            }
        });





    }

    private void DisableSeekBar() {
        sbCuong.setEnabled(false);
        sbTai.setEnabled(false);
        sbTien.setEnabled(false);
    }

    private void DisableCheckBox() {
        cbCuong.setEnabled(false);
        cbTai.setEnabled(false);
        cbTien.setEnabled(false);
    }

    private void EnableCheckBox() {
        cbCuong.setEnabled(true);
        cbTai.setEnabled(true);
        cbTien.setEnabled(true);
    }

    private void AnhXa() {
        ibtnPlay    = findViewById(R.id.ibtnPlay);
        cbCuong     = findViewById(R.id.cbcuong);
        cbTien      = findViewById(R.id.cbtien);
        cbTai       = findViewById(R.id.cbtai);
        sbCuong     = findViewById(R.id.sbcuong);
        sbTai       = findViewById(R.id.sbtai);
        sbTien      = findViewById(R.id.sbtien);
    }
}