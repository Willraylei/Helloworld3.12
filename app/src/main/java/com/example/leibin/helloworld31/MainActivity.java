package com.example.leibin.helloworld31;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();

        editText=(EditText)findViewById(R.id.editText);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
     MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.small:
                editText.setTextSize(10);
                break;
            case R.id.large:
                editText.setTextSize(20);
                break;
            case R.id.middle:
                editText.setTextSize(15);
                break;
            case R.id.black:
                editText.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.red:
                editText.setTextColor(Color.parseColor("#FF0000"));
                break;
            case R.id.generous:
                Toast.makeText(this,"您点击了普通菜单",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void initEvent(){
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    private void showDialog(){

        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.alertdialog,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");
        builder.setView(view);
        builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "点击了登录按钮",
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "点击了取消按钮",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
