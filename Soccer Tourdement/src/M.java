import java.util.Scanner;
import java.util.ArrayList;
public class M{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Store the team names
        String[] team_list = new String[8];
        for (int i = 0; i < 8; i++) {
            System.out.println("Please enter the name of team " + (i + 1));
            String name = sc.nextLine();

            //Looking at Uniqueness
            int isUnique = 0;
            for (int j = 0; j < i; j++) {
                if (name.equals(team_list[j])) {
                    isUnique = 1;
                    j = i;
                }
            } if (isUnique == 0) {
                team_list[i] = name;
            } else {
                System.out.println("Please ensure the team names are unique");
                i--;
            }
        }

        //Confirmation
        for (String i: team_list){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("enter \"confirm\" to continue");
        if (sc.nextLine().toLowerCase().equals("confirm")){
            System.out.println("Continuing");
        } else {
            System.out.println("Please exit and re-enter the name");
        }

        //Assign teams
        String[] group1 = new String[4];
        String[] group2 = new String[4];
        int[] assignedIndices = new int[8];
        int counter = 0;
        int counter2 = 0;


        //putting teams in groups
        while(counter < 4 || counter2 < 4){
            int n = (int)(Math.random()*(8));
            if (assignedIndices[n] == 0) {
                assignedIndices[n] = 1;
                if (counter < 4) {
                    group1[counter++] = team_list[n];
                } else {
                    group2[counter2++] = team_list[n];
                }
            }

        }
        System.out.println("\nGroup 1:");
        for (String team : group1) {
            System.out.println(team);
        }

        System.out.println("\nGroup 2:");
        for (String team : group2) {
            System.out.println(team);
        }


        //Game Result
        System.out.println("\nLet The Group 1 Games Begin");
        int game = 1;
        int[] point_1 = new int[4];
        int[] goal_scored_1 = new int[4];
        int[] goal_received_1 = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                System.out.println("\nGame " + game);
                System.out.println(group1[i] + " VS " + group1[j]);
                System.out.println("Please enter the score of the game, seperated by space");
                String[] result = sc.nextLine().split(" ");
                if (Integer.parseInt(result[0]) == Integer.parseInt(result[1])) {
                    point_1[i] += 1;
                    point_1[j] += 1;
                    goal_scored_1[i] += Integer.parseInt(result[0]);
                    goal_scored_1[j] += Integer.parseInt(result[1]);
                    goal_received_1[i] += Integer.parseInt(result[1]);
                    goal_received_1[j] += Integer.parseInt(result[0]);
                    game++;
                } else if (Integer.parseInt(result[0]) > Integer.parseInt(result[1])) {
                    point_1[i] += 3;
                    point_1[j] += 0;
                    goal_scored_1[i] += Integer.parseInt(result[0]);
                    goal_scored_1[j] += Integer.parseInt(result[1]);
                    goal_received_1[i] += Integer.parseInt(result[1]);
                    goal_received_1[j] += Integer.parseInt(result[0]);
                    game++;
                } else if (Integer.parseInt(result[0]) < Integer.parseInt(result[1])) {
                    point_1[i] += 0;
                    point_1[j] += 3;
                    goal_scored_1[i] += Integer.parseInt(result[0]);
                    goal_scored_1[j] += Integer.parseInt(result[1]);
                    goal_received_1[i] += Integer.parseInt(result[1]);
                    goal_received_1[j] += Integer.parseInt(result[0]);
                    game++;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(group1[i] + " has a total points of " + point_1[i] + "| Goals scored: " + goal_scored_1[i] + "| Goal received: " + goal_received_1[i]);
            System.out.println("--------------------------------------------------------");
        }


        //Advancing From Group 1
        int[] goal_difference = new int[4];
        for (int i = 0; i < 4; i++) {
            goal_difference[i] = goal_scored_1[i] - goal_received_1[i];
        }
        int first = -2;
        int second = -1;
        int advanced_1 = -1;
        int advanced_2 = -1;

        for (int i = 0; i < 4; i++) {
            if (point_1[i] > first) {
                second = first;
                advanced_2 = advanced_1;

                first = point_1[i];
                advanced_1 = i;
            } else if (point_1[i] == first) {
                if (goal_difference[i] > goal_difference[advanced_1]) { // Compare goal difference
                    second = first;
                    advanced_2 = advanced_1;

                    advanced_1 = i;
                } else if (goal_difference[i] == goal_difference[advanced_1]) { // Same goal difference
                    if (goal_scored_1[i] > goal_scored_1[advanced_1]) { //Compare goal
                        second = first;
                        advanced_2 = advanced_1;

                        advanced_1 = i;
                    } else if (goal_scored_1[i] > goal_scored_1[advanced_2]) {
                        advanced_2 = i;
                    }
                }
            } else if (point_1[i] > second) {
                second = point_1[i];
                advanced_2 = i;
            } else if (point_1[i] == second) {
                if (goal_difference[i] > goal_difference[advanced_2]) { // Compare goal difference
                    advanced_2 = i;
                } else if (goal_difference[i] == goal_difference[advanced_2]) { // Same goal difference
                    if (goal_scored_1[i] > goal_scored_1[advanced_2]) { // Compare Goal
                        advanced_2 = i;
                    }
                }
            }
        }
        System.out.println("\nTeams that advance from Group 1: " + group1[advanced_1] + " and " + group1[advanced_2]);

        String[] group1_advanced = new String[2];
        group1_advanced[0] = group1[advanced_1];
        group1_advanced[1] = group1[advanced_2];


        //Group2
        System.out.println("\nLet The Group 2 Games Begin:");
        int game2 = 1;
        int[] point_2 = new int[4];
        int[] goal_scored_2 = new int[4];
        int[] goal_received_2 = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                System.out.println("\nGame " + game2);
                System.out.println(group2[i] + " VS " + group2[j]);
                System.out.println("Please enter the result, seperated by space");
                String[] result = sc.nextLine().split(" ");
                if (Integer.parseInt(result[0]) == Integer.parseInt(result[1])) {
                    point_2[i] += 1;
                    point_2[j] += 1;
                    goal_scored_2[i] += Integer.parseInt(result[0]);
                    goal_scored_2[j] += Integer.parseInt(result[1]);
                    goal_received_2[i] += Integer.parseInt(result[1]);
                    goal_received_2[j] += Integer.parseInt(result[0]);
                    game2++;
                } else if (Integer.parseInt(result[0]) > Integer.parseInt(result[1])) {
                    point_2[i] += 3;
                    point_2[j] += 0;
                    goal_scored_2[i] += Integer.parseInt(result[0]);
                    goal_scored_2[j] += Integer.parseInt(result[1]);
                    goal_received_2[i] += Integer.parseInt(result[1]);
                    goal_received_2[j] += Integer.parseInt(result[0]);
                    game2++;
                } else if (Integer.parseInt(result[0]) < Integer.parseInt(result[1])) {
                    point_2[i] += 0;
                    point_2[j] += 3;
                    goal_scored_2[i] += Integer.parseInt(result[0]);
                    goal_scored_2[j] += Integer.parseInt(result[1]);
                    goal_received_2[i] += Integer.parseInt(result[1]);
                    goal_received_2[j] += Integer.parseInt(result[0]);
                    game2++;
                }
            }
        } for (int i = 0; i < 4; i++) {
            System.out.println(group2[i] + " has a total points of: " + point_2[i] + "| Goals scored: " + goal_scored_2[i] + "| Goal received: " + goal_received_2[i]);
            System.out.println("--------------------------------------------------------");
        }

        //Advance from Group 2
        int[] goal_difference2 = new int[4];
        for (int i = 0; i < 4; i++) {
            goal_difference2[i] = goal_scored_2[i] - goal_received_2[i];
        }
        int first2 = -2;
        int second2 = -1;
        int advanced_3 = -1;
        int advanced_4 = -1;

        for (int i = 0; i < 4; i++) {
            if (point_2[i] > first2) {
                second2 = first2;
                advanced_4 = advanced_3;

                first2 = point_2[i];
                advanced_3 = i;
            } else if (point_1[i] == first2) {
                if (goal_difference[i] > goal_difference[advanced_3]) { // Compare goal difference
                    second2 = first2;
                    advanced_4 = advanced_3;

                    advanced_3 = i;
                } else if (goal_difference[i] == goal_difference[advanced_3]) { // Same goal difference
                    if (goal_scored_2[i] > goal_scored_2[advanced_3]) { //Compare goal
                        second2 = first2;
                        advanced_4 = advanced_3;

                        advanced_3 = i;
                    } else if (goal_scored_2[i] > goal_scored_2[advanced_4]) {
                        advanced_4 = i;
                    }
                }
            } else if (point_2[i] > second2) {
                second2 = point_2[i];
                advanced_4 = i;
            } else if (point_2[i] == second2) {
                if (goal_difference2[i] > goal_difference2[advanced_4]) { // Compare goal difference
                    advanced_4 = i;
                } else if (goal_difference2[i] == goal_difference2[advanced_4]) { // Same goal difference
                    if (goal_scored_2[i] > goal_scored_2[advanced_4]) { // Compare Goal
                        advanced_4 = i;
                    }
                }
            }
        }
        System.out.println("\nTeams that advance from Group 2: " + group2[advanced_3] + " and " + group2[advanced_4]);

        String[] group2_advanced = new String[2];
        group2_advanced[0] = group2[advanced_3];
        group2_advanced[1] = group2[advanced_4];

        //Combining the goal
        ArrayList<Integer> goal_list = new ArrayList<>();
        for (int element : goal_scored_1){
            goal_list.add(element);
        }
        for (int element : goal_scored_2){
            goal_list.add(element);
        }

        System.out.println(goal_list);
        sc.close();
        //Semi-Final

        String[] Final = new String[2];
        int Final_index_1 = -1;
        int Final_index_2 = -1;
        String[] semi_1 = new String[2];
        semi_1[0] = group1[advanced_1];
        semi_1[1] = group2[advanced_4];
        String[] semi_2 = new String[2];
        semi_2[0] = group1[advanced_2];
        semi_2[1] = group2[advanced_3];
        System.out.println(advanced_1);
        System.out.println(advanced_2);
        System.out.println(advanced_3);
        System.out.println(advanced_4);

        System.out.println("Semi-Final 1: " + group1[advanced_1] + " VS " + group2[advanced_4]);
        int goal_1 = (int) (Math.random() * 10);
        int goal_2 = (int) (Math.random() * 10);
        if (goal_1 == goal_2){
            while(goal_1 == goal_2){
                int i = 1;
                System.out.println("It is a tie, entering round" + i + "penalties kick");
                int penalties_1 = (int)(Math.random() * 5);
                int penalties_2 = (int)(Math.random() * 5);
                goal_1 += penalties_1;
                goal_2 += penalties_2;
                i ++;
            }
            System.out.println("After the penalties kick, the result is: " + goal_1 + ":" + goal_2);
            if (goal_1 < goal_2){
                System.out.println("The result is: " + goal_1 + ":" + goal_2);
                System.out.println(semi_1[1] + "advances to the final");
                Final[0] = semi_1[1];
                Final_index_1 = 4 + advanced_4;
            }
            else if (goal_1 > goal_2){
                System.out.println("The result is: " + goal_1 + ":" + goal_2);
                System.out.println(semi_1[0] + "advances to the final");
                Final[0] = semi_1[0];
                Final_index_1 = advanced_1;
            }
        }
        else
        if (goal_1 < goal_2){
            System.out.println("The result is: " + goal_1 + ":" + goal_2);
            System.out.println(semi_1[1] + "advances to the final");
            Final[0] = semi_1[1];
            Final_index_1 = 4 + advanced_4;
        }
        else if (goal_1 > goal_2){
            System.out.println("The result is: " + goal_1 + ":" + goal_2);
            System.out.println(semi_1[0] + "advances to the final");
            Final[0] = semi_1[0];
            Final_index_1 = advanced_1;
        }

        goal_list.set(advanced_1, goal_list.get(advanced_1) + goal_1);
        goal_list.set(4 + advanced_4, goal_list.get(advanced_4 + 4) + goal_2);
        System.out.println(goal_list);


        System.out.println("Semi-Final 2: " + group1[advanced_2] + " VS " + group2[advanced_3]);
        int goal_3 = (int) (Math.random() * 10);
        int goal_4 = (int) (Math.random() * 10);
        if (goal_3 == goal_4){
            while(goal_3 == goal_4){
                int i = 1;
                System.out.println("It is a tie, entering round" + i + "penalties kick");
                int penalties_1 = (int)(Math.random() * 5);
                int penalties_2 = (int)(Math.random() * 5);
                goal_3 += penalties_1;
                goal_4 += penalties_2;
                i ++;
            }
            System.out.println("After the penalties kick, the result is: " + goal_3 + ":" + goal_4);
            if (goal_3 < goal_4){
                System.out.println("The result is: " + goal_3 + ":" + goal_4);
                System.out.println(semi_2[1] + " advances to the final");
                Final[1] = semi_2[1];
                Final_index_2 = 4 + advanced_3;
            }
            else if (goal_3 > goal_4){
                System.out.println("The result is: " + goal_3 + ":" + goal_4);
                System.out.println(semi_2[0] + " advances to the final");
                Final[1] = semi_2[0];
                Final_index_2 = advanced_2;
            }
        }
        else
        if (goal_3 < goal_4){
            System.out.println("The result is: " + goal_3 + ":" + goal_4);
            System.out.println(semi_2[1] + " advances to the final");
            Final[1] = semi_2[1];
            Final_index_2 = 4 + advanced_3;
        }
        else if (goal_3 > goal_4){
            System.out.println("The result is: " + goal_3 + ":" + goal_4);
            System.out.println(semi_2[0] + " advances to the final");
            Final[1] = semi_2[0];
            Final_index_2 = advanced_2;
        }

        goal_list.set(advanced_2, goal_list.get(advanced_2) + goal_3);
        goal_list.set(4 + advanced_3, goal_list.get(advanced_3 + 4) + goal_4);
        System.out.println(goal_list);

        //Final
        System.out.println("The Final is " + Final[0] + "vs" + Final[1]);
        int Goal_1 = (int) (Math.random() * 10);
        int Goal_2 = (int) (Math.random() * 10);
        if (Goal_1 == Goal_2) {
            while (Goal_1 == Goal_2) {
                int i = 1;
                System.out.println("It is a tie, entering round" + i + "penalties kick");
                int penalties_1 = (int) (Math.random() * 5);
                int penalties_2 = (int) (Math.random() * 5);
                Goal_1 += penalties_1;
                Goal_2 += penalties_2;
                i++;
            }
            System.out.println("After the penalties kick, the result is: " + Goal_1 + ":" + Goal_2);
            if (Goal_1 < Goal_2) {
                System.out.println("The result is: " + Goal_1 + ":" + Goal_2);
                System.out.println(Final[1] + " Win the game!");

            } else if (Goal_1 > Goal_2) {
                System.out.println("The result is: " + Goal_1 + ":" + Goal_2);
                System.out.println(Final[0] + " Win the game!");
            }
        }
        else if (Goal_1 < Goal_2) {
            System.out.println("The result is: " + Goal_1 + ":" + Goal_2);
            System.out.println(Final[1] + " Win the game!");
        } else if (Goal_1 > Goal_2) {
            System.out.println("The result is: " + Goal_1 + ":" + Goal_2);
            System.out.println(Final[0] + " Win the game!");
        }

        goal_list.set(Final_index_1, goal_list.get(Final_index_1) + Goal_1);
        goal_list.set(Final_index_2, goal_list.get(Final_index_2) + Goal_2);
       

        //Tournament
        int max = -1;
        for (int i : goal_list) {
            if (i > max){
                max = i;
            }
        }
        System.out.println("The top scorer is team" + team_list[goal_list.indexOf(max)]);
        System.out.println("which scored total " + max + "goals");


    }
}