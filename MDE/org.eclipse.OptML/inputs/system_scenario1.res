<?xml version="1.0" encoding="UTF-8"?>
<platformMM:PlatformDiagram xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:platformMM="http://www.example.org/platformMM">
  <System name="System" belongs="//@resourceTypes.0">
    <childs xsi:type="platformMM:TerminalResource" name="CPU0101" belongs="//@resourceTypes.1">
      <states scale="1.0" energy="100.0"/>
    </childs>
    <childs xsi:type="platformMM:TerminalResource" name="MEM0101" belongs="//@resourceTypes.2" capacity="1024">
      <states scale="1.0" energy="50.0"/>
    </childs>
  </System>
  <resourceTypes identifier="COMPOSITE_t"/>
  <resourceTypes identifier="CPU_t" abstraction="ACTIVE"/>
  <resourceTypes identifier="MEM_t" abstraction="PASSIVE"/>
</platformMM:PlatformDiagram>
