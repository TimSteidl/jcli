package de.volkswagen.programs;

public class Echo implements CommandlineProgram {
    @Override
    public void run(String[] args) {
        if (args[0].contains("-help")) {
            help();
            return;
        }
        System.out.println(InMemoryCacheSingleton.getInstance().getCurrentPath().toString());
    }
}
