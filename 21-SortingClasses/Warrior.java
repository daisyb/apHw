public class Warrior extends Basechar{
    public Warrior(){
	this.setStrength(randomValue(10,21));
    }

    // Powerful attack that deals 1.5 damage, reduces Stamina by 5
    public String swipe(Basechar opponent){
	double Damage = Math.round((this.getStrength() * 2.2));


	
	if (Success() == true){ 
	    // this checkes whether the attack connects
	    if (randomValue(1,100) > 20){
		double newHealth = opponent.getHealth() - Damage;
	    
		opponent.setHealth((int)newHealth);
	    
		String s = this + " hit " + opponent + " with a sword!";
		s = s + "\n" + "The attack dealt " + Damage + " damage.";
		s = s + "\n" + opponent + " now has " + opponent.getHealth() + " health.\n";
		return s;
	    }

	    //What if the opponent blocks?
	    else {
		double newHealth = opponent.getHealth() - (Damage - opponent.getDefense());
		String s = opponent + " has blocked " + this + "'s attack!\n";
		opponent.setHealth((int)newHealth);
		s = s + "The attack dealt " + Math.round(Damage - opponent.getDefense()) +" damage.\n" ;
		s = s + opponent + " now has " + opponent.getHealth() + " health.\n";
		return s;
		    }

	}
	
	//If the attack misses
	else {
	    String s = this + "'s attack missed!\n";
	    return s;
		}
    }






    //####################################NEW ATTACK#####################################



    public String stab(Basechar opponent){
	double Damage = Math.round((this.getStrength() * 1.8));


	
	if (Success() == true){ 
	    // this checkes whether the attack connects
	    if (randomValue(1,100) > 20){
		double newHealth = opponent.getHealth() - Damage;
	    
		opponent.setHealth((int)newHealth);
	    
		String s = this + " stabs " + opponent + " with a  dagger!";
		s = s + "\n" + "The attack dealt " + Damage + " damage.";
		s = s + "\n" + opponent + " now has " + opponent.getHealth() + " health.\n";
		return s;
	    }

	    //What if the opponent blocks?
	    else {
		double newHealth = opponent.getHealth() - (Damage - opponent.getDefense());
		String s = opponent + " has blocked " + this + "'s attack!\n";
		opponent.setHealth((int)newHealth);
		s = s + "The attack dealt " + Math.round(Damage - opponent.getDefense()) + " damage.";
		s = s + "\n" +  opponent + " now has " + opponent.getHealth() + " health.\n";
		return s;
		    }

	}
	
	//If the attack misses
	else {
	    String s = this + "'s attack missed!\n";
	    return s;
		}
    }
}
