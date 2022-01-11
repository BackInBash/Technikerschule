# Docker Container Plattform
Docker ist ein Open Source-Projekt zur Automatisierung der Bereitstellung von Apps als mobile, eigenständige Container, die in der Cloud oder lokal ausgeführt werden können. Docker ist darüber hinaus ein Unternehmen, das diese Technologie fördert und weiterentwickelt und mit Cloud-, Linux- und Windows kompatiebel ist.

Dabei stellen Container eigenständige und abgeschottete Laufzeitumgebungen für Anwendungen verschiedenster art dar.
Container und die dazugehörigen Container Images basieren auf dem OCI (Open Container Initiative) Standard und sind somit nicht nur mit Docker Kompatiebel.
Docker ist vielmehr nur das zugehörige Verwaltungswerkzeug um die darunterliegende Container Infrastruktur zu verwalten.
Docker bietet dabei die Möglichkeiten Container anzulegen, zu starten / stoppen oder zu löschen. Es konnen neue Images erstellt und bestehende Images verwaltet werden, lokal oder remote in sogenannten Container Registries (z.B. hub.docker.com)

## Moby Project
Das Moby Projekt stellt zufinden auf [Github](https://github.com/moby/moby), stellt die Library dar, die von Docker für die Interaktion mit dem System verwendet wird. Hier ist z.B. der Image Build Prozess abgebildet.

## ContainerD
ContainerD ist eine OCI Standartisierte Container Lauzeitumgebung. Diese ist für den eigentlichen Betrieb der Container verantwortlich und steuert diesen Eigenständig.

containerd is an industry-standard container runtime with an emphasis on simplicity, robustness and portability. It is available as a daemon for Linux and Windows, which can manage the complete container lifecycle of its host system: image transfer and storage, container execution and supervision, low-level storage and network attachments, etc.


## OCI - Open Container Initiative
Die Open Container Initiative verabschiedet Standards im Bereich Containering.
Darunter fallen die Spezifikationen der Container und deren Images, damit diese zu den Verschiendenen Systemen interkompatiebel sind.

## runc