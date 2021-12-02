// CODE BY: ADRIANE TROY V. ROA
// FOR: CC 11.0 MIDTERM PRACTICAL

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TicTacToe{

    //intializing and declaring a character array "cell"
    static char[] cell=new char[9];

    //declaring a void method named "TheGame" for use later
    public static void TheGame() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //for loop giving initial values to character array "cell"
         for(int i=0;i<cell.length;i++){
             cell[i] = '.';
         }

        //program prompt
        System.out.println("\n████████╗██╗ ██████╗████████╗ █████╗  ██████╗████████╗ ██████╗ ███████╗");
        System.out.println("╚══██╔══╝██║██╔════╝╚══██╔══╝██╔══██╗██╔════╝╚══██╔══╝██╔═══██╗██╔════╝");
        System.out.println("   ██║   ██║██║        ██║   ███████║██║        ██║   ██║   ██║█████╗  ");
        System.out.println("   ██║   ██║██║        ██║   ██╔══██║██║        ██║   ██║   ██║██╔══╝  ");
        System.out.println("   ██║   ██║╚██████╗   ██║   ██║  ██║╚██████╗   ██║   ╚██████╔╝███████╗");
        System.out.println("   ╚═╝   ╚═╝ ╚═════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚══════╝");
        System.out.println("\nTicTacToe CLI App");
        System.out.println("Version 1.0");
        System.out.println("Created by Adriane Troy V. Roa for CC 11.0 Midterms");
        System.out.println("\nHello players! Welcome to my TicTacToe CLI App!\n");
        System.out.println("Choose a cell to place your marks on the 3x3 board.");
        System.out.println("The first to make a line with the marks wins.");
        System.out.println("\nNOTE: x --> Player 1 | o --> Player 2\n");

        //while loop for prompt response
        while (true){
            System.out.printf(" %c %c %-15c 1 2 3\n", cell[0], cell[1], cell[2]);
            System.out.printf(" %c %c %-6c --> %6c 5 6\n", cell[3],
                    cell[4], cell[5], '4');
            System.out.printf(" %c %c %-15c 7 8 9\n\n", cell[6], cell[7], cell[8]);
            System.out.println("The numbers above represents the cells/choice.");
            System.out.println("READY? Press Y then enter to continue");
            System.out.print(": ");
            String response = in.readLine();
            if(response.equals("Y")||response.equals("y"))
                break;
            else{
                System.out.println("\nInvalid response. Please try again.\n");
                continue;
            }
        }

        //while loop for game proper
        while (true){

            //block for player 1
            char m = 'x';
            int choice;
            System.out.print("Player 1, choose a cell: ");

            //while loops for error anticipation
            while(true){
                try{
                    choice = Integer.parseInt(in.readLine());
                    if(choice == 0){
                        System.out.print("Invalid choice. Please try again.\n: ");
                        continue;
                    }
                }
                catch(NumberFormatException e){
                    System.out.print("Invalid choice. Please try again.\n: ");
                    continue;
                }
                break;
            }
            while(choice > cell.length || cell[choice-1] != '.'){
                System.out.print("Invalid choice. Please try again.\n: ");
                try{
                    choice = Integer.parseInt(in.readLine());
                }
                catch(NumberFormatException e){
                    continue;
                }
            }
            System.out.println();
            cell[choice-1] = m;

            //checks if player 1 won
            if((cell[0]==m && cell[1]==m && cell[2]==m) ||
                (cell[3]==m && cell[4]==m && cell[5]==m) ||
                (cell[6]==m && cell[7]==m && cell[8]==m) ||
                (cell[0]==m && cell[3]==m && cell[6]==m) ||
                (cell[1]==m && cell[4]==m && cell[7]==m) ||
                (cell[2]==m && cell[5]==m && cell[8]==m) ||
                (cell[0]==m && cell[4]==m && cell[8]==m) ||
                (cell[2]==m && cell[4]==m && cell[6]==m)
                ){
                        //displays the board with greetings then breaks out
                        System.out.printf(" %c %c %c\n %c %c %c\n %c %c %c\n\n", 
                            cell[0], cell[1], cell[2], cell[3], cell[4], cell[5], cell[6],
                            cell[7], cell[8]);
                        System.out.println("PLAYER 1 WINS! CONGRATULATIONS");
                        break;
                }
            //displays the board with legends
            System.out.printf(" %c %c %-15c 1 2 3\n", cell[0], cell[1], cell[2]);
            System.out.printf(" %c %c %-6c --> %6c 5 6\n", cell[3],
                    cell[4], cell[5], '4');
            System.out.printf(" %c %c %-15c 7 8 9\n\n", cell[6], cell[7], cell[8]);

            //checks if all cells are occupied. if so, then game over
            if(cell[0] != '.' && cell[1] != '.' && cell[2] != '.' &&
                    cell[3] != '.' && cell[4] != '.' && cell[5] != '.' &&
                    cell[6] != '.' && cell[7] != '.' && cell[8] != '.'){
                        System.out.println("Game Over :< No one won.");
                        break;
                    }

            //block for player 2 (SAME SYNTAX AS PLAYER 1)
            m = 'o';
            System.out.print("Player 2, choose a cell: ");
            while(true){
                try{
                    choice = Integer.parseInt(in.readLine());
                }
                catch(NumberFormatException e){
                    System.out.print("Invalid choice. Please try again.\n: ");
                    continue;
                }
                break;
            }
            while(choice > cell.length || cell[choice-1] != '.'){
                System.out.print("Invalid choice. Please try again.\n: ");
                try{
                    choice = Integer.parseInt(in.readLine());
                }
                catch(NumberFormatException e){
                    continue;
                }
            }
            System.out.println();
            cell[choice-1] = m;
            if((cell[0]==m && cell[1]==m && cell[2]==m) ||
                (cell[3]==m && cell[4]==m && cell[5]==m) ||
                (cell[6]==m && cell[7]==m && cell[8]==m) ||
                (cell[0]==m && cell[3]==m && cell[6]==m) ||
                (cell[1]==m && cell[4]==m && cell[7]==m) ||
                (cell[2]==m && cell[5]==m && cell[8]==m) ||
                (cell[0]==m && cell[4]==m && cell[8]==m) ||
                (cell[2]==m && cell[4]==m && cell[6]==m)
                ){
                        System.out.printf(" %c %c %c\n %c %c %c\n %c %c %c\n\n", 
                            cell[0], cell[1], cell[2], cell[3], cell[4], cell[5], cell[6],
                            cell[7], cell[8]);
                        System.out.println("PLAYER 2 WINS! CONGRATULATIONS");
                        break;
                }

            System.out.printf(" %c %c %-15c 1 2 3\n", cell[0], cell[1], cell[2]);
            System.out.printf(" %c %c %-6c --> %6c 5 6\n", cell[3],
                    cell[4], cell[5], '4');
            System.out.printf(" %c %c %-15c 7 8 9\n\n", cell[6], cell[7], cell[8]);
            
            if(cell[0] != '.' && cell[1] != '.' && cell[2] != '.' &&
                    cell[3] != '.' && cell[4] != '.' && cell[5] != '.' &&
                    cell[6] != '.' && cell[7] != '.' && cell[8] != '.'){
                        System.out.println("Game Over :< No one won.\n");
                        break;
                    }
            }
    }

    //start of main method
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        //while loop for proper flow
        while(true){
            TheGame();

            //checks if players want to play again
            System.out.println("\nPlay again? Press Y then enter to do so.");
            System.out.println("Otherwise, press any key then enter or");
            System.out.print("just press enter.\n:");
            String again=in.readLine();
            if(again.equals("y") || again.equals("Y")){
                continue;
            }
            else{
                System.out.println("Exiting the game...");
                break;
            }
        }
    }
}

// CODE BY: ADRIANE TROY V. ROA
// FOR: CC 11.0 MIDTERM PRACTICAL
