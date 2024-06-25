# Internet tehnologije - teorija
## 1. LAN tehnologije - svicevi 
- Kolizioni domen je skup uredjaja poveznih na zajednicki dijeljeni medijum
  - Svi poslati okviri dolaze do svih uredjaja
- Sa povecanjem broja ucesnika povecava se vjerovatnoca da dodje do kolizije
  - Limit propusnog opsega je tipicno ispod 20% od ukupnog propusnog opsega
- Bridge razdvaja LAN mrezu na vise kolizionih domena
  - Jedan port je jedan kolizioni domen
- Princip rada bridza je tzv *transparentni bridzing*, IEEE 802.1d
  - Hostovi ne znaju za postojanje bridzeva
  - Svaki bridz ima svoju bridzing tabelu - MAC adresa hosta, izlazni port
- **Pet procesa bridzinga (switching-a):**
  - Forwarding
    - Prosljedjivanje okvira je uslovljeno da su komunicirajuci uredjaji na razlicitim kolizionim domenima
    - 1. Prima se okvir na jednom portu
    - 2. Gleda se **odredisna MAC adresa**
    - 3. Paket se prosljedjuje ako odredisna MAC adresa **nije uparena** sa ulaznim portom
  - Filtering
    - Blokiranje okvira je uslovljeno tim da su komunicirajuci uredjaji na istom kolizionom domenu
    - 1. Prima se okvir na jednom portu
    - 2. Gleda se **odredisna MAC adresa**
    - 3. Paket se blokira ako je odredisna MAC adresa **uparena** sa ulaznim portom
  - Learning
    - Bridz saznaje na kom portu se nalaze pojedine MAC adrese
    - 1. Prima se okvir na jednom portu
    - 2. Gleda se **izvorisna MAC adresa**
    - 3. Izvorisna MAC adresa sa ulaznim portom se upisuje u bridzing tabelu
  - Flooding
    - U slucaju da odredisna MAC adresa nije poznata
    - 1. Prima se okvir na jednom portu
    - 2. Gleda se **odredisna MAC adresa** - nije nadjena
    - 3. Okvir se prosljedjuje na sve portove bridza osim prijemnog porta
    - 3a. Posljedica: okvir ce se propusiti cak iako ne treba
  - Aging
    - Postavlja se tajmer za svaki unos u bridzing tabeli (tipicno 2min)
    - Tajmer se resetuje prilikom svakog prepoznatog saobracaja koji koriti datu MAC adresu
    - Kad istekne tajmer, unos iz bridzing tabele se brise
- Habovi
  - Motiv je otpornost na otkaze upotrebom zvjezdaste tehnologije
  - Viseportni ripiter za UTP kablove (10BASE-T, IEEE 802.3)
  - Moguce je kaskadno povezati maksimalno 4 haba u nizu
- Nedostatke izmedju habova i bridzeva upotpunjava switch
  - Switch = pametni hab + viseportni bridz
  - Svaka veza (port svica) je zaseban kolizioni domen
  - Half duplex - moguca istovremena komunikacija u samo jednom smijeru
  - Full duplex - moguca istovremena obostrana komunikacija (Transmit i Receive parice UTP kabla)
    - Full duplex je moguc **samo na** point-to-point vezama
  - Kod slanja broadcast okvira (`ffff.ffff.ffff`) sa ulaznog porta, isti okvir se kopira i prosljedjuje na sve preostale portove
  - Neki od aspekata koristenja sviceva su:
    - 1. Moguce koristiti UTP i opticke tehnologije
    - 2. Omogucen izbor half-duplex i full-duplex komunikacije
    - 3. Brzine portova mogu biti fiksne ili '*dogovorene*'
  - Switch moze ucitati i proslijediti okvir na tri razlicita nacina:
    - 1. Store and forward 
      - Svic prima cijeli okvir, provjerava FCS i uslovno prosljedjuje na izlazni port
      - **Mora da se koristi kod asimetricnog prosljedjivanja**
    - 2. Fragment free
      - Svic prosljedjuje okvir nakon primljenih prvih 64 bajta (minimalni transmission unit)
    - 3. Cut-through ili Fast-forward
      - Svic prosljeduje okvir odmah nakon ucitavanja odredisne MAC adrese (prvih 6 bajtova)
  - Auto-negotiation - svic i povezani uredjaji automatski uspostavljaju vezu na najvecoj mogucoj brzini koju podrzavaju
  - Simetricno prosljedjivanje - ulazni i izlazni port su iste brzine
  - Asimetricno prosljedjivanje - ulazni i izlazni port su razlicite brzine


