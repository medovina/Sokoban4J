import java.io.File;

import com.martiansoftware.jsap.JSAPException;

import cz.sokoban4j.tournament.SokobanTournamentConsole;

public class Evaluate {

	// A series of 80 levels in increasing order of difficulty.
	
	public static String[] LEVELS = new String[] { 
			// "Easy/;all",		// 11 easy levels
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;11",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;19",
			"sokobano.de/Aymeric_du_Peloux_1_Minicosmos.sok;14",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;5",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;18",
			"sokobano.de/Blazz2.sok;2",
			"sokobano.de/Cosmonotes.sok;9",
			"sokobano.de/Jacques_Duthen_Sokogen.sok;78",
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;4",
			"sokobano.de/Jacques_Duthen_Sokogen.sok;76",
			"sokobano.de/Aymeric_du_Peloux_1_Minicosmos.sok;24",
			"sokobano.de/A.K.K._Informatika.sok;2",
			"sokobano.de/Cosmonotes.sok;7",
			"sokobano.de/Cosmonotes.sok;6",
			"sokobano.de/Cosmonotes.sok;4",
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;3",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;20",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;21",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;15",
			"sokobano.de/Blazz.sok;3",
			"sokobano.de/Jacques_Duthen_Sokogen.sok;77",
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;12",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;14",
			"sokobano.de/A.K.K._Informatika.sok;3",
			"sokobano.de/Cosmonotes.sok;5",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;11",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;10",
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;9",
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;10",
			"sokobano.de/Jacques_Duthen_Kids.sok;51",
			"sokobano.de/Blazz2.sok;4",
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;2",
			"sokobano.de/Aymeric_du_Peloux_3_Nabokosmos.sok;7",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;5",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;2",
			"sokobano.de/Blazz.sok;2",
			"sokobano.de/Blazz2.sok;5",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;6",
			"sokobano.de/GRIGoRusha_Comet.sok;1",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;19",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;3",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;1",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;18",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;16",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;15",
			"sokobano.de/Brian_Damgaard_YASGen.sok;1",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;20",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;8",
			"sokobano.de/Flatland.sok;1",
			"sokobano.de/Blazz2.sok;6",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;7",
			"sokobano.de/Brian_Damgaard_YASGen.sok;2",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;22",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;12",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;3",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;4",
			"sokobano.de/Aymeric_du_Peloux_5_Cosmopoly.sok;9",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;13",
			"sokobano.de/Blazz.sok;6",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;11",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;17",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;8",
			"sokobano.de/Flatland.sok;2",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;9",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;14",
			"sokobano.de/Aymeric_du_Peloux_4_Picokosmos.sok;10",
			"sokobano.de/Blazz2.sok;7",
			"sokobano.de/A.K.K._Informatika.sok;6",
			"sokobano.de/Blazz.sok;7"
	};
	
	private static String getAllLevels() {
		StringBuffer result = new StringBuffer();
		for (String level : LEVELS) {
			result.append(";" + level);
		}
		result.delete(0, 1);
		return result.toString();
	}

	
	private static void evaluateLevels(Class<?> agentClass, boolean visualize, int maxFail) {
		String levels = getAllLevels();
		
		String ps = File.pathSeparator;
		
		try {
			SokobanTournamentConsole.main(
				new String[] {
					"-l", levels,
					"-r", "Sokoban4J-Playground/results/results-" + System.currentTimeMillis() + ".csv",
					"-t", "" + (5*1000),  // maximum of 5 seconds/level
					"-a", agentClass.getName(),
					"-v", "" + visualize, 
					"-f", "" + maxFail,
					"-i", agentClass.getSimpleName(),
					"-j", "-Xmx2g " +  // 2 GB maximum heap size 
					      "-cp Sokoban4J-Playground/target/classes"+ps+
						    "Sokoban4J-Tournament/target/classes"+ps+
					      "Sokoban4J/target/classes"+ps+
					      "Sokoban4J-Agents/target/classes"+ps+
					      "Sokoban4J-Tournament/libs/jsap-2.1.jar"+ps+
					      "Sokoban4J-Tournament/libs/process-execution-3.7.0.jar"+ps+
					      "Sokoban4J-Tournament/libs/xstream-1.3.1.jar"
				}
			);
		} catch (JSAPException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	public static void main(String[] args) {
		Class<?> agentClass = MyAgent.class;
		
		boolean visualize = false;
		
		int maxFail = 1;
		
		evaluateLevels(agentClass, visualize, maxFail);
	}
	
}