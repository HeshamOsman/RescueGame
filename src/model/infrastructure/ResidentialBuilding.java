package model.infrastructure;

import java.security.SecureRandom;
import java.util.ArrayList;

import model.disasters.Disaster;
import model.events.SOSListener;
import model.people.Citizen;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public class ResidentialBuilding implements Rescuable, Simulatable {

	private Address location;
	private int structuralIntegrity;
	private int fireDamage;
	private int gasLevel;
	private int foundationDamage;
	private ArrayList<Citizen> occupants;
	private Disaster disaster;
	private SOSListener emergencyService;
	private SecureRandom sr;
	public ResidentialBuilding(Address location) {

		this.location = location;
		this.structuralIntegrity = 100;
		occupants = new ArrayList<Citizen>();
		this.sr = new SecureRandom();
		//??disaster
	}
	
	@Override
	public void struckBy(Disaster d) {
		
		this.disaster = d;
		if(this.emergencyService != null) {
			this.emergencyService.receiveSOSCall(this);
		}
		
		
	}

	@Override
	public void cycleStep() {
		if (foundationDamage>0) {
			setStructuralIntegrity(getStructuralIntegrity()-getRandom(5, 10));
		}
		
		if (fireDamage>0 && fireDamage<30) {
			setStructuralIntegrity(getStructuralIntegrity()-3);
		}else if(fireDamage>=30&&fireDamage<70) {
			setStructuralIntegrity(getStructuralIntegrity()-5);
		}else if(fireDamage>=70&&fireDamage<100){
			setStructuralIntegrity(getStructuralIntegrity()-7);
		}
		
	}
	
	private int getRandom(int start,int end) {
		return start+sr.nextInt(end);
	}
	
	public int getStructuralIntegrity() {
		return structuralIntegrity;
	}

	public void setStructuralIntegrity(int structuralIntegrity) {
		if(structuralIntegrity<=0) {
			structuralIntegrity = 0;
			for(Citizen s:occupants) {
				s.setHp(0);
			}
		}else {
			this.structuralIntegrity = structuralIntegrity;
		}
	
	}

	public int getFireDamage() {
		return fireDamage;
	}

	public void setFireDamage(int fireDamage) {
		this.fireDamage = fireDamage;
	}

	public int getGasLevel() {
		return gasLevel;
	}

	public void setGasLevel(int gasLevel) {
		this.gasLevel = gasLevel;
	}

	public int getFoundationDamage() {
		return foundationDamage;
	}

	public void setFoundationDamage(int foundationDamage) {
		this.foundationDamage = foundationDamage;
	}

	@Override
	public Address getLocation() {
		return location;
	}

	public ArrayList<Citizen> getOccupants() {
		return occupants;
	}

	@Override
	public Disaster getDisaster() {
		return disaster;
	}
	public void setEmergencyService(SOSListener emergencyService) {
		this.emergencyService = emergencyService;
	}
}