## 2. Ethernet mreze - STP, VLAN
- Petlje u putanjama prouzrokuju vise nepozeljnih fenomena:
  - Dupliranje pristiglih okvira (principijelno potice od flooding-a)
  - Broadcast storm (broadcast frejm neprestano kruzi po topologiji)
  - Nestabilnost bridzing tabela (neprestano kruzenje u oba pravca prouzrokuje oscilaciju bridzing tabele)
- Rjesenje: STP (Spanning-Tree Protocol), IEEE 802.1d (**L3 protokol**)
- Zasnovan na formiranju stabla unutar grafovske topologije
- **Parametri STP-a:**
  - **Bridge ID**
    - Dva polja (8 bajtova)
      - *Bridge priority* - veci prioritet = veci znacaj
      - *MAC adresa*
  - **Port Cost**
    - Inicijalno 10^9 / bandwidth, poslije revidirano 
  - **Path Cost**
    - Sumarna cijena portova na putu do root bridza
- **Vrste STP poruka:**
  - STP poruke su **BPDU poruke** (Bridge Protocol Data Unit) enkapsulirane **unutar Ethernet okvira** - L3
  - {*Root ID*, *Path Cost*, *Bridge ID*}
  - Prenose STP informacije samo izmedju susjednih sviceva
  - **Configuration BPDU**
  - **TCN** - Topology Change Notification
  - **TCA** - Topology Change Acknowledgement
- **STP proces**:
  - 1. Izbor root svica
    - Svaki svic sebe nominuje za root switch
    - Ukoliko primi manji Root ID - oglasava tu vrijednost kao Root ID
    - Poslije zavrsene nominacije, samo Root Bridge salje **Configuration BPDU** poruke
  - 2. Izbor root portova
    - Svaki svic ima **maksimalno jedan** Root Port
    - U slucaju da primi dvije iste vrijednosti Path Cost-a, uzima oglasenu poruku sa manjom vrijednoscu Root ID
    - Poslije zavrsenog procesa izbora RP, svi RP su aktivni i stavljaju se u **Forwarding (FWD)** stanje
  - 3. Izbor designated portova
    - Port na segmentu koji oglasava najmanju vrijednost Path Cost
    - Root bridge ima sve DP sa vrijednoscu **Path Cost = 0**
  - 4. Blokiranje preostalih portova
    - Svi ostali portovi su blokirani
    - Ne prosljedjuju poruke u izlaznom smijeru
    - Primaju poruke samo ako su BPDU
- U stacionarnom stanju, Root Bridge emituje Configuration BPDU svakih 2sec (Hello timer)
- STP konvergencija nastupa pri promjeni topologije, a desava se pri:
  - Prekidu na vezama krajnjih uredjaja
  - Prekidu na direktnim vezama izmedju sviceva
  - Prekidu na indirektnim vezama izmedju sviceva
  - Dodavanju nove veze
- **STP tajmeri:**
  - Hello timer (2s)
  - Max age timer (10 * Hello period) - u slucaju da svic vise ne prima BPDU poruke
  - Forward delay (15s) - vrijeme cekanja na uspostavljanje Forwarding stanja
- **STP stanja:**
  - Blocking state
  - Listening state
    - Privremeno stanje (Forward Delay)
    - Pocinju i da se salju samo BPDU paketi
  - Learning state
    - Privremeno stanje 
  - Forwarding state
- RSTP (Rapid STP) - IEEE 802.1w
  - Uvodi nove metrike Cost-a (20Tbps / bandwidth)
  - Razliciti tipovi veza - Link type (P2P, Shared), Edge type
  - Nove vrste portova (Alternate, Backup)
    - Alternate port - blokiran port, najbolji poslije RP 
    - Backup port - blokiran port, najbolji poslije DP 
  - Redefinsano stanje portova - **izbaceno Learning** stanje
- VLAN - 802.1q
  - Moguc je i *Legacy nacin povezivanja* - svaki VLAN ima zaseban link (neskalabilno)
  - Trunk link - zajednicka veza za sve VLAN-ove
  - VLAN Frame Tagging u Ethernet frejmu - 2 polja po 2 bajta (4B), 2^12 mogucih VLAN-ova 
  - FT se primjenuje samo na Trunk vezama
  - **Access port** - prenosi samo jedan VLAN
  - **Trunk port** - prenosi vise VLAN-ova

