package model.infrastructure;

import java.util.ArrayList;

import model.disasters.Disaster;
import model.events.SOSListener;
import model.people.Citizen;
import model.people.CitizenState;
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
	public ResidentialBuilding(Address location) {

		this.location = location;
		this.structuralIntegrity = 100;
		occupants = new ArrayList<Citizen>();
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
		// TODO Auto-generated method stub
		
	}
	
	
	public int getStructuralIntegrity() {
		return structuralIntegrity;
	}

	public void setStructuralIntegrity(int structuralIntegrity) {
		this.structuralIntegrity = structuralIntegrity;
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
