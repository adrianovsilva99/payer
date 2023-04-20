package application;

import entities.Company;
import entities.Individual;
import entities.Payer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Payer> payerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Tax payer #" + (i+ 1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char indvOrComp = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();

            if (indvOrComp == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                payerList.add(new Individual(name, anualIncome, healthExpenditures));
            } else if (indvOrComp == 'c') {
                System.out.print("Number of employees: ");
                int numberEmployee = sc.nextInt();
                payerList.add(new Company(name, anualIncome, numberEmployee));
            }
        }

        System.out.println();

        System.out.println("TAXES PAID:");
        for (Payer p : payerList) {
            System.out.println(p);
        }

        System.out.println();

        double sum = 0;
        for (Payer p : payerList) {
            sum += p.taxesPaid();
        }
        System.out.printf("TOTAL PAID: %.2f%n", sum);

        sc.close();
    }
}