## 3. Wireless LAN
- Definisan standardom IEEE 802.11
- Koristi se dijeljeni medijum i half-duplex prenos 
- Kolizija se ne moze detektovati - **CSMA/CA**
- Zahtijeva se slanje potvrde za uspjesan prijem svakog okvira
- **Service Set** - grupa povezanih uredjaja u WLAN mrezi
- IBSS - Independent Basic Service Set
- BSS - Basic Service Set (centralni uredjaj)
- ESS - Extended Service Set
- **Access point** - centralni uredjaj u WLAN mrezi
  - Rjesenje za "hidden station" problem
  - Sva komunikacija se vrsi preko AP
    - Uredjaji mogu da detektuju okvire, ali prihvataju samo okvire od AP
- **Service Set Identifier (SSID)** - naziv WLAN mreze (32B)
- Beacon okvir - periodicno oglasavanje, sadrzi SSID i MAC adresu AP
- Povezivanje na WLAN se odvija u tri faze:
  - 1. Razmjena parametara (Probing)
    - Probe Request, Probe Response
  - 2. Autentikacija
    - Authentication Request, Authentication Response
  - 3. Asocijacija
    - Association Request, Association Response
- **Moguce je integrirati LAN sa WLAN mrezama:**
  - Mapiranjem SSID-a u VLAN
  - Vise SSID-ova mapiranih u odvojene VLAN-ove upotrebom trankovanja
  - Prosirivanjem SSID-a na vise AP uredjaja preko LAN mreze:
    - Svaki SSID mapira u jedan WLAN
    - Trank izmedju AP i svica
  - AP moze raditi u bridge modu (dobija napon putem Power-over-Ethernet)
- WLAN kanal je frekvencijski domen fiksne sirine (20MHz-40MHz, 20/40MHz auto)
- Postoji ukupno 16 kanala, medjusobno razdvojenih sa 5MHz
- AP radi **samo na jednom kanalu**, moguce postojanje preklapajucih kanala 
- Skeniranje kanala se moze izvrsiti:
  - Pasivno - uredjaj ceka da AP oglasi *beacon* okvir koji sadrzi informaciju o kanalu
  - Aktivno - uredjaj salje *Probe Request* o raspolozivim kanalima
- **Format okvira:**
  - Frame Control
  - FCS
  - Source Address
  - Transmitter Address
  - Receiver Address
  - Destination Address
  - To DS, From DS (flegovi)
- CSMA/CA koristi dva pristupa koordinacije za izbjegavanje kolizije na MAC nivou:
  - Centralizovanu (PCF) - jedan centralni uredjaj kontrolise promet
  - Decentralizovanu (DCF) - uredjaji se nadmecu za zauzece medijuma
- Kod decentralizovane koordinacije:
  - Ako je medijum **slobodan** ceka se fiksni vremenski interval (**DIFS**), 50 mikrosekundi
  - Ako je medijum **zauzet**, na **DIFS** se dodatno ceka i **back-off**:
    - Slot-time = 20 mikrosekundi
    - R - random vrijeme cekanja, CW - contention window (inkrementirano)
- Potvrda okvira se sprovodi u dva rezima:
  - 1. Two-way handshake (podaci + potvrda)
  - 2. Four-way handshake (zahtjev + odobravanje + podaci + potvrda)
- Sigurnosni problemi se ogledaju u:
  - Dijeljeni medijumi - mogucnost presretanja paketa
  - Kontrola pristupa - povezivanje i bez fizickog prisustva objektu
- Sigurnosni algoritmi:
  - WEP - RC4
  - WPA - TKIP (Temporal Key Integrity Protocol)
  - WPA2 - AES
  - WPA3 - ?

## 4. WAN tehnologije
ma ovo samo procitati
bitno: sinhronizacija takta, PPP
- WAN tehnologije:
- L1 - RS-232, RS-449, X.21, V.35, G.703
- L2 - HDLC, PPP, Frame Relay, X.25
- L3 - ISDN, ATM, SONET

- PPP je unaprijedjena verzija HDLC (High-level Data Link Control) protokola
- Na L1 prenosi signal **preko serijske veze**
- L2 nivo se sastoji od dva podsloja:
  - 1. Link Control Protocol
  - 2. Network Control Protocols (logicki podsloj, interfejs prema L3 nivou)
