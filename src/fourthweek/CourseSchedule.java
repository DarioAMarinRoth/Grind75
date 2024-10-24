package fourthweek;

import java.util.*;


public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] test1 = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        System.out.println(cs.canFinish(7, test1));
    }

    private Map<Integer, Set<Integer>> coursesWithPrerequisites;
    private Set<Integer> possibleCourses;
    private Set<Integer> analyzedCourses;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        coursesWithPrerequisites = new HashMap<>();
        possibleCourses = new HashSet<>();

        for (int[] course : prerequisites) {
            if (coursesWithPrerequisites.containsKey(course[0])) {
                coursesWithPrerequisites.get(course[0]).add(course[1]);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(course[1]);
                coursesWithPrerequisites.put(course[0], temp);
            }
        }

        for (int course = 0; course < numCourses; course++) {

            if (!coursesWithPrerequisites.containsKey(course)) {
                possibleCourses.add(course);
                continue;
            }

            if (possibleCourses.contains(course)) {
                continue;
            }

            analyzedCourses = new HashSet<>();
            if (!isPossible(course)) {
                return false;
            }
            possibleCourses.add(course);
        }
        return true;
    }


    private boolean isPossible(int course) {
        boolean isPossible = true;

        if (!coursesWithPrerequisites.containsKey(course) || possibleCourses.contains(course)) {
            possibleCourses.add(course);
            return true;
        } else if (analyzedCourses.contains(course)) {
            return false;
        } else {
            analyzedCourses.add(course);
            for (int correlative : coursesWithPrerequisites.get(course)) {
                isPossible &= isPossible(correlative);
            }
        }
        if (isPossible) {
            possibleCourses.add(course);
        }
        return isPossible;
    }

}
