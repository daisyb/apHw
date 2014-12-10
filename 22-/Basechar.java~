import java.util.*;


public abstract class Basechar{
    private int health,speed,defense,strength,magic; //base stats
    //should manna be only in mage, or basechar too?
    private Random r = new Random();
    private String name = "Peter Stuyvesant"; //default name

    //returns a random integer between lower and upper [lower,upper)
    public int randomValue(int lower, int upper){
        int value = r.nextInt(upper - lower) + lower;
	return value;
    }

    //randomly sets base stats
    //still not exactly sure about constructors and inheritence
    //should work with 0 params though, tell me if u have probs
    public Basechar(){
	health = 100;
	//health will be the same for all, stats will decide the course of battle!
	speed = randomValue(10,21);
	defense = randomValue(10,21);
	strength = randomValue(2,9); //set higher in warrior class
	magic = 0; //set higher in mage class
    }

    public String toString(){
	return name;
    }
    
    public void setName(String name){
	this.name = name;
    }

    public int getHealth(){
	return health;
    }
    
    public void setHealth(int health){
	this.health = health;
    }
    public int getDefense(){
	return defense;
    }
    
    public void setDefense(int defense){
	this.defense = defense;
    }

    public void setMagic(int value){
        magic = value;
    }
    
    public void setStrength(int value){
        strength = value;
    }
    public int getStrength(){
	return strength;
    }
    //too lazy to make get and set methods for all vars
    //I think it will be easier once he teaches us arrays
    //hopefully this will be enough 4now though



    //prints string containing stat values
    //we can use this as a battle command for strategizing
    public String status(){
	String s = name + "'s Status\n";
	s += "Health:  " + health + "\n";
	s += "Speed:   " + speed + "\n";
	s += "Defense: " + defense + "\n";
	s += "Strength:" + strength + "\n";
	//only problem is we might want to include
	//mana in this
	return s;
    }



    //returns true if attack is successfull
    //false if not
    //use this for your attack methods
    public boolean Success(){
	double successRate = speed/20.0;
	double d = Math.random();
	if (d < successRate){
	    return true;
	    //so for example
	    //if successRate = 0.7
	    //and d = 0.534624272
	    //your attack will hit
	} else {
	    return false;
	}
	//if we want we can create a 3rd critical option
	//like if successRate >= .9
	//then critical hit, or something like that
    }
	    
    
    //default physical attack for all!
    public String punch(Basechar opponent){
	String s = "";
	if (Success()){
	    int newHealth = opponent.getHealth() - this.strength;
	    //deals damage equivalent to strength stat
	    opponent.setHealth(newHealth);

	    s = s + this + " punched " + opponent + "!\n";
	    s = s + this.strength + "pts damage dealt, ";
	    s = s + opponent + " now has " + opponent.getHealth() + "hp.\n";
	    //prints damage meassage
	    //I used hp to refer to hit points, hope that's okay
	    return s;
	} else {
	    return this + " tried to punch "+ opponent + " and failed!\n";
	}
    }
    


    //method to let you run away
    public String run(Basechar opponent){
	double runChance;
        double d = Math.random();
	if (this.speed > opponent.speed){
	    runChance = 0.6;
	} else {
	    runChance = 0.2;
	} 
        if (d < runChance){
	    //probability works the same way as Successful()

	    //gameOver = true;
	    //^ or some other way of ending the game

	    return "You successfully fled!\n";
	    //^we can make this more colorful later
	} else {
	    return "Oh no! Your opponent caught up to you. The battle continues!!!\n";
	}
    }

    

    /*
     I'm still thinking about how to do block It should probably be a boolean. 
     But since what happens after you block is dependent on your opponent's attack,
     maybe it should be implemented in Driver? Or in the attack method itself? idk
      --Daisy 10/18/2014
    */
	    
}
