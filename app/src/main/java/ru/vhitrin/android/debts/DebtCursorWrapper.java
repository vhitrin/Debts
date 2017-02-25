package ru.vhitrin.android.debts;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import ru.vhitrin.android.debts.database.DebtDbSchema.DebtTable;

public class DebtCursorWrapper extends CursorWrapper {

    public DebtCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Debt getDebt() {
        String debtorUuidString = getString(getColumnIndex(DebtTable.Cols.DEBTOR_UUID));
        boolean isLoan = getColumnIndex(DebtTable.Cols.IS_LOAN) == 1 ? true : false;
        float amount = getFloat(getColumnIndex(DebtTable.Cols.AMOUNT));
        long  lastDate = getLong(getColumnIndex(DebtTable.Cols.LAST_DATE));
        float lastAmount = getFloat(getColumnIndex(DebtTable.Cols.LAST_AMOUNT));

        Debt debt = new Debt(UUID.fromString(debtorUuidString));
        debt.setLoan(isLoan);
        debt.setAmount(amount);
        debt.setLastDate(new Date(lastDate));
        debt.setLastAmount(lastAmount);

        return debt;
    }
}
