package de.volkswagen.programs;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class Ls implements CommandlineProgram {

    @Override
    public void run(String[] args) {
        if (args.length > 1) {
            String arg = args[1];
            if (arg.contains("-help")) {
                help();
                return;
            }
        }
        Path url = InMemoryCacheSingleton.getInstance().getCurrentPath();
        int count = 0;
        int bytes = 0;
        File file = new File(url.toString());
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                bytes += f.length();
                System.out.println(f.getName() + " " + f.length() + " bytes");
                count++;
            }
        }
        System.out.println(count + " files" + " " + bytes + " bytes");

    }
}
