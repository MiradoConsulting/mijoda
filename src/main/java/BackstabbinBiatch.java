
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
			setAdjustRadarForRobotTurn(true);
			setAdjustGunForRobotTurn(true);
			turnRadarRightRadians(Double.POSITIVE_INFINITY);
			setBodyColor(Color.yellow);
			setGunColor(Color.yellow);
			setRadarColor(Color.yellow);
			setScanColor(Color.yellow);
			setBulletColor(Color.yellow);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double enemy = e.getBearingRadians() + getHeadingRadians();
		double velocity = e.getVelocity() * Math.sin(e.getHeadingRadians() -enemy);
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
		if(Math.random()>.9){
			setMaxVelocity((12*Math.random())+12);
		}
		
		setTurnGunRightRadians(robocode.util.Utils.normalRelativeAngle(enemy- getGunHeadingRadians()+velocity/22));
		setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(enemy-getHeadingRadians()+velocity/getVelocity()));
		setAhead((e.getDistance() - 140)*forward);
		setFire(3);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		forward=-forward;
	}	
	
	public void onDeath(DeathEvent event) {
		onDeath(event);
	}

}

