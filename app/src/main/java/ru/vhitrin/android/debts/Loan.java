package ru.vhitrin.android.debts;

import java.util.Date;
import java.util.UUID;

public class Loan {

    private UUID mId;
    private Debtor mDebtor;
    private UUID mDebtorId;
    private boolean mIsLoan;
    private Date mDate;
    private float mAmount;
    private String mDescription;

    public Loan(UUID debtorId) {
        this(UUID.randomUUID(), debtorId);
    }

    public Loan(UUID id, UUID debtorId) {
        mId = id;
        mDebtorId = debtorId;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
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

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public float getAmount() {
        return mAmount;
    }

    public void setAmount(float amount) {
        mAmount = amount;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
