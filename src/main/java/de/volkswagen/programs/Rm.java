package de.volkswagen.programs;

public class Rm implements CommandlineProgram {
    @Override
    public void run(String[] args) {
        if (args[0].contains("-help")) {
            help();
            return;
        }
        String path = args[0];
        boolean deleted = InMemoryCacheSingleton.getInstance().getCurrentPath().resolve(path).toFile().delete();
        if (deleted) {
            System.out.println("File deleted");
        } else {
            System.out.println("File not found");
        }
    }
}
