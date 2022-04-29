# IPv6 Adresstypen

## Link-Local-Adressen
Link Local Adressen sind nur in dem sich befindlichen Netzwerksegment nutzbar. Dies bedeutet in der Regel sind diese Adressen bis zum ersten Router gültig. Da Link Lokal Adressen an unterschieldichen Interfaces mehrfach verwendet werden können ist für die Kommunikation über die gleiche Adresse das Interface mitzugeben.

Der Netzbereich für Link Local Adresse ist: `fe80::/10`

Bsp. für das Interface `eth0` `fe80::7645:6de2:ff:1%eth0` 

## Global-Unicast-Adressen
Sind alle öffentlich im Internet routebaren Adressen.
Diese werden von der IANA an die LIRs von dort aus an die ISPs und dann an die Endkunden verteilt.

## Unique-Local-Adressen
Unique Locak Adressen sind in einem LAN oder anderen privaten Netzwerk Routebar.
Sie können aber nicht über das öffentliche Netz geroutet werden.

Der Netzbereich für Unique Local Adressen ist: `FD00::/8`

## Site-Local-Adressen
Können nur innerhalb eines privaten Netzwerks geroutet werden.
Durch den kleinen Netzbereich kam es oft zu netzüberlagerungen gerade im zusammenhang mit VPN Tunneln.
Aus diesem Grund wurde der Standard 2004 durch die Unique-Local-Adressen abgelöst.