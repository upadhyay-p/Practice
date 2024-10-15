package org.opcode.factory.Commands;

import org.datastore.RegisterStorage;

public class ResetCommand implements ICommand {
    private final RegisterStorage storage;
    
    public ResetCommand(RegisterStorage storage) {
        this.storage = storage;
    }
    @Override
    public void validateCommandInput(String instruction) {
        // command name is already validated in factory method, this command does not have any other input
        // hence no validation required.
        return;
    }

    @Override
    public void executeCommandInstruction(String instruction) {
        this.storage.resetAll();
    }

}
