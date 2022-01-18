# OSPF Konfiguration

## OSPF Aktivieren
OSPFv2 über Prozess-ID aktivieren

```ios
router ospf 10
```

> Best Practise: Alle OSPF Router erhalten die selbe Prozess-ID

## (Optional) OSPF Router-ID Setzen
Auf einem Loopback Interface wird die Router-ID gesetzt.

```ios
interface Loopback 1
ip address 1.1.1.1 255.255.255.255
```

Anzeigen der Router ID
```ìos
show ip protocols | include Router ID
```

> Wird die RouterID nicht gesetzt wird automatisch der Router mit der höchsten Adresse ausgewählt.

## RouterID Ändern

Ändern der bestehenden RouterID
```ìos
conf t
router ospf 10
router-id 1.1.1.1
end
```

## OSPF Netzwerke hinzufügen
Am Router angeshlossene Netzwerke dem OSPF hinzufügen

```ìos
conf t
router ospf 10
network 10.1.1.4 0.0.0.0 area 0
```

> Die Angabe der Netzmaske, kann über eine Wildcard Maske erfolgen oder über die Eingabe `0.0.0.0` damit wird die Eingetragene Netwadresse aus der Interface Konfiguration übernommen. Bei einigen IOS Versionen kann auch die "normal" Netzadresse verwendet werden.

Netzwerke können auch über die Interface Konfiguration hinzugefügt werden.

```ios
conf t
int gi0/0
ip ospf 10 area 0
```

## Passive Interfaces
Passive Interfaces verschicken keine OSPF Pakete. Alle Interfaces die nicht an dem OSPF Ring beteiligt sind, sollten als Passive Interfaces deklariert werden.

+ Es wird Bandbreite gespart
+ Die Pakete laufen ins Leere, da keine OSPF Geräte sich im Netz befindet (Brodcast Last).
+ Sicherheitsrisiko ein Angreifer könnte OSPF Sproofing betreiben.

```ios
router ospf 10
passive-interface loopback 0
```