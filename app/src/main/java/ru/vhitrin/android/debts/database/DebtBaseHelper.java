package ru.vhitrin.android.debts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ru.vhitrin.android.debts.database.DebtDbSchema.DebtorTable;
import ru.vhitrin.android.debts.database.DebtDbSchema.LoanTable;
import ru.vhitrin.android.debts.database.DebtDbSchema.DebtTable;

public class DebtBaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "debtBase.sqlite";

    public DebtBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + DebtorTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DebtorTable.Cols.UUID           + " text, " +
                DebtorTable.Cols.NAME           + " text, " +
                DebtorTable.Cols.ALWAYS_SHOW    + " integer)");

        db.execSQL("create table " + LoanTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                LoanTable.Cols.UUID             + " text, " +
                LoanTable.Cols.DEBTOR_UUID      + " text, " +
                LoanTable.Cols.IS_LOAN          + " integer, " +
                LoanTable.Cols.DATE             + ", " +
                LoanTable.Cols.AMOUNT           + " real, " +
                LoanTable.Cols.DESCRIPTION      + " text)");

        db.execSQL("create table " + DebtTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DebtTable.Cols.DEBTOR_UUID    + " text, " +
                DebtTable.Cols.IS_LOAN   + " integer, " +
                DebtTable.Cols.AMOUNT   + " real, " +
                DebtTable.Cols.LAST_DATE   + ", " +
                DebtTable.Cols.LAST_AMOUNT  + " real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
