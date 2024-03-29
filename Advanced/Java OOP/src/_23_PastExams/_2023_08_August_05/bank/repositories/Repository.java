package _23_PastExams._2023_08_August_05.bank.repositories;

import _23_PastExams._2023_08_August_05.bank.entities.loan.Loan;

public interface Repository {

    void addLoan(Loan loan);

    boolean removeLoan(Loan loan);

    Loan findFirst(String type);
}
