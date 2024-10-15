package org.datastore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.opcode.model.Register;

public class RegisterStorageLocal implements RegisterStorage {
    private static Map<Character, Register> registers;

    public RegisterStorageLocal(List<Register> reg) {
        registers = reg.stream().collect(Collectors.toMap(Register::getName, r -> r));
    }

    @Override
    public void updateRegister(Register reg) {
        if (!registers.containsKey(reg.getName())) {
            throw new RuntimeException(String.format("The register %s is not present", reg.getName()));
        }
        registers.put(reg.getName(), reg);
    }

    @Override
    public Register getRegister(Character registerChar) {
        if (!registers.containsKey(registerChar)) {
            throw new RuntimeException(String.format("The register %s is not present", registerChar));
        }
        return registers.get(registerChar);
    }
    
    @Override
    public void resetAll() {
        registers.replaceAll((k, v) -> {
            v.setValue(0);
            return v;
        });
    }
}
