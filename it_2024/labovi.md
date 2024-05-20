# 0. Mreze    
`en` - ulazenje u admin mod    
`no shutdown` - paljenje rutera    
`sh ip route` - prikaz tabele rutiranja rutera    
`copy running-config startup-config`    
`line console 0` - `password <password>` - `login` - za pristup ruteru    
`enable secret <password>` - za enable mode    
`banner motd <message>`    
`ip address <address> <mask>` (sw)    
`ip default-gateway <gateway_address>` (sw)    
    
    
# 1. STP    
podesen po defaultu    
en -> show spanning-tree    
`spanning-tree vlan <vlan_id> priority <priority>` - rucno podesavanje prioriteta (stp   konvergencija)  
`spanning-tree vlan <vlan_id> root primary` - isto kao gore    
`spanning-tree vlan <vlan_id> root secondary` - zamjenski root bridge    
ako znamo da port nece biti blokiran, te da pri prikljucivanju na dati port ne cekamo 50   sekundi (do stanja proslijedjivanja), mozemo ukljuciti portfast opciju na tom   interfejsu:
`int <interfejs>` -> `spanning-tree portfast`, nije predlozeno da se koristi ako se   nakacuju svicevi na taj port  
ukoliko se kace svicevi/habovi/bridzevi:    
`int <interfejs>` -> `spanning-tree bpduguard enable`    
kod povezivanja dva fizicka interfejsa izmedju dva svica (2-2), ukoliko nije   etherchannel upaljen: stp izabere neblokiran port koji sa druge strane ima nizi indeks   (Prio.Nbr u `sh spanning-tree`)
`spanning-tree vlan <vlan_id> port priority <priority>`    
    
komande:    
`show spanning-tree`    
`spanning-tree vlan <vlan_id> priority <priority>`    
`spanning-tree vlan <vlan_id> root primary`    
`spanning-tree vlan <vlan_id> root secondary`    
`spanning tree vlan <vlan_id> port priority <priority>`    
`int <interface>` -> `spanning-tree portfast`    
`int <interface>` -> `spanning-tree bpduguard enable`    
    
# 2. VLAN     
vlan == broadcast domen == mreza    
mora postojati l3 uredjaj (najcesce ruter) zbog komunikacije izmedju razlicitih mreza    
vlanovi su transparentni za hostove    
konfiguracija se radi na svicevima:    
definisemo broj za odredjeni vlan (npr 10, 20)    
`show vlan brief` - svi portovi su u defaultnom vlanu 1    
`conf terminal` -> `vlan <vlan_id>` (opcionalno `name <vlan_name>`)    
- moraju biti konfigurisani na svakom od sviceva u topologiji    
dodjeljujemo vlan na nivou porta:     
- `switchport mode access` (access ili trunk mod)    
- `switchport access vlan <vlan_id>`    
trunk -> prenos saobracaja iz svih vlanova    
`interface range <range>` -> `switchport mode trunk`    
`<range>` npr `f0/1-6` -> `{f0/1, f0/2, f0/3, f0/4, f0/5, f0/6}`    
    
ukljucivanje rutera u topologiju:    
podinterfejsi - na jednom fizickom portu rutera kreiramo vise razlicitih logickih   podinterfejsa, koje ruter smatra zasebnim portom (zasebnom mrezom)  
`en` -> `conf t` -> `interface <interface>.<id>` (najcesce id = vlan_id)    
`encapsulation dot1Q <id>`, pri cemu id `<id>` predstavlja broj vlana kojem je defaultni   gateway (npr za vlan 10 => id = 10)  
adresiranje interfejsa - podinterfejs ima adresu defaultnog gatewaya za sve hostove u   tom vlanu - `interface <interface>.<id>` -> `ip address <gateway_address> <subnet_mask>`  
**bitno je** prvo raditi `encapsulation` pa onda `adresiranje`, jer `encapsulation`   ponistava postojecu adresu na interfejsu  
`sh ip int brief` - prikazivanje informacija o interfejsima uredjaja    
port svica koji je povezan za routerom **mora obavezno** biti trunk:    
`en` -> `conf terminal` -> `int <interface>` -> `switchport mode trunk`    
komunikacija izmedju vlanova ne ide direktno, nego preko rutera    
kada svic prvobitno prosljedjuje frejm on ga oznacava (VLAN taguje Ethernet zaglavlje,   802.1q), da bi ruter znao kom vlanu da ga rutira  
ruter prosljedjuje paket izmedju razlicitih vlanova preko istog interfejsa ali   razlicitih odgovarajucih podinterfejsa  
    
