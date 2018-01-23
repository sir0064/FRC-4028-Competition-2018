package org.usfirst.frc.team4028.robot.paths;

import java.util.ArrayList;

import org.usfirst.frc.team4028.robot.Constants;
import org.usfirst.frc.team4028.robot.paths.PathBuilder.Waypoint;
import org.usfirst.frc.team4028.util.control.Path;

import static org.usfirst.frc.team4028.robot.paths.PathBuilder.buildPathFromWaypoints;
import static org.usfirst.frc.team4028.robot.paths.PathBuilder.flipPath;
import static org.usfirst.frc.team4028.robot.paths.PathBuilder.reversePath;

public class Paths {
	public enum PATHS {
		AUTO_RUN,
		
		// First Switch Cube
		L_SWITCH,
		R_SWITCH,
		
		// Second Switch Cube
		L_SWITCH_TO_FRONT_OF_PYRAMID,
		IN_FRONT_OF_PYRAMID_TO_LEFT_SWITCH,
		
		R_SWITCH_TO_FRONT_OF_PYRAMID,
		IN_FRONT_OF_PYRAMID_TO_RIGHT_SWITCH,
		
		TO_PYRAMID,
		AWAY_FROM_PYRAMID,
		S_TURN_FROM_PYRAMID_TO_RIGHT,
		S_TURN_FROM_PYRAMID_TO_LEFT,
		TO_L_SWITCH_AFTER_S_TURN,
		TO_R_SWITCH_AFTER_S_TURN,
		
		// Third Switch Cube
		AWAY_FROM_LEFT_SWITCH,
		PYRAMID_FOR_THIRD_CUBE_FROM_LEFT,
		AWAY_FROM_L_PYRAMID,
		TO_L_SWITCH_WITH_CUBE_3,

		AWAY_FROM_RIGHT_SWITCH,
		PYRAMID_FOR_THIRD_CUBE_FROM_RIGHT,
		AWAY_FROM_R_PYRAMID,
		TO_R_SWITCH_WITH_CUBE_3,
		
		L_SCALE,
		L_SCALE_TO_L_SWITCH_PT_1,
		L_SCALE_TO_L_SWITCH_PT_2,
		L_SWITCH_TO_L_SCALE_PT_1,
		L_SWITCH_TO_L_SCALE_PT_2,
		L_SCALE_TO_R_SWITCH_PT_1,
		L_SCALE_TO_R_SWITCH_PT_2,
		
		// Tokyo Drift Test
		TOKYO_DRIFT_PT_1,
		TOKYO_DRIFT_PT_2,
	}
	
