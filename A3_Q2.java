// --------------------------------------------------------------------
// Assignment 3 Question 2
// Written by: Yuqian Cai (40187954)
// For COMP 248 Section (EC) – Winter 2023
// --------------------------------------------------------------------
//algorithm of question two is on the text file
//comp_u-248;Soen_G-348;MATH_w-332;sTat_h-228
//enel_s-325;SOEN_f-287;comp_t-248;COMp_w-248

import java.util.Scanner;

public class A3_Q2 {
    public static void main(String[] args) {
        //welcome message
        System.out.println("=======****======****======****======****======****=========");
        System.out.println("Welcome to Concordia ACSD Exam Registration Program (CAERP): ");
        System.out.println("=======****======****======****======****======****=========");
        System.out.println();
        System.out.println("Please enter a list of courses having ACSD students:");
        
        // Variable declarations.
        Scanner input = new Scanner(System.in);
        String fullInput = input.next();
        String delimeter = ";";
        String courseNameadd;
        String courseNameinputbefore;
        //using api split to separate string
        String[] courses = fullInput.split(delimeter);
        // build arrays.
        String[] courseName = new String[100];
        String[] courseNumber = new String[100];
        int[] students = new int[100];
        int[] rank = new int[100];
        boolean done = false;
        boolean done2 = false;
        int position;
        int countIndex;
        String[] coursesAdd;
        String newInput;

        //print the menu window
        System.out.println("===============================");
        System.out.println("|  Choice. Description        |");
        System.out.println("===============================");
        System.out.println("|   1.      List of courses   |");
        System.out.println("|   2.      Add a student     |");
        System.out.println("|   3.      Add course(s)     |");
        System.out.println("|   4.      Display details   |");
        System.out.println("|   0.      Exit CAERP        |");
        System.out.println("==============================");
        System.out.println();
        System.out.print("Please enter your choice (1, 2, 3, 4, or 0) :");

        //assign all input to array courseName and courseNumber first
        for (position = 0; position < courses.length; position++) {
            courseName[position] = courses[position].substring(0, 6);
            courseNumber[position] = courses[position].substring(courses[position].length() - 3);

        }
        //using a while statement after user's choice and lead to the right one
        while (!done) {
            String choice = input.next();
            //print the list of courses
            if (choice.equals("1")) {
                System.out.println("==============================");
                System.out.println("|  Course Name-Course Number |");
                System.out.println("==============================");
                //courseName[] and courseNumber[] will be print by index 0 to the end.
                for (int i = 0; i < position; i++) {
                    System.out.println("|   " + courseName[i].toUpperCase() + "\t   " + courseNumber[i] + "\t     |");
                }
                System.out.println("==============================");
            }
            // let user input which course they want to add student, if the input is correct, students is adding in.
            if (choice.equals("2")) {
            	System.out.println();
            	System.out.print("Please enter the course name you want to add student to: ");
                courseNameadd = input.next();
                for (int i = 0; i < position; i++) {
                    //using a string to record the string array courses[] from index 0 to the end.
                    courseNameinputbefore = courses[i];
                    //and whether courses contains courseNameadded,if yes, print and student is adding in.
                    if (courseNameinputbefore.toUpperCase().contains(courseNameadd.toUpperCase())) {
                        done2 = true;
                        System.out.println("A student has been successfully added to the course: " + courseNameinputbefore.toUpperCase());
                        System.out.println();
                        students[i]++; // record how many students and are from which course
                        break;// if yes, finish the for loop
                    }
                }
                //if not, let user continue to input.
                if (!done2) {
                    System.out.println("Course name : " + courseNameadd.toUpperCase() + " is inexistent in the list of courses.");
                    System.out.println();
                }
            }
            // assign NEW list of courses to the array[] newInput, and still using split by ";"
            if (choice.equals("3")) {
            	System.out.println();
            	System.out.println("Please enter a NEW list of courses to add to the ACSD:");
                newInput = input.next();
                coursesAdd = newInput.split(delimeter);
                // all remaining holds in the array courseName[] and courseNumber[] can be defined until the old and new input amounts.
                for (countIndex = position; countIndex < position + coursesAdd.length; countIndex++) {
                    courseName[countIndex] = coursesAdd[countIndex - position].substring(0, 6);
                    courseNumber[countIndex] = coursesAdd[countIndex - position].substring(coursesAdd[countIndex - position].length() - 3);
                }
                position += coursesAdd.length;// a new length of all arrays can be updated by plus the array newInput.length
            	System.out.println("Successfully added a NEW set of courses to Concordia ACSD Exam Registration (CAERP).");
            	System.out.println();

            }
            //print the table included rank, students, courseName, and courseNumber.
            if (choice.equals("4")) {
                System.out.println("============================================");
                System.out.println("| rank | #students | Course Name - Number |");
                System.out.println("============================================");

                // use two for loop to compare students[i] and students[j], if students[i] < students[j], then the rank
                //result will plus one, if not then do not change, then the largest int from student[] which is result will be 1.
                for (int i = 0; i < students.length; i++) {
                    int result = 1; //initialize the result back to one
                    for (int j = 0; j < students.length; j++) {
                        if (students[i] < students[j]) {
                            result++;
                        }
                        rank[i] = result;
                    }
                }
                //Sort the array in descending order using two for loops
                for (int i = 0; i < rank.length; i++) {
                    for (int j = i + 1; j < rank.length; j++) {
                        if (rank[i] > rank[j]) {
                            int temp = rank[i];
                            rank[i] = rank[j];
                            rank[j] = temp;
                            //and changing all positions for array students[], courseName[], courseNumber[]
                            int tempStudents = students[i];
                            students[i] = students[j];
                            students[j] = tempStudents;

                            String tempCourseName = courseName[i];
                            courseName[i] = courseName[j];
                            courseName[j] = tempCourseName;

                            String tempCourseNumber = courseNumber[i];
                            courseNumber[i] = courseNumber[j];
                            courseNumber[j] = tempCourseNumber;
                        }
                    }
                }
                //print all strings and integers from array rank[], students[], courseName[], courseNumber[]   
                for (int a = 0; a < position; a++) {
                    System.out.println("|   " + rank[a] + " |\t\t" + students[a] + "  |  " + courseName[a].toUpperCase() + " - " + courseNumber[a] + "\t  |");
                }

            }
            //boolean done is true, while statement ends.
            if (choice.equals("0")) {
                done = true;
                System.out.println("Thank you for using Concordia CAERP Exam Registration Program! ");
            } else {
                System.out.print("\n Kindly keep entering a valid choice from the menu:");
               
            }
            
        }
        input.close();


    }
}
