#!/bin/bash

#####################################
## RPI Wlan AP Setup
## 2021-02-12
## markus.brunsch@its-stuttgart.de
#####################################

## Install Required Packages
EBIAN_FRONTEND=noninteractive apt install -y netfilter-persistent iptables-persistent hostapd dnsmasq

## Config Services
systemctl unmask hostapd
systemctl enable hostapd
systemctl enable dnsmasq

## Configure DHCPCD
echo "interface wlan0
    static ip_address=192.168.4.1/24
    nohook wpa_supplicant" >> /etc/dhcpcd.conf
sysctl -p

## Enable IPv4 Forwarding
echo "# https://www.raspberrypi.org/documentation/configuration/wireless/access-point-routed.md
# Enable IPv4 routing
net.ipv4.ip_forward=1"  >>/etc/sysctl.d/routed-ap.conf

## Setup iptabels Firewall

# Nat Rule enabel Outgoing Masquerading
iptables -t nat -A POSTROUTING -o eth0 -j MASQUERADE
# Forwarding Rule WLAN --> to --> Ethernet
iptables -A FORWARD -i wlan0 -o eth0 -j ACCEPT
# Forwarding Rule Ethernet --> back to --> WLAN (only Esteblished Connections)
iptables -A FORWARD -i eth0 -o wlan0 -m state --state ESTABLISHED,RELATED -j ACCEPT
# Save Rules
netfilter-persistent save

## Configure DNSMasq
echo 'interface=wlan0 # Listening interface
dhcp-range=192.168.4.2,192.168.4.20,255.255.255.0,24h
                # Pool of IP addresses served via DHCP
domain=wlan     # Local wireless DNS domain
address=/gw.wlan/192.168.4.1
                # Alias for this router' >> /etc/dnsmasq.conf

## Unblock WLAN
rfkill unblock wlan

## Setup AP
echo "country_code=DE
interface=wlan0
ssid=NameOfNetwork
hw_mode=g
channel=7
macaddr_acl=0
auth_algs=1
ignore_broadcast_ssid=0
wpa=2
wpa_passphrase=AardvarkBadgerHedgehog
wpa_key_mgmt=WPA-PSK
wpa_pairwise=TKIP
rsn_pairwise=CCMP" >> /etc/hostapd/hostapd.conf

echo "To complete the setup please reboot the system... systemctl reboot"
