package org.usfirst.frc.team4028.robot.auton.modes.center;

import org.usfirst.frc.team4028.robot.auton.AutonBase;
import org.usfirst.frc.team4028.robot.auton.actions.PrintTimeFromStart;
import org.usfirst.frc.team4028.robot.auton.actions.RunMotionProfileAction;
import org.usfirst.frc.team4028.robot.paths.Paths;
import org.usfirst.frc.team4028.robot.paths.Paths.Center;
import org.usfirst.frc.team4028.util.control.Path;

public class AutoRun extends AutonBase {
	Path path = Paths.getPath(Center.AUTO_RUN);
	
	@Override
	public void routine() {
		runAction(new RunMotionProfileAction(path, true));
		runAction(new PrintTimeFromStart(_startTime));
	}
}