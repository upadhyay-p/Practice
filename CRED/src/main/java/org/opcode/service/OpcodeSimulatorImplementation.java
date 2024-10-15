package org.opcode.service;

import java.util.List;
import org.datastore.RegisterStorage;
import org.opcode.factory.Commands.CommandFactory;
import org.opcode.factory.Commands.ICommand;

public class OpcodeSimulatorImplementation implements OpcodeSimulator {
    private RegisterStorage registerState;
    private CommandFactory commandFactory;

    // Liskove Substitution: RegisterStore can hold object of type RegisterStorageLocal
    // Dependency Inversion: High level modules should contain abstractions instead of concrete classes
    public OpcodeSimulatorImplementation(RegisterStorage rs) {
        this.registerState = rs;
        this.commandFactory = new CommandFactory(rs);
    }

    public RegisterStorage execute(List<String> instructions) {
        for (String instruction : instructions) {
            try {
                ICommand commandExecutor = commandFactory.getCommandObject(instruction);
                commandExecutor.executeCommandInstruction(instruction);
            } catch (Exception e) {
                System.err.println("There was and error executing the instruction: " + e.getMessage());
            }
       }
        return registerState;
    }
}