package ru.vhitrin.android.debts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ru.vhitrin.android.debts.database.DebtBaseHelper;
import ru.vhitrin.android.debts.database.DebtDbSchema.DebtTable;
import ru.vhitrin.android.debts.database.DebtDbSchema.DebtorTable;

public class DebtBank {

    private static DebtBank sDebtBank;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static DebtBank get(Context context) {
        if (sDebtBank == null) {
            sDebtBank = new DebtBank(context);
        }
        return sDebtBank;
    }

    private DebtBank(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DebtBaseHelper(mContext).getWritableDatabase();
    }

    public List<Debt> getDebts() {
        List<Debt> debts = new ArrayList<>();

        DebtCursorWrapper cursor = queryDebts(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                debts.add(cursor.getDebt());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return debts;
    }

    private DebtCursorWrapper queryDebts(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DebtTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new DebtCursorWrapper(cursor);
    }

    public void addDebtor(Debtor d) {
        ContentValues values = getContentValues(d);
        mDatabase.insert(DebtorTable.NAME, null, values);
    }

    private static ContentValues getContentValues(Debtor debtor) {
        ContentValues values = new ContentValues();
        values.put(DebtorTable.Cols.UUID, debtor.getId().toString());
        values.put(DebtorTable.Cols.NAME, debtor.getName());
        values.put(DebtorTable.Cols.ALWAYS_SHOW, 1);

        return values;
    }
}
