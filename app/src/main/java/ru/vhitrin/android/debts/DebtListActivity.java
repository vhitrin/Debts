package ru.vhitrin.android.debts;

import android.support.v4.app.Fragment;

public class DebtListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new DebtListFragment();
    }
}
