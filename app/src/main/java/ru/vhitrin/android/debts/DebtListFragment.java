package ru.vhitrin.android.debts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DebtListFragment extends Fragment {
    
    private RecyclerView mDebtRecyclerView;
    private DebtAdapter mAdapter;
    private int currentPosition;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_debt_list, container, false);

        mDebtRecyclerView = (RecyclerView) view.findViewById(R.id.debt_recycler_view);
        mDebtRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_debt_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_item_new_debtor:
                Debtor debtor = new Debtor();
                DebtBank.get(getActivity()).addDebtor(debtor);
                Intent intent = DebtPagerActivity.newIntent(getActivity(), debtor.getId());
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    private class DebtHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Debt mDebt;
        private TextView mDebtorTextView;
        private TextView mLastDateAmountTextView;
        private TextView mDebtAmountTextView;

        public DebtHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mDebtorTextView = (TextView) itemView.findViewById(R.id.list_item_debt_debtor_text_view);
            mLastDateAmountTextView = (TextView) itemView.findViewById(R.id.list_item_debt_last_date_amount_text_view);
            mDebtAmountTextView = (TextView) itemView.findViewById(R.id.list_item_debt_amount_text_view);
        }

        public void bindDebt(Debt debt) {
            mDebt = debt;
            mDebtorTextView.setText(debt.getDebtorId().toString());
            mLastDateAmountTextView.setText(debt.getLastDateAmount());
            mDebtAmountTextView.setText(debt.getDebtorId().toString());
        }

        @Override
        public void onClick(View v) {
            currentPosition = mDebtRecyclerView.getChildAdapterPosition(v);
            Intent intent = DebtPagerActivity.newIntent(getActivity(), mDebt.getDebtorId());
            startActivity(intent);
        }
    }
    
    public class DebtAdapter extends RecyclerView.Adapter<DebtHolder> {

        private List<Debt> mDebts;

        public DebtAdapter(List<Debt> debts) {
            mDebts = debts;
        }

        @Override
        public DebtHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_debt, parent, false);

            return new DebtHolder(view);
        }

        @Override
        public void onBindViewHolder(DebtHolder holder, int position) {
            Debt debt = mDebts.get(position);
            holder.bindDebt(debt);
        }

        @Override
        public int getItemCount() {
            return mDebts.size();
        }

        public void setDebts(List<Debt> debts) {
            mDebts = debts;
        }
    }
}
