package ru.vhitrin.android.debts;

import java.util.UUID;

public class Debtor {

    private UUID mId;
    private String mName;
    private boolean mAlwaysShow;

    public Debtor() {
        this(UUID.randomUUID());
    }

    public Debtor(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
