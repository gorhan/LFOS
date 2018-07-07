<?xml version="1.0" encoding="UTF-8"?>
<platformMM:CompositeResource xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:platformMM="http://www.example.org/platformMM" name="System">
  <childs xsi:type="platformMM:CompositeResource" name="Node01">
    <childs xsi:type="platformMM:TerminalResource" type="ACTIVE" name="CPU01" capacity="1.0">
      <states/>
    </childs>
    <childs xsi:type="platformMM:TerminalResource" type="PASSIVE" name="Memory01" capacity="512.0">
      <states/>
    </childs>
  </childs>
  <childs xsi:type="platformMM:CompositeResource" name="Node02">
    <childs xsi:type="platformMM:TerminalResource" type="ACTIVE" name="CPU02" capacity="1.0">
      <states/>
    </childs>
    <childs xsi:type="platformMM:TerminalResource" type="PASSIVE" name="Memory02" capacity="256.0">
      <states/>
    </childs>
  </childs>
</platformMM:CompositeResource>
