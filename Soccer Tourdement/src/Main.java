import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        // Store the team names
        String[] team_list = new String[8];
        for (int i = 0; i < 8; i++) {
            System.out.println("Please enter the name of team " + (i + 1));
            String name = sc.nextLine();
            //Looking at Uniqueness
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (name.equals(team_list[j])) {
                    isUnique = false;
                    break;
                }
            } if (isUnique) {
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
        if (sc.nextLine().equals("confirm")){
            System.out.println("Continuing");
        }
        else{
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
            
        

        // game result
        System.out.println("Group 1");
        int game = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                System.out.println("game" + game);
                System.out.println( group1[i] + " VS " + group1[j]);
                System.out.println("please enter the result, seperated by space");
                

            }
        }
    }
}