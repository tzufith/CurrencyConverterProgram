import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        File myObj = new File("filename.txt");// create new file to write the result to
        boolean Finish=false;// if the user want to finish the program or insert another input
        ArrayList<String> myList= new ArrayList<String>(); // Create an ArrayList which can hold the calculator results
        System.out.println("Welcome to currency converter:");
        while (Finish==false) {

            System.out.println("Please choose an option (1/2): ");
            System.out.println("1.Dollar to Shekel");
            System.out.println("2.Shekel to Dollar");
            Scanner s = new Scanner(System.in);// connect to keyboard in the computer
            int Option = s.nextInt();//get the choosen option from user
            if (Option != 1 && Option != 2) {
                System.out.println("Invalid choice, please try again");
                s = new Scanner(System.in);// connect to keyboard in the computer
                Option = s.nextInt();//get the choosen option from user
            }
            System.out.println("please enter an amount to convert");
            s = new Scanner(System.in);// connect to keyboard in the computer
            double amountToConvert = s.nextDouble();//get the amount from user to convert
            coin element;
            double Results;
            if (Option == 1) {
                element = Factory.GetCoinInstance(Coins.USD); //create the USD element in the factory
                Results = element.Calculate(amountToConvert);//Calculate the amount result
            } else {
                element = Factory.GetCoinInstance(Coins.ILS); //create the ILS element in the factory
                Results = element.Calculate(amountToConvert); //Calculate the amount result
            }
            System.out.println("the results is:" + Results); //Print the result to the screen
            myList.add("The Input="+amountToConvert+"option to convert"+Option+"resoult is"+ Results);
            System.out.println("Do you want to start over N/Y");
            s = new Scanner(System.in);
            String ToContinue = s.nextLine();//get the number from user
            while (ToContinue.toLowerCase().equals("n") ==false && ToContinue.toLowerCase().equals("y")==false){
                    System.out.println("Invalid choice, please try again");
                System.out.println(ToContinue);
                s = new Scanner(System.in);
                ToContinue = s.nextLine();//get the choosen option from user
            }
            if (ToContinue.toLowerCase().equals("n") ==true){
                Finish=true; //the user choose to end the program
                String WriteToFile;
                for (int i = 0; i < myList.size(); i++) { // Iterate through an array
                    System.out.println(myList.get(i)); //Print all the calaulation to the screen
                }

                try {
                    File logFile = new File("filename.txt"); //Try to create file to write the calculation
                    BufferedWriter writer= new BufferedWriter(new FileWriter(logFile));
                    for (int i = 0; i < myList.size(); i++) { // Iterate through an array
                        writer.write(myList.get(i));  //Print all the calaulation to the file
                    }
                    writer.close(); //close the file
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Thanks for using our currency converter :)");
            }
        }
    }

}