![alt text](image.png)
- Flag - uvijek `01111110`, posiljalac poslije 5. uzastopne **1** dodaje **0**
- Address - uvijek 0xff
- Control - uvijek 0x3
- Protokol - identifikacija protokola L3 nivoa
- Data - podaci (maksimalno 1500 bajtova)
- FCS - CRC
- LCP okviri:
  - 1. Link-establishment frames (Config-Request, Config-Ack, Config-Nack, Config-Reject)
  - 2. Link-maintenance frames (Code-Reject, Protocol-Reject, Echo-Request, Echo-Reply, Discard-Request)
  - 3. Link-termination frames (Terminate-Request, Terminate-Ack)
![alt text](image-1.png)
- Dvije opcije autentikacije PPP protokola:
  - PAP - jednokratna cleartext razmjena lozinki
  - CHAP - challenge (vrijeme i slucajni podaci), response (MD5), accept/reject (provjera validnosti response-a)
- PPP algoritmi kompresije:
  - Predictor
  - STAC
- PPP multilink - mehanizam kojim se vise fizickih serijskih veza spaja u jednu logicku

## 5. Principi rutiranja, ARP, ICMP
- rutiranje iz mreza ponovljeno samo
- razlike statickog i dinamickog rutiranja:
  - staticko:
    - rucna konfiguracija
    - neskalabilno
    - neadaptivno
    - korisno u pojedinim slucajevima (npr. testiranje)\
  - dinamicko:
    - skalabilno
    - adaptivno
    - primjenjuje se u svim vecim mrezama
- princip najspecificnije rute u rutiranju
- ARP - Address Resolution Protocol
- koristi se kad je nepoznata **odredisna MAC adresa**
- L3 protokol - ARP Request, ARP Reply - ARP tabela
- ARP Request:
  - ffff.ffff.ffff
  - sadrzi IP i MAC adresu posiljaoca, te IP adresu odredisnog uredjaja
  - ako nema odgovora - ARP javlja gresku na **IP nivou**
- ARP Reply:
  - unikast MAC adresa zahtjevaoca
  - paket: Hardware Type, Protocol Type, HLEN, PLEN, Operation, Sender i Target HA, Sender i Target IP, te Target HA + Target IP u tijelu
- prilikom rutiranja, u paketu se **NE MIJENJAJU IP ADRESE**, a **mijenjaju se MAC adrese**
- ICMP - slanje kontrolnih poruka o radu IP mreze, enkapsulacija u IP poruku
- **Error Message i Query Message**
- Razlicite vrste ICMP poruka:
  - **Destination Unreachable**
    - *Can't Fragment* - IP paket veci od MTU u L2 segmentu, a postavljen 'Dont Fragment' fleg - odbacuje se paket
    - *Network Unreachable* - ne postoji potpuna ruta za ciljnu mrezu od izvorista poruke - vraca ju zadnji ruter na trenutnoj putanji
    - *Host Unreachable* - u mrezi ne postoji host (ARP Request nije dobio ARP Reply) - odbacuje se, ruter obavjestava
    - *Protocol Unreachable* - ne postoji protokol na L4 nivou kod uredjaja, **UREDJAJ** obavjestava
    - *Port Unreachable* - ne postoji otvoren/slobodan port na L4 nivou kod uredjaja, **UREDJAJ** obavjestava
  - **Time Exceeded** - istekao TTL paketa
  - **Redirect** - kada je vise rutera povezano na LAN mrezu
    - default gateway obavjestava uredjaj o boljoj ruti, te tu upisuje u ruting tabelu
  - **Echo Request, Echo Reply**
    - o pingu ispricati
    - o traceroute-u ispricati (salje se paket sa TTL = 1, 2, 3, ..., TTLmax)

## 6. Protokoli rutiranja - Distance Vector
- RIP, IGRP (EIGRP je hibridni)
- **Ciljevi protokola rutiranja**:
  - Potpuno 
  - Konzistentno
  - Optimalno
  - Adaptivno
  - p o k a
- Autonomni sistem - jedinstveni administrativni domen racunarske mreze, moze biti podijeljen na pod-domene
- Interni protokoli rutiranja - unutar jednog administrativnog sistema, eksterni - izmedju autonomnih sistema (izmedju granicnih rutera)
- **Distance Vector** - bazirani na principu udaljenosti, ruteri poznaju samo susjedne rutere (ne i cijelu mrezu)
- **Link** **State** - saznaje se cijela topologija mreze, sa svim parametrima (poput brzine, adresa)
- Classful - bez maski (Class A, B, C, D, E - RIPv1, autosumarizacija), Classless - sa maskama
- Tipovi metrika:
  - Hop count
  - Bandwidth
  - Cost
  - Delay
  - Load
  - Reliability
