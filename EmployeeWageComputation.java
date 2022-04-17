package com.bridgelabz.EmployeeWage;

public class EmployeeWageComputation {


    private static final int IS_FULL_TIME = 1;   // Initializing Variable
    private static final int IS_PART_TIME = 2;   // Initializing Variable

    private final String company;
    private final int empRate;
    private final int numOFDays;
    private final int maxHours;
    private int empWagePerMonth;

    public EmployeeWageComputation(String company, int empRate, int numOFDays, int maxHours) {
        this.company = company;
        this.empRate = empRate;
        this.numOFDays = numOFDays;
        this.maxHours = maxHours;
    }

    public void calculateEmpWageForCompany() {

        int empHrs = 0, totalWorkingdays = 0, totalEmpHours = 0;

        while (totalEmpHours <= maxHours && totalWorkingdays < numOFDays) {

            totalWorkingdays++;
            int empType = (int) Math.floor(Math.random() * 10) % 3;

            switch (empType) {
                case IS_FULL_TIME:
                    System.out.println("Employee Doing Full Time:");
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    System.out.println("Employee Doing Part Time:");
                    empHrs = 4;
                    break;
                default:
                    System.out.println("Employee Is Absent:");
                    empHrs = 0;
            }

            totalEmpHours += empHrs;
            int empWagePerDay = empHrs * empRate;
            empWagePerMonth += empWagePerDay;
            System.out.println("Emp Wage Per Day : " + empWagePerDay);
        }

    }

    @Override
    public String toString() {
        return "Emp Wage Per Month for Company " + company + " is : " + empWagePerMonth;
    }

    public static void main(String[] args) {

        System.out.println("----- Welcome to Employee Wage Computation Program! -----");
        EmployeeWageComputation firoz = new EmployeeWageComputation("FIROZ", 20, 2, 10);
        EmployeeWageComputation shaik = new EmployeeWageComputation("SHAIK", 40, 5, 20);

        firoz.calculateEmpWageForCompany();
        System.out.println(firoz);
        System.out.println();

        shaik.calculateEmpWageForCompany();
        System.out.println(shaik);

    }

}