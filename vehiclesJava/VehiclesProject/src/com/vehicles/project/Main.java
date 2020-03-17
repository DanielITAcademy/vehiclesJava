package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isBrandOk=false;
		
		String vehicleSelection;
		String brand;
		String color;
		String plate;
		
		Car car;
		Bike bike;
		
		List<Wheel> frontWheels;
		List<Wheel> backWheels;

		System.out.println(" Would your prefer? car or bike");
		vehicleSelection = sc.next();


		System.out.println("Give me a brand: ");// Marca pedida al usuario
		brand = sc.next();
		System.out.println("Give me a colour: ");// Color pedido al usuario
		color = sc.next();
		
		do {
			System.out.println("Give me a plate: "); // Matricula pedida al usuario
			plate = sc.next().toUpperCase();
			
			Matcher m = Pattern.compile("\\d\\d\\d\\d[A-Z][A-Z][A-Z]").matcher(plate);
			isBrandOk = m.find();
			if (!isBrandOk) {
				System.out.println(plate + " is not a valid number plate");	
				  
			}
		} while (isBrandOk==false);
		
		
		switch (vehicleSelection) {
		case "car":
			car = new Car(plate, brand, color);
			frontWheels =  new ArrayList<Wheel>();
			backWheels = new ArrayList<Wheel>();
			for (int i = 0; i < Car.QNT_WHEELS; i++) {
				if(i<2) {
					System.out.println("Give me data on the rear wheel");
					backWheels.add(CreateWheel(sc));
				}else {
					System.out.println("Give me data on the front wheel");
					frontWheels.add(CreateWheel(sc));
				}
			}
			
			try {
				car.addWheels(frontWheels,backWheels);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(car.toString());
			
			break;
		case "bike":
			bike = new Bike(plate, brand, color);
			for (int i = 0; i <Bike.QNT_WHEELS ; i++) {
				if(i<1) {
					System.out.println("Give me data on the rear wheel");
					bike.wheels.add(CreateWheel(sc));
				}else {
					System.out.println("Give me data on the front wheel");
					bike.wheels.add(CreateWheel(sc));
				}
			}
			System.out.println(bike.toString());

			break;
		default:
			break;
		}
		
	}
	
	public static Wheel CreateWheel(Scanner sc) {
		System.out.println("Brand wheel:");
		String brandW = sc.next();
		System.out.println("Diameter wheel");
		double diameter = sc.nextDouble();
		
		Wheel wheel = new Wheel(brandW,diameter);
		
		return wheel;
	}
	
	

}
