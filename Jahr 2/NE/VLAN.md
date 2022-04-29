# VLAN Best Practices

## Native VLAN
Per Default laufen Managment, Switchpakete und User Traffic über das VLAN 1
es wird empfohlen gerade bei Trunk oder untagged Ports das Native VLAN abzuändern.
Damit nich der komplette Traffic über das selbe Netz geht und somit leichter zu analysieren ist.

## Trunk Ports
Deativieren der Automatischen Trunkport erkennung.
```console
no switchport mode dynamic
```

Trunk VLANs whitelisten:
```console
switchport trunk allowed vlan 12
```

Native VLAN setzen:
```console
switchport native vlan 10
```

## Access Ports
Den (ungenutzten) Access Ports ein nicht genutztes VLAN zuweisen, sodas diese nicht mehr in VLAN 1 enthalten sind.