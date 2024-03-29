package _23_PastExams._2023_08_August_05.bank.core;

import _23_PastExams._2023_08_August_05.bank.common.ConstantMessages;
import _23_PastExams._2023_08_August_05.bank.common.ExceptionMessages;
import _23_PastExams._2023_08_August_05.bank.entities.bank.Bank;
import _23_PastExams._2023_08_August_05.bank.entities.client.Client;
import _23_PastExams._2023_08_August_05.bank.entities.client.Student;
import _23_PastExams._2023_08_August_05.bank.entities.loan.Loan;
import _23_PastExams._2023_08_August_05.bank.entities.loan.MortgageLoan;
import _23_PastExams._2023_08_August_05.bank.entities.loan.StudentLoan;
import _23_PastExams._2023_08_August_05.bank.entities.bank.BranchBank;
import _23_PastExams._2023_08_August_05.bank.entities.bank.CentralBank;
import _23_PastExams._2023_08_August_05.bank.entities.client.Adult;
import _23_PastExams._2023_08_August_05.bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private static final Loan MORTGAGE_LOAN = new MortgageLoan();
    private static final Loan STUDENT_LOAN = new StudentLoan();
    private LoanRepository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        switch (type) {
            case "CentralBank":
                this.banks.add(new CentralBank(name));
                break;

            case "BranchBank":
                this.banks.add(new BranchBank(name));
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        switch (type) {
            case "StudentLoan":
                this.loans.addLoan(STUDENT_LOAN);
                break;

            case "MortgageLoan":
                this.loans.addLoan(MORTGAGE_LOAN);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan;

        switch (loanType) {
            case "StudentLoan":
                loan = STUDENT_LOAN;
                break;

            case "MortgageLoan":
                loan = MORTGAGE_LOAN;
                break;

            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }

        if (this.loans.removeLoan(loan)) {
            this.banks.stream()
                    .filter(bank -> bank.getName().equals(bankName))
                    .forEach(bank -> bank.addLoan(loan));
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;

        switch (clientType) {
            case "Student":
                client = new Student(clientName, clientID, income);
                break;

            case "Adult":
                client = new Adult(clientName, clientID, income);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
        }

        this.banks.stream()
                .filter(bank -> bank.getName().equals(bankName))
                .forEach(bank -> bank.addClient(client));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        double sumOfIncomes = 0;

        for (Bank bank : this.banks) {
            if (bank.getName().equals(bankName)) {
                sumOfIncomes += bank.getLoans()
                        .stream()
                        .mapToDouble(Loan::getAmount)
                        .sum();

                sumOfIncomes += bank.getClients()
                        .stream()
                        .mapToDouble(Client::getIncome)
                        .sum();
            }
        }

        return String.format(ConstantMessages.FUNDS_BANK, bankName, sumOfIncomes);
    }

    @Override
    public String getStatistics() {
        return String.join(System.lineSeparator(), this.banks.stream()
                .map(Bank::getStatistics)
                .toArray(String[]::new));
    }
}
