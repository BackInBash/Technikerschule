# Übertragungsmedien

# Kupfer

Bezeichnung|Name
|--|--|
TP| Twisted Pair oder Sternvierer
U|ungeschiemt
F|folienschirm
S|Geflechtschirm
SF|Folien- und Geflechtschirm

<br/>

![S/FTP](https://upload.wikimedia.org/wikipedia/commons/f/fc/S-FTP-Kabel.svg)

![S/UTP](https://upload.wikimedia.org/wikipedia/commons/e/ea/SUTP-Kabel.svg)

![STP](https://upload.wikimedia.org/wikipedia/commons/e/e8/STP-Kabel.svg)

|Kabel-Kathegorie (EIA/TIA 568)|Link Klasse EN 50173|Grenzfrequenz|Zulässige Dämpfung bei Grenzfrequenz|Datenrate|Anwendung
|--|--|--|--|--|--|
|3||16 MHz| 13,1 dB/100m|10Mbit/s|Telefom/LAN
||D|100 MHz|24 dB/100m|100 Mbit/s| FastEthernet
||E|250 MHz| 35,9 dB/100m |1 Gbit/s|GbE
|(6a)|Ea|500 MHz| 49,3 dB/100m|10 Gbit/s|10 GbE

<br/>
Die Link klasse bezieht sich auf die komplette Strecke (Ende zu Ende).
Mit der Kabel Kategorie werden die Einzelene komponenten beschrieben.

Bezeichnung|Typ|
|--|--|
10 Base-T | Cat3
100 Base-T | Cat5
1000 Base-T | Cat5E
10GBASE-T | Cat6/a/e

<br>

[Datenblatt Übertragungsmedien](/Jahr%201/NE/Datenblatt_Übertragungsmedien.pdf)

### NEXT (Near End Cross Talk)
### FEXT (Far End Cross Talk)
### ELFEXT (Equal Level Cross Talk)

<br>

[Cross Talk](/Jahr%201/NE/CrossTalk.pdf)

**N = Next**

**E = End**

**C = Cross**

**T = Talk**

Im Deutschen als "Übersprechen" bekannt.
Beschreibt die gegenseitige beeinflussung von Sende und Empfangsrichtung.

### dB
Verhältniss von Sende und Empfangsleistung

<br/>

# Glasfaser (LWL)

Teurer, aufwändiger zu verlegen bzw. anzuschließen
Vorteile: Geringere Dämpfung, damit größere Reichweiten, keine EMI/RFI-Störungen (Elektromagnetische Störungen), dünnes Medium

**Einsatzgebiete für LWL**
+ Enterprise-Netze im Backbone zwischen Infrastruktur-Geräten
+ Fiber-to-the-Home (FTTH)
+ Fiber-to-the-Desk (FTTD)
+ Unterseekabel

## Multimode

+ LED als Lichtquelle
+ kleinerer Leitungsdurchmesser
+ kostengünstiger als Singlemode
+ Orange

**Einsatzgebiet** Gebäude und in House verkabelung

![Multimode](Multimode.png)

## Singlemode
+ großere Übertragungsstrecke
+ Laser als Lichtquelle
+ großerer Leitungsdurchmesser
+ Gelb

**Einsatzgebiet** In Straßen und Backbone

![Singlemode](Singlemode.png)

# Wireless

+ Bietet größte Mobilität

**Einschränkungen bei Wireless:**
+ Abdeckungsgebiet – teils durch Umgebung verringert
+ Interferenzanfälligkeit – teil schon durch Haushaltsgeräte
+ Sicherheit – im Gegensatz zum Kabel nicht klar wo es ankommt
+ Shared Medium – Keine fixe Bandbreite

### Funkstandards:
+ Wi-Fi (IEEE 802.11)
+ Bluetooth (IEEE 802.15)
+ WiMAX (IEEE 802:16)
+ Zigbee (IEEE 802.15.4)

### WLAN-Infrastruktur
+ Wireless Access-Point (AP)
+ Wireless NIC-Adapters
+ Wireless Controller