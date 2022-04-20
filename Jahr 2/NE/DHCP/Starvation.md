# DHCP Starvation
Bei diesem Szenario, werden alle vorhandenen IP Adressen eines DHCP Servers an einen Rechner vergeben.
Ziel des Angriffs ist es den IP Adressraum auszuschöpfen sodas ein legitimer Client keine IP Adresse mehr vom DHCP Server beziehen kann.

Die Ausführung erfolgt durch das stetige verändern der MAC Adresse nach jeder erfolgreichen DHCP Abfrage.
Somit ist der Angreifer in der Lage immer neue IP Adressen am DHCP Server anzufragen.
Da es für diesen so aussieht als würde sich jeweils immer ein neuer Client melden.

Ein solcher Angriff kann eingeschränkt werden, indem man die erlaubte Anzahl an MAC Adressen an einem Switchport limitiert.