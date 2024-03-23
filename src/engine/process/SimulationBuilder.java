package engine.process;

import config.SimulationConfiguration;
import engine.map.Map;


public class SimulationBuilder {

	public static Map buildMap() {
		return new Map(SimulationConfiguration.LINE_COUNT, SimulationConfiguration.COLUMN_COUNT);
	}
}

