package de.volkswagen.programs;

import java.io.File;
import java.util.Objects;

public class Ls implements CommandlineProgram {

    @Override
    public void run(String[] args) {
        //String url = args[0];
        String url = System.getProperty("user.dir");
        String arg = "-help";
        if (arg.contains("-help")) {
            help();
            return;
        }
        int count = 0;
        File file = new File(url);
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                System.out.println(f.getName() + " " + f.length() + " bytes");
                count++;
            }
        }
        System.out.println(count + " files");

    }
}
