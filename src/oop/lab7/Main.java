package oop.lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private Scanner in = new Scanner(System.in);
    private StudentProcessor processor = new StudentProcessor();

    private void run() {
        printMenu();
        int answer;
        while (true) {
            answer = menu();

            switch (answer) {
                case 0: System.exit(0);

                case 1: {
                    if ( processor.addRecord() ) System.out.println("Successfully added!");
                    else System.out.println("Can't add record");
                    break;
                }

                case 2: {
                    System.out.print("Enter ID: ");
                    if ( processor.deleteRecord(in.nextInt()) ) System.out.println("Successfully deleted!");
                    else System.out.println("Student not found");
                    break;
                }

                case 3: {
                    findStudent();
                    break;
                }

                case 4: {
                    processor.printAllStudents();
                    break;
                }

                case 5: {
                    printFaculty();
                    break;
                }

                case 6: {
                    printYear();
                    break;
                }

                case 7: {
                    printGroup();
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
                    processor.printAllSurnames();
                    break;
                }

                default: System.out.println("Wrong number. Try again!");
            }
        }
    }

    private void printGroup() {
        System.out.print("Enter group: ");
        int group = in.nextInt();
        ArrayList<Student> students = processor.searchGroup(group);
        if ( students.size() > 0 ) {
            System.out.println("Group "+group);
            processor.printSurnames(students);
        } else {
            System.out.println("No students from "+group);
        }
    }

    private void printYear() {
        System.out.print("Enter year: ");
        int year = in.nextInt();
        ArrayList<Student> students = processor.searchAfterYear(year);
        if ( students.size() > 0 ) {
            System.out.println("Born after "+year);
            processor.printSurnames(students);
        } else {
            System.out.println("No students born after "+year);
        }
    }

    private void printFaculty() {
        System.out.print("Enter faculty: ");
        in.nextLine();
        String faculty = in.nextLine();
        ArrayList<Student> students = processor.searchFaculty(faculty);
        if ( students.size() > 0 ) {
            System.out.println(faculty);
            processor.printSurnames(students);
        } else {
            System.out.println("No students from "+faculty);
        }
    }

    private void findStudent() {
        System.out.print("Enter ID: ");
        int id = in.nextInt();
        Student student = processor.findStudent(id);
        if ( student != null ) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    private void printMenu(){
        System.out.println( "1) Add record\n" +
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
    }

    private int menu() {
        System.out.println();
        System.out.print("Choose number from menu: ");
        return in.nextInt();
    }
}