import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AllChars {
	private FileReader input = null;
	private PrintWriter output = null;
	private int[] counter = new int[128];

	public AllChars(String input, String output) {
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

			counter[readStuff]++;

		}

	}

	public void histogramMaker(String FileOut) throws FileNotFoundException {
		output = new PrintWriter(FileOut);

		for (int i = 0; i <= 127; i++) {

			int count = counter[i];
			String stars = "";
			for (int k = 0; k < count; k++) {
				stars += "*";
			}
			if (i != 13)
				output.println((char) i + " " + stars);
			//
			//
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

	public static void main(String[] args) throws IOException {
		AllChars fileReader = new AllChars("file.txt", "bigHistogram.txt");
		// System.out.println(fileReader.normalizeChar('g'));
		// fileReader.nextChar("file.txt");

	}

}
