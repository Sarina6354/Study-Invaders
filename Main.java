import StdDraw.java;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Math;

public class Main {
  public static void main(String[] args) throws IOException {
      StdDraw.setXScale(0, 100);
      StdDraw.setYScale(0, 100);
      StdDraw.setPenRadius(0.01);
      ArrayList<Flashcard> f = createSet();
      System.out.println("Here's your set: ");
      for (int i = 0; i < f.size(); i++){
        System.out.println(f.get(i).toString());
      }

      PrintWriter outFile = new PrintWriter(new File("createdset.txt"));
      for (int i=0; i<f.size(); i++){
        outFile.println(f.get(i).toString());
      outfile.close();
      }
      File fileName = new File("createdset.txt");
      Scanner inFile = new Scanner(System.in);
      int setLength = 0;
      while(inFile.hasNextLine())
      {
        inFile.nextLine();
        numValues++;
      }
      inFile.close();

      String [] questions = new String[numValues];
      String [] answers = new String[numValues];

      inFile = new Scanner(fileName);
      int index = 0;
      while(inFile.hasNext())
      {
        questions[index] = inFile.next();
        answers[index] = inFile.next();
        // idkkkkkk
      }
      inFile.close();

  }
  ArrayList <Flashcard> termsUsed = new ArrayList<Flashcard>();
  for (int i = 0; i < questions.length; i++)
  {
    termsUsed.add(new Flashcard(questions[i], answers[i]));
  }
  public static void showMenu(ArrayList<Flashcard> f){
    Scanner sc = new Scanner(System.in);
    System.out.println("Options:");
    System.out.println("Create a set: enter 'c'");
    System.out.println("Warning! Creating a new set will erase previously made sets.");
    System.out.println("Play Space Invaders: enter 'p'");
    System.out.println("See instructions: enter 'i'");
    String r = sc.nextLine();
    if(r.equals("c")){
        f = createSet();
    }
    else if(r.equals("p")){
      playGame(f);
    }
    else if(r.equals("i")){
      System.out.println("Welcome to Study Invaders! You are in a spaceship, and you must defeat the evil aliens by shooting them with your knowledge! Every turn, you will be shown a term from your flashcard set. If you answer the question correctly, you will be rewarded with 5 shots to beat those pesky aliens! But watch out - if you answer incorrectly you'll be the one taking damage. The game ends when you answer every question correctly, unless the aliens get to you first! Good luck and happy studying!!!");
    }
    else {
      System.out.println("Please enter a valid option!");
      showMenu(f);
    }
  }

  public static ArrayList<Flashcard> createSet () {
     Scanner sc = new Scanner(System.in);
     boolean done = false;
     ArrayList<Flashcard> set = new ArrayList<Flashcard>();
     while (!done){
       System.out.println("Enter a term: ");
       String t = sc.nextLine();
       System.out.println("Enter the definition:");
       String d = sc.nextLine();
       Flashcard f = new Flashcard(t, d);
       set.add(f);
       
       System.out.println("Would you like to add another card? 'yes' or 'no'");
       String r = sc.nextLine();
       if (r.equals("no")){
         done = true;
       }   
       else if (!r.equals("yes")){
         System.out.println("Please enter 'yes' or 'no'!");
         r = sc.nextLine();
       }
       if (r.equals("no")){
         done = true;
       } 
     }
     return set;
  }
  
  public static boolean compareCoord(ArrayList<Aliens> alist , Laser laser){
    for (int i = 0; i<aList.size();i++){
      if (aList.get(i).getX() <= (laser.getX() + 5) && aList.get(i).getX() <= (laser.getX() - 5)){
        aList.get(i).setHit();
      }
    }
  }

  public static void playGame(ArrayList<Flashcard> f){
  //display the ship at the bottom of the screen w/background
  // initialize lives and shots 
    Ship ship = new Ship();
    ArrayList<Aliens> allAliens = new ArrayList<Aliens>();
    //enemies on other side of screen (maybe like ten at the start)
    for(int i =0; i < 5; i++){ 
      Aliens a = new Aliens();
      allAliens.add(a);
    }

    while(ship.getLives() > 0){
      boolean correctAnswer = checkAnswer();
      if (correctAnswer){
      //add Lasers
      //shoot the enemies
      }
    //enemies fire back
    //update lives and shots accordingly
    //loop again (ask the question, etc.)
      if (f.size() == 0){
        System.out.println("Congrats! You showed those aliens who's boss.");
        //winning screen
        //enemies spontaneously combust
        break;
      }
      if (ship.getLives() == 0){
        System.out.println("Better luck next time, haha.");
        break;
      }
    }



    while(ship.isShipHit == false){
      ship.moveShip();
      if(StdDraw.isMousePressed()){
        Lasers shot = new Lasers(ship.getX(), ship.getY());
      }
    }
    
  // space to shoot
  // esc to pause 
        //create a pause menu
  //loop
    //question shows up:
    //the aliens get to shoot(must be within 5 y level)
    //if answer correctly, gets to have like 5 shots(must be within 5 y level)
    //game over if answer all questions or u die (lol rip)
  }

  public static boolean checkAnswer (ArrayList<Flashcard> f){
    Scanner sc = new Scanner(System.in);
    int index = (int)(Math.random() * (f.size()) + 0);
    System.out.print("What term has the definition: ");
    System.out.println(f.get(i).getDef() + "? ");
    String answ = sc.nextLine();
    if( answ.equals(f.get(i).getTerm())){
      f.remove(i);
      System.out.println("Good job, you got it! Now shoot down those aliens!");
      return true;
    }
    else{
      System.out.println("Oh no! The answer was actually " + f.get(i).getTerm());
      System.out.println("Looks like the aliens are stealing this shot.");
      return false;
    }
  }
}