ukoliko imamo loadbalancing izmedju sviceva (npr 2-2 veze), tada svaki link izmedju   sviceva moramo staviti u `trunk` stanje (`int range f0/a-b` -> `switchport mode trunk`)  
    
podesavanje root bridge-ova za svaki vlan (pVSTP):    
switch -> `spanning-tree vlan <vlan_id> root primary`    
gdje je switch razlicit za svaki vlan    
    
# 3. EtherChannel, WAN, WLAN, staticko rutiranje, MLS    
## 3a. EtherChannel    
svaki link mora da bude istih karakteristika (npr ista brzina)    
posmatra do 8 fizickih linkova kao 1 link:    
`en` -> `conf terminal` -> `int range <interface>-<range>` -> `channel-group <channel>   mode <option>`, gdje je `<option>` najcesce `on`  
obe strane kanala moraju da budu u istom modu    
    
`show etherchannel summary` - prikaz detalja o etherchannelu    
    
## 3b. WAN    
Serial DCE (na novim 2911 ruterima), bitno ubaciti HWIC-2T karticu (sacuvati konfig)    
protokol koji se koristi po default-u na tim serijskim linkovima je HDLC (nije optimalno   rjesenje - PPP / CHAP protokol je rjesenje):  
`configure terminal` - `int <serial_interface>` - `encapsulation ppp`    
PPP nije kompatibilan sa HDLC: moramo i na drugom ruteru/interfejsu isto to uraditi    
*brisanje PPP konfiguracije mozemo uraditi sa `no encapsulation ppp`*    
podesavanje CHAP (autentikacije izmedju A i B)    
na ruteru A:     
- `enable` - `conf t` - `username <hostname_b> password <password>`    
na ruteru B:     
- `enable` - `conf t` - `username <hostname_a> password <password>`     
- `int <serial_interface>` - `ppp authentication <chap, pap>` - chap se najcesce koristi     
na ruteru A:    
- `enable` - `conf t` - `int <serial_interface>` - `ppp authentication <chap, pap>`    
    
## 3c. WLAN    
najcesce se u CPT koristi Home Router, pri cemu se border router iskljucivo prikljucuje   na `Internet` port wireless routera   
wireless router se koristi za komunikaciju i dodjeljivanje dhcp adresa     
- internet setup (static ip linka izmedju rutera)    
- save setings izmedju mijenjanja tabova    
- laptop mrezna kartica: WPC, pa u PC wireless -> tab Connect    
wireless ruter je rubni ruter pa stoga svaku outbound komunikaciju mapira su svoj   izlazni interfejs prema daljim mrezama (NAT)  
    
## 3d. Staticko rutiranje    
ne mozemo komunicirati sa udaljenim privatnim mrezama (npr iz 192.168.0.0/24 sa 172.16.0.  0/16)  
    
## 3e. MLS    
- nista    
    
# 4. RIP, SSH, PortSecurity    
## 4a. RIP    
- ripv1:    
konfigurisanje RIP protokola:    
`en` - `conf terminal` - `router <protocol>`, pri cemu je `protocol = rip`    
- `network <address>` za svaku direktno povezanu mrezu na ruteru (classful za v1)    
diskontinuirana mreza - podmreze koje su nastale iz istog klasnog opsega ali nisu   direktno povezane, vec su razdvojene nekim drugim klasnim opsegom  
ripv1 ne mozemo da funkcionise za diskontinuirane mreze (opet, jer podrazumijeva   classful adrese)  
    
