package iRacing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Launcher {

	public JFrame frmIracingTestDrive;
	public static staticCar cars = new staticCar();
	public static staticTrack tracks = new staticTrack();
	public JTextField txtTemperatura;
	public JTextField textMes;
	public JTextField textDia;
	public JTextField textHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		cars = idCoches.LoadArray();
		tracks = idTracks.LoadArray();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frmIracingTestDrive.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIracingTestDrive = new JFrame();
		frmIracingTestDrive.setTitle("iRacing Test Drive");
		frmIracingTestDrive.setBounds(100, 100, 450, 300);
		frmIracingTestDrive.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIracingTestDrive.getContentPane().setLayout(null);

		JComboBox<String> CarList = new JComboBox<String>();
		for (int i = 1; i < cars.size; i++) {
			CarList.addItem(cars.array[i].nombre);
		}
		CarList.setBounds(101, 70, 235, 20);

		frmIracingTestDrive.getContentPane().add(CarList);

		JComboBox<String> TrackList = new JComboBox<String>();
		TrackList.setBounds(101, 101, 235, 20);
		for (int i = 1; i < tracks.size; i++) {
			TrackList.addItem(tracks.array[i].nombre);
		}
		frmIracingTestDrive.getContentPane().add(TrackList);

		JComboBox<String> WeatherBox = new JComboBox<String>();
		WeatherBox.setModel(
				new DefaultComboBoxModel(new String[] { "Clear", "Partly Cloudy", "Mostly Cloudy", "Overcast" }));
		WeatherBox.setBounds(227, 132, 109, 20);
		frmIracingTestDrive.getContentPane().add(WeatherBox);

		txtTemperatura = new JTextField();
		txtTemperatura.setToolTipText("Temperatura");
		txtTemperatura.setBounds(101, 132, 109, 20);
		frmIracingTestDrive.getContentPane().add(txtTemperatura);
		txtTemperatura.setColumns(10);

		textMes = new JTextField();
		textMes.setBounds(101, 163, 25, 20);
		frmIracingTestDrive.getContentPane().add(textMes);
		textMes.setColumns(10);

		textDia = new JTextField();
		textDia.setBounds(145, 163, 25, 20);
		frmIracingTestDrive.getContentPane().add(textDia);
		textDia.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setEditable(false);
		textArea.setText("-");
		textArea.setBounds(130, 161, 12, 22);
		frmIracingTestDrive.getContentPane().add(textArea);

		JTextArea txtrMes = new JTextArea();
		txtrMes.setEditable(false);
		txtrMes.setBackground(UIManager.getColor("Button.background"));
		txtrMes.setText("Mes");
		txtrMes.setBounds(101, 186, 25, 22);
		frmIracingTestDrive.getContentPane().add(txtrMes);

		JTextArea txtrDia = new JTextArea();
		txtrDia.setEditable(false);
		txtrDia.setBackground(UIManager.getColor("Button.background"));
		txtrDia.setText("Dia");
		txtrDia.setBounds(145, 186, 25, 22);
		frmIracingTestDrive.getContentPane().add(txtrDia);

		textHora = new JTextField();
		textHora.setBounds(258, 163, 46, 20);
		frmIracingTestDrive.getContentPane().add(textHora);
		textHora.setColumns(10);

		JTextArea txtrHhmm = new JTextArea();
		txtrHhmm.setEditable(false);
		txtrHhmm.setBackground(UIManager.getColor("Button.background"));
		txtrHhmm.setText("HH:MM");
		txtrHhmm.setBounds(258, 186, 46, 22);
		frmIracingTestDrive.getContentPane().add(txtrHhmm);

		JButton btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int trackid = (TrackList.getSelectedIndex() + 1);
				int carid = (CarList.getSelectedIndex() + 1);
				int weather = WeatherBox.getSelectedIndex();
				int temp = Integer.parseInt(txtTemperatura.getText());
				int month = Integer.parseInt(textMes.getText());
				int day = Integer.parseInt(textDia.getText());
				String hora = textHora.getText();
				String fecha = "2019-" + month + "-" + day + "%20" + hora;
				String url = iRacing.TestDrive.url(cars.array[carid].id, tracks.array[trackid].id, temp, weather,
						fecha);
				System.out.println(url);
			}
		});
		btnLaunch.setBounds(167, 227, 89, 23);
		frmIracingTestDrive.getContentPane().add(btnLaunch);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ander\\Downloads\\iRacing.png"));
		lblNewLabel.setBounds(0, 0, 434, 59);
		frmIracingTestDrive.getContentPane().add(lblNewLabel);

	}
}
