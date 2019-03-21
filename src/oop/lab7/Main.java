package oop.lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        StudentProcessor processor = new StudentProcessor();
        System.out.println(
                "1) Add record\n" +
                "2) Delete record\n" +
                "3) Find student by ID\n" +
                "4) Show all records\n" +
                "5) Show faculty list\n" +
                "6) Show students born after year\n" +
                "7) Show group list\n" +
                "8) Read from file\n" +
                "9) Read from binary file\n" +
                "10) Write to file\n" +
                "11) Write to binary file\n" +
                "12) Generate 5 records\n" +
                "13) Show all records (short form)\n" +
                "0) Exit"
        );

        while (true) {
            System.out.println();
            System.out.print("Choose number from menu: ");
            byte answer = in.nextByte();
            switch (answer) {
                case 0: System.exit(0);

                case 1: {
                    if ( processor.addRecord() ) {
                        System.out.println("Successfully added!");
                    } else {
                        System.out.println("Can't add record");
                    }
                    break;
                }

                case 2: {
                    System.out.print("Enter ID: ");
                    if ( processor.deleteRecord(in.nextInt()) ) {
                        System.out.println("Successfully deleted!");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter ID: ");
                    int id = in.nextInt();
                    Student student = processor.findStudent(id);
                    if ( student != null ) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                }

                case 4: {
                    processor.showAll();
                    break;
                }

                case 5: {
                    System.out.print("Enter faculty: ");
                    in.nextLine();
                    String faculty = in.nextLine();
                    ArrayList<Student> students = processor.searchFaculty(faculty);
                    if ( students.size() > 0 ) {
                        System.out.println(faculty);
                        processor.showSurnames(students);
                    } else {
                        System.out.println("No students from "+faculty);
                    }
                    break;
                }

                case 6: {
                    System.out.print("Enter year: ");
                    int year = in.nextInt();
                    ArrayList<Student> students = processor.searchAfterYear(year);
                    if ( students.size() > 0 ) {
                        System.out.println("Born after "+year);
                        processor.showSurnames(students);
                    } else {
                        System.out.println("No students born after "+year);
                    }
                    break;
                }

                case 7: {
                    System.out.print("Enter group: ");
                    int group = in.nextInt();
                    ArrayList<Student> students = processor.searchGroup(group);
                    if ( students.size() > 0 ) {
                        System.out.println("Group "+group);
                        processor.showSurnames(students);
                    } else {
                        System.out.println("No students from "+group);
                    }
                    break;
                }

                case 8: {
                    System.out.print("Enter name of file: ");
                    processor.readTextFile(in.next());
                    break;
                }

                case 9: {
                    System.out.print("Enter name of file: ");
                    processor.readBinaryFile(in.next());
                    break;
                }

                case 10: {
                    System.out.print("Enter name of file: ");
                    processor.writeTextFile(in.next());
                    break;
                }

                case 11: {
                    System.out.print("Enter name of file: ");
                    processor.writeBinaryFile(in.next());
                    break;
                }

                case 12: {
                    processor.addSomeRecords();
                    System.out.println("Generated");
                    break;
                }

                case 13: {
                    processor.showAllSurnames();
                    break;
                }

                default: System.out.println("Wrong number. Try again!");
            }
        }
    }
}