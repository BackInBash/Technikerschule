# Leitfragen:

### **1. In Serverumgebungen gibt es u.a. drei klassische Varianten, wie Speicher an einem Server angebunden werden: DAS, SAN und NAS. Unterscheiden Sie die Begriffe bezüglich Aufbau.**

**Direct Attached Storage (DAS)**:

Speicher Shelves die per SAS an einen Server angeschlossen werden können.

![](https://tse4.mm.bing.net/th?id=OIP.ypkhMcpfmoNGtNxnW_glAwHaCm&pid=Api)

**Storage Area Network (SAN)**:

Mehrere Server die über DAS Verbundene Storage Shelves verfügen und untereinander mit Fiber Channel verbunden sind. Dadurch ergeben sich hohe speicher kapazitäten, gute IOps werde und hochverfügbarkeit.

![](https://www.snia.org/sites/default/files/Figure_1_2_SAN_Eliminates.jpg)

**Network Attached Storage (NAS):**

Ein in sich geschlossenes System das Speicher per SMB / NFS / SCSI oder andere File Based Protokolle im Netzwerk zur Verfügung stellt.

<img src="https://tse4.mm.bing.net/th?id=OIP.VZWug4Q-yIb4-gmAqYQCXwHaGY&pid=Api" alt="drawing" width="300"/>

### **2. Vergleichen Sie die Varianten miteinander. Gehen Sie auf die Vor- und Nachteile sowie typische Einsatzgebiete.**

**SAN**
- teuer
- zusätzliches nicht __konvergentes__ netzwerk notwendig
- hochverfügbar
- hoher daten durchsatz
- gut skalierbar

**NAS**
- Güstig
- Begrenzte Skalierbarkeit
- Begrenzte Geschwindigkeit
- Begrenzte Verfügbarkeit

### **3. Im Storage-Umfeld gibt es unterschiedliche "Storage-TIERs". Gehen Sie kurz auf die Unterschiede und Einsatzgebiete ein.**

Storage wird in unterteilt anhand der Geschwindigkeit, mögliche unterteilungen wären z.B.

**Unterteilung 1**
+ Storage SSD (NVNe / 3D-NAND SSD)
+ Storage SSD Cached HDD (HDD Storage Pool mit SSD Cache ähnlich zu SSHD / Intel Optane)
+ Storage HDD (SAS / SATA Storage Pool)


**Unterteilung 2**
+ VM Storage (NVMe / SSD hohe IOPS)
+ Data Storage (12k SAS gute IOPS)
+ Archive Storage (SATA 7,2 / 5,7k wenig IOPS dafür große kapazität)

### **4. In Serverumgebungen werden aktuell vermehrt nvme-Storage eingesetzt. Worum handelt es sich bei nvme?**

Flash Speicher der direkt an den PCIe Bus angeschlossen wird.

### **5. Die Preise und Ausführungen unterscheiden sich bei den nvme-Varianten. Nennen und beschreiben Sie kurz diese Ausführungen.**

Es gibt verschiedene Bus Typen die angeboten werden z.B.
+ PCIe 3.0 <-- am langsamsten ca 3300/s lesen
+ PCIe 4.0 <-- ca 7000MB/s lesen
+ PCIe 4.0 x4 <-- am schnellsten über < 7000MB/s

Speicher Typen:
+ **QLC**: Günstiger Consumer speicher (langsamer und schlechtere lebensdauer)

+ **TLC**: Guter kompromuss aus geschwindigkeit und lebensdauer (am schnellsten)

+ **MLC**: In Datacenter SSDs verbaut geringere Geschwindigkeit aber dafür die beste Lebensdauer.

### **6. Vergleichen Sie die Verwendung einer SSD, die via nvme-Schnittstelle angebunden wird gegenüber SATA- oder SAS-Schnittstelle**

Eine NVMe SSD ist um das 7 bis 14 fache schneller.

### **7. Ein IOPS-Wert wird bei Speichermedien angegeben. Gehen Sie auf die Bedeutung dieses Merkmals ein.**

IOPS beschreibt wie viele Input Output operationen pro sekunden verarbeitet werden können.
IOPS beschreiben die Geschwindigkeit des Speichermediums.

### **8. Eine weiteres Leistungskriterium von Festplatten ist der sogenannte Drive Write per Day. Beschreiben Sie kurz worum es hier geht.**

Ist ein Indikator der für die bestimmung der Lebenszeit einer SSD verwendet wird, dabei wird angegeben wie oft die SSD in einem Tag überschrieben werden kann um die angebegene Lebenszeit zu erreichen.

### **9. Beschreiben Sie den Unterschied zwischen Desktop- und High-End-SSDs**

Consumer SSDs bestehen gerne aus mehreren Speicherarten.
Einem schnellem TLC Cache und einem größeren aber langsameren QLC Teil.

Pro oder Datacenter SSD bestehen aus TLC oder MLC Speicher dieser ist ensprechend teurer aber auch langlebiger und schneller.
