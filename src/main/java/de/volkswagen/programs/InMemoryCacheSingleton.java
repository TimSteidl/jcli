package de.volkswagen.programs;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCacheSingleton {

    private static InMemoryCacheSingleton instance;
    private final List<String> commandHistory = new ArrayList();

    private Path currentPath;

    private InMemoryCacheSingleton() {
        this.currentPath = Path.of(System.getProperty("user.dir"));
    }

    public static InMemoryCacheSingleton getInstance() {
        if (instance == null) {
            synchronized (InMemoryCacheSingleton.class) {
                if (instance == null) {
                    instance = new InMemoryCacheSingleton();
                }
            }
        }

        return instance;
    }

    public Path getCurrentPath() {
        return this.currentPath;
    }

    public void setCurrentPath(Path actualPath) {
        this.currentPath = actualPath;
    }

    public void addCommandToHistory(String command) {
        this.commandHistory.add(command);
    }

    public List<String> getCommandHistory() {
        return this.commandHistory;
    }


}
