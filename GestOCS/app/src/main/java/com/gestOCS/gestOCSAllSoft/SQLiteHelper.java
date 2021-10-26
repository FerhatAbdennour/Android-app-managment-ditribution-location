package com.gestOCS.gestOCSAllSoft;

/**
 * Created by Juned on 3/13/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="dbGestOCS";

    //Table Utilisateur

    public static final String TABLE_NAME="tbUtilisateur";

    public static final String Table_Column_ID="IdUser";

    public static final String Table_Column_1_Name="NomUtilisateur";

    public static final String Table_Column_2_TypeUser="TypeUtilisateur";

    public static final String Table_Column_3_Password="MotPasse";

    public static final String Table_Column_4_Profil = "IdProfil";

    public static final String Table_Column_5_Commercial = "IdCommercial";

    //Table Commercial

    public static final String TABLE_NAME_COMMERCIAL="tbCommercial";

    public static final String Table_Column_ID_COMMERCIAL="IdCommercial";

    public static final String Table_Column_1_Nom="NomCommercial";

    public static final String Table_Column_2_Fonction="Fonction";

    public static final String Table_Column_3_Telephone="Telephone";

    public static final String Table_Column_4_Adresse="Adresse";

    public static final String Table_Column_5_IdZoneAffecte = "IdZoneAffecte";

    public static final String Table_Column_6_Actif = "Actif";

    // Table Machine

    public static final String TABLE_NAME_MACHINE="tbMachine";

    public static final String Machine_Column_Num_Serie_Machine="NumSerieMachine";

    public static final String Machine_Column_Designation_Machine="DesignationMachine";

    public static final String Machine_Column_Etat_Machine="EtatMachine";

    public static final String Machine_Column_Statut_Machine="StatutMachine";

    public static final String Machine_Column_Date_Reception_Machine="DateReception";

    public static final String Machine_Column_PV_Installation_Machine = "PVInstallation";

    public static final String Machine_Column_Date_Installation_Machine = "DateInstallation";

    public static final String Machine_Column_ID_Operateur = "IdOperateur";

    public static final String Machine_Column_ID_Client = "IdClient";

    public static final String Machine_Column_Observation = "Observation";

    public static final String Machine_Column_Couleur = "Couleur";





    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE_UTILISATEUR="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_Name+" VARCHAR, "+Table_Column_2_TypeUser+" VARCHAR, "+Table_Column_3_Password+" VARCHAR, "+Table_Column_5_Commercial+" INTEGER, "+Table_Column_4_Profil+" INTEGER)";
        String CREATE_TABLE_COMMERCIAL="CREATE TABLE IF NOT EXISTS "+TABLE_NAME_COMMERCIAL+" ("+Table_Column_ID_COMMERCIAL+" INTEGER PRIMARY KEY, "+Table_Column_1_Nom+" VARCHAR, "+Table_Column_2_Fonction+" VARCHAR, "+Table_Column_3_Telephone+" VARCHAR, "+Table_Column_4_Adresse+" VARCHAR, "+Table_Column_5_IdZoneAffecte+" INTEGER, "+Table_Column_6_Actif+" INTEGER)";
        String CREATE_TABLE_MACHINE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME_MACHINE+" ("+Machine_Column_Num_Serie_Machine+" VARCHAR PRIMARY KEY, "+Machine_Column_Designation_Machine+" VARCHAR, "+Machine_Column_Etat_Machine+" INTEGER, "+Machine_Column_Statut_Machine+" INTEGER, "+Machine_Column_Date_Reception_Machine+" datetime, "+Machine_Column_Date_Installation_Machine+" datetime, "+Machine_Column_ID_Client+" INTEGER, "+Machine_Column_ID_Operateur+" INTEGER, "+Machine_Column_Observation+" VARCHAR, "+Machine_Column_Couleur+" VARCHAR)";



        database.execSQL(CREATE_TABLE_UTILISATEUR);
        database.execSQL(CREATE_TABLE_COMMERCIAL);
        database.execSQL(CREATE_TABLE_MACHINE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}