- ripv2:     
`en` - `configure terminal` - `router rip` - `version 2`    
bitno je u podesavanjima rutera (config-router) iskljuciti autosumarizaciju `no   auto-summary`  
da ruteri ne bi slali RIP update poruke hostovima (koji ne razumiju poruke jer nisu   ruteri) mozemo optimizovati ripv2 protokol na svakom interfejsu svakog rutera:  
`conf t` - `router rip` - `passive-interface <outbound_interface>`, pri cemu je   `outbound_interface` rubni interfejs prema hostovima  
    
## 4b. SSH    
`no ip domain-lookup` - iskljucivanje razrjesavanja pogresno ukucanih komandi    
`hostname <hostname>`    
`security passwords min-length <num>` - minimalna duzina sifre    
`line console 0` - `password <password>` - `login`    
`exec-timeout <minutes>` -> {moze na `line console <line>` i na `line vty <line>`/`line   vty <from> <to>`}  
kod SSH moramo definisati korisnike koji mogu pristupiti uredjaju:    
dodavnje korisnika: `username <username> secret <password>`    
definisanje ssh domena: `ip domain-name security.com`    
`crypto key generate rsa`    
`line vty 0 4` - `transport input <mode>`, pri cemu je `mode = ssh` (moze i `telnet`,   ali radimo `ssh`)  
ako imamo lokalno definisane korisnike, umjesto `login` koristimo `login local`    
sprjecavanje brute-force napada: `login block-for <seconds> attempts <amount> within   <seconds>`  
    
`interface range [<port>/<port_range>]` - `(no) shutdown`    
    
na hostu: `ssh -l <username> <ssh_address>`    
ako na uredjaju nema password/secret onda ne mozemo koristiti te modove preko ssh    
    
## 4c. PortSecurity    
tip l2 zastite na svicevima (ogranicavanje)    
    
`int range [<interface>?-<range>]` - `switchport port-security maximum <num_hosts>`    
pri cemu `maximum <num_hosts>` ogranicava broj maksimalnih korisnika koji pristupaju   datim interfejsima  
`int range [<interface>?-<range>]` - `switchport port-security mac-address sticky`    
`int range [<interface>?-<range>]` - `switchport port-security violation <type>`    
    
ako je violation mode `shutdown`, da bismo vratili port u pocetno stanje, onda moramo   'stvarno' ugasiti port putem `shutdown` komande i upaliti putem `no shutdown`  
    
# 5. OSPF    
10^8 / bandwidth = cost    
area se definise izmedju interfejsa, a ne na ruteru    
isto kao i kod ripa, oglasavamo direktno povezane mreze    
`conf terminal` - `router ospf <distance>`, gdje `distance` sluzi za pokretanje vise   distanci na jednom ruteru  
`network <netaddr> <wildcard_mask> (area <area_number>)?`, pri cemu je ispunjen uslov   `wildcard_mask XOR mask = 255.255.255.255`, tj. zbir odgovarajucih okteta wildcard maske   i originalne maske je uvijek 255
    
loopback interfejs na ruteru je logicki interfejs i ne moze da bude u stanju DOWN    
`conf t` - `interface loopback <id>` - `ip address <address> <mask>`    
    
oglasavanje defaultne rute svim ostalim ruterima:    
`conf t` - `router ospf <distance>` - `default-information originate`    
    
LSA 1, 2 - IntraArea (samo O u ruting tabeli)    
LSA 3, 4 - InterArea (O IA)    
LSA 5 - External (O*E`<id>`)    
    
sumarizacija - vise ruta preko jedne (= broj prvih poklapajucih bita)    
ospf sumarizacija:    
`router ospf <distance>` - `area <area> range <summarized_address> <mask>`    
    
multiaccess mreza - vise rutera pristupa/dijeli jednu mrezu - pojava Designated Router i   Backup Designated Router, gleda se:  
1. da li je postavljen prioritet (postavlja se na nivou interfejsa), ako nije gleda se   Router ID  
2. Router ID:    
   1. moze biti rucno postavljen (`a.b.c.d`)    
   2. najveci loopback interfejs    
   3. najveci fizicki interfejs     
    
`show ip ospf neighbor` - DROTHER znaci da nije ni DR ni BDR    
    
