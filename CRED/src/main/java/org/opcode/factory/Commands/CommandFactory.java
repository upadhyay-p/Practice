package org.opcode.factory.Commands;

import org.datastore.RegisterStorage;

public class CommandFactory implements ICommandFactory {
    final private AddCommand add;
    final private AdrCommand adr;
    final private MovCommand mov;
    final private InrCommand inr;
    final private DcrCommand dcr;
    final private SetCommand set;
    final private ResetCommand reset;

    public CommandFactory(RegisterStorage storage) {
        add = new AddCommand(storage);
        adr = new AdrCommand(storage);
        mov = new MovCommand(storage);
        inr = new InrCommand(storage);
        dcr = new DcrCommand(storage);
        set = new SetCommand(storage);
        reset = new ResetCommand(storage);
    }

    @Override
    public ICommand getCommandObject(String instruction) throws Exception {
        String[] instructionInput = instruction.split(" ");
        ICommand cmd;
        String operation = instructionInput[0];
        switch (operation) {
            case "ADD":
                cmd = add;
                break;
            case "ADR":
                cmd = adr;
                break;
            case "MOV":
                cmd = mov;
                break;
            case "INR":
                cmd = inr;
                break;
            case "DCR":
                cmd = dcr;
                break;
            case "SET":
                cmd = set;
                break;
            case "RST":
                cmd = reset;
                break;
            default:
                throw new Exception("Invalid input");
        }

        return cmd;
    }

}
