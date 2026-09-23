package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest= new Student(0,"",0);
        for(int i=0;i<students.length;i++){
            if(students[i].getAge()>oldest.getAge()){
                oldest=students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(int i=0;i<students.length;i++){
            if(students[i].getAge()>=18){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
    double avg = 0.0;
    if (students.length == 0) {
        return Double.NaN;
    }

    for(int i = 0;i< students.length;i++){
        avg+=students[i].getGrade();
    }
    if (avg==0){
        return Double.NaN;
    }
    return avg/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
    for(Student student: students){
        if(student.getName().equalsIgnoreCase(name)){
            return student;
        }
    }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        // by searching i found that java can implement lambda functions
        Arrays.sort(students, (student1, student2) ->
                Double.compare(student2.getGrade(), student1.getGrade())
        );
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
    for(Student student:students){
        if(student.getGrade()>=15){
            System.out.println("Student name: "+student.getName()+" Student age: "+student.getAge()+" Student grade: "+student.getGrade());
        }
    }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
    for(Student student:students){
        if(student.getId()==id){
            student.setGrade(newGrade);
            return true;
        }
    }
    return  false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i=0;i<students.length; i++) {
            for (int j = i+1; j<students.length; j++) {
                if (students[i].getName().equalsIgnoreCase(students[j].getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
    Student[] newstudents = new Student[students.length+1];
    for(int i=0;i<students.length;i++){
        newstudents[i]= students[i];
    }
    newstudents[students.length]=newStudent;
    return  newstudents;
    }
    //Important note: I have changed the name of the array from arr into students because I did so in the whole project
    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] students = {new Student(1,"Rania"),new Student(2,"Nouha",20),new Student(3,"Mohamed",21,14),new Student(4,"Manal",19,16),new Student(5,"Samira")};

        // Print all
        System.out.println("== All Students ==");
        for (Student s : students) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("the oldest student : Student id"+ManageStudent.findOldest(students).getId()+"Student name: "+ManageStudent.findOldest(students).getName()+" Student age: "+ManageStudent.findOldest(students).getAge());


        // 3) Count adults
        System.out.println("The count of adults is : "+ManageStudent.countAdults(students));

        // 4) Average grade
        System.out.println("The average grade is: "+ManageStudent.averageGrade(students));

        // 5) Find by name
        Student s1 = ManageStudent.findStudentByName(students,"manal");// should normally treat the uppercase
        if(s1!=null) {
            System.out.println("Student found id: " + s1.getId() + " Student age: " + s1.getAge() + " Student grade: " + s1.getGrade());
        }
        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : students) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by id
        // function
        boolean updated =ManageStudent.updateGrade(students,4,12);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(students, "Dina"));

        // 9) Duplicate names
        System.out.println(ManageStudent.hasDuplicateNames(students));

        // 10) Append new student
       Student[] updatedStudents =  ManageStudent.appendStudent(students,new Student(6,"yasmine",13));

    }
}

