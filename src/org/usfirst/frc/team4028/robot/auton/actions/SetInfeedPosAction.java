package org.usfirst.frc.team4028.robot.auton.actions;

import org.usfirst.frc.team4028.robot.subsystems.CubeHandler;
import org.usfirst.frc.team4028.robot.subsystems.Infeed.INFEED_ARM_TARGET_POSITION;

public class SetInfeedPosAction implements Action{
	INFEED_ARM_TARGET_POSITION _infeedTargetPos;
	CubeHandler _cubeHandler = CubeHandler.getInstance();
	
	public SetInfeedPosAction(INFEED_ARM_TARGET_POSITION infeedTargetPos) {
		_infeedTargetPos = infeedTargetPos;
	} 

	@Override
	public void start() {
		_cubeHandler.infeedArms_MoveToPresetPosition(_infeedTargetPos);
	}

	@Override
	public void update() {
		_cubeHandler.infeedArms_MoveToPresetPosition(_infeedTargetPos);
	}

	@Override
	public void done() {}

	@Override
	public boolean isFinished() {
		return true;
	}
}