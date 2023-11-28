package de.volkswagen.programs;

public class Rm implements CommandlineProgram {
    @Override
    public void run(String[] args) {
        if (args.length > 1) {
            String arg = args[1];
            if (arg.contains("-help")) {
                help();
                return;
            }
        }
        String path = args[1];
        boolean deleted = InMemoryCacheSingleton.getInstance().getCurrentPath().resolve(path).toFile().delete();
        if (deleted) {
            System.out.println("File deleted");
        } else {
            System.out.println("File not found");
        }
    }
}
