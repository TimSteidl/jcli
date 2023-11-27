package de.volkswagen.programs;

import java.io.File;
import java.nio.file.Path;

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
        Path url = InMemoryCacheSingleton.getInstance().getCurrentPath();
        boolean created = new File(url.toString() + "/" + arg).mkdir();
        if (created) {
            System.out.println("Directory created");
        } else {
            System.out.println("Directory already exists");
        }
    }
}
