package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.subsystems.Elevator.ELEVATOR_PRESET_POSITION;

public class CubeHandler {
	private Infeed _infeed = Infeed.getInstance();
	private Elevator _elevator = Elevator.getInstance();
	private Carriage _carriage = Carriage.getInstance();
			
	//=====================================================================================
	//Define Singleton Pattern
	//=====================================================================================	
	private static CubeHandler _instance = new CubeHandler();
	
	public static CubeHandler getInstance() {
		return _instance;
	}
	
	//=====================================================================================
	//Private Constructor for Singleton pattern
	//=====================================================================================	
	private CubeHandler() {}
	
	//=====================================================================================
	//Methods for Handling Interactions between multiple Subsystems
	//=====================================================================================	
	public void runInfeedCubePlusCarriage(double joystickCommand) {
		if(_elevator.isElevatorAtFloorPosition()) {
			_infeed.driveInfeedWheelsVBus(joystickCommand);
			_carriage.infeedCarriageMotorsVBus(joystickCommand);
		}
	}
	
	public void runInfeedSpinManuver() {
		_infeed.spinManuverInfeedWheels();
	}
	
	public void ejectCube(double joystickCommand) {
		_carriage.ejectCubeVBus(joystickCommand);
	}
	
	public void moveElevatorToFloorInfeed() {
		if(_infeed.moveArmsToSafePosition()) {
			_elevator.MoveToPresetPosition(ELEVATOR_PRESET_POSITION.CUBE_ON_FLOOR);	
		}
	}
	
	public boolean isSafeToMoveElevatorUp() {
		if(_infeed.moveArmsToSafePosition()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void doNothing() {
		_infeed.doNothing();
		_elevator.doNothing();
	}
	
	public void stop() {
		_infeed.stopDriveMotors();
		_carriage.stop();
	}
}