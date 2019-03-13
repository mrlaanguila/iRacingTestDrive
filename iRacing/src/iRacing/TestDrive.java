package iRacing;

public class TestDrive {
	public static String times = "2019-03-13%2016:44";

	public static void main(String[] args) {
		staticCar cars = new staticCar();
		cars = idCoches.LoadArray();
		staticTrack tracks = new staticTrack();
		tracks = idTracks.LoadArray();
		for (int i = 1; i < cars.size; i++) {
			System.out.println(i + ". " + cars.array[i].nombre);
		}
		int idCar = StdIn.readInt("Seleccionar coche introduciondo su numero:");
		for (int i = 1; i < tracks.size; i++) {
			System.out.println(i + ". El circuito " + tracks.array[i].nombre);
		}
		int idTrack = StdIn.readInt("Seleccionar circuito introduciondo su numero:");
		int weather = StdIn.readInt(
				"Elige el tiempo introduciendo su numero (0 = Clear, 1 = Partly Cloudy, 2 = Mostly Cloudy, 3 = Overcast):");
		int temp = StdIn.readInt("Introduce la tempreatura en farenhait:");
		int month = StdIn.readInt("Introduce el numero del mes:");
		int day = StdIn.readInt("Introduce el numero del dia:");
		int time = StdIn.readChar("Introduce la hora con el formato HH:MM (24h)");
		String fecha = "2019-" + month + "-" + day + "%20" + time;
		String url = url(cars.array[idCar].id, tracks.array[idTrack].id, temp, weather, fecha);
		System.out.println(url);

	}

	public static String url(int idCar, int idTrack, int Temp, int Weather, String date) {

		return ("https://members.iracing.com/membersite/member/launchTestVRS.jsp?carId=" + idCar + "&trackId=" + idTrack
				+ "&startDateTime=" + date + "&skyOptions=" + Weather + "&temperatureValue=" + Temp
				+ "&windDirection=0&weatherType=0");
	}
}
