package com.example.pc.iot_nckh;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 9/9/2017.
 */

public class Giaodien extends AppCompatActivity {
    EditText taikhoan,matkhau;
    Button dangnhap,xoa;
    TextView dangki,thoat,doimatkhau;
      database database1;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien);
        taikhoan = (EditText) findViewById(R.id.edtUsername);
        matkhau = (EditText) findViewById(R.id.edtMatkhau);
        dangnhap = (Button)findViewById(R.id.btnSignin);
        xoa = (Button)findViewById(R.id.btnClear);
        dangki = (TextView)findViewById(R.id.txtSignup);
        thoat = (TextView)findViewById(R.id.txtThoat);

        doimatkhau = (TextView)findViewById(R.id.txtChangepass);
        //------tao database-----//
        database1 = new database(this, "qltaikhoan",null,1);
        //-----tao bang taikhoan---//
        database1.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan(Id INTEGER PRIMARY KEY AUTOINCREMENT, TaiKhoan VARCHAR(200),MatKhau VARCHAR(200))");

        //----insert data
      // database1.QueryData("INSERT INTO TaiKhoan VALUES(null,'nguyendangkhoa','khoa')");
       //----select data
        Cursor datataikhoan = database1.GetData("SELECT * FROM TaiKhoan");

        while (datataikhoan.moveToNext()){
//           String taikhoan1 = datataikhoan.getString(1);
          // Toast.makeText(this,taikhoan1,Toast.LENGTH_SHORT).show();
        }

        dangnhap.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {

              Cursor datataikhoan = database1.GetData("SELECT * FROM TaiKhoan");
               while (datataikhoan.moveToNext()) {
               String taikhoan2 = taikhoan.getText().toString();
                   String matkhau2 = matkhau.getText().toString();
                   String taikhoan1 = datataikhoan.getString(1);
                   String matkhau1 = datataikhoan.getString(2);

        if (taikhoan2.equals("")&&matkhau2.equals("")){
            Toast.makeText(Giaodien.this,"xin mời bạn đăng nhập tài khoản",Toast.LENGTH_SHORT).show();

        }else {
            if (taikhoan2.equals(taikhoan1) && matkhau2.equals(matkhau1)) {
                intentActibityMain();
            } else {
                Toast.makeText(Giaodien.this, "tài khoản hoặc mật khẩu của bạn nhập không đúng mời nhập lại", Toast.LENGTH_SHORT).show();
            }
        }
               }
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taikhoan.setText("");
                matkhau.setText("");
                taikhoan.requestFocus();
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(Giaodien.this);
                b.setTitle("Question");
                b.setMessage("Are you sure you want to exit");
               b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       finish();
                   }
               });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    }
                });
                b.create().show();
            }
        });
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentActibityDangky();
            }
        });
        doimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentActibitydoimatkhau();
            }
        });
    }
    public void intentActibityMain()
    {
        Intent myIntent=new Intent(this, MainActivity.class);
        startActivity(myIntent);

    }
    public void intentActibitydoimatkhau()
    {
        Intent myIntent4=new Intent(this, Doimatkhau.class);
        startActivity(myIntent4);

    }
    public void intentActibityDangky()
    {
        Intent myIntent1 =new Intent(this, Dangky.class);
        startActivity(myIntent1);
    }
}
