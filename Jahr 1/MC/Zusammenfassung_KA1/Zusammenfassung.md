# MC KA1 Zusammenfassung

## Themen
+ **Zahlensysteme**
    + Dual
    + Hexadezimal
    + Dezimal
+ **Logische Verknüpfungen**
    + Und
    + Oder
    + Nicht
    + Nand
    + Xor
    + Nor
+ **Wahrheitstabellen**
+ **Disjunktive Normalform (DNF)**
+ **Impulsdiagramme**
+ **KV-Diagramme**
+ **DeMorganische Gesetz**
    + Umwandlung einer Nor oder Nand Schaltung
+ **2er Komplement**
+ **Multiplexer**
+ **Addition von Dualzahlen**
+ **RS-FlipFlop**

# Zahlensysteme

## Dual

**Basiszahl: 2**

**Ziffern: (0,1)**

Beispiel: 

`10010` = 18

**Umrechnen von Dualzahlen ins Dezimalsystem**

16, 8, 4, 2, 1

16+2=18

-> 1\*2^4 + 0\*2^3 + 0\*2^2 + 1\*2^1 + 0\*2^0 (10010)

== 18

**Umrechnen von Dezimalzahlen in Dualzahlen**

Bsp. 18

18/2 = 9 Rest 0 -> 0

9/2  = 4 Rest 1 -> 1

4/2  = 2 Rest 0 -> 0

2/2  = 1 Rest 0 -> 0

1/2  = 0 Rest 1 -> 1

== 10010

## Hexadezimal

**Basis: 16**
**Ziffern: (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F)**

-> 119 -> 1\*16^2 + 1\*16^1 + 9\*16^0

**Umwandlung von Dual in Hexadezimal**

{ 1001 0001 1101 } -> ToDo!

# Logische Verknüpfungen

## And
![](https://www.elektronik-kompendium.de/sites/dig/zeichen/02051811.gif)

**Funktionsgleichung** 

Q = A^B

**Wahrheitstabelle**
A|B|Q|
--|--|--|
|0 |0 |0
|0|1| 0
|1|0|0
|1|1|1

## Or
![](https://www.elektronik-kompendium.de/sites/dig/zeichen/02051821.gif)

**Funktionsgleichung** 

![](https://www.elektronik-kompendium.de/sites/dig/formel/02051821.gif)

**Wahrheitstabelle**
A|B|Q|
--|--|--|
|0 |0 |0
|0|1| 1
|1|0|1
|1|1|1

## Not
![](https://www.elektronik-kompendium.de/sites/dig/zeichen/02051831.gif)

**Funktionsgleichung** 

![](https://www.elektronik-kompendium.de/sites/dig/formel/02051831.gif)

**Wahrheitstabelle**
A|Q|
--|--|--|
|0 |1
|1|0

## Nand

![](https://www.elektronik-kompendium.de/sites/dig/zeichen/02051841.gif)

**Funktionsgleichung** 

![](https://www.elektronik-kompendium.de/sites/dig/formel/02051841.gif)

![](https://www.elektronik-kompendium.de/sites/dig/formel/02051842.gif)

**Wahrheitstabelle**
A|B|Q|
--|--|--|
|0 |0 |1
|0|1| 1
|1|0|1
|1|1|0

## Nor 

![](https://www.elektronik-kompendium.de/sites/dig/zeichen/02051851.gif)

**Funktionsgleichung** 

![](https://www.elektronik-kompendium.de/sites/dig/formel/02051851.gif)

![](https://www.elektronik-kompendium.de/sites/dig/formel/02051852.gif)

**Wahrheitstabelle**
A|B|Q|
--|--|--|
|0 |0 |1
|0|1| 0
|1|0|0
|1|1|0

## Xor

![](https://www.elektronik-kompendium.de/sites/dig/zeichen/02051861.gif)

**Funktionsgleichung** 

![](https://www.elektronik-kompendium.de/sites/dig/formel/02051861.gif)

**Wahrheitstabelle**
A|B|Q|
--|--|--|
|0 |0 |0
|0|1| 1
|1|0|1
|1|1|0

## Wahrheitstabellen

**Bsp mit 1 Variablen**
A|Q|
--|--|
|0 |x
|1|x

**Bsp mit 2 Variablen**
A|B|Q|
--|--|--|
|0 |0 |0
|0|1| 1
|1|0|1
|1|1|0


**Bsp mit 3 Variablen**

A|B|C|Q|
--|--|--|--|
|0 |0|0 |x
|0|0|1| x
|0|1|0|x
|0|1|1|x
|1|0|0|x
|1|0|1|x
|1|1|0|x
|1|1|1|x

## Disjunktive Normalform

+ **Vollkonjunktion:** Ist die UND-Verknüpftung in der alle vorhandenen Eingangssignale einmal vorkommen (negiert oder nicht)
+ **Disjunktive Normalform:** Besteht aus mehreren oder Verknüpften Vollkonjunktionen

Bsp. 
![](https://www.biancahoegel.de/svg/066b2f8e6f1b5c0d05eabf223b641c53d5b83b59.svg)

## Impulsdiagramm
![](Impulsdiagramm.PNG)

## KV-Diagramm
![](KV-Diagramm.PNG)

## DeMorgan Gesetze

### Regel 1
![](DeMorgan1.png)

### Regel 2
![](DeMorgan2.png)

## 2er Komplement

### Negative Zahlen im Dualsystem darstellen

![](2erkomplement.png)

> **Das Bit mit der größten Wertigkeit wird Negativ gewertet. Die restlichen Bits werden auf Addiert.**

Bsp1.
|-8|4|2|1|
-|-|-|-|
|1|1|1|1

= -1

Bsp2.
|-16|8|4|2|1|
-|-|-|-|--|
|1|1|1|1|1

= -1

### Schritt 1: Alle Stellen Invertieren

Aus `0010` wird `1101`

### Schritt 2: Mit 1 Addieren

`1101` + `0001` = `1110`

### Rechnung

`0101` (5) + `1110` (-2) = `0011` (3) 

> **Im Zahlenbereich bei 4-Bit. Von [-8] bis [7] kein Übertrag bei der Addition.**

## Multiplexer

![](Multiplexer.png)

## RS-Flip Flop

### Funktionsplan eines RS-Flip Flops ohne Taktsteuerung
![](rs-flip-flop-ohne-takt.png)

### Taktsteuerung
![](taktsteuerung.png)

### Taktzustand Gesteuert
![](taktzustandgesteuert.png)

### Taktflanken Gesteuert
![](taktflankengesteuert.png)