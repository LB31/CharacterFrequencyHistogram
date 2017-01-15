import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.io.PrintWriter;
import java.io.FileReader;

public class Reader {
	private FileReader input = null;
	private PrintWriter output = null;
	private int[] counter = new int[52];
	private static JFrame frmHistogramm;

	public Reader(String input, String output) {
		try {
			nextChar(input);
			histogramMaker(output);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void nextChar(String fileIn) throws IOException {

		input = new FileReader(fileIn);

		int readStuff;
		while ((readStuff = input.read()) != -1) {

			if (readStuff >= 65 && readStuff <= 90) {
				readStuff -= 65;
				counter[readStuff]++;

			} else if (readStuff >= 97 && readStuff <= 122) {
				readStuff -= 72;
				counter[readStuff]++;

			}

		}

	}

	public void histogramMaker(String FileOut) throws FileNotFoundException {
		output = new PrintWriter(FileOut);

		for (int i = 65; i <= 122; i++) {
			int smallBig;
			if (!(i > 90 && i < 97)) {
				smallBig = (i >= 97 && i <= 122) ? 72 : 65;
				int count = counter[i - smallBig];
				String stars = "";
				for (int k = 0; k < count; k++) {
					stars += "*";
				}

				output.println((char) i + " " + stars);

			}

		}
		output.close();

	}

	public char normalizeChar(char letter) {
		int ascii = (int) letter;
		ascii += (ascii > 90) ? -32 : 32;
		return (char) ascii;
	}

	public void charArray() {
		Integer[] a = new Integer['B' + 1];
		a['B'] = 7;
		System.out.println(a.length);
		System.out.println(a['B']);

	}

	public static void main(String[] args) throws IOException {
		frmHistogramm = new JFrame();
		frmHistogramm.setTitle("Histogramm");
		frmHistogramm.setBounds(100, 100, 517, 375);
		frmHistogramm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHistogramm.getContentPane().setLayout(null);

		JDialog frameopener = new JDialog();
		frameopener.setBounds(100, 100, 505, 366);
		frameopener.getContentPane().setLayout(null);
		frameopener.setModal(true);

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(0, 0, 505, 326);
		frameopener.getContentPane().add(fileChooser);

		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			Reader fileReader = new Reader(selectedFile.getAbsolutePath(), "histogram.txt");
		}

	}
}
