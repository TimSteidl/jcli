package de.volkswagen.programs;

import de.volkswagen.utils.ProgramUtils;

public interface CommandlineProgram {

    public default void help(){
        System.out.println(ProgramUtils.PROGRAM_HELP.get(getClass().getSimpleName()));
    }

    void run(String[] args);


}
