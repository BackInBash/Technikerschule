1) Lassen Sie sich alle angeschlossenen Festplatten anzeigen

```console
lsblk
```

```bash
NAME  MAJ:MIN RM   SIZE RO TYPE MOUNTPOINT
loop0   7:0    0 396.4M  1 loop /mnt/wsl/docker-desktop/cli-tools
loop1   7:1    0 343.4M  1 loop
sda     8:0    0   256G  0 disk
sdb     8:16   0   256G  0 disk /mnt/wsl/docker-desktop/docker-desktop-proxy
sdc     8:32   0   256G  0 disk /mnt/wsl/docker-desktop-data/isocache
sdd     8:48   0   256G  0 disk /
```

2) Was sind sda und sdb?

Block Devices

3) Welche Informationen sind aus der Ausgabe zu entnehmen?

Device Name, Bus ID, Size, Type, Mountpoint

4) Lassen Sie sich alle möglichen Befehle von fdisk auflisten! Wie heißt der dazugehörige Befeh?

```console
fdisk -h 
```

5) Welche Funktion haben die Buchstaben p, i und l? Führen Sie diese für die Platte sdb aus!

```console
l   list known partition types
i   print information about a partition
p   print the partition table
```

`p`
```console
Command (m for help): p
Disk /dev/sda: 256 GiB, 274877906944 bytes, 536870912 sectors
Disk model: Virtual Disk
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 4096 bytes
I/O size (minimum/optimal): 4096 bytes / 4096 bytes
Disklabel type: dos
Disk identifier: 0x6b9fad8a
```

`l`

```console
Command (m for help): l

 0  Empty           24  NEC DOS         81  Minix / old Lin bf  Solaris
 1  FAT12           27  Hidden NTFS Win 82  Linux swap / So c1  DRDOS/sec (FAT-
 2  XENIX root      39  Plan 9          83  Linux           c4  DRDOS/sec (FAT-
 3  XENIX usr       3c  PartitionMagic  84  OS/2 hidden or  c6  DRDOS/sec (FAT-
 4  FAT16 <32M      40  Venix 80286     85  Linux extended  c7  Syrinx
 5  Extended        41  PPC PReP Boot   86  NTFS volume set da  Non-FS data
 6  FAT16           42  SFS             87  NTFS volume set db  CP/M / CTOS / .
 7  HPFS/NTFS/exFAT 4d  QNX4.x          88  Linux plaintext de  Dell Utility
 8  AIX             4e  QNX4.x 2nd part 8e  Linux LVM       df  BootIt
 9  AIX bootable    4f  QNX4.x 3rd part 93  Amoeba          e1  DOS access
 a  OS/2 Boot Manag 50  OnTrack DM      94  Amoeba BBT      e3  DOS R/O
 b  W95 FAT32       51  OnTrack DM6 Aux 9f  BSD/OS          e4  SpeedStor
 c  W95 FAT32 (LBA) 52  CP/M            a0  IBM Thinkpad hi ea  Rufus alignment
 e  W95 FAT16 (LBA) 53  OnTrack DM6 Aux a5  FreeBSD         eb  BeOS fs
 f  W95 Ext'd (LBA) 54  OnTrackDM6      a6  OpenBSD         ee  GPT
10  OPUS            55  EZ-Drive        a7  NeXTSTEP        ef  EFI (FAT-12/16/
11  Hidden FAT12    56  Golden Bow      a8  Darwin UFS      f0  Linux/PA-RISC b
12  Compaq diagnost 5c  Priam Edisk     a9  NetBSD          f1  SpeedStor
14  Hidden FAT16 <3 61  SpeedStor       ab  Darwin boot     f4  SpeedStor
16  Hidden FAT16    63  GNU HURD or Sys af  HFS / HFS+      f2  DOS secondary
17  Hidden HPFS/NTF 64  Novell Netware  b7  BSDI fs         fb  VMware VMFS
18  AST SmartSleep  65  Novell Netware  b8  BSDI swap       fc  VMware VMKCORE
1b  Hidden W95 FAT3 70  DiskSecure Mult bb  Boot Wizard hid fd  Linux raid auto
1c  Hidden W95 FAT3 75  PC/IX           bc  Acronis FAT32 L fe  LANstep
1e  Hidden W95 FAT1 80  Old Minix       be  Solaris boot    ff  BBT
```

`i`

```console
Command (m for help): i
No partition is defined yet!
```

6) Welche Funktionen haben die Buchstaben t und a? Führen Sie diese für die Platte sdb aus!

```console
t   change a partition type
a   toggle a bootable flag
```

7) Lassen Sie den ersten Bereich vom USB-Stick/virtuelle Festplatte anzeigen

```console
fdisk -l /dev/sdb1
```

8 ) Führen Sie einige Berechnungen durch und beweisen Sie, dass die angezeigten Informationen zur Größe der Partition richtig sind! (Wiederholung Zahlensyteme hexadezimal). Hinweis: d im Expertenmodus verwenden

```console
sudo fdisk -l /dev/sda
```

```console
Disk /dev/sda: 256 GiB, 274877906944 bytes, 536870912 sectors
Disk model: Virtual Disk
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 4096 bytes
I/O size (minimum/optimal): 4096 bytes / 4096 bytes
```

```console
sectore * sector size
``` 

9) Ändern Sie die ID der Partition in 0x0000D00F und kontrollieren Sie das Ergebnis dieser Änderung.

Partitionstabelle zu GPT

10) Ändern Sie den Start der Partition auf 65536 und testen Sie erneut, ob Sie erfolgreich waren. Analysieren Sie auch, ob die Größe des Datenträgers sinnvoll/richtig ist.

11) Experimentieren: Löschen, Erstellen und Verändern Sie die vorhandenen Partitionen (nicht von der Systempartition, sondern die virtuelle Festplatte oder USB-Stick).

12) Ändern Sie die Dateisysteme von drei von Ihnen ausgewählten Partitionen und kontrollieren Sie Ihre Änderungen.

13) Speichern (Schreiben) Sie Ihre Änderungen/Konfigurationen auf dem Stick.

14) Ändern Sie die Partitionstabelle von DOS zu GPT. Welche Veränderungen gibt es? Lassen Sie sich dies anzeigen.

15) Bei dieser Aufgabe sollte ein Stick partitioniert (mit allen Aufgaben 1-14) und eine virtuelle Festplatte im Anschluss verwendet werden.

16) Erstellen Sie mit Hilfe des Befehls mkfs ein Dateisystem für die virtuelle Partition bzw. für den Stick

17) Ermitteln Sie die UUID von einzelne Partitionen. Für welche Zwecke benötigt man die UUID? Geben Sie dazu ein Beispiel an.