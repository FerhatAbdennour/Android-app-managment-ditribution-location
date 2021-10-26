package com.gestOCS.gestOCSAllSoft;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    String NameHolder;
    TextView NomUtilisateur;
    Button LogOUT ;
    Button AddCommercial;
    Button AddMachine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        NomUtilisateur = (TextView)findViewById(R.id.textView1);
        LogOUT = (Button)findViewById(R.id.button1);
        AddCommercial = (Button)findViewById(R.id.btnAjouterCommercial);
        AddMachine = (Button)findViewById(R.id.btnAjouterMachine);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        NameHolder = intent.getStringExtra(MainActivity.UserName);

        // Setting up received email to TextView.
        NomUtilisateur.setText(NomUtilisateur.getText().toString()+ " "+NameHolder);

        // Adding click listener to Log Out button.
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(DashboardActivity.this,"Au revoir!", Toast.LENGTH_LONG).show();

            }
        });

        AddCommercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DashboardActivity.this, CommercialActivity.class);


                startActivity(intent);

            }
        });

        AddMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DashboardActivity.this, MachineActivity.class);


                startActivity(intent);

            }
        });

    }
}
