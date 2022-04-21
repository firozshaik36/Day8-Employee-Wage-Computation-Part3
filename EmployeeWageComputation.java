package com.bridgelabz.EmployeeWage;

import java.util.*;
interface EmpWageBuilder {
    public void computeEmpWage( CompanyEmpWage obj );
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
            System.out.println("Day:"+totalWorkingDays +" Wage is : "+empDailyWage );
        }
        totalEmpWage=( totalEmpHrs * companyEmpWage.getEmpRatePerHour());
        empDailyMonthlyTotalWage.add( totalEmpWage );
        companyEmpWage.setTotalEmpWage( totalEmpWage );
        System.out.println("Employee Monthly Wage of " + companyEmpWage.getCompanyName() + " is " + companyEmpWage.getTotalEmpWage());
    }
    //Main Function
    public static void main(String[] args) {
        System.out.println("WELCOME to EMPLOYEE WAGE Computation");
        EmployeeWageComputation emp = new EmployeeWageComputation();
        //ArrayList of Multiple Companies Wage

        ArrayList<CompanyEmpWage> company = new ArrayList<CompanyEmpWage>();
        // assign value to object of Companyempwage
        company.add( new CompanyEmpWage("Firoz", 40, 20, 100));
        emp.computeEmpWage(company.get(0));
        System.out.println();
        company.add( new CompanyEmpWage("Shaik", 30, 22, 120));
        emp.computeEmpWage(company.get(1));
        System.out.println();
        company.add( new CompanyEmpWage("Jilani", 45, 18, 90));
        emp.computeEmpWage(company.get(2));
        System.out.println();
    }
}

class CompanyEmpWage {

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