`conf t` - `int <interface>` - `ip ospf priority <priority>` - prioritet je srazmjeran   broju (veci broj == veci prioritet)  
    
2WAY - nemaju direktno susjedstvo, nego poruke razmjenjuju putem Designated Router-a    
    
# 6. DHCP, NAT (Static, Dynamic, Port)    
## 6a. DHCP    
`ip dhcp excluded-address [addresses]`    
`dhcp pool <pool_name>`    
`network <netaddr> <mask>`    
`default-router <default_gateway>`    
`dns-server <dns_address>`    
`ip helper-address <address>` - kada primi broadcast poruku da ju transformise u unicast   i posalje na `address`  
cmd: `ipconfig /renew` - ponovno slanje dhcp zahtjeva    
`ip address dhcp` - dodjeljivanje adrese interfejsu putem dhcp-a    
    
uloge rutera: dhcp klijent, relay agent i dhcp server    
    
## 6b. Static NAT    
"In IPv4 configured networks, clients and servers use private addressing. Before packets with private addressing can cross the internet, they need to be translated to public addresing. Servers that are accesses from outside the organization **are usually assigned both a public and a private static IP address**."  
NAT-iranje se radi na ruteru koji je granica izmedju privatne i javne mreze  

`conf t` - `ip nat inside source <type> <from> <to>`, npr: `ip nat inside source static 172.16.16.1 64.100.50.1`  
potrebno je takodje aktivirati nat na interfejsu rutera: `int <interface>` - `ip nat {inside, outside}`, a pinguje se uvijek `outside` adresa (jer je javna).  

`sh ip nat translations` - prikaz nat translacija 

## 6c. Dynamic NAT    
translacija vise adresa u vise adresa  
standardna kontrol lista 
`conf t` - `access-list <list_id> permit <private_netaddr> <wildcard_mask>` - kreiranje liste privatnih adresa za mapiranje iz  
`ip nat pool <pool_name> <start_address> <end_address> netmask <mask>` - kreiranje pool-a javnih adresa za mapiranje u  
`ip nat inside source list <list_id> pool <pool_name>` - povezivanje privatnih i javnih adresa u dinamicki NAT  
`interface <inbound_interface>` - `ip nat inside`, za unutrasnji interfejs  
`interface <outbound_interface>` - `ip nat outside`  
glavni problem: ukoliko je pool u potpunosti rezervisan, on se kao takav ne moze promijeniti te za posljedicu privatne ip adrese nemapiranih uredjaja se ne mogu mapirati  

## 6d. Port AT (PAT) - Dynamic NAT with Overload
transliranje vise privatnih adresa u jednu javnu (N:1) koristenjem nekog pseudo-porta kao identifikatora    
`conf t` - `access-list <id> permit <private_netaddr> <wildcard_mask>`  
`ip nat pool <pool_name> <from> <to> netmask <mask>`  
`ip nat inside source list <id> pool <pool_name> overload` - dobijanje PAT-a kao rezultat uz koristenje kljucne rijeci `overload`  
`interface <inbound_interface>` - `ip nat inside`  
`interface <outbound_interface>` - `ip nat outside`    

cest slucaj: sve privatne adrese se prevode u javnu (izlaznu) adresu rutera:  
`access-list <id> permit <private-netaddr> <wildcard_mask>`  
`ip nat inside source list <id> interface <router_outboundInterface> overload` 
`interface <inbound_interface>` - `ip nat inside`  
`interface <outbound_interface>` - `ip nat outside`    

# 7. IPv6    
svaki ipv6 interfejs ima dvije adrese:
1. *mora* da ima link-local adresu
2. *moze* da ima globalnu unicast adresu

ip i ipv6 imaju isti cli api

`int <interface>` - `ipv6 address <ipv6_address>/<prefix_length> (link-local?)`  
mozemo imati vise interfejsa rutera sa istom link-local adresom  
`ipv6 unicast-routing` - **neophodno** da ipv6 prosljedjuje pakete  

da bismo radili podmrezavanje kod ipv6, to se uvijek radi kod cetvrtog heksteta