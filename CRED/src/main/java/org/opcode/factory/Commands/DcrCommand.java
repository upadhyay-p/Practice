package org.opcode.factory.Commands;

import org.datastore.RegisterStorage;
import org.opcode.model.Register;

public class DcrCommand implements ICommand {

    private final RegisterStorage storage;

    public DcrCommand(RegisterStorage storage) {
        this.storage = storage;
    }

    @Override
    public void executeCommandInstruction(String instruction) throws Exception {
        System.out.println(instruction);
        validateCommandInput(instruction);
        String[] instructionComponents =  instruction.split(" ");
        Register reg = this.storage.getRegister(instructionComponents[1].charAt(0));
        int newVal = reg.getValue() - 1;
        reg.setValue(newVal);
        storage.updateRegister(reg);
    }

    @Override
    public void validateCommandInput(String instruction) throws Exception {
        String[] instructionComponents =  instruction.split(" ");
        if(instructionComponents.length < 2) {
            throw new Exception("Insufficient input in instruction");
        }
    }

}
