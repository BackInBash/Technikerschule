# DHCP Snooping
Ist ein Sicherheitsfeature womit DHCP Anfragen im Netzwerk in Vertrauenswürdig und nicht Vertrauenswürdig eingestuft werden.
Somit werden Ports auf denen ein legitiemer DHCP Server seine Anfragen versendet als Vertrauenswürdig kategorisiert.
Die restlichen Ports sind dann nicht vertrauenswürdig, sollte nun ein dritter versuchen DHCP Anfragen über einen solchen Port
zu verschicken werden diese vom Switch verworfen.

![](https://upload.wikimedia.org/wikipedia/commons/c/cc/DHCP_Snooping.png)

Somit können z.b. Rogue DHCP Angriffe bei denen der DNS Server oder das Default Gateway des opfers geändert wird verhindert werden.
