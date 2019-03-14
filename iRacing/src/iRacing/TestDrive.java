package iRacing;

public class TestDrive {
	public static String url(int idCar, int idTrack, int Temp, int Weather, String date) {

		return ("https://members.iracing.com/membersite/member/launchTestVRS.jsp?carId=" + idCar + "&trackId=" + idTrack
				+ "&startDateTime=" + date + "&skyOptions=" + Weather + "&temperatureValue=" + Temp
				+ "&windDirection=0&weatherType=0");
	}
}