- Ako dvije rute imaju jednaku metriku, mogu se obe koristiti u svrhu **load balancing**-a
- Administrativna distanca - poredjenje protokola rutiranja (C=0, S=1, OSPF=110, RIP=120) - manja AD -> veci znacaj
- **Distance vector**:
  - Koristi classless adresu i metriku do mreze koju razmjenjuje sa susjednim ruterima
  - Pravilo: samo se najbolja ruta upisuje u tabelu (+ load balancing)
  - **Periodicno oglasavaju rute iz tabele rutiranja**
  - **Konvergencija** - proces uspostavljanja stabilnog i konzistentnog stanja na svim ruterima u mrezi
    - Stabilno - tabele rutiranja se ne mijenjaju sa novim ruting apdejtima
    - Konzistentno stanje - sve rute su ispravne bez nepravilnosti
      - nekonzistentno stanje - npr. ruting petlje (moze se desiti kad se ukine neka mreza, neki ruter idalje ima informacije o toj mrezi)
      - rjesenje - uvodjenje fiksne maksimalne vrijednosti hop-counta
  - Zastite od ruting petlji:
    - **Route poisoning**
      - kada je mreza nedostupna upisuje je joj se maksimalna/beskonacna metrika
    - **Triggered update**
      - oglasava se da je mreza nedostupna tog istog trenutka
    - **Split horizon**
      - ruta se nikad ne oglasava na interfejs preko kog je stigla
    - **Holddown timer**
      - kada se dobije informacija o postojanju neke petlje/pada mreze u topologiji - tokom tajmera se ignorisu sve nove rute za mrezu
- **RIPv1**:
  - classful, hop count max 16, radi na **aplikativnom nivou** - **UDP 520**
  - RIP Request (255.255.255.255), RIP Response (unicast)
- **RIPv2**:
  - RIP Request (224.0.0.9 - RIPRouters), RIP Response (unicast)
  - classless (vlsm podrska), medjusobna autentikacija rutera (lozinka, niz kljuceva)
![alt text](image-2.png)

## 7. Protokoli rutiranja - Link-State
- razmjena informacija putem **LSA** (Link State Advertisements)
- rezultat je baza informacija **LSDB** (Link State Database) - sadrzi LSA dobijene od svih rutera
- Link - interfejs rutera (opisuje mrezu)
- Link state - informacije o interfejsima (IP adresa i maska mreze, IP adresa interfejsa, identifikacija rutera, tip interfejsa, cijena linka, ...)
- svaki ruter oglasava sopstveni LSA paket, koji se razmjenjuje putem direktnih susjeda (flooding)
- OSPF/OpenSPF - Dijsktra algoritam O(nlog(n))
- grupisanje rutera i IP mreza u pojedinacne oblasti (**AREA**), ako pane link u jednoj oblasti, flooding se sprovodi samo u toj oblasti - veca skalabilnost
- osobine LS protokola:
  - Brza konvergencija (zbog flooding procesa)
  - Opterecenje pri konvergenciji (vise CPU vremena, vise memorije, vise propusnog opsega)
  - Opterecenje u stabilnom stanju (**keepalive** poruke)
- Vrste LS protokola: **OSPF**, **IS-IS**

- **OSPF**:
  - 5 razlicitih poruka - enkapsuliraju se u **IP pakete - Protocol 89**:
    - **Hello**, **DBD**, **LSRequest, LSUpdate, LSAck**
  - 224.0.0.5 - AllSPFRouters, 224.0.0.6 - AllDRouters
  - **Hello protokol**
    - sluzi za uspostavljanje OSPF susjedstva
    - uslov - isti parametri na oba rutera:
      - ista IP mrezna adresa (povezani na istu IP mrezu)
      - **Hello interval** (10s)
      - **Dead interval** (4x Hello interval)
      - **Area ID** - pripadaju istoj oblasti
      - **Router ID**
    - Prolazi se kroz **Down**, **Init**, **2-way** stanja
      - **Down**: pocetno
      - **Init**: nakon podizanja interfejsa
      - **2way**: uspostavljeno susjedstvo - prepoznaje se RID u Seen polju, fizicki susjedi (ali ne i OSPF susjedi)
  - **Identifikacija rutera** - Router ID, loopback, fizicka
  - **ExStart**: priprema za razmjenu (Master, Slave, Sequence Number od Mastera)
  - **Exchange**: razmjenjuju se LSA podaci iz LSDB - utvrdjivanje nedostajucih informacija
    - salju se **Database Description** paketi - opis podataka iz LSDB, bez potpunih informacija
    - retransmisija izgubljenih podataka
  - **Loading**: razmjena podataka
    - **LSR** - master
    - **LSU** - slave
    - **LSAck** - master
    - Zavrsno stanje = **FULL**, LSDB sinhronizovane
  - Susjedstvo - OSPF susjedi su DROther sa DR/BDR, i DR/BDR
  - Odabir DR:
    - Najveci prioriter = DR
    - Drugi najveci prioritet = BDR
    - Prioriteti isti - gleda se najveci Router ID
  - Promjena topologije:
    - nece izazvati momentalnu promjenu, tek nakon ponovnog pokretanja mreze
  - **OSPF metrika**:
    - **10^8 / bandwidth** - defaultni referentni propusni opseg (moze se redefinisati)
    - stvarna brzina: `bandwidth <bw>`, konkretna cijena na interfejsu: `ip ospf cost <cost>`
  - **OSPF oblasti**:
    - 0 - centralna oblast, n - periferna oblast (veze se na centralnu)
  - **Vrste OSPF rutera**: 
    - **ABR** - Area Backbone Router - granicni ruter izmedju oblasti
    - **ASBR** - Autonomous System Boundary Router - granicni ruter izmedju nekog rutirajucih domena
    - **Internal router** - pripada samo jednoj oblasti
    - **Backbone router** - pripada centralnoj oblasti (moze se oznaciti kao Backbone + Internal)
  - **Vrste LSA** - prema nacinu razmjene:
    - **Router LSA** - Tip1
      - intra-area, generisu svi ruteri, daju informacije o svim interfejsima
    - **Network LSA** - Tip2
      - intra area, generise DR ruter
    - **Summary LSA** - Tip3 i Tip4
      - inter-area, `O IA`
      - Tip3 - pretvaraju se u RouterLSA i NetworkLSA na ABR
      - Tip4 - LSA koje ASBR oglasava za svoje interfejse
    - **External LSA** - Tip5 - informacije o mrezama van OSPF domena
      - `O E1` - na metriku iz drugog domena **dodana** OSPF cijena, `O E2` - na metriku iz drugog domena **izvorna** metrika
  - **Vrste OSPF oblasti**:
    - Standard Area - generisu se RLSA i NLSA, prihvata SLSA i ELSA
    - Backbone Area (uvijek je standard area)
    - Stub Area - periferna oblast - postavljen Stub fleg
    - Totally Stubby Area - 'skroz' periferna oblast - ABR generisu defaultnu rutu za ovakve oblasti
  - Virtuelni link - stvaranje logicke veze do ABR kroz neku drugu oblast - npr. spajanje dva OSPF domena
  - **Redistribucija OSPF ruta** - razmjena ruta izmedju razlicitih protokola rutiranja
    - jedan ruting domen ucitava rute iz drugog ruting domena i nastavlja da ih distribuira kao svoje rute
    - **Connected routes** - automatski se ukljucuju u ruting domen ako su obuhvacene konfiguriacijom ruting protokola (`network <network> <mask>` CISCO komanda)

## 8. Protokoli na aplikativnom nivou
- **WWW**
  - http 80, https 443
  - html
  - binarni podaci se refenciraju i prenose kao posebni objekti
  - non-persistent (posebna tcp veza za svaki upit), persistent (jedna tcp veza tokom komunikacije)
  - stateless (rest), stateful (cookies)
- **Proxy servis**
  - posredni server za http, kesira zahtjeve
  - vraca zahtjeve iz kesa (ako su kesirani)
  - load balancing, privatnost korisnika, filtiranje saobracaja
- **FTP**
  - kontrolna konekcija (tcp 21), podatkovna konekcija (tcp 20)
  - user, pass, list, retr, stor, put, get, dir, quit, stor, retr
  - tftp - udp 69
- **Email**
  - SMTP - tcp 25
    - SSL/TLS SMTP - tcp 465, 587
  - POP3
    - tcp 110
  - IMAP
    - tcp 143
- **Telnet**
  - tcp 23
  - udaljeni pristup tekstualnoj konzoli (cli)
- **SSH**
  - secure shell
  - tcp 20
- **RDP**
  - microsoft, tcp/udp 3389
  - graficka kontrola
- **DNS**
  - dns - pretvaranje simbolickog naziva u ip adrese
  - reverse dns - pretvaranje ip adrese u simbolicki naziv
  - definisanje hijerarhije domena, ili email servera za domen
  - inicijalno - hosts.txt
  - danas hosts.txt olaksava napor dns-a
  - **DNS Struktura**:
    - korijen - prazan string
    - cvor stabla - simbolicki naziv
    - case-insensitive
    - FQDN - Fully Qualified Domain Name - **apsolutni naziv domena**
      - etf.bg.ac.rs, etf.unibl.org
    - **relativni naziv domena** - poddomen, npr `etf` u `etf.bg.ac.rs`
    - TLD - Top Level Domain, poddomen root domena, npr. `com`, `rs`, `org`, ...
  - Logicka struktura je fizicki organizovana na distribuirani nacin - cijelo stablo je podijeljeno u zone
  - **Zona stabla** - dio stabla, jedan ili vise cvorova
    - unutar jedne organizacije definisano u tzv. **Name Serveru**
    - uredjaji iz jednog domena mogu da pripadaju razlicitim, fizicki udaljenim mrezama
  - **DNS - Princip rada**
    - **Primarni DNS Server**
      - sadrzi definiciju zone za neki domen
    - **Sekundarni DNS Server**
      - periodicno preuzima zonu od primarnog DNS-a - **transfer zone**
    - **Autoritativni DNS Server**
      - imaju cjelokupne zone za odredjene domene
    - **DNS Resolver** - ako klijent nema kesiran podatak, salje upit lokalnom DNS serveru (udp/tcp 53)
    - **Dvije vrste upita**:
      - Rekurzivni upit - vraca potpun odgovor ili gresku (generalno namijenjen za klijente)
      - Iterativni upit - vraca djelimicni najbolji moguci odgovor, referise na druge servere koji mogu da dalje rijese upit
    - **Zona** - tekstualni fajl
    - **Resource record (RR)**:
      - osnovna jedinica podataka - pojedinacan zapis u zoni
      - sintaksa: `name ttl class type value`
        - `name` - naziv podatka (domen ili host adresa)
        - `ttl` - vrijeme validnosti podatka u kesu
        - `class` - za internet uvijek **IN**
        - `type` - tip RR podatka (SOA, NS, MX, A, AAAA, PTR)
        - `value` - vrijednost koja se pridruzuje RR (npr. adresa, naziv, ...)
      - **VRSTE**
        - *SOA* - pocetak zone
          - Serial, Refresh, Retry, Expire, Minimum TTL
        - *NS* - definisanje dns servera za domen
          - **Glue Record** - IP adresa DNS servera poddomena
        - *MX* - definisanje mejl servera za domen
        - *A* - mapiranje ime -> ipv4
        - *AAAA* - mapiranje ime -> ipv6
        - *CNAME* -> alternativni nazivi
          - prednosti: definisanje samo jedne adrese (A/AAAA zapis) i vise naziva (CNAME)
          - nedostaci: upit se razrjesava u dva koraka
        - *PTR* - mapiranje ip -> ime (rDNS)

## 9. Border Gateway Protocol
- circuit-switching - rezervisane veze
- packet-switching - nezavisan odnos putanja-paket

## 10. IPv6
- nedostaci ipv4:
  - bezbjednost na ip/l3 nivou
  - qos?
![alt text](image-3.png)
- izbaceno: IHL, Header Checksum, Options, polja za fragmentaciju
- **Traffic Class** - klasa saobracaja => razlicit prioritet
- **Flow Label** - optimizovan proces rutiranja
- **fragmentacija**
  - neekonomican proces
  - sprovodi se na izvoristu, a ne u ruterima
  - ipv6 **garantuje MTU od minimalno 1280 bajtova**
    - ako je paket prevelik - **ICMPv6 - Packet Too Big**
- opciono:
  - **Routing** opcija:
    - utice na put paketa, definisuci sekvencu rutera, tzv. Checkpoints
