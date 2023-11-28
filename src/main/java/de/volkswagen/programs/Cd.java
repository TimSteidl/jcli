package de.volkswagen.programs;

public class Cd implements CommandlineProgram {


    @Override
    public void run(String[] args) {
        if (args[0].contains("-help")) {
            help();
            return;
        }
        System.out.println("arg");
        if (args.length == 1) {
            System.out.println("No path given");
            return;
        }
        String path = args[1];
        if (args[0].equals("..")) {
            InMemoryCacheSingleton.getInstance().setCurrentPath(InMemoryCacheSingleton.getInstance().getCurrentPath().getParent());
        } else {
            InMemoryCacheSingleton.getInstance().setCurrentPath(InMemoryCacheSingleton.getInstance().getCurrentPath().resolve(path));
        }
    }
}
