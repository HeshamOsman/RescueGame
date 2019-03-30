package model.people;

import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;
import model.disasters.Disaster;
import model.events.SOSListener;
import model.events.WorldListener;

public class Citizen implements Rescuable, Simulatable {

	private CitizenState state;
	private Disaster disaster;
	private String name;
	private String nationalID;
	private int age;
	private int hp;
	private int bloodLoss;
	private int toxicity;
	private Address location;
	private SOSListener emergencyService;
	private WorldListener worldListener;

	public Citizen(Address location, String nationalID, String name, int age) {

		this.name = name;
		this.nationalID = nationalID;
		this.age = age;
		this.location = location;
		this.state = CitizenState.SAFE;
		this.hp = 100;
		//??disaster

	}
	
	
	

	@Override
	public void cycleStep() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void struckBy(Disaster d) {
		this.state = CitizenState.IN_TROUBLE;
		this.disaster = d;
		if(this.emergencyService != null) {
			this.emergencyService.receiveSOSCall(this);
		}
		
		
	}




	public CitizenState getState() {
		return state;
	}

	public void setState(CitizenState state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if(hp>=100) {
			this.hp = 100;
		}else if(hp <= 0) {
			this.hp = 0;
			setState(CitizenState.DECEASED);
		}else {
			this.hp = hp;
		}
		
	}

	public int getBloodLoss() {
		return bloodLoss;
	}

	public void setBloodLoss(int bloodLoss) {
		if(bloodLoss>=100) {
			this.bloodLoss = 100;
			setHp(0);
		}else if(bloodLoss <= 0) {
			this.bloodLoss = 0;
			
		}else {
			this.bloodLoss = bloodLoss;
		}
	}

	public int getToxicity() {
		return toxicity;
	}

	public void setToxicity(int toxicity) {
		if(toxicity>=100) {
			this.toxicity = 100;
			setHp(0);
		}else if(toxicity <= 0) {
			this.toxicity = 0;
			
		}else {
			this.toxicity = toxicity;
		}
	}
	@Override
	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}
	@Override
	public Disaster getDisaster() {
		return disaster;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setEmergencyService(SOSListener emergencyService) {
		this.emergencyService = emergencyService;
	}
	
	

}
