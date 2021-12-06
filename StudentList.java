import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	//This function is used to read a text file as string.
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

	//This function is used to write a string in text file.
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
		//creating object of Constants class
		Constants constant = new Constants();

		//checking argument
		if (!args[0].equals("a") && !args[0].equals("r") &&  !args[0].contains("+") && !args[0].contains("?") && !args[0].contains("c")){
			System.out.println("You entered Wrong Arguments.Run again..\n");
			System.exit(0);
		}

		// Check arguments
		if (args[0].equals("a")) {
			System.out.println(constant.loadingText);
			//spliting the text of file as single student
			String students[] = readFile().split(",");
			for (String singleStudent : students) {
			//printing each student from text file.
				System.out.println(singleStudent);
			}
			System.out.println(constant.loadedText);
		} else if (args[0].equals("r")) {
			System.out.println(constant.loadingText);
			//spliting the text of file as single student.
			String students[] = readFile().split(",");
			//generate random number from Random class.
			int randomNumber = new Random().nextInt(students.length);

			//printing random student from text file.
			System.out.println(students[randomNumber]);
			System.out.println(constant.loadedText);
		} else if (args[0].contains("+")) {
			System.out.println(constant.loadingText);
			String inputText = args[0].substring(1);
	
			//generate current date and time
			String formatDate = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
			writeFile(inputText, formatDate);
			System.out.println(constant.loadedText);
		} 
		//searching a student in text file.
		else if (args[0].contains("?")) {
			System.out.println(constant.loadingText);
			//spliting the text of file as single student.
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
			//print the number of single student.
			System.out.println(students.length + " word(s) found ");
			System.out.println(constant.loadedText);
		}
	}
}