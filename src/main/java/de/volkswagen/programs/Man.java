package de.volkswagen.programs;

import de.volkswagen.utils.ProgramUtils;

import java.util.List;

public class Man implements CommandlineProgram {
    @Override
    public void run(String[] args) {
        if (args.length > 1) {
            String arg = args[1];
            if (arg.contains("-help")) {
                help();
                return;
            }
        }
        List<String> commands = List.of("Cd", "Echo", "Ls", "MkDir", "Rm");
        for (String command : commands) {
            System.out.print(command + " -> ");
            System.out.println(ProgramUtils.PROGRAM_HELP.get(command));
        }
    }
}
