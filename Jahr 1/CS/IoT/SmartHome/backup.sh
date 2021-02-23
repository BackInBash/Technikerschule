#!/bin/bash

#####################################
## SmartHome Data Backup
## 2021-02-23
## markus.brunsch@its-stuttgart.de
#####################################

BACKUP_FOLDER="/opt/SmartHomeBackup"

function check_sudo ()
{
 if [ ! $(id -u) == "0" ]; then
        echo "Start with sudo and try again"
        exit 1
 fi
}

# Check for Root Rights
check_sudo

# Check if Docker Composer is Installed
if [ -z $(which docker-composer) ]; then
       echo "Docker Composer not found!"
       exit 1
fi

# Check & Create Backup Dir
if [ ! -d "$BACKUP_FOLDER" ]; then
  mkdir $BACKUP_FOLDER
fi

tar cfvz $BACKUP_FOLDER/SmartHomeBackup_$(date +"%d-%m-%Y_%R").tar.gz $(pwd)