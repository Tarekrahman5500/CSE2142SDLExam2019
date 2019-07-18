import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StudentList {

    public static String File_Call() throws IOException {

        BufferedReader Student_filereader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
        String input = Student_filereader.readLine();
        return input;

    }


    public static void main(String[] args) {

//		Check arguments

        if (!args[0].contains("a") && !args[0].contains("r") && !args[0].contains("+") && !args[0].contains("?") && !args[0].contains("c")) {

            System.out.println("Invalid Selection");
            System.exit(0);

        } else {
            if (args[0].equals("a")) {
                System.out.println("Loading data ...");
                try {
                    // BufferedReader Student_filereader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                    String input = File_Call(); //Student_filereader.readLine();
                    String Student_array[] = input.split(",");

                    for (String Student_name : Student_array) {
                        System.out.println(Student_name);
                    }
                } catch (Exception e) {
                }
                System.out.println("Data Loaded.");
            } else if (args[0].equals("r")) {
                System.out.println("Loading data ...");
                try {
                    // BufferedReader Student_filereader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                    String Student_Name = File_Call();
                    System.out.println(Student_Name);
                    String Student_array[] = Student_Name.split(",");
                    Random input = new Random();
                    int Random_number = input.nextInt();
                    System.out.println(Student_array[Random_number]);
                } catch (Exception e) {
                }
                System.out.println("Data Loaded.");
            } else if (args[0].contains("+")) {
                System.out.println("Loading data ...");
                try {
                    BufferedWriter Student_filereader = new BufferedWriter(new FileWriter("students.txt", true));
                    String Student_Search = args[0].substring(1);
                    Date date = new Date();
                    String date_format = "dd/mm/yyyy-hh:mm:ss a";
                    DateFormat dateFormat = new SimpleDateFormat(date_format);
                    String format_date = dateFormat.format(date);
                    Student_filereader.write(", " + Student_Search + "\nList last updated on " + format_date);
                    Student_filereader.close();
                } catch (Exception e) {
                }

                System.out.println("Data Loaded.");
            } else if (args[0].contains("?")) {
                System.out.println("Loading data ...");
                try {
                    // BufferedReader Student_filereader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                    String input = File_Call();
                    String Student_array[] = input.split(",");
                    boolean terminate_loop = false;
                    String Student_Name = args[0].substring(1);
                    for (int increment_loop = 0; increment_loop < Student_array.length && !terminate_loop; increment_loop = increment_loop + 1) {
                        if (Student_array[increment_loop].equals(Student_Name)) {
                            System.out.println("We found it!");
                            terminate_loop = true;
                        }
                    }
                } catch (Exception e) {
                }
                System.out.println("Data Loaded.");
            } else if (args[0].contains("c")) {
                System.out.println("Loading data ...");
                try {
                    // BufferedReader Student_filereader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                    String input = File_Call();
                    char Student_array[] = input.toCharArray();
                    boolean input_word = false;
                    int Total_Word = 0;
                    for (char c : Student_array) {
                        if (c == ' ') {
                            if (!input_word) {
                                Total_Word = Total_Word + 1;
                                input_word = true;
                            } else {
                                input_word = false;
                            }
                        }
                    }
                    System.out.println(Total_Word + " word(s) found " + Student_array.length);
                } catch (Exception e) {
                }
                System.out.println("Data Loaded.");
            }

        }
    }
}