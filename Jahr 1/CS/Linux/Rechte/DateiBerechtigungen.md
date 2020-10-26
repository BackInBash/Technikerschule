# Datei Berechtigungen

## Allgemeines
In Linux: einfaches Rechtekonzept > 50 Jahre alt,
Benutzernamen und Gruppen basiert.

Jede Datei (auch Geräte - „everything is a file“) und jedes Verzeichnis gehört genau einem Nutzer (user: u) und einer Gruppe (group g).

Der Besitzer gilt als `u`, andere Mitglieder der Besitzergruppe gelten als `g`.
Alle anderen gelten als sonstige Nutzer (others: `o`).

Beim Anlegen einer Datei gehört sie zunächst der primären Gruppe des Anlegenden.
Will man mehr Berechtigungen? ACL (Access Control List): erlauben die Vergabe komplexer Rechtestrukturen ähnlich zu NTFS-Berechtigungen.

```bash
root@PCITBMR:/tmp/tmp.tP7iSWSie9# ls -ltsa
total 0
0 drwxrwxrwt 1 root root     512 Oct 26 11:42 ..
0 drwx------ 1 root root     512 Oct 26 11:41 .
0 -rw------- 1 root www-data   0 Oct 26 11:41 tmp.c4x2xSSTNk
0 -rw------- 1 root www-data   0 Oct 26 11:41 tmp.RR1cd1Rzz0
0 -rw------- 1 root www-data   0 Oct 26 11:41 tmp.ffCLHbTpoh
0 -rw------- 1 root www-data   0 Oct 26 11:41 tmp.2ykfAZO1O3
0 -rw------- 1 root www-data   0 Oct 26 11:41 tmp.LsAW89CTtO
0 -rw------- 1 root www-data   0 Oct 26 11:41 tmp.lHaxyGeRJQ
```

## Programme zum Ändern der Berechtigungen

`chgrp` ändert Besitzergruppe
Aber: Nur Besitzer und root können `chgrp` ausführen

Parameter `-R` ändert Gruppe rekursiv (in allen Dateien und Unterverzeichnissen des Ziels)
chown ("change owner") kann Besitzer, aber auch die Besitzergruppe ändern.
Nur Besitzer: `chown` neuuser datei
Besitzer und Gruppe: `chown` neuuser:neugruppe datei
Nur Gruppe: `chown` :neugruppe datei

## Berechtigungs Kategoriern

Für jede der drei Kategorien `u`, `g` und `o` lassen sich folgende drei Dateirechte vergeben:
+ Leserecht (read `r`)
+ Schreibrecht (write `w`)
+ Ausführungsrecht (execute `x`)
Bei Verzeichnissen gilt:
`r`: Dateinamen im Verzeichnis (aber keine Details) anschauen
`w` (nur in Kombination mit `x`) Dateien löschen / anlegen
`x` mit cd "betreten"

Die Rechtesuche geht von links nach rechts:
`u`-Eigenschaft sticht `g` (selbst wenn `g` höhere Rechte hat)
`g`-Eigenschaft sticht `o` (selbst wenn `o` höhere Rechte hat)
```bash
----r--rw- 1 go go 0 Okt 10 15:52 datei1
```
User `go` hat gar keine Rechte auf die Datei `datei1`, selbst wenn er Mitglied der Gruppe `go` ist.

Ungeachtet dessen ist `go` als Eigentümer der Einzige, der diese Berechtigungen ändern darf (außer `root` natürlich).
Alle Mitglieder von `go` (außer `go`) haben Leserechte. Alle anderen (nicht `go`, nicht Mitglied von `go`) haben Lese- und Schreibrechte.

## Beispiel

Gegeben sind folgende Rechte:
```bash
drwxr-xr-x 9 root  root  4096 Okt 10 16:09 /
drwxr-xr-- 3 root  root  4096 Okt 10 16:01 /a
-rwxrwxrwx 1 user1 user1 254  Okt 10 15:52 /a/y
```
Welche Rechte hat `user1` auf `/a/y` in der Praxis?
- Gar keine, denn es fehlt das `x`-Recht für `/a` – somit kommt der User gar nicht in das nötige Verzeichnis hinein!
Wer darf sich den Inhalt von `/a` mit `ls /a` anzeigen lassen?
- Alle, denn dazu reicht das `r`-Bit auf `/a` in Kombination mit dem `x`-Bit auf `/` - allerdings sehen nur Mitglieder der `root`-Gruppe Details zu den Inhalten wegen des `x`-Bit auf `/a`

