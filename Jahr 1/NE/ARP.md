# Address Resolution Protokoll (ARP)
+ Die zu einer IPv4-Adresse gehörende MAC-Adresse auffinden 
+ Tabelle mit Zuordnung "IPv4 ↔ MAC" pflegen → der "ARP-Cache" 
+ ARP-Cache im RAM des Rechners

**ARP arbeitet für, aber ohne IPv4**
+ Protokoll direkt im Ethernet-Frame (EtherType 0x806) 
+ Bestandteil TCP/IP-Stack
+ Bleibt im LAN – Router leiten nicht weiter

**Zwei Nachrichten-Typen**
+ ARP-Request als Broadcast, ARP-Reply als Unicast

Netzlast durch ARP-Broadcast ggf. hoch – z.B. bei großen Netzen, oder auch bei gleichzeitigem Start der Clients

**ARP Cache**
+ automatische Bereinigung des ARP-Caches
+ Zeit zur Bereinigung von OS Abhängig
+ Manuelle Löschung ebenfalls möglich

## Neighbor Discovery Protocol (ND oder NDP)

**ARP-Gegenstück bei IPv6**
+ Nicht direkt im Ethernet-Frame → ICMPv6-Bestandteil 
+ ICMPv6 wird in IPv6-Paket gekapselt
+ Ebenfalls RAM-Tabelle → Neighbor-Cache (vgl. ARP-Cache)

**Wie ARP zwei Nachrichten-Typen für Neighbor-Auflösung**
+ Neighbor-Solicitation (NS), vergleichbar mit ARP-Request
    + Zieladresse kein Broadcast!
    + IPv6-Zieladresse → IPv6 Solicited Node Multicast Address
    + Ethernet-Destination-MAC → Multicast-MAC-Address
    + Nicht betroffene Hosts verwerfen NS auf NIC-Ebene - OS-Entlastung!

+ Neighbor-Advertisment (NA), vergleichbar mit ARP-Reply
    + Diese Message ist Unicast