package ru.vhitrin.android.debts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DebtorFragment extends Fragment {

    private Debtor mDebtor;

    private EditText mDebtorNameField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDebtor = new Debtor(mDebtor.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_debtor, container, false);

        mDebtorNameField = (EditText) v.findViewById(R.id.debtor_name);
        mDebtorNameField.setText(mDebtor.getName());
        mDebtorNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {
                mDebtor.setName(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        return v;
    }
}
