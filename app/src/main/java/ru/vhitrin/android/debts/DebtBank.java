package ru.vhitrin.android.debts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ru.vhitrin.android.debts.database.DebtBaseHelper;

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
}
