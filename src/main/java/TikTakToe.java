import java.util.*;

public class TikTakToe
{
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    static String result = checkWinner();
    public static void main(String[] args)
    {
        char[][] gameBoard =
                {{' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '}};
        game:
        while (true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("User to play tiktaktoe do you want to play aganist cpu or.... another player?");
            String choice = scan.nextLine().toLowerCase();
            while (choice.equals("player") || choice.equals("another player") || choice.equals("anotherplayer"))
            {
                System.out.println("Enter your placement (1-9) Player 1:");
                int playerPos = scan.nextInt();
                while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions) || player2Positions.contains(playerPositions) || playerPositions.contains(player2Positions))
                {
                    System.out.println("Position taken! Enter a correct Position");
                    playerPos = scan.nextInt();
                }
                if (playerPos > 9 || playerPos < 1)
                {
                    System.out.println("Invalid Position input a playerPosition between 1-9");
                    playerPos = scan.nextInt();
                }
                placePiece(gameBoard, playerPos, "player");
                printGameBoard(gameBoard);
                result = checkWinner();
                if(result.equals("") != true)
                {
                    System.out.println(result);
                    System.out.println("");
                    System.out.println("Want to play again? Y/N");
                    choice = scan.nextLine().toLowerCase();
                    boolean choseToPlay = false;
                    choseToPlay = choice == "y" || choice == "yes" ? true : false;
                    if (choseToPlay)
                    {
                        continue game;
                    } else
                    {
                        break game;
                    }
                }
                System.out.println("Enter your placement (1-9) Player 2:");
                int player2Pos = scan.nextInt();
                while (playerPositions.contains(player2Positions) || cpuPositions.contains(playerPositions))
                {
                    System.out.println("Position taken! Enter a correct Position");
                }
                placePiece(gameBoard, player2Pos, "player2");
                printGameBoard(gameBoard);
           if(result.equals("") != true)
           {
               System.out.println(result);
               System.out.println("");
               System.out.println("Want to play again? Y/N");
               choice = scan.nextLine().toLowerCase();
               boolean choseToPlay = false;
               choseToPlay = choice == "y" || choice == "yes" ? true : false;
               if (choseToPlay)
               {
                   continue game;
               } else
               {
                   break game;
               }
           }
       }


            while (choice.equals("cpu"))
            {
                System.out.println("Enter your placement (1-9):");
                int playerPos = scan.nextInt();
                while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions) || player2Positions.contains(playerPositions) || playerPositions.contains(player2Positions))
                {
                    System.out.println("Position taken! Enter a correct Position");
                    playerPos = scan.nextInt();
                }
                if (playerPos > 9 || playerPos < 1)
                {
                    System.out.println("Invalid Position input a playerPosition between 1-9");
                    playerPos = scan.nextInt();
                }

                placePiece(gameBoard, playerPos, "player");
                printGameBoard(gameBoard);
                Random rand = new Random();
                int cpuPos = rand.nextInt(9) + 1;
                while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPositions))
                {
                    System.out.println("Position taken! Enter a correct Position");
                    cpuPos = rand.nextInt(9) + 1;
                }
                placePiece(gameBoard, cpuPos, "cpu");
                printGameBoard(gameBoard);
                if(result.equals("") != true)
                {
                    System.out.println("......");
                    System.out.println();
                    System.out.println("Want to play again? Y/N");
                    choice = scan.nextLine().toLowerCase();
                    boolean choseToPlay = false;
                    choseToPlay = choice == "y" || choice == "yes" ? true : false;
                    if (choseToPlay)
                    {
                        continue game;
                    } else
                    {
                        break game;
                    }
                }
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard)
    {
        for (char[] row : gameBoard)
        {
            for (char c : row)
            {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void placePiece(char[][] gameBoard, int playerPos, String user)
    {
        char symbol = ' ';
        if (user.equals("player"))
        {
            symbol = 'X';
            playerPositions.add(playerPos);
        } else if (user.equals("cpu"))
        {
            symbol = '0';
            cpuPositions.add(playerPos);
        } else if (user.equals("player2"))
        {
            symbol = '0';
            player2Positions.add(playerPos);
        }
        switch (playerPos)
        {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner()
    {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning)
        {
            if (playerPositions.containsAll(l))
            {
                return "Congratulations you won at tik tak toe!" + " Wow You must be bigbrain to get this!";
            } else if (playerPositions.size() + cpuPositions.size() == 9)
            {
                return "TIE! NO ONE WINS!!!";
            }
        }
        return "";
    }
}



