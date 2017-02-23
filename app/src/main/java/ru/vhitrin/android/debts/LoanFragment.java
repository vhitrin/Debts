package ru.vhitrin.android.debts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class LoanFragment extends Fragment {

    private Loan mLoan;
    private Debtor mDebtor;

    private TextView mDebtorNameField;
    private Button mLoanDateButton;
    private EditText mLoanAmountField;
    private EditText mLoanDescriptionField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 23-Feb-17 Инициализировать mDebtor и mLoan по нормальному
        mDebtor = new Debtor(mLoan.getDebtorId());
        mLoan = new Loan(mDebtor.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_loan, container, false);

        mDebtorNameField = (TextView) v.findViewById(R.id.loan_debtor_name);
        mDebtorNameField.setText(new Debtor(mLoan.getDebtorId()).getName());

        mLoanDateButton = (Button) v.findViewById(R.id.loan_date);
        mLoanDateButton.setText(new SimpleDateFormat("dd.mm.yyyy", new Locale("ru")).format(mLoan.getDate()));

        mLoanAmountField = (EditText) v.findViewById(R.id.loan_amount);
        mLoanAmountField.setText(Float.toString(mLoan.getAmount()));
        mLoanAmountField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {
                mLoan.setAmount(Float.parseFloat(c.toString()));
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        mLoanDescriptionField = (EditText) v.findViewById(R.id.loan_description);
        mLoanDescriptionField.setText(mLoan.getDescription());
        mLoanDescriptionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {
                mLoan.setDescription(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        return v;
    }
}
