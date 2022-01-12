# Docker Container Plattform
Docker ist ein Open Source-Projekt zur Automatisierung der Bereitstellung von Apps als mobile, eigenständige Container, die in der Cloud oder lokal ausgeführt werden können. Docker ist darüber hinaus ein Unternehmen, das diese Technologie fördert und weiterentwickelt und mit Cloud-Anbietern, Linux und Windows kompatiebel ist.

Dabei stellen Container eigenständige und abgeschottete Laufzeitumgebungen für Anwendungen verschiedenster art dar.
Container und die dazugehörigen Container Images basieren auf dem OCI (Open Container Initiative) Standard und sind somit nicht nur mit Docker Kompatiebel.
Docker ist vielmehr nur das zugehörige Verwaltungswerkzeug um die darunterliegende Container Infrastruktur zu verwalten.
Docker bietet dabei die Möglichkeiten Container anzulegen, zu starten / stoppen oder zu löschen. Es konnen neue Images erstellt und bestehende Images verwaltet werden, lokal oder remote in sogenannten Container Registries (z.B. hub.docker.com)


## Containervirtualisierung
Containervirtualisierung beschriebt eine form der Virualisierung, beider auf dem Host System mittels PID Namespacing im Linux-Kernel eine eigene Laufzeitumgebung geschaffen wird. Inder Anwendungen abgeschottet vom restlichen System betrieben werden können.

<img src="https://miro.medium.com/max/700/1*V7cmO3r2-UN5OsCzrXtUxw.png" width="70%">

Der Vorteil dieser Virtualisierungesmethode, ist der um ein vielfaches veringerte Overhead im Vergleich zu KVM (Kernel Virtuell Machine).
Da bei einer Container Virtualisierung im direkten vergleich der Kernel des Host OS verwendet wird und die Ressourcen des Systems nur abstrahiert und nicht virtualisiert werden. 

Somit kann bei Containern auf ein eigenes Betriebssystem im klassischen Sinne verzichtet werden.
Es muss lediglich eine Lafzeitumgebung mitbegeben werden um die entsprechende Anwendung ausführen zu können.
Somit kann die Hardware optimal ausgenutzt und der Wartungsaufwand deutlich reduziert werden.

<img src="https://artbio.github.io/Run-Galaxy/images/docker.png" width="70%">

Technologien, die auf diese art der Virtalisierung zurückgreifen sind. **LXC** und **OCI** Container.

Bei **LXC** Containern wird ein leichtgewichtiges Linux System Erzeugt, das über tradizionelle Methoden Administriert / verwaltet wird z.B. SSH.

**OCI** Container verfolgen einen anderen Weg, hier geht es darum sehr leichtgewichtige Systme für die Cloud bereitzustellen. Hier liegt der Fokus auf Sicherheit, Performance und Fehlerminimierung.

