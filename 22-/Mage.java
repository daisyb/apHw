public class Mage extends Basechar{
    private int magic = randomValue(10,21);
    private int manna = 25;
    
    public void setManna(int value){
        int manna = value;
    }

    public int getManna(){
	return manna;
    }
    public int getMagic(){
    return magic;
    }

    public String FeelingsofInadequacy(Basechar opponent){
	if (Success() == true){
	    String s = this+" casted 'Feelings of Inadequacy' on "+opponent + ".\n";
	    if (randomValue(1,100)< 20){
	        s = s + "However " + opponent + " has blocked the attack.\n";
		double newHealth = opponent.getHealth() - Math.round(this.magic*1.5 - opponent.getDefense());
		opponent.setHealth((int)newHealth);
		s = s + Math.round(this.magic*1.5 - opponent.getDefense()) + "pts damage dealt, ";
		s = s + opponent + " now has " + opponent.getHealth() + "hp.\n";
		this.setManna(this.getManna()-5);
		return s;
		
	    } else {		    		        	    
		double newHealth = opponent.getHealth() - Math.round(this.magic*1.5);
		opponent.setHealth((int)newHealth);
		s = s + Math.round(this.magic*1.5) + "pts damage dealt, ";
		s = s + opponent + " now has " + opponent.getHealth() + "hp.\n";
		this.setManna(this.getManna()-5);
		return s;
			  
	    
	
	    }
	} else{
	    return this+" failed to cast 'Feelings of Inadequacy' on " + opponent + ".\n";
	}
    }
   public String CaffeineCrash(Basechar opponent){
    if (Success() == true){
        String s = this+" casted 'CaffeineCrash' on "+opponent + ".\n";
        if (randomValue(1,100)< 20){
            s = s + "However " + opponent + "has blocked the attack.\n";
    	    double newHealth = opponent.getHealth() - Math.round(this.magic*2.2 - opponent.getDefense());
            opponent.setHealth((int)newHealth);
	    s = s +"" + Math.round(this.magic*2.2 - opponent.getDefense())/1 + "pts damage dealt, ";
	    s = s + opponent + "now has " + opponent.getHealth() + "hp.\n";
	    this.setManna(this.getManna()-10);
	    return s;
	    
        } else {		    		        	    
	    double newHealth = opponent.getHealth() - Math.round(this.magic*2.2);
	    opponent.setHealth((int)newHealth);
	    s = s + Math.round(this.magic*2.2)/1 + "pts damage dealt, ";
	    s = s + opponent + " now has " + opponent.getHealth() + "hp.\n";
	    this.setManna(this.getManna()-10);	    
	    return s;
	    
	}
   }else{
        return this+" failed to cast 'Caffine Crash' on " + opponent + ".\n";
	}
    }
}


