package com.example.pc.iot_nckh;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 9/15/2017.
 */

public class Doimatkhau  extends AppCompatActivity{
    EditText edttaikhoan,edtmatkhaucu,edtmatkhaumoi;
    Button   btndoimatkhau,btnxoa;
    TextView thoat;
    database database3;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doimatkhau);
        edttaikhoan = (EditText) findViewById(R.id.edtUsernamedoimatkhau);
        edtmatkhaucu = (EditText) findViewById(R.id.edtMatkhaucũ);
        edtmatkhaumoi = (EditText) findViewById(R.id.edtMatkhaumoi);
        btndoimatkhau = (Button) findViewById(R.id.btndoimatkhau);
        btnxoa = (Button) findViewById(R.id.btnxoa3);
        thoat = (TextView)findViewById(R.id.txtSignup11) ;

        //------tao database-----//
        database3 = new database(this, "qltaikhoan",null,1);
        //-----tao bang taikhoan---//
        database3.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan(Id INTEGER PRIMARY KEY AUTOINCREMENT, TaiKhoan VARCHAR(200),MatKhau VARCHAR(200))");

        Cursor datataikhoan3 = database3.GetData("SELECT * FROM TaiKhoan");

        btndoimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor datataikhoan3 = database3.GetData("SELECT * FROM TaiKhoan");
                while (datataikhoan3.moveToNext()) {
                    String bientaikhoan = edttaikhoan.getText().toString();
                    String bienmatkhaucu = edtmatkhaucu.getText().toString();
                    String bienmatkhaumoi = edtmatkhaumoi.getText().toString();
                    int id = datataikhoan3.getInt(0);
                    String taikhoan3 = datataikhoan3.getString(1);
                    String matkhau3 = datataikhoan3.getString(2);
                    if (taikhoan3.equals(bientaikhoan)&& matkhau3.equals(bienmatkhaucu)){
                     database3.QueryData("UPDATE TaiKhoan SET  MatKhau= '"+ bienmatkhaumoi +"' WHERE Id = '"+ id +"'");
                       Toast.makeText(Doimatkhau.this, "Chúc mừng bạn đã đổi mật khẩu thành công tài khoản", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(Doimatkhau.this, "tai khoản hoặc mật khẩu của bạn nhập không đúng xin vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                  }
            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttaikhoan.setText("");
                edtmatkhaucu.setText("");
                edtmatkhaumoi.setText("");
                edttaikhoan.requestFocus();
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3();
            }
        });
    }
    public void intent3()
    {
        Intent intent4 = new Intent(this,Giaodien.class);
        startActivity(intent4);
    }
}
