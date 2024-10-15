/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.opcode.factory;

import java.util.List;
import java.util.ArrayList;

import org.datastore.RegisterStorageLocal;
import org.opcode.model.Register;
import org.opcode.service.OpcodeSimulator;
import org.opcode.service.OpcodeSimulatorImplementation;
/**
 *
 * @author user
 */
public class OpcodeSimulatorFactory {
  public static OpcodeSimulator defaultOpcodeSimulatorFactory(List<Character> registerNames) {
    List<Register> registers = new ArrayList<>();
    registerNames.forEach(r-> registers.add(new Register(r)));
    return new OpcodeSimulatorImplementation(new RegisterStorageLocal(registers));
  }
}
