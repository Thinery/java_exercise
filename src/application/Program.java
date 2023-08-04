package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the department name: ");
		String department = sc.nextLine();
		System.out.print("Enter Worker data\n");
		System.out.print("Enter worker name: ");
		String workerName = sc.nextLine();
		System.out.print("Worker level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Worker base salary: ");
		double workerSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary, new Department(department));
		
		System.out.print("How many contracts to this worker? ");
		int x = sc.nextInt();
		for(int i=0;i<x;i++) {
			sc.nextLine();
			System.out.println("Enter the #"+(i+1)+" contract");
			System.out.print("Date (DD/MM/YYYY): ");
			String data = sc.nextLine();
			LocalDate lcd = LocalDate.parse(data,fmt1);
			System.out.println("Value per Hour: ");
			double vph = sc.nextDouble();
			System.out.println("Hours: ");
			int hours = sc.nextInt();
			HourContract hourContract = new HourContract(lcd,vph,hours);
			worker.addContract(hourContract);
		}
		
		System.out.println();
		
		System.out.println("Enter the month and year to calculate the income");
		System.out.print("Month: ");
		int month = sc.nextInt();
		System.out.print("Year: ");
		int year = sc.nextInt();
		
		System.out.println("Worker name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income: "+worker.income(year, month));
		
		sc.close();
	}

}
