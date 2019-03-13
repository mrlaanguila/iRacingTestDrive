package iRacing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class idCoches {
	public static staticCar LoadArray() {
		Car[] anArray = new Car[30];
		int Line = 1;
		int elem = 1;
		try {
			Scanner scanner = new Scanner(new File("carsID.txt"));
			String linea = null;
			while (scanner.hasNextLine()) {
				if ((Line % 2) == 1) {
					linea = (scanner.nextLine());
				} else {
					int num = Integer.parseInt(scanner.nextLine());
					Car record = new Car();
					record.nombre = linea;
					record.id = num;
					anArray[elem] = record;
					elem++;
				}
				Line++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		staticCar cars = new staticCar();
		cars.array = anArray;
		cars.size = elem;
		return cars;
	}
}
