package de.volkswagen.utils;


import java.util.Map;

public final class ProgramUtils {

    public static final Map<String, String> PROGRAM_HELP = Map.of("Cd", "Change directory",
            "Ls", "List directory contents",
            "Echo", "Write arguments to the standard output",
            "Rm", "Remove files or directories",
            "MkDir", "Create directories",
            "Man", "Format and display the on-line manual pages");

    private ProgramUtils() {
    }


}
