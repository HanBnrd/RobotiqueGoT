package achievement2;

import general.Map;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class TurnRight implements Behavior {
	private MovePilot pilot;

	/**
	 * Constructeur du comportement permettant de tourner a droite
	 */
	public TurnRight() {
		// TODO Auto-generated constructor stub
		Wheel wheelB = WheeledChassis.modelWheel(Motor.B,56).offset(-120);
        Wheel wheelC = WheeledChassis.modelWheel(Motor.C,56).offset(0);
        Chassis ch = new WheeledChassis(new Wheel[]{wheelB,wheelC},2);
        MovePilot mp = new MovePilot(ch);
        mp.setLinearSpeed(60);
        mp.setAngularSpeed(30);
        pilot = mp;
	}

	public boolean takeControl() {
		// TODO Auto-generated method stub
		return Button.RIGHT.isDown();
	}

	public void action() {
		// TODO Auto-generated method stub
	     pilot.travel(80);
	     pilot.stop();
		 pilot.rotate(85);
		 pilot.stop();
	     pilot.travel(20);
	     pilot.stop();
			 // ajust position according to the orientation
	     if (Map.POSITION[2]==0) {
	        	Map.POSITION[2]=1;
	        	Map.POSITION[1]=Map.POSITION[1]+1;
	        } else if (Map.POSITION[2]==1) {
	        	Map.POSITION[2]=2;
	        	Map.POSITION[0]=Map.POSITION[0]+1;
	        } else if (Map.POSITION[2]==2) {
	        	Map.POSITION[2]=3;
	        	Map.POSITION[1]=Map.POSITION[1]-1;
	        } else if (Map.POSITION[2]==3) {
	        	Map.POSITION[2]=0;
	        	Map.POSITION[0]=Map.POSITION[0]-1;
	        }
	}

	public void suppress() {
		// TODO Auto-generated method stub
	}
}
