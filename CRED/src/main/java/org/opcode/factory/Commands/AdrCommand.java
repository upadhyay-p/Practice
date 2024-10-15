package org.opcode.factory.Commands;

import org.datastore.RegisterStorage;
import org.opcode.model.Register;

public class AdrCommand implements ICommand {

    private final RegisterStorage storage;

    public AdrCommand(RegisterStorage storage) {
        this.storage = storage;
    }

    @Override
    public void executeCommandInstruction(String instruction) throws Exception {
        System.out.println(instruction);
        validateCommandInput(instruction);
        String[] instructionComponents =  instruction.split(" ");
        Register reg1 = this.storage.getRegister(instructionComponents[1].charAt(0));
        Register reg2 = this.storage.getRegister(instructionComponents[2].charAt(0));
        int newVal = reg1.getValue() + reg2.getValue();
        reg1.setValue(newVal);
        storage.updateRegister(reg1);
    }

    @Override
    public void validateCommandInput(String instruction) throws Exception {
        String[] instructionComponents =  instruction.split(" ");
        if (instructionComponents.length < 3) {
            throw new Exception("Insufficient arguments in instruction");
        }
    }


}
