package isetb.tp5.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CompteActivty extends AppCompatActivity {
EditText e1,e2,e3,e4;
private String prefs;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte_activty);
        e1=findViewById(R.id.t1);
        e2=findViewById(R.id.t2);
        e3=findViewById(R.id.t3);
        e4=findViewById(R.id.t4);
        btn=findViewById(R.id.t5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("prefs",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                String user=e1.getText().toString();
                e.putString("U",user);
                String email=e2.getText().toString();
                e.putString("E",email);
                String pw=e3.getText().toString();
                e.putString("M",pw);
                String cpw=e4.getText().toString();
               if (pw.equals(cpw)){
                   e.commit();
                   Intent i=new Intent(CompteActivty.this,MainActivity.class);
                   startActivity(i);
                   Toast.makeText(CompteActivty.this,"donné",Toast.LENGTH_SHORT).show();
               }else
                   Toast.makeText(CompteActivty.this,"Mot de passe non confirmé",Toast.LENGTH_LONG).show();


            }
        });
    }
}