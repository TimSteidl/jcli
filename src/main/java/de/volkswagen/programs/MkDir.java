package de.volkswagen.programs;

import java.io.File;
import java.nio.file.Path;

public class Mkdir implements CommandlineProgram {
    @Override
    public void run(String[] args) {
        String arg = "";
        if (args.length > 1) {
            arg = args[1];
            if (arg.contains("-help")) {
                help();
                return;
            }
        } else {
            System.out.println("No arguments");
            return;
        }
        Path url = InMemoryCacheSingleton.getInstance().getCurrentPath();
        boolean created = new File(url.toString() + "/" + arg).mkdir();
        if (created) {
            System.out.println("Directory created");
        } else {
            System.out.println("Directory already exists");
        }
    }
}
