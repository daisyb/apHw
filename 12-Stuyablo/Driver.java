import java.util.*;
import java.io.*;

public class Driver {

   public static void pause(int n) {
       try {
	   Thread.sleep(n);
	   } catch (Exception e) {}
	}

    public static void main(String[] args) {
	boolean gameover = false;
	System.out.println("You wake up alone in the forest");
	System.out.println("You are a warrior.");
	Scanner scan = new Scanner(System.in);
	/*
	String type = scan.nextLine();
        type = type.toLowerCase();
	type = type.replaceAll("\\s+","");
	*/
	Warrior player = new Warrior();
	    /*
	if (type.equals("warrior")) {
      	    player = new Warrior();
        }
	if (type.equals("mage")) {
	    player = new Mage();
        }
	else {

	    System.out.println("*Please type mage or warrior*");
	    type = scan.nextLine();
	    type = type.replaceAll("\\s+","");
	}
	    */
        Mage cpu = new Mage();
	System.out.println("A mysterious figure approaches...");	
        pause(1500);
	System.out.println("It speaks...");
	pause(1500);
	System.out.println("'I command you...tell me asl ;)'*Type a response*");
	String nametroll = scan.nextLine();
        pause(1000);
	System.out.println("'Excellent!'");
	pause(1000);
	System.out.println("'What is your name hottie? ;)' *Type name below:*");
	String name = scan.nextLine();
        player.setName(name);
	pause(1000);
	System.out.println("'Mucho gusto "  + name + ". I am a mage. My name is Peter Stuyvesant but you can call me tonight ;)'");
	System.out.println("'How many kidneys do you have?'*Type a response*");
	String kidnum = scan.nextLine();
        if (kidnum.equals("2") || (kidnum.toLowerCase()).equals("two")) {
	    System.out.println("'Niceee,' he says.");
	}
	else {
	    System.out.println("'You Lie!!!!' he says.");
	}
	System.out.println("'Now give me your kidneys!!!' *Yes or No*");
	String story = scan.nextLine();
	story = story.toLowerCase();
	story = story.replaceAll("\\s+","");
	if (story.equals("yes")) {
	    System.out.println("The flirtatious stranger gently places his fingers upon your waist." + "\n" + " He gropes slightly, and whispers: " + "\n" + " 'You got some healthy beans there!! ;)'");
	    pause(4000);
	    System.out.println("*shoves hand into sides and pulls out kidneys*");
	    pause(2000);
	    System.out.println("Game Over");
	    gameover = true;
	}
	else {
	    System.out.println("'Fine. Then I'll just have to take them by force!'");
	     pause(2000);
	    System.out.println("*Initiate battle*");
	}

	boolean turn = true;
	while (gameover != true) {
	//fight sequence//
	   System.out.println("Attack, run, or getStatus? *Please type as seen*");
	    String move = scan.nextLine();
	    move = move.toLowerCase();
	    move = move.replaceAll("\\s+","");
	    if (turn == true) {

		if (move.equals("attack")) {
		    System.out.println("Punch, swipe, or stab?");
		    String attacktype = scan.nextLine();
		    attacktype = attacktype.toLowerCase();
		    attacktype = attacktype.replaceAll("\\s+","");
		    if (attacktype.equals("punch")) {
			System.out.println(player.punch(cpu));
			turn = false;
		    }
		    else {
			if (attacktype.equals("swipe")) {
			    System.out.println(player.swipe(cpu));
			    turn = false;
			} else if (attacktype.equals("stab")){
			    System.out.println(player.stab(cpu));
			    turn = false;
			} else {
			    System.out.println("Command not recognized, try again.\n");
			}
		    }
		
		} 
		if (move.equals("run")) {
		    String runner = player.run(cpu);
		    System.out.println(runner);
		    if (runner.equals("You successfully fled!\n")) {
			gameover = true;
		    }
		    turn = false;
		}
		if (move.equals("getstatus")) {
		    System.out.println(player.status());
		    System.out.println(cpu.status());
		}
	    }

	    int cpuhp = cpu.getHealth();
	    if (cpuhp <= 0) {
		System.out.println("Congratulations! You defeated the mage and get to keep your kidneys!!!");
		gameover = true;
	    }
	    if (turn == false && gameover != true) {
		pause(2000);
		double d = Math.random();
		if (d < .2){
		    System.out.println(cpu.punch(player));
		    turn = true;
		}
		else {
		    if (d < .6) {
			System.out.println(cpu.FeelingsofInadequacy(player));
			turn = true;
		    }
		    else {
			System.out.println(cpu.CaffeineCrash(player));
			turn = true;
		    }
		}
	    }
	    pause(2000);

	    
	    int hp = player.getHealth();
	    if (hp <= 0) {
		System.out.println("You Died. Game over.");
		gameover = true;
	    }
	}
		
    	if (gameover == true) {
	    System.exit(0);
	}
    }
}
