package de.volkswagen.programs;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCacheSingleton {

    private InMemoryCacheSingleton instance;
    private List<String> commandHistory = new ArrayList();

    private Path currentPath;

    private InMemoryCacheSingleton() {
        this.currentPath = Path.of(System.getProperty("user.dir"));
    }

    public InMemoryCacheSingleton getInstance() {
        if (this.instance == null) {
            synchronized (InMemoryCacheSingleton.class) {
                if (this.instance == null) {
                    this.instance = new InMemoryCacheSingleton();
                }
            }
        }
        
        return this.instance;
    }

    public void setCurrentPath(Path actualPath) {
        this.currentPath = actualPath;
    }

    public Path getCurrentPath() {
        return this.currentPath;
    }

    public void addCommandToHistory(String command) {
        this.commandHistory.add(command);
    }

    public List<String> getCommandHistory() {
        return this.commandHistory;
    }




}
