package org.opcode.factory.Commands;

public interface ICommand {
    void validateCommandInput(String instruction) throws Exception;
    void executeCommandInstruction(String instruction) throws Exception;
}
