package ru.vhitrin.android.debts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class DebtPagerActivity extends AppCompatActivity{

    private static final String EXTRA_DEBT_ID = "ru.vhitrin.android.criminalintent.debt_id";

    private ViewPager mViewPager;
    private List<Debt> mDebts;

    public static Intent newIntent(Context packageContext, UUID debtId) {
        Intent intent = new Intent(packageContext, DebtPagerActivity.class);
        intent.putExtra(EXTRA_DEBT_ID, debtId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_pager);

        UUID debtId = (UUID) getIntent().getSerializableExtra(EXTRA_DEBT_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_debt_pager_view_pager);

        mDebts = DebtBank.get(this).getDebts();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Debt debt = mDebts.get(position);
                return LoanFragment.newInstance(debt.getDebtorId());
            }

            @Override
            public int getCount() {
                return mDebts.size();
            }
        });

        for (int i = 0; i < mDebts.size(); i++) {
            if (mDebts.get(i).getDebtorId().equals(debtId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
