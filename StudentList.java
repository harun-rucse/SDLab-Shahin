import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	static String readFile() {
		String textFile = null;
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			textFile = reader.readLine();
		} catch (Exception e) {
		}
		return textFile;
	}

	static void writeFile(String inputText, String formatDate) {
		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("students.txt", true));
			writer.write(", " + inputText + "\nList last updated on " + formatDate);
			writer.close();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		Constants constant = new Constants();

		if (!args[0].equals("a") && !args[0].equals("r") &&  !args[0].contains("+") && !args[0].contains("?") && !args[0].contains("c")){
			System.out.println("You entered Wrong Arguments.Run again..\n");
			System.exit(0);
		}

		// Check arguments
		if (args[0].equals("a")) {
			System.out.println(constant.loadingText);
			String students[] = readFile().split(",");
			for (String singleStudent : students) {
				System.out.println(singleStudent);
			}
			System.out.println(constant.loadedText);
		} else if (args[0].equals("r")) {
			System.out.println(constant.loadingText);
			String students[] = readFile().split(",");
			int randomNumber = new Random().nextInt(students.length);
			System.out.println(students[randomNumber]);
			System.out.println(constant.loadedText);
		} else if (args[0].contains("+")) {
			System.out.println(constant.loadingText);
			String inputText = args[0].substring(1);
	
			
			//DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
			String formatDate = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
			writeFile(inputText, formatDate);
			System.out.println(constant.loadedText);
		} else if (args[0].contains("?")) {
			System.out.println(constant.loadingText);
			
			String students[] = readFile().split(",");
			
			String searchText = args[0].substring(1);
				for (int idx = 0; idx < students.length; idx++) {
					if (students[idx].trim().equals(searchText)) {
						System.out.println("We found it!");
						break;
					}
				}
			System.out.println(constant.loadedText);
		} else if (args[0].contains("c")) {
			System.out.println(constant.loadingText);
			
			String students[] =  readFile().split(",");
			System.out.println(students.length + " word(s) found ");
			System.out.println(constant.loadedText);
		}
	}
}