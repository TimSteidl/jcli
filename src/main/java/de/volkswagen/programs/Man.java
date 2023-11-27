package de.volkswagen.programs;

import de.volkswagen.utils.ProgramUtils;

import java.util.List;

public class Man implements CommandlineProgram {
    @Override
    public void run(String[] args) {
        if (args[0].contains("-help")) {
            help();
            return;
        }
        List<String> commands = List.of("cd", "echo", "ls", "mkdir", "pwd", "rm");
        for (String command : commands) {
            System.out.println(command);
            System.out.println(ProgramUtils.PROGRAM_HELP.get(command));
        }
    }
}
