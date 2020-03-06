
import robocode.*;
import java.awt.Color;



// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * BackstabbinBiatch - a robot by (your name here)
 */
public class BackstabbinBiatch extends AdvancedRobot
{
	int forward=1;
	/**
	 * run: BackstabbinBiatch's default behavior
	 */
	public void run() {
			setColors(Color.YELLOW, Color.BLACK, Color.YELLOW);
			setAdjustRadarForRobotTurn(true);
			setAdjustGunForRobotTurn(true);
			turnRadarRightRadians(Double.POSITIVE_INFINITY);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getName().contains("Dumle")) {
			return;
		}
		if (e.getName().contains("Roomba")) {
			return;
		}
		double enemy = e.getBearingRadians() + getHeadingRadians();
		double velocity = e.getVelocity() * Math.sin(e.getHeadingRadians() -enemy);
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
		if(Math.random()>.9){
			setMaxVelocity((12*Math.random())+15);
		}
		

		setTurnGunRightRadians(robocode.util.Utils.normalRelativeAngle(enemy- getGunHeadingRadians()+velocity/22));
		setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(enemy-getHeadingRadians()+velocity/getVelocity()));

		
		if (e.getDistance() <= 70) {
			setFire(5);
			setAhead(-1);
		} else {
			setAhead((e.getDistance())*forward);
			if (e.getDistance() <= 100) {
				setFire(3);
			} else {
				setFire(1);
			
			}
		}

		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		// back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		forward=-forward;
	}	
	


}