Die Container sind weitergehend dazu auch im Hinblick auf die [12 Fakroren](https://12factor.net) im Cloud Umfeld designed, sie sind vorzugsweise Stateless, Skalierbar und im Fehlerfall schnell austauschbar. Eine Manuelle Fehlerbehebung eines einzelnen "bad" Containers ist hier nicht vorgesehen. Vielmehr werden die Container einfach schnell gegen einen neuen Funktionsfähigen Container Ausgetauscht.

Gerade im Hinblick auf Kubernetes, ist diese Art der Containerverwaltung die Gundlage eines solchen Konzepts.

## Moby Project
Das Moby Projekt zufinden auf [Github](https://github.com/moby/moby), stellt die Library dar, die von Docker für die Interaktion mit dem System verwendet wird. Hier ist z.B. der Image Build Prozess abgebildet.

## ContainerD
ContainerD ist eine OCI Standartisierte Container Lauzeitumgebung. Diese ist für den eigentlichen Betrieb der Container verantwortlich und steuert diesen Eigenständig.

containerd is an industry-standard container runtime with an emphasis on simplicity, robustness and portability. It is available as a daemon for Linux and Windows, which can manage the complete container lifecycle of its host system: image transfer and storage, container execution and supervision, low-level storage and network attachments, etc.

Zufinden ist das Projekt bei [Github](https://github.com/containerd/containerd)

<img src="https://github.com/containerd/containerd/raw/main/design/architecture.png" width="70%">


## OCI - Open Container Initiative
Die Open Container Initiative verabschiedet Standards im Bereich Containering.
Darunter fallen die Spezifikationen der Container und deren Images, damit diese zu den Verschiendenen Systemen interkompatiebel sind.

## runc
`runc` is a CLI tool for spawning and running containers on Linux according to the OCI specification.
Wird von Docker im hibtergrund verwendet um Container anzulegen und zu verwalten.
Zufinden bei [Github](https://github.com/opencontainers/runc)

## Docker Image Erstellen
Um ein Docker Image zu erstellen, wird mit sogenannten Dockerfiles das Image definiert.
Dieses Dockerfile wird dann dem Build Agnet übergeben,
der dann aus dem übergebenen Dockerfile ein OCI Container Image erstellt.

In der Regel sind Dockerfiles in 3 Bereiche aufgeteilt.

**Import**:
hier werden OS Images (Debian, Alpine, Ubuntu, ...) angegeben bzw. Base Images (Frameworks wie Java, dotNet, NodeJS oder Python) damit wird die
Laufzeitumgebung festgelegt.

**Installation**:
hier wird die Installationsroutine der Software angegeben z.B. Download von Artefakten oder Kompilierung der Software.

**Entrypoint**:
hier wird der Startpunkt der Anwendung festgelegt.

Ein beispielhaftes Dockerfile sieht in etwa so aus:
```docker
FROM alpine:3.4

RUN apk update && apk add \
    curl \
    git \
    vim

RUN wget http://myapp.com/run && chmod +x run

ENTRYPOINT['run']
```

Im Anschluss kann dann das Dockerfile zu einem Image gebaut werden `docker build .`

## Docker Image Verwaltung

+ Anzeigen der lokal geladenen Images

    ```bash
    [root@host ~]$ docker image ls
    REPOSITORY                   TAG       IMAGE ID       CREATED         SIZE
    ngoduykhanh/powerdns-admin   latest    938d8ef921ab   5 months ago    157MB
    psitrax/powerdns             latest    720c44942097   6 months ago    63.7MB
    redis                        latest    08502081bff6   6 months ago    105MB
    mariadb                      latest    104f4e7cbe83   6 months ago    408MB
    ubuntu                       latest    7e0aa2d69a15   8 months ago    72.7MB
    freinet/powerdns             latest    8fdce2cafa4e   12 months ago   55.5MB
    jorgedlcruz/zimbra           latest    79403a039239   4 years ago     302MB
    ```

+ Löschen eines Images

    ```bash
    [root@host ~]$ docker image rm 79403a039239
    Untagged: jorgedlcruz/zimbra:latest
    Untagged: jorgedlcruz/zimbra@sha256:5d2548365fd079ba51e87c7a8f54feacfce23d370f49d66311632eb2a422b026
    Deleted: sha256:79403a039239add5f60084f7ff2203fe145b3f8f86e83a925359e06e38cb437f
    Deleted: sha256:c07d6c55520b0908e868f8a85d2b8928616008a8c26d27bd61f425ce1a2058c6
    Deleted: sha256:e2a75e141e320208ce68299d7f72e1fe46a1c9b8a5702256ea45ef94ae80cca0
    Deleted: sha256:1f0250b6692ee176c5e1978ee2aa921d724873b9c5fa8ec19be04c640660393d
    Deleted: sha256:7f6e10c2ecea8d277d1a8c7c618e7dd93e5e0357e68d6e88f1f1ab26de03e59a
    Deleted: sha256:ec1fd849ff0a8f0aa2fd1acc29ad5dabbc79b89f63b74a4f54e31a7b0a100aa1
    Deleted: sha256:e3f6dffa20cf36460d23bfb22e17be6e5339891f8537f32db79887caf832048b
    Deleted: sha256:c213ffdc9f7032702de5a8e9045fcce2353b7221ef6bf4509e02005cfc858f58
    Deleted: sha256:3fddf55a451aa43707518f2d8788c12ee5eb1f1e3075433f5bcf4d445d5c275d
    Deleted: sha256:0f5ff0cf6a1c53f94b15f03536c490040f233bc455f1232f54cc8eb344a3a368
    ```

+ Herunterladen eines neuen Images

    ```bash
    [root@host ~]$ docker pull alpine:latest
    latest: Pulling from library/alpine
    59bf1c3509f3: Pull complete 
    Digest: sha256:21a3deaa0d32a8057914f36584b5288d2e5ecc984380bc0118285c70fa8c9300
    Status: Downloaded newer image for alpine:latest
    docker.io/library/alpine:latest
    ```

## Docker Container Verwaltung

+ Auflistung der Container in auf dem System

    ```bash
    [root@host ~]$ docker container ls -a
    CONTAINER ID   IMAGE                               COMMAND                  CREATED        STATUS                      PORTS      NAMES
    5793bbed585b   mariadb:latest                      "docker-entrypoint.s…"   28 hours ago   Exited (0) 21 hours ago                elastic_agnesi
    13102f675ad0   mariadb:latest                      "docker-entrypoint.s…"   3 months ago   Up 2 hours                  3306/tcp   docker-db-1
    0e98170a7024   ngoduykhanh/powerdns-admin:latest   "entrypoint.sh gunic…"   3 months ago   Exited (0) 3 months ago                powerdns_admin
    a0f8b16bc64a   psitrax/powerdns:latest             "/entrypoint.sh"         3 months ago   Exited (143) 3 months ago              powerdns
    cc6847b3c8a9   ubuntu                              "bash"                   6 months ago   Exited (0) 6 months ago                recursing_mendeleev
    7fc041db6bc6   redis:latest                        "docker-entrypoint.s…"   6 months ago   Exited (0) 6 months ago                lucid_kepler
    be47035dd9d3   mariadb:latest                      "docker-entrypoint.s…"   6 months ago   Exited (0) 2 months ago                mariadb
    ```

> Mit dem `-a` Parameter lassen sich auch die Abgeschalteten Container anzeigen.

+ Starten neuer Container

Im Beispiel: Startet einen Nginx Container auf Port `8080`
```bash
docker run -d -p 8080:80/tcp --name=webserver --restart=always nginx:latest
```

> Die verwendeten Parameter
> Parameter | Funktion |
> -------- | -------- | 
> -d | Container im Hintergrund Starten
> -p 8080:80/tcp | TCP Portfreigabe von 8080 extern nach 80 intern
> --name | Namen des Containers festlegen
> --restart=always | Setzt die Restart Policy auf immer starten

Genauere Infos und Referenzen in der [Docker Dokumentation](https://docs.docker.com/engine/reference/run/)

+ Löschen eines Containers

```bash
docker container rm -f 5793bbed585b
```

Container ID oder Container Name

> Verwendeter Paramerter `-f` (Force) Löscht den Container auch im Aktiven Zustand.

+ Vorhandenen Container Starten / Stoppen / Neustarten

    + Starten
        ```bash
        docker container start [ContainerID]
        ```
    + Stoppen
        ```bash
        docker container stop [ContainerID]
        ```
    + Neustarten
        ```bash
        docker container restart [ContainerID]
        ```

## Docker Compose
Docker Compose ermöglicht es mehrere Container in einem Deployment zusammenzufassen und die Ressource in diesem Deployment gegenüber anderen Containern abzuschirmen, die dafür notwendigen Schritte werden alle automatisch von Docker Compose übernommen.

Docker Compose benötigt eine sogenannte `docker-compose.yml` Datei, diese Datei enthällt die Konfiguration des Deployments.
Durch Docker Compose werden die Folgenden Ressourcen Verwaltet:
+ Container
+ Overlaynetzwerke
+ Volumes

Ein typisches Usecase für Docker Compose wäre eine Webanwendung, bei der eine Datenbank, ein Webserver und ein Anwendungsserver benötigt werden.
Dabei steuert Docker Compose die Erstellung der Container und deren Persistenden Daten, die Erstellung eines Cloud Netzwerks sowei die automatische Zuseisung des Netzwerks an die Container.

Die `docker-compose.yml` für den oben beschriebenen Usecase sieht wie folgt aus:

```yaml
version: "3.9"
    
services:
  db:
    image: mysql:5.7
    container_name: db
    volumes:
      - db_data:/var/lib/mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: dbpasswd
      MYSQL_DATABASE: db
      MYSQL_USER: db
      MYSQL_PASSWORD: db
    
  proxy:
    image: nginx:latest
    container_name: proxy
    restart: always
    volumes:
      - ./nginx.conf:/etc/nginx/nginx.conf
      - ./nginx/error.log:/etc/nginx/error_log.log
      - ./nginx/cache/:/etc/nginx/cache
      - ./ssl/:/etc/letsencrypt/
    ports:
      - 80:80
      - 443:443
  app:
    depends_on:
      - db
      - proxy
    image: registry/myapp
    restart: always
    environment:
       DBL_USER: db
       DB_PASSWORD: db
       DB_HOST: db
    container_name: app
    ports:
        - 3000:3000
volumes:
  db_data: {}
```

> Die Nginx Konfiguration muss noch entsprechend als Reverse Proxy auf den `app` Container angepasst werden.

## Docker Volumes

Docker Volumes bieten die Möglichkeit anfallende Persistente Daten in einem Container zu speichern.
Volumes werden komplett durch Docker verwaltet und sind damit der Ofiziell Empfohlene weg Persistente Daten abzuspeichern.

+ Anzeigen bestehender Volumes
    ```bash
    C:\Users\Markus>docker volume ls
    DRIVER    VOLUME NAME
    local     256895275dee26176790078f8470e124671e3f74abf7fb5f84e36aaa8f8e6a78
    local     c3687c2c12df99cfcbb6b725d57facf0e678ae776fdd6009009b7571ca1968cb
    local     telly.config.toml
    local     vscode
    ```

+ Anlegen eines neuen Volumes
    ```bash
    docker volume create data
    ```

Docker bietet auch die Möglichkeit andere Storage Dirver anzusprechen. Somit ist es Möglich die Volumes auf anderen Storage Medien zu speichern.
Von Haus aus unterstützt Docker die folgenden Stroage Drivers:
+ Eine [Liste](https://docs.docker.com/storage/storagedriver/select-storage-driver/) mit eingebauten Storage Drivern
+ Eine [Liste](https://docs.docker.com/engine/extend/legacy_plugins/#volume-plugins) mit 3rd-party Storage Drivern

## Docker Networking
Um die Container untereinander zu vernetzen bietet Docker die Möglichkeit über Bridges auf dem Hostsystem Container miteinander zu Verbinden.

+ Auslisten aller Netzwerke auf dem Host
    ```bash
    C:\Users\Markus>docker network ls
    NETWORK ID     NAME      DRIVER    SCOPE
    fa8c5ca426e1   bridge    bridge    local
    f9f00956c91d   host      host      local
    679b81f531b8   none      null      local
    ```

+ Anlegen eines neues Netzwerks
    ```bash
    docker network create --driver bridge new-network
    ```
    > Mit dem Parameter `--driver | -d` kann der Netzwerk Driver angegeben werden.

+ Konfiguration der Standard Bridge
    ```bash
    C:\Users\Markus>docker network inspect bridge
    [
        {
            "Name": "bridge",
            "Id": "fa8c5ca426e18372730c1dce298ddf97862c8574cf2e71e58ed9f5a584948158",
            "Created": "2022-01-12T14:58:18.607125133Z",
            "Scope": "local",
            "Driver": "bridge",
            "EnableIPv6": false,
            "IPAM": {
                "Driver": "default",
                "Options": null,
                "Config": [
                    {
                        "Subnet": "172.17.0.0/16",
                        "Gateway": "172.17.0.1"
                    }
                ]
            },
            "Internal": false,
            "Attachable": false,
            "Ingress": false,
            "ConfigFrom": {
                "Network": ""
            },
            "ConfigOnly": false,
            "Containers": {},
            "Options": {
                "com.docker.network.bridge.default_bridge": "true",
                "com.docker.network.bridge.enable_icc": "true",
                "com.docker.network.bridge.enable_ip_masquerade": "true",
                "com.docker.network.bridge.host_binding_ipv4": "0.0.0.0",
                "com.docker.network.bridge.name": "docker0",
                "com.docker.network.driver.mtu": "1500"
            },
            "Labels": {}
        }
    ]
    ```

Bei einem durch Docker verwalteten Netzwerk, erfolgt die IP Adressvergabe eigenständig durch Docker. Ebenso wie eine DNS Namenvergabe jeder Name eines Containers ist im Docker Netzwerk per DNS auflößbar. Somit ist es möglich Container nach ihrem Namen im Netzwerk aufzurufen.

Es existieren auch noch einige andere Netzwermodelle, diese können [hier](https://docs.docker.com/network/#network-drivers) eingesehen werden.

> Mit Docker Swarm, lassen sich mehrere Docker Dienste zu einem Verbund zusammenschalten und somit können die Container auch Hostübergreifend miteinander Kommunizieren.
> 
> Übersicht Overlay Netzwerke: https://docs.docker.com/network/overlay/
>
> Beispielkonfiguration: https://docs.docker.com/network/network-tutorial-overlay/