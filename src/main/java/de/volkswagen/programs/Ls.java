package de.volkswagen.programs;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class Ls implements CommandlineProgram {

    @Override
    public void run(String[] args) {

        //String url = args[0];
        Path url = InMemoryCacheSingleton.getInstance().getCurrentPath();
        String arg = "";
        if (arg.contains("-help")) {
            help();
            return;
        }
        int count = 0;
        File file = new File(url.toString());
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                System.out.println(f.getName() + " " + f.length() + " bytes");
                count++;
            }
        }
        System.out.println(count + " files");

    }
}
