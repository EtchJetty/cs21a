/**
 * This is provided code, do not modify
 * 
 * @author COSI 21a-Team
 *
 */
public class Player {
    private String name;
    private int id;
    private double ELO;

    
	
    public Player(String name,int id,double ELO){
		this.name = name;
		this.id=id;
		this.ELO=ELO;
    }
	
    public String getName(){
    	return name;
    }
	
    public int getID(){
    	return id;
    }
    
    public double getELO(){
    	return ELO;
    }

    public void logVictory(Player defeatedPlayer) {
        this.ELO+=defeatedPlayer.logDefeat(this);
	
    }
    
    private double logDefeat(Player victoriousPlayer) {
		double theirELO=victoriousPlayer.getELO();
		theirELO=Math.pow(10.0,theirELO/400.0);
		double myELO=Math.pow(10.0,this.ELO/400.0);
		double totalSkill=myELO+theirELO;
		double myExp=myELO/totalSkill;
		double theirExp=theirELO/totalSkill;
		this.ELO-=32.0*myExp;
		return 32.0*(1.0-theirExp);
    }

    public void stalemate(Player worthyAdversary) {
    	this.ELO+=worthyAdversary.internalStalemate(this);
    }

    public double internalStalemate(Player worthyAdversary) {
		double theirELO=worthyAdversary.getELO();
		theirELO=Math.pow(10.0,theirELO/400.0);
		double myELO=Math.pow(10.0,this.ELO/400.0);
		double totalSkill=myELO+theirELO;
		double myExp=myELO/totalSkill;
		double theirExp=theirELO/totalSkill;
		this.ELO+=32.0*(0.5-myExp);
		
		return 32.0*(0.5-theirExp);	
    }

    public boolean equals(Player person2) {
    	return this.id==person2.id;
    }	
	
}
