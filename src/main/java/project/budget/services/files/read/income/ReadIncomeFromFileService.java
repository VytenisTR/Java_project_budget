package project.budget.services.files.read.income;

import project.budget.services.files.transformers.IncomeCSVReadTransformer;
import project.budget.utils.BudgetListSizeResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ReadIncomeFromFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetIncomeRecords.csv");
    private final IncomeCSVReadTransformer incomeCSVReadTransformer = new IncomeCSVReadTransformer();

    public void readIncomeFromCSV(List<BudgetRecord> budgetRecordsList) {
        List<BudgetRecord> budgetIncomeRecordsList = new ArrayList<>();
        int incomeRecordsCount = 1;

        try {
            if (!doesIncomeFileExist()) {
                PrintMessages.printMessageWithNewLine("\nBiudžeto pajamų duomenų failas neegzistuoja.");
            } else {
                final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

                if (inputFromCSV.isEmpty()) {
                    PrintMessages.printMessageWithNewLine("\nNerasta jokių biudžeto pajamų įrašų.");
                } else {
                    for (String string : inputFromCSV) {
                        readFromCSV(budgetIncomeRecordsList, string, incomeRecordsCount);
                        incomeRecordsCount++;
                    }

                    if (BudgetListSizeResolver.checkIfEmpty(budgetIncomeRecordsList)) {
                        PrintMessages.printMessageWithNewLine
                                ("\nNepavyko apdoroti nei vieno biudžeto pajamų įrašo.");
                    } else {
                        addIncomeRecordsToBudget(budgetIncomeRecordsList, budgetRecordsList);
                        PrintMessages.printMessageWithNewLine
                                ("\nBiudžeto pajamų įrašai buvo sėkmingai įkelti.");
                    }

                    incomeRecordsCount = 1;
                }
            }
        } catch (IOException exception) {
            PrintMessages.printMessageWithNewLine
                    ("\nĮvyko klaida, bandant gauti biudžeto pajamų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }
    }

    private void readFromCSV(List<BudgetRecord> budgetIncomeRecordsList, final String string,
                             final int incomeRecordsCount) {
        final String[] budgetRecordStrings = string.split(",");
        if (budgetRecordStrings.length == 7) {
            final IncomeRecord incomeRecord = incomeCSVReadTransformer.transformFromCSV(budgetRecordStrings);
            if (incomeRecord != null) {
                budgetIncomeRecordsList.add(incomeRecord);
            } else {
                PrintMessages.printMessageWithoutNewLine(
                        String.format("\nĮvyko klaida apdorojant %d biudžeto pajamų įrašą iš CSV failo.\n",
                                incomeRecordsCount));
            }
        }
    }

    private void addIncomeRecordsToBudget(final List<BudgetRecord> budgetIncomeRecordsList, List<BudgetRecord> budgetRecordsList) {
        for (BudgetRecord budgetRecord : budgetIncomeRecordsList) {
            budgetRecordsList.add(budgetRecord);
        }
    }

    public boolean doesIncomeFileExist() {
        return Files.exists(FILE_PATH);
    }
}
