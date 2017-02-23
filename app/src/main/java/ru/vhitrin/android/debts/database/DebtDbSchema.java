package ru.vhitrin.android.debts.database;

public class DebtDbSchema {

    public static final class DebtorTable {
        public static final String NAME = "debtors";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String ALWAYS_SHOW = "alwaysShow";
        }
    }

    public static final class LoanTable {
        public static final String NAME = "loans";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String DEBTOR_UUID = "debtorUUID";
            public static final String IS_LOAN = "isLoan";
            public static final String DATE = "date";
            public static final String AMOUNT = "amount";
            public static final String DESCRIPTION = "description";
        }
    }

    public static final class DebtTable {
        public static final String NAME = "debts";

        public static final class Cols {
            public static final String DEBTOR_UUID = "debtorUUID";
            public static final String IS_LOAN = "isLoan";
            public static final String AMOUNT = "amount";
            public static final String LAST_DATE = "lastDate";
            public static final String LAST_AMOUNT = "lastAmount";
        }
    }
}