- **Vrste IPv6 Adresa**:
  - Unicast - jedinstvena adresa, identifikuje interfejs
    - GUA - Global Unicast Address `2000::/3` - **javne** adrese, poicnju sa `b001`
      - tri logicka dijela:
        - 1. Global Routing Prefix - 48b
        - 2. Subnet ID - 16b
        - 3. Interface ID - 64b
          - staticki (manuelno)
          - dinamicki (**EUI-64** ili random) - Extended Unique Identifier (fffe + 7. bit na '1')
    - ULA - Unique Local Address `fc00/7` - **privatne** adrese
      - Global ID - pseudoslucajna vrijednost
      - Interface ID - random/EUI64/manuelno
    - LLA - Link-Local Address `fe80::/10`
    - Loopback Address `::1/128` - ne izlazi van uredjaja, ne rutira se
    - Unspecified Address `::/128` - ne rutira se
    - Embedded IPv4 address `::/80` - za tranziciju sa ipv4 na ipv6
    - Default Route `::/0`
  - Multicast - identifikuje vise interfejsa `ff00::/8`
    - Well Known `ff00::/12`
    - Transient `ff10::/12`
    - Solicited-Node `ff02::1:ff00:0:0/104` - odnose se na pojedinacne uredjaje
      - automatski generisane iz GUA, ULA i LLA
      - fiksan prefiks `ff02::1:ff00:0:0/104`
      - koristi se za internu komunikaciju - **Neighbor Discovery Protocol** (NDP)
        - Addres Resolution (ekvivalent ARP-a)
        - Duplicate Address Detection (DAD)
  - Anycast - identifikuje vise interfejsa razlicith uredjaja (paket poslan na ovakvu adresu primice **samo jedan** interfejs)
- **Konfigurisanje IPv6 adresa**:
  - Staticko
    - Interface ID se automatski postavlja pomocu EUI64
  - Dinamicko
    - Stateful DHCPv6 - DHCP server pamti kom je uredjaju dodijelio koju adresu
    - **Stateless Address Autoconfiguration** (SLAAC)
      - automatsko postavljanje IPv6 adresa za hostove/interfejse
      - uredjaji automatski saznaju **site prefix**, **default gateway**, **DNS**
      - Interface ID se automatski postavlja putem EUI64 ili PRNG
- **ICMPv6**:
  - Error Messages - sve iste
  - Query/Informational Messages
    - dodano: **Multicast Listener Discovery**, **Neighbor Discovery Protocol**
- **NDP**:
  - ICMPv6 NDP
  - zamjenjuje ARP, ICMP Router Discovery i ICMP Redirect
  - Funkcije:
    - **Router discovery**
    - **Prefix discovery**
    - **Address Resolution**
    - **Duplicate Address Detection**
    - **Redirect**
    - **Neighbor Unreachability Detection**
  - Poruke (Router/Neighbor Solicitation/Advertisement):
    - Router Solicitation (RS)
    - Router Advertisement (RA)
    - Neighbor Solicitation (NS)
    - Neighbor Advertisement (RA)
  - **Autokonfiguracija IPv6 uredjaja**:
    - SLAAC
    - 1. Router Solicitation - (source: link-local, odrediste: `ff02::2/8` (AllIPv6Routers))
    - 2. Router Advertisement - (link-local rutera, link-local uredjaja, mrezna adresa/prefiks, opciono i dns)
    - ruteri takodje periodicno oglasavaju RA poruke (`ff02::1/8` - AllIPv6Devices)
  - **Dodjela DNS Servera**:
    - Putem tijela Router Advertisement poruke
    - Automatski (Stateful/Stateless DHCPv6)
      - Stateful DHCPv6:
        - dodjeljuje se sve, i pamti se koje su adresene dodijeljene (i kome)
      - Stateless DHCPv6:
        - dodjeljuje se samo DNS (+ ponesto?) ali ne i IPv6 adrese
  - **Address Resolution**:
    - Neighbor poruke
    - 1. Neighbor Solicitation - 3333.ff55.6666 + Solicited-Node Multicast adresa poznate IPv6 adrese
    - 2. Neighbor Advertisement (ako postoji)
  - **Duplicate Address Detection** - salje se NS upit na adresu koja se zeli koristiti i ceka se NA (ako je zauzeta adresa)
- **Mehanizmi tranzicije IPv4 -> IPv6**:
  - 1. Dual Stack
    - 0x86dd identifikator u Type/Len polju
  - 2. IPv6 Tunnelovanje
    - ipv6 paket sadrzan u tijelu ipv4 paketa
    - ipv4 domen je transparentan za ucesnike ipv6 komunikacije
  - 3. Protocol Translation
    - direktna komunikacija izmedju IPv6 i IPv4 uredjaja
    - **NAT-PT** - Network Address Translation - Protocol Translation
    - slicno kao i ipv4 NAT - zamjena adresa u zaglavlju na granicnom ruteru izmedju v6 i v4 domena