package de.volkswagen.programs;

import java.nio.file.Path;

public class Cd implements CommandlineProgram {


    @Override
    public void run(String[] args) {
        if (args[1].contains("-help")) {
            help();
            return;
        }
        if (args.length == 1) {
            System.out.println("No path given");
            return;
        }
        String path = args[1];
        if (args[1].equals("..")) {
            InMemoryCacheSingleton.getInstance().setCurrentPath(InMemoryCacheSingleton.getInstance().getCurrentPath().getParent());
        } else {
            if (Path.of(path).toFile().isDirectory()) {
                InMemoryCacheSingleton.getInstance().setCurrentPath(InMemoryCacheSingleton.getInstance().getCurrentPath().resolve(path));
            }
        }
    }
}
