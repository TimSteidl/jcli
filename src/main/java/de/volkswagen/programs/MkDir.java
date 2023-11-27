package de.volkswagen.programs;

import java.io.File;

public class MkDir implements CommandlineProgram {
    @Override
    public void run(String[] args) {
        String arg = args[0];
        if (arg.contains("-help")) {
            help();
            return;
        }
        if (args.length == 0) {
            System.out.println("No arguments");
            return;
        }
        //TODO Change to Singleton variant
        String url = System.getProperty("user.dir");
        boolean created = new File(url + "/" + arg).mkdir();
        if (created) {
            System.out.println("Directory created");
        } else {
            System.out.println("Directory already exists");
        }
    }
}
