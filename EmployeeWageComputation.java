package com.bridgelabz.EmployeeWage;

public class EmployeeWageComputation {

    private static final int IS_FULL_TIME = 1;
    private static final int IS_PART_TIME = 2;

    public static int calculateEmpWageForCompany(String company, int empRate, int numOFDays, int maxHours) {

        System.out.println("----- Welcome to Employee Wage Computation! -----");
        int empHrs=0, empWagePerMonth = 0, totalWorkingDays=0, totalEmpHours = 0;

        while(totalEmpHours <= maxHours && totalWorkingDays < numOFDays) {

            totalWorkingDays ++;
            int empType = (int)Math.floor(Math.random() * 10) % 3;

            switch(empType) {
                case IS_FULL_TIME:
                    System.out.println("Employee Doing Full Time:");
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    System.out.println("Employee Doing Part Time:");
                    empHrs = 4;
                    break;
                default:
                    System.out.println("Employee is Absent:");
                    empHrs = 0;
            }

            totalEmpHours += empHrs;
            int empWagePerDay = empHrs * empRate;
            empWagePerMonth += empWagePerDay;
            System.out.println("Emp Wage Per Day : "+empWagePerDay);
        }

        System.out.println("Emp Wage Per Month for Company: "+company+" is : "+empWagePerMonth);
        return empWagePerMonth;
    }

    public static void main(String[] args) {
        calculateEmpWageForCompany("Firoz", 20, 2, 10);
        calculateEmpWageForCompany("Shaik", 10, 4, 20);

    }

}
