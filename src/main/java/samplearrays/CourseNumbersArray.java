package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        //create a larger array
        int[] updatedCourses = new int[registeredCourses.length +2]; // to add 2 new courses
        //copy the content of the previous array
        for(int i = 0;i<registeredCourses.length;i++){
            updatedCourses[i]= registeredCourses[i];
        }
        // add two courses
        updatedCourses[registeredCourses.length]= 2170;
        updatedCourses[registeredCourses.length+1]= 2180;
        //print the content of the new array updatedCourse
        for(int i = 0;i<updatedCourses.length;i++){
            System.out.println(updatedCourses[i]);
        }
        //check if updatedCourses contains 2180 the newly added course for example
        boolean isContainedCourse = false;
        for(int i = 0;i<updatedCourses.length;i++){
            if (updatedCourses[i]==2180) {
                System.out.println("updatedCourses contains the course 2180");
                isContainedCourse= true;
            }
        }
        if(!isContainedCourse){
            System.out.println("updatedCourses does not contains the course 2180");
        }
    }
}
