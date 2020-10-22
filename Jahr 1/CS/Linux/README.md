# Linux Commands

## [POSIX Standard Command List](https://en.wikipedia.org/wiki/List_of_Unix_commands)

<br>

**Benutzer mit Gruppe und Shell erstellen**
```bash
useradd -m -U -s /bin/bash test1
```

**Benutzer einer Gruppe hinzufügen**
```bash
usermod -aG Gruppe Benutzer
```

**Datei erstellen**
```bash
touch test
```

**Temp Datei erstellen**
```bash
mktemp
```

### APT Commands

**Paket Suche**
```bash
apt search htop
````

**Paket Cache Löschen**
```bash
apt autoclean
````

**Unbenutzte Pakete löschen**
```bash
apt autoremove
```