package isetb.tp5.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t;
    EditText e1,e2;
    Button btn_conneter;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.create_account);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,CompteActivty.class);
                startActivity(i);
            }
        });
        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);
        btn_conneter=findViewById(R.id.saveButton);
        btn_conneter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=e1.getText().toString();
                String pw=e2.getText().toString();
                SharedPreferences sp=getSharedPreferences("prefs",MODE_PRIVATE);
                if(email.equals(sp.getString("E",""))&&pw.equals(sp.getString("M",""))){
                    Intent i=new Intent(MainActivity.this,HomeActivity.class);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("connect" , true);
                    editor.commit();
                    Intent intent  = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity.this, "Vérifié", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}