package ru.vhitrin.android.debts;

import java.util.Date;
import java.util.UUID;

public class Debt {

    private UUID mDebtorId;
    private boolean mIsLoan;
    private float mAmount;
    private Date mLastDate;
    private float mLastAmount;

    public Debt(UUID debtorId) {
        mDebtorId = debtorId;
    }

    public UUID getDebtorId() {
        return mDebtorId;
    }

    public boolean isLoan() {
        return mIsLoan;
    }

    public void setLoan(boolean loan) {
        mIsLoan = loan;
    }

    public float getAmount() {
        return mAmount;
    }

    public void setAmount(float amount) {
        mAmount = amount;
    }

    public Date getLastDate() {
        return mLastDate;
    }

    public void setLastDate(Date lastDate) {
        mLastDate = lastDate;
    }

    public float getLastAmount() {
        return mLastAmount;
    }

    public void setLastAmount(float lastAmount) {
        mLastAmount = lastAmount;
    }
}
