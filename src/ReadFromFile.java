import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFromFile {
	private FileReader input = null;
	private PrintWriter output = null;
	private int[] counter = new int[52];

	public ReadFromFile(String input, String output) {
		try {
			nextChar(input);
			histogramMaker(output);
			charArray();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void nextChar(String fileIn) throws IOException {

		input = new FileReader(fileIn);

		int readStuff;
		while ((readStuff = input.read()) != -1) {
			// System.out.println((char)readStuff);

			if (readStuff >= 65 && readStuff <= 90) {
				readStuff -= 65;
				counter[readStuff]++;
				// System.out.println(counter[readStuff]);
			} else if (readStuff >= 97 && readStuff <= 122) {
				readStuff -= 72;
				counter[readStuff]++;
				// System.out.println(counter[readStuff]);
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

	public void histogramMakerVertical(String FileOut) throws FileNotFoundException {
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
		ReadFromFile fileReader = new ReadFromFile("file.txt", "histogram.txt");
		// System.out.println(fileReader.normalizeChar('g'));
		// fileReader.nextChar("file.txt");

	}

}