	public static Path getPath(PATHS pathName) {
		Path path;
		switch(pathName) {		
			case AUTO_RUN:
				path = buildPathFromWaypoints(getAutoRunWaypoints());
				path.setIsReversed(false);
				return path;
				
			case L_SWITCH:
		        path = buildPathFromWaypoints(getLeftSwitchWaypoints());
		        path.setIsReversed(false);
		        return path;
			case R_SWITCH:
				path = buildPathFromWaypoints(flipPath(getLeftSwitchWaypoints()));
				path.setIsReversed(false);
				return path;
				
			case L_SWITCH_TO_FRONT_OF_PYRAMID:
				path = buildPathFromWaypoints(flipPath(getRightSwitchtoFrontofPyramidWaypoints()));
				path.setIsReversed(true);
				return path;
			case IN_FRONT_OF_PYRAMID_TO_LEFT_SWITCH:
				path = buildPathFromWaypoints(flipPath(getFrontofPyramidtoRightSwitchWaypoints()));
				path.setIsReversed(false);
				return path;
			case R_SWITCH_TO_FRONT_OF_PYRAMID:
				path = buildPathFromWaypoints(getRightSwitchtoFrontofPyramidWaypoints());
				path.setIsReversed(true);
				return path;
			case IN_FRONT_OF_PYRAMID_TO_RIGHT_SWITCH:
				path = buildPathFromWaypoints(getFrontofPyramidtoRightSwitchWaypoints());
				path.setIsReversed(false);
				return path;
			case TO_PYRAMID:
				path = buildPathFromWaypoints(getToPyramidWaypoints());
				path.setIsReversed(false);
				return path;
			case AWAY_FROM_PYRAMID:
				path = buildPathFromWaypoints(getAwayFromPyramidWaypoints());
				path.setIsReversed(true);
				return path;
			
			case AWAY_FROM_LEFT_SWITCH:
				path = buildPathFromWaypoints(getAwayFromLeftSwitchForThirdCubeWaypoints());
				path.setIsReversed(true);
				return path;
			case PYRAMID_FOR_THIRD_CUBE_FROM_LEFT:
				path = buildPathFromWaypoints(gettoLeftPyramidForThirdCubeWaypoints());
				path.setIsReversed(false);
				return path;
			case AWAY_FROM_RIGHT_SWITCH:
				path = buildPathFromWaypoints(flipPath(getAwayFromLeftSwitchForThirdCubeWaypoints()));
				path.setIsReversed(true);
				return path;
			case PYRAMID_FOR_THIRD_CUBE_FROM_RIGHT:
				path = buildPathFromWaypoints(flipPath(gettoLeftPyramidForThirdCubeWaypoints()));
				path.setIsReversed(false);
				return path;
			case S_TURN_FROM_PYRAMID_TO_LEFT:
				path = buildPathFromWaypoints(getSTurnFromPyramidtoLeftWaypoints());
				path.setIsReversed(true);
				return path;
			case TO_L_SWITCH_AFTER_S_TURN:
				path = buildPathFromWaypoints(gettoLeftSwitchAfterSTurn());
				path.setIsReversed(false);
				return path;
			case AWAY_FROM_L_PYRAMID:
				path = buildPathFromWaypoints(reversePath(gettoLeftPyramidForThirdCubeWaypoints()));
				path.setIsReversed(true);
				return path;
			case TO_L_SWITCH_WITH_CUBE_3:
				path = buildPathFromWaypoints(reversePath(getAwayFromLeftSwitchForThirdCubeWaypoints()));
				path.setIsReversed(false);
				return path;
			case S_TURN_FROM_PYRAMID_TO_RIGHT:
				path = buildPathFromWaypoints(flipPath(getSTurnFromPyramidtoLeftWaypoints()));
				path.setIsReversed(true);
				return path;
			case TO_R_SWITCH_AFTER_S_TURN:
				path = buildPathFromWaypoints(flipPath(gettoLeftSwitchAfterSTurn()));
				path.setIsReversed(false);
				return path;
			case AWAY_FROM_R_PYRAMID:
				path = buildPathFromWaypoints(reversePath(flipPath(gettoLeftPyramidForThirdCubeWaypoints())));
				path.setIsReversed(true);
				return path;
			case TO_R_SWITCH_WITH_CUBE_3:
				path = buildPathFromWaypoints(flipPath(reversePath(getAwayFromLeftSwitchForThirdCubeWaypoints())));
				path.setIsReversed(false);
				return path;
				
			case L_SCALE:
				path = buildPathFromWaypoints(getLeftScaleWaypoints());
				path.setIsReversed(false);
				return path;
			case L_SCALE_TO_L_SWITCH_PT_1:
				path = buildPathFromWaypoints(getLeftScaleToLeftSwitch1Waypoints());
				path.setIsReversed(true);
				return path;
			case L_SCALE_TO_L_SWITCH_PT_2:
				path = buildPathFromWaypoints(getLeftScaleToLeftSwitch2Waypoints());
				path.setIsReversed(false);
				return path;
			case L_SWITCH_TO_L_SCALE_PT_1:
				path = buildPathFromWaypoints(reversePath(getLeftScaleToLeftSwitch2Waypoints()));
				path.setIsReversed(true);
				return path;
			case L_SWITCH_TO_L_SCALE_PT_2:
				path = buildPathFromWaypoints(reversePath(getLeftScaleToLeftSwitch1Waypoints()));
				path.setIsReversed(false);
				return path;
			case L_SCALE_TO_R_SWITCH_PT_1:
				path = buildPathFromWaypoints(getLeftScaleToRightSwitch1Waypoints());
				path.setIsReversed(true);
				return path;
			case L_SCALE_TO_R_SWITCH_PT_2:
				path = buildPathFromWaypoints(getLeftScaleToRightSwitch2Waypoints());
				path.setIsReversed(false);
				return path;
				
			case TOKYO_DRIFT_PT_1:
				path = buildPathFromWaypoints(getTokyoDrift1Waypoints());
				path.setIsReversed(false);
				return path;
			case TOKYO_DRIFT_PT_2:
				path = buildPathFromWaypoints(getTokyoDrift2Waypoints());
				path.setIsReversed(true);
				return path;
				
			default:
				path = buildPathFromWaypoints(getDoNothingWaypoints());
				path.setIsReversed(true);
				return path;
		}
	}
	// Do Nothing (default)
	private static ArrayList<Waypoint> getDoNothingWaypoints() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(30,162,0,0));
        sWaypoints.add(new Waypoint(31,162,0,Constants.CELERY_SPEED));
        return sWaypoints;
	}
	
	// Auto Run
	private static ArrayList<Waypoint> getAutoRunWaypoints() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
		sWaypoints.add(new Waypoint(20,50,0,0));
		sWaypoints.add(new Waypoint(200,50,0,Constants.NORMAL_SPEED));
        //sWaypoints.add(new Waypoint(150,50,0,Constants.WILD_TURTLE_SPEED));
        return sWaypoints;
	}
	
	// Switch (First Cube)
	private static ArrayList<Waypoint> getLeftSwitchWaypoints() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
		sWaypoints.add(new Waypoint(18,162,0,0));
        sWaypoints.add(new Waypoint(35,162,15,Constants.FLOOR_IT_SPEED));
        sWaypoints.add(new Waypoint(75,100,30,Constants.NORMAL_SPEED));
        sWaypoints.add(new Waypoint(122,100,0,Constants.NORMAL_SPEED));
        return sWaypoints;
	}
	
	// Switch (Second Cube)
	private static ArrayList<Waypoint> getAwayFromPyramidWaypoints() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(91,162,0,0));
        sWaypoints.add(new Waypoint(45,162,0,Constants.NORMAL_SPEED));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getRightSwitchtoFrontofPyramidWaypoints() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(123,224,0,0));
        sWaypoints.add(new Waypoint(85,224,20,Constants.NORMAL_SPEED));
        sWaypoints.add(new Waypoint(65,162,12,Constants.NORMAL_SPEED));
        sWaypoints.add(new Waypoint(50,162,0,Constants.NORMAL_SPEED));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getToPyramidWaypoints() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(50,162,0,0));
        sWaypoints.add(new Waypoint(91,162,0,Constants.FLOOR_IT_SPEED));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getFrontofPyramidtoRightSwitchWaypoints() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(45,162,0,0));
        sWaypoints.add(new Waypoint(62,162,15,Constants.FLOOR_IT_SPEED));
        sWaypoints.add(new Waypoint(80,224,15,Constants.NORMAL_SPEED));
        sWaypoints.add(new Waypoint(122,224,0,Constants.WILD_TURTLE_SPEED));
        return sWaypoints;
	}
	
	// Switch (Third Cube)
	private static ArrayList<Waypoint> getSTurnFromPyramidtoLeftWaypoints(){
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(91,162,0,0));
        sWaypoints.add(new Waypoint(70,162,15,Constants.FLOOR_IT_SPEED));
        sWaypoints.add(new Waypoint(60,121,15,Constants.FLOOR_IT_SPEED));
        sWaypoints.add(new Waypoint(40,121,0,Constants.FLOOR_IT_SPEED));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> gettoLeftSwitchAfterSTurn(){
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(40,121,0,0));
        sWaypoints.add(new Waypoint(122,121,0,Constants.FLOOR_IT_SPEED));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getAwayFromLeftSwitchForThirdCubeWaypoints(){
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(122,121,0,0));
        sWaypoints.add(new Waypoint(60,121,0,Constants.FLOOR_IT_SPEED));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> gettoLeftPyramidForThirdCubeWaypoints(){
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(60,121,0,0));
        sWaypoints.add(new Waypoint(77,121,15,Constants.FLOOR_IT_SPEED));
        sWaypoints.add(new Waypoint(102,143,0,Constants.NORMAL_SPEED));
        return sWaypoints;
	}
	
	// Scale
	private static ArrayList<Waypoint>  getLeftScaleWaypoints() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(18,50,0,0));
        sWaypoints.add(new Waypoint(195,50,20,80));
        sWaypoints.add(new Waypoint(245,80,20,60));
        sWaypoints.add(new Waypoint(285,80,0,60));
    	return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getLeftScaleToLeftSwitch1Waypoints() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(285,80,0,0));
        sWaypoints.add(new Waypoint(265,80,10,60));
        sWaypoints.add(new Waypoint(265,60,0,60));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getLeftScaleToLeftSwitch2Waypoints() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(265,60,0,0));
        sWaypoints.add(new Waypoint(265,75,8,60));
        sWaypoints.add(new Waypoint(245,92,8,60));
        sWaypoints.add(new Waypoint(213,92,0,60));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getLeftScaleToRightSwitch1Waypoints() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(285,80,0,0));
        sWaypoints.add(new Waypoint(243,80,10,60));
        sWaypoints.add(new Waypoint(243,60,0,60));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getLeftScaleToRightSwitch2Waypoints() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(243,60,0,0));
        sWaypoints.add(new Waypoint(243,203,10,60));
        sWaypoints.add(new Waypoint(213,203,0,60));
        return sWaypoints;
	}
	
	// Tokyo Drift
	private static ArrayList<Waypoint> getTokyoDrift1Waypoints() {
        ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
        sWaypoints.add(new Waypoint(18,162,0,0));
        sWaypoints.add(new Waypoint(50,162,10,60));
        sWaypoints.add(new Waypoint(50,180,0,60));
        return sWaypoints;
	}
	
	private static ArrayList<Waypoint> getTokyoDrift2Waypoints() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
		sWaypoints.add(new Waypoint(50,180,0,0));
        sWaypoints.add(new Waypoint(50,162,10,60));
        sWaypoints.add(new Waypoint(100,162,0,60));
        return sWaypoints;
	}
}