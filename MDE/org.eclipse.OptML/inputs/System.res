<?xml version="1.0" encoding="UTF-8"?>
<platformMM:PlatformDiagram xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:platformMM="http://www.example.org/platformMM">
  <System name="System" belongs="//@resourceTypes.0">
    <childs xsi:type="platformMM:CompositeResource" name="Node01" belongs="//@resourceTypes.0">
      <childs xsi:type="platformMM:TerminalResource" name="CPU0101" belongs="//@resourceTypes.1">
        <states scale="1.0" energy="100.0"/>
      </childs>
      <childs xsi:type="platformMM:TerminalResource" name="MEM0101" belongs="//@resourceTypes.2" capacity="256">
        <states scale="1.0" energy="50.0"/>
      </childs>
    </childs>
    <childs xsi:type="platformMM:CompositeResource" name="Node02" belongs="//@resourceTypes.0">
      <childs xsi:type="platformMM:TerminalResource" name="CPU0201" belongs="//@resourceTypes.1">
        <states scale="1.0" energy="120.0"/>
        <states scale="0.5" energy="50.0"/>
      </childs>
      <childs xsi:type="platformMM:TerminalResource" name="MEM0201" belongs="//@resourceTypes.2" capacity="128">
        <states scale="1.0" energy="75.0"/>
      </childs>
    </childs>
  </System>
  <resourceTypes identifier="COMPOSITE_t"/>
  <resourceTypes identifier="CPU_t" abstraction="ACTIVE"/>
  <resourceTypes identifier="MEM_t" abstraction="PASSIVE"/>
</platformMM:PlatformDiagram>
