package org.teamresistance.frc.util.testing;

import org.strongback.Strongback;
import org.strongback.command.Command;
import org.strongback.components.ui.FlightStick;
import org.teamresistance.frc.subsystem.climb.Climber;

import static org.teamresistance.frc.util.testing.JoystickMap.RightJoystick.CLIMBER;
import static org.teamresistance.frc.util.testing.JoystickMap.RightJoystick.CLIMBER_STOP;

/**
 * @author Shreya Ravi
 */
public class ClimberTesting extends CommandTesting {
  private final Climber climber;

  public ClimberTesting(Climber climber, FlightStick joystickA, FlightStick joystickB, FlightStick joystickC) {
    super(joystickA, joystickB, joystickC);
    this.climber = climber;
  }

  public void enableClimbRopeTest() {
    reactor.onTriggeredSubmit(joystickB.getButton(CLIMBER),
        () -> climber.climbRope(70, 0.1));
    reactor.onUntriggered(joystickB.getButton(CLIMBER),
        () -> Strongback.submit(Command.cancel(climber)));
    reactor.whileTriggered(joystickB.getButton(CLIMBER_STOP), climber::stop);
  }
}
