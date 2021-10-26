package com.gestOCS.gestOCSAllSoft;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by NAZIH on 28/03/2018.
 */

public class MachineActivity extends AppCompatActivity {

    EditText NumSerieMachine, DesignationMachine, EtatMachine, Statut, DateReception, PVInstallation ;
    Button SaveCommercialBtn;
    String NomCommercialHolder, FonctionHolder, AdresseHolder, TelephoneHolder;
    int IdZoneAffecteHolder, ActifHolder;

    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_machine);



    }
}
