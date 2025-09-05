import java.util.Scanner;

public class IncomeTaxMain {
    public static void main(String [] args) {
        final String PROMPT_SALARY = "\nEnter annual salary (-1 to exit)";
        Scanner scnr = new Scanner(System.in);
        int annualSalary;
        double taxRate;
        int taxToPay;
        int i;

        // Tables to use in the exercise are the same as in the TaxTableTools class
        // int [] salaryRange = {   0,  20000, 50000, 100000,  Integer.MAX_VALUE };
        // double [] taxRates = { 0.0,   0.10,  0.20,   0.30,               0.40 };

        // 2(a) Modify the salary and tax tables in the main method to use
        // different salary ranges and tax rates.
        int []    salaryRange  = {   0,  30000,  60000,  Integer.MAX_VALUE };
        double [] taxRates     = { 0.0,  0.25,   0.35,               0.45 };

        // Access the related class
        // TaxTableTools table = new TaxTableTools();

        // 2(b)Use the just-created overloaded constructor to initialize
        // the salary and tax tables.
        TaxTableTools table = new TaxTableTools(salaryRange, taxRates);

        // Get the first annual salary to process
        annualSalary = table.getInteger(scnr, PROMPT_SALARY);

        while (annualSalary >= 0) {
            taxRate = table.getValue(annualSalary);
            taxToPay= (int)(annualSalary * taxRate);     // Truncate tax to an integer amount
            System.out.println("Annual Salary: " + annualSalary +
                    "\tTax rate: " + taxRate +
                    "\tTax to pay: " + taxToPay);

            // Get the next annual salary
            annualSalary = table.getInteger(scnr, PROMPT_SALARY);
        }
    }
}
