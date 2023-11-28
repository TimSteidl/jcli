package de.volkswagen;

import de.volkswagen.programs.CommandlineProgram;
import de.volkswagen.programs.InMemoryCacheSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class CommandLineRunner {

    public void run() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        String command = "";
        String[] splitCommands;
        CommandlineProgram program;
        InMemoryCacheSingleton cache = InMemoryCacheSingleton.getInstance();

        while (isRunning) {
            System.out.print(cache.getCurrentPath() + " >>> ");
            command = sc.nextLine();
            splitCommands = firstCharToUppercase(command.split(" "));
            if (splitCommands[0].equalsIgnoreCase("exit")) {
                isRunning = false;
            } else {
                try {
                    System.out.println("de.volkswagen.programs." + splitCommands[0]);
                    Class<?> clazz = Class.forName("de.volkswagen.programs." + splitCommands[0]);
                    Constructor<?> ctor = clazz.getConstructor();
                    program = (CommandlineProgram) ctor.newInstance();
                    program.run(splitCommands);
                } catch (ClassNotFoundException  | InstantiationException  | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException | NoClassDefFoundError e){
                    System.out.println("Command not found. Use 'man' for help");
                }
            }

        }

        sc.close();

    }


    private String[] firstCharToUppercase(String[] stringArray) {
        if (stringArray[0].length() >= 1) {
            char firstChar = stringArray[0].charAt(0);
            firstChar = Character.toUpperCase(firstChar);
            if(stringArray[0].length() >= 2) {
                stringArray[0] = firstChar + stringArray[0].substring(1, stringArray[0].length());
            } else {
                stringArray[0] = firstChar + "";
            }
        }
        return stringArray;
    }
}
