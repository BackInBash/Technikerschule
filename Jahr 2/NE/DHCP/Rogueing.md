# Rogue DHCP Server
Ein Rogue DHCP Server ist ein von einem Angreifer betriebener DHCP Server mit dem Ziel.
Clientanfragen mit gefälschten Inhalten zu beantworten.
Dabei können ganz unterschiedliche Ziele verfolgt werden.

1. Denial of Service.

    Dem Client flasche IP Adresse Infromationen zukommen lassen, somit ist der Client nicht in der Lage am Netzwerk teilzunehmen.
1. DNS Server Swap

    Den DNS Server eines Client auszutauschen. Dies kann dazu führen das Opfer unbewusst auf andere Seiten oder Dienste umzuleiten.

1. Default Gateway Swap

    Das Default Gateway des Clients über einen vom Angreifer kontrollierten Knoten zu leiten. Somit ist der Angreifer inder Lage den
    gesammten Traffic des opfers zu durchsuchen. Somit ist der DHCP Angriff eine vorbereitung zum Man in the Middle Angriff.