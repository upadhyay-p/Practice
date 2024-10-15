package org.opcode.factory.Commands;

public interface ICommandFactory {
    ICommand getCommandObject(String instruction) throws Exception;
}
