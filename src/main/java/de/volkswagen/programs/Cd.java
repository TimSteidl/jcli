package de.volkswagen.programs;

public class Cd implements CommandlineProgram {


    @Override
    public void run(String[] args) {
        if (args.length == 0) {
            help();
            return;
        }
        String path = args[0];
        if (args[0].equals("..")) {
            InMemoryCacheSingleton.getInstance().setCurrentPath(InMemoryCacheSingleton.getInstance().getCurrentPath().getParent());
        } else {
            InMemoryCacheSingleton.getInstance().setCurrentPath(InMemoryCacheSingleton.getInstance().getCurrentPath().resolve(path));
        }
    }
}
