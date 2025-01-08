import java.util.Scanner;
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
        int counter = 0;
        while(counter < 4){
            int n = (int)(Math.random()*(8));
            // seprate and check if team is in a geoup or not repated
        }


        
    }
}