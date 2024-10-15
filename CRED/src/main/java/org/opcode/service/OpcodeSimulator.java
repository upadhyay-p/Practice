package org.opcode.service;

import java.util.List;

import org.datastore.RegisterStorage;

public interface OpcodeSimulator {
    RegisterStorage execute(List<String> instructions);
}
