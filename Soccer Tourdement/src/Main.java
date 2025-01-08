
public class Main {
    public static void main(String[] args) {
       

         // Store the team names
        String[] team_list = new String[8];
        for (int i = 0; i < 8; i ++){
            System.out.println("please enter the name of team " + (i+1));
            String name = sc.nextLine();
            if (i-1 >= 0){
                //Ensure uniqueness
                if(!name.equals(team_list[i-1])){
                    team_list[i] = name;
                }
                else{
                    System.out.println("please ensure the team names are unique");
                    break;
                }
            }
            else{
            team_list[i] = name;
            }
        }

        //Confirmation
        for (String i: team_list){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("enter \" confirm\" to continue");
        if (sc.nextLine().equals("confirm")){
            System.out.println("Continuing");
        }
        else{
            System.out.println("Please exit and re-enter the name");
        }

        
    }
}