package de.volkswagen.programs;

public class Cls implements CommandlineProgram {

    @Override
    public void run(String[] args) {
        if (args.length > 1) {
            String arg = args[1];
            if (arg.contains("-help")) {
                help();
                return;
            }
        }
        System.out.println("\n".repeat(50));
    }
}
