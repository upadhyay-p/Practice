package org.datastore;

import org.opcode.model.Register;

public interface RegisterStorage {
    Register getRegister(Character regName);
    void updateRegister(Register r);
    void resetAll();
}
