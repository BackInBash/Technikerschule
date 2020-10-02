# Virtualisierung

Hypervisoren erlauben den simultanen Betrieb mehrerer Gastsysteme auf einem Hostsystem. Der Hypervisor verwaltet die Ressourcenzuteilung für einzelne Gastsysteme. Er verteilt die Hardware-Ressourcen derart, dass für jedes einzelne Gastbetriebssystem alle Ressourcen bei Bedarf verfügbar sind, so, als ob nur ein Betriebssystem vorhanden wäre. Dies kann durch Hardware-Emulation, Hardware-Virtualisierung oder Paravirtualisierung stattfinden. Den einzelnen Gastsystemen wird dabei jeweils ein eigener kompletter Rechner mit allen Hardware-Elementen (Prozessor, Laufwerke, Arbeitsspeicher usw.) vorgespielt.

## Type 1 Hypervisor
![type-1](https://upload.wikimedia.org/wikipedia/commons/5/53/VMM-Type1.JPG)

+ Bare Metal Virtualisierung
+ Performanter da hier das OS nur die Aufgabe der Virtalisierung übernimmt

## Type 2 Hypervisor
![type-2](https://upload.wikimedia.org/wikipedia/commons/1/1a/VMM-Type2.JPG)

+ Hypervisor baut auf bestehendes OS auf
+ Performance ist nicht so gut wie bei einem Type 1 Hypervisor, da das OS noch andere Aufgaben außer der Virualisierung übernimmt.

## Liste von Virtualisierungslösungen
+ HyperV
+ KVM
+ XEN
+ ESXi
+ OpenNebula
+ OpenStack
+ Proxmox

## Netzwerk

Anbindung der VMs ans Netzwerk.

+ Bridge

    Anbindung an die Physikaleische Netzwerk Karte des Hosts

+ NAT

    Network Adress Translation

+ Local Only

    Virtueller Netzwerk Adapter um VMs untereinander zu Verbinden.