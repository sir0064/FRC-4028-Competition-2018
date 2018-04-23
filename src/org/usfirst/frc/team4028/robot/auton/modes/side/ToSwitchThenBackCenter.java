package org.usfirst.frc.team4028.robot.auton.modes.side;

import java.util.Arrays;

import org.usfirst.frc.team4028.robot.auton.AutonBase;
import org.usfirst.frc.team4028.robot.auton.actions.*;
import org.usfirst.frc.team4028.robot.paths.Paths;
import org.usfirst.frc.team4028.robot.paths.Paths.Left;
import org.usfirst.frc.team4028.robot.paths.Paths.Right;
import org.usfirst.frc.team4028.robot.subsystems.Elevator.ELEVATOR_PRESET_POSITION;
import org.usfirst.frc.team4028.robot.subsystems.Infeed.INFEED_ARM_TARGET_POSITION;
import org.usfirst.frc.team4028.util.control.Path;

public class ToSwitchThenBackCenter extends AutonBase{
	Path toSwitchSide;
	Path toBackSide;
	
	public ToSwitchThenBackCenter(boolean isStartingLeft) {
		if (isStartingLeft) {
			toSwitchSide = Paths.getPath(Left.L_SWITCH_SIDE);
			toBackSide = Paths.getPath(Left.TO_BACK_LEFT);
		} else {
			toSwitchSide = Paths.getPath(Right.R_SWITCH_SIDE);
		}
	}
	
	@Override
	public void routine() {
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
				new SeriesAction(Arrays.asList(new Action[] {
						new WaitAction(0.8),
						new MoveElevatorToPosAction(44)
				})),
				new RunTimedMotionProfileAction(toSwitchSide, 2.6)
		})));
		runAction(new OutfeedCubeAction());
		runAction(new PrintTimeFromStart(_startTime));
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
				new SeriesAction(Arrays.asList(new Action[] {
						new TurnAction(0, false),
						new RunMotionProfileAction(toBackSide)
				})),
				new MoveElevatorToPosAction(ELEVATOR_PRESET_POSITION.INFEED_HEIGHT)
		})));
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
				new TurnAction(165, true),
				new SetInfeedPosAction(INFEED_ARM_TARGET_POSITION.WIDE)
		})));
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
				new DriveSetDistanceAction(16),
				new SeriesAction(Arrays.asList(new Action[] {
						new WaitAction(0.5),
						new InfeedCubeAction()
				}))
		})));
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
				new DriveSetDistanceAction(14),
				new SetInfeedPosAction(INFEED_ARM_TARGET_POSITION.STORE),
				new MoveElevatorToPosAction(30)
		})));
		// Outfeed cube for 0.2s
		runAction(new OutfeedCubeAction());
		runAction(new PrintTimeFromStart(_startTime));
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
					new SeriesAction(Arrays.asList(new Action[] {
							new DriveSetDistanceAction(-13.0),
							new SetInfeedPosAction(INFEED_ARM_TARGET_POSITION.WIDE),
							new TurnAction(120.0, false)
					})),
					new MoveElevatorToPosAction(ELEVATOR_PRESET_POSITION.INFEED_HEIGHT)
		})));
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
				new DriveSetDistanceAction(15.0),
				new SeriesAction(Arrays.asList(new Action[] {
						new WaitAction(.4),
						new InfeedCubeAction()
				}))
				
		})));
		runAction(new SimultaneousAction(Arrays.asList(new Action[] {
				new TurnAction(80.0,false),
				new SetInfeedPosAction(INFEED_ARM_TARGET_POSITION.STORE)
		})));
		runAction(new DriveSetDistanceAction(15));
		runAction(new PrintTimeFromStart(_startTime));
	}
}