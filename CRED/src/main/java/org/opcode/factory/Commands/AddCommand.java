package org.opcode.factory.Commands;

import org.datastore.RegisterStorage;
import org.opcode.model.Register;

public class AddCommand implements ICommand {
    private final RegisterStorage storage;

    public AddCommand(RegisterStorage storage) {
        this.storage = storage;
    }

    @Override
    public void executeCommandInstruction(String instruction) throws Exception {
        System.out.println(instruction);
        validateCommandInput(instruction);
        String[] instructionComponents =  instruction.split(" ");
        Register reg = this.storage.getRegister(instructionComponents[1].charAt(0));
        int newVal = reg.getValue() + Integer.parseInt(instructionComponents[2]);
        reg.setValue(newVal);
        storage.updateRegister(reg);
    }

    @Override
    public void validateCommandInput(String instruction) throws Exception {
        String[] instructionComponents =  instruction.split(" ");
        if (instructionComponents.length < 3) {
            throw new Exception("Insufficient arguments in instruction");
        }
        // for inavlid param, this will throw exception
        Integer.parseInt(instructionComponents[2]);
    }


}
