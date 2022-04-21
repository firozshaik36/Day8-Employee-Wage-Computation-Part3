package com.bridgelabz.EmployeeWage;

import java.util.*;
interface EmpWageBuilder {
    public void computeEmpWage( EmployeeWageComputation.CompanyEmpWage obj );
}

public class EmployeeWageComputation implements EmpWageBuilder {
    final int IS_PART_TIME = 1;
    final int IS_FULL_TIME = 2;
    // ArrayList to Store daily Wage along with Monthly Wage

    ArrayList<Integer> empDailyMonthlyTotalWage = new ArrayList<Integer>();

    public void computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0;
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        int totalEmpWage = 0;
        int empDailyWage = 0;
        while (totalWorkingDays < companyEmpWage.getNumOfWorkingDays() && totalEmpHrs <=  companyEmpWage.getMaxHoursPerMonth()) {

            int empCheck = (int) ((Math.random() * 10) % 3);
            switch (empCheck) {
                case IS_PART_TIME:
                    //    System.out.println("Employee is Present");
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    //    System.out.println("Employee is Present");
                    empHrs = 8;
                    break;
                default:
                    //    System.out.println("Employee is Absent");
                    empHrs = 0;
            }
            totalWorkingDays++;
            totalEmpHrs = totalEmpHrs + empHrs;
            empDailyWage = empHrs * companyEmpWage.getEmpRatePerHour();
            empDailyMonthlyTotalWage.add( empDailyWage );
        }
        totalEmpWage=( totalEmpHrs * companyEmpWage.getEmpRatePerHour());
        empDailyMonthlyTotalWage.add( totalEmpWage );
        companyEmpWage.setTotalEmpWage( totalEmpWage );
    }
    //Main Function
    public static void main(String[] args) {
        System.out.println("---Welcome to Employee Wage Computation---");
        EmployeeWageComputation emp = new EmployeeWageComputation();
        //ArrayList of Multiple Companies Wage

        ArrayList<CompanyEmpWage> company = new ArrayList<CompanyEmpWage>();
        while (true) {

            System.out.println("Please Enter your choice to show Company Monthly Total Wage ");
            System.out.println("1:For Firoz");
            System.out.println("2:For Shaik ");
            System.out.println("3:For Jilani");
            System.out.println("4:For Exit Computation");

            Scanner sobj = new Scanner(System.in);
            int choice = sobj.nextInt();
            switch (choice) {
                case 1:
                    company.add( new CompanyEmpWage("Firoz", 40, 20, 100));
                    emp.computeEmpWage(company.get(0));
                    System.out.println("Employee Total wage is: " + company.get(0).getTotalEmpWage());
                    System.out.println();
                    break;
                case 2:
                    company.add( new CompanyEmpWage("Shaik", 30, 22, 120));
                    emp.computeEmpWage(company.get(1));
                    System.out.println("Employee Total wage is: " + company.get(1).getTotalEmpWage());
                    System.out.println();
                    break;
                case 3:
                    company.add( new CompanyEmpWage("Jilani", 45, 18, 90));
                    emp.computeEmpWage(company.get(2));
                    System.out.println("Employee Total wage is: " + company.get(2).getTotalEmpWage());
                    System.out.println();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    System.exit(0);
            }
        }
    }

    public static class CompanyEmpWage {

        public String company=" ";
        public int empRatePerHour=0;
        public int numOfWorkingDays=0;
        public int maxHoursPerMonth=0;
        public int totalEmpWage=0;

        public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
            this.company = company;
            this.empRatePerHour = empRatePerHour;
            this.numOfWorkingDays = numOfWorkingDays;
            this.maxHoursPerMonth = maxHoursPerMonth;
        }
        //GETTERS method to get variables
        public String getCompanyName(){
            return company;
        }
        public int getEmpRatePerHour(){
            return empRatePerHour;
        }

        public int getNumOfWorkingDays(){
            return numOfWorkingDays;
        }

        public int getMaxHoursPerMonth(){
            return maxHoursPerMonth;
        }

        public void setTotalEmpWage( int totalEmpWage ){
            this.totalEmpWage = totalEmpWage;
        }

        public int getTotalEmpWage(){
            return totalEmpWage;
        }

    }
}