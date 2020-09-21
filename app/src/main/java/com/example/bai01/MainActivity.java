package com.example.bai01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    private EditText txtSoA,txtSoB;
    private TextView txtKetQua;
    private Button btnTong,btnHieu,btnTich,btnThuong,btnUoc,btnThoat;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        txtSoA = (EditText) findViewById(R.id.txtSoA);
        txtSoB = (EditText) findViewById(R.id.txtSoB);
        btnTong = (Button) findViewById(R.id.btnTong);
        btnHieu = (Button) findViewById(R.id.btnHieu);
        btnTich = (Button) findViewById(R.id.btnTich);
        btnThuong = (Button) findViewById(R.id.btnThuong);
        btnThoat = (Button)  findViewById(R.id.btnExit);
        btnUoc = (Button)  findViewById(R.id.btnUocChung);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(kiemTraRong(txtSoA.getText()+"",txtSoB.getText()+"")){
                        int a = Integer.parseInt(txtSoA.getText()+"");
                        int b = Integer.parseInt(txtSoB.getText()+"");
                        int tong = 0;
                        tong += a+b;
                        txtKetQua.setText(tong + "");
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Không được bỏ trống!!!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }catch (Exception ex){
                    Toast toast = Toast.makeText(getApplicationContext(),"Phải nhập số!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(kiemTraRong(txtSoA.getText()+"",txtSoB.getText()+"")) {
                        int a = Integer.parseInt(txtSoA.getText() + "");
                        int b = Integer.parseInt(txtSoB.getText() + "");
                        int hieu = 0;
                        hieu += a - b;
                        txtKetQua.setText(hieu + "");
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Không được bỏ trống!!!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }catch (Exception ex){
                    Toast toast = Toast.makeText(getApplicationContext(),"Phải nhập số!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(kiemTraRong(txtSoA.getText()+"",txtSoB.getText()+"")) {
                        int a = Integer.parseInt(txtSoA.getText() + "");
                        int b = Integer.parseInt(txtSoB.getText() + "");
                        int tich = 0;
                        tich += a * b;
                        txtKetQua.setText(tich + "");
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Không được bỏ trống!!!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }catch (Exception ex){
                    Toast toast = Toast.makeText(getApplicationContext(),"Phải nhập số!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(kiemTraRong(txtSoA.getText()+"",txtSoB.getText()+"")) {
                        int a = Integer.parseInt(txtSoA.getText() + "");
                        int b = Integer.parseInt(txtSoB.getText() + "");
                        int thuong = 0;
                        thuong += a / b;
                        txtKetQua.setText(thuong + "");
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Không được bỏ trống!!!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }catch (Exception ex){
                    Toast toast = Toast.makeText(getApplicationContext(),"Phải nhập số!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        btnUoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(kiemTraRong(txtSoA.getText()+"",txtSoB.getText()+"")) {
                        int a = Integer.parseInt(txtSoA.getText() + "");
                        int b = Integer.parseInt(txtSoB.getText() + "");

                        txtKetQua.setText(UCLN(a, b) + "");
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Không được bỏ trống!!!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }catch (Exception ex){
                    Toast toast = Toast.makeText(getApplicationContext(),"Phải nhập số!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bạn có chắc chắn thoát?");
                builder.setMessage("Lựa chọn");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }
    public static boolean kiemTraRong(String txtSoA,String txtSoB){
        if(txtSoA.equals("") || txtSoB.equals("")){
            return false;
        }
        return true;
    }
    public static int UCLN(int a,int b){
        // Nếu a = 0 => ucln(a,b) = b
        // Nếu b = 0 => ucln(a,b) = a
        if (a == 0 || b == 0){
            return a + b;
        }
        while (a != b){
            if (a > b){
                a -= b; // a = a - b
            }else{
                b -= a;
            }
        }
        return a;
        // return a or b, bởi vì lúc này a và b bằng nhau
    }
}
