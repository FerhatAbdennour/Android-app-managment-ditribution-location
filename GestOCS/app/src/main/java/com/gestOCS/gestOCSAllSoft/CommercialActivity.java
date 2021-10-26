package com.gestOCS.gestOCSAllSoft;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

/**
 * Created by NAZIH on 24/03/2018.
 */

public class CommercialActivity extends AppCompatActivity {

    EditText NomCommercial, Fonction, Adresse, Telephone, IdZoneAffecte, Actif ;
    Button SaveCommercialBtn;
    String NomCommercialHolder, FonctionHolder, AdresseHolder, TelephoneHolder;
    int IdZoneAffecteHolder, ActifHolder;

    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;

    ArrayList<String> items = new ArrayList<>();
    SpinnerDialog spinnerDialog;
    Button btnShow;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_commercial);

        NomCommercial = (EditText)findViewById(R.id.editNomCommercial);
        Fonction = (EditText)findViewById(R.id.editFonction);
        Adresse = (EditText)findViewById(R.id.editAdresse);
        Telephone = (EditText)findViewById(R.id.editTelephone);
        IdZoneAffecte = (EditText)findViewById(R.id.editZoneAffecte);
        Actif = (EditText)findViewById(R.id.editActif);

        SaveCommercialBtn = (Button)findViewById(R.id.buttonSave);
        
        InitItems();
        spinnerDialog = new SpinnerDialog(CommercialActivity.this,items,"Select Item");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {

                Toast.makeText(CommercialActivity.this, "Selected: " + item, Toast.LENGTH_LONG).show();

            }
        });

        sqLiteHelper = new  SQLiteHelper(this);

        // Adding click listener to register button.
        SaveCommercialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creating SQLite database if dose n't exists else Opening it
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();


            }
        });

        btnShow = (Button)findViewById(R.id.buttonSpinner);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               spinnerDialog.showSpinerDialog();


            }
        });



    }

    private void InitItems() {

        for (int i=0;i<100;i++) {

            items.add("Item " + (i+1));
        }
    }

    private void SQLiteDataBaseBuild() {

        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }

    private void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME_COMMERCIAL+" ("+SQLiteHelper.Table_Column_ID_COMMERCIAL+" INTEGER PRIMARY KEY, "+SQLiteHelper.Table_Column_1_Nom +" VARCHAR, "+SQLiteHelper.Table_Column_2_Fonction+" VARCHAR, "+SQLiteHelper.Table_Column_3_Telephone+" VARCHAR, "+SQLiteHelper.Table_Column_4_Adresse+" VARCHAR, "+SQLiteHelper.Table_Column_5_IdZoneAffecte+" INTEGER, "+SQLiteHelper.Table_Column_6_Actif+" INTEGER);");

    }

    private void CheckEditTextStatus() {

        NomCommercialHolder = NomCommercial.getText().toString();
        TelephoneHolder = Telephone.getText().toString();
        AdresseHolder = Adresse.getText().toString();
        FonctionHolder = Fonction.getText().toString();
        IdZoneAffecteHolder = Integer.parseInt(IdZoneAffecte.getText().toString());
        ActifHolder = Integer.parseInt(Actif.getText().toString());

        if(TextUtils.isEmpty(NomCommercialHolder)) {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(CommercialActivity.this,"Veuiller saisir le nom SVP", Toast.LENGTH_LONG).show();

        }

        else {

            InsertDataIntoSQLiteDatabase();
        }
    }

    private void InsertDataIntoSQLiteDatabase() {

        // SQLite query to insert data into table.
        SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.TABLE_NAME_COMMERCIAL+" (NomCommercial,Fonction,Telephone,Adresse,IdZoneAffecte,Actif) VALUES('"+NomCommercialHolder+"', '"+FonctionHolder+"', '"+TelephoneHolder+"', '"+AdresseHolder+"', '"+IdZoneAffecteHolder+"', '"+ActifHolder+"');";

        // Executing query.
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

        // Closing SQLite database object.
        sqLiteDatabaseObj.close();

        // Printing toast message after done inserting.
        Toast.makeText(CommercialActivity.this,"Le commercial a été ajouté avec succès", Toast.LENGTH_LONG).show();
    }


    private void EmptyEditTextAfterDataInsert() {

        NomCommercial.getText().clear();

        Adresse.getText().clear();

        Telephone.getText().clear();

        IdZoneAffecte.getText().clear();

        Fonction.getText().clear();

        Actif.getText().clear();
    }





}
