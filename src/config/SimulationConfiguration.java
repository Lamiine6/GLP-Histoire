package config;

public class SimulationConfiguration {
	public static final int WINDOW_WIDTH = 1920;
	public static final int WINDOW_HEIGHT = 1080;
	
	public static final int BLOCK_SIZE = 8;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	public static int SIMULATION_SPEED = 33;
}
