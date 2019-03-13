package iRacing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class idTracks {
	public static staticTrack LoadArray() {
		Track[] anArray = new Track[200];
		int Line = 1;
		int elem = 1;
		try {
			Scanner scanner = new Scanner(new File("trackID.txt"));
			String linea = null;
			while (scanner.hasNextLine()) {
				if ((Line % 2) == 1) {
					linea = (scanner.nextLine());
				} else {
					int num = Integer.parseInt(scanner.nextLine());
					Track record = new Track();
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
		staticTrack cars = new staticTrack();
		cars.array = anArray;
		cars.size = elem;
		return cars;
	}
}
