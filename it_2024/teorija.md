# 1. LAN tehnologije - svicevi
Kolizioni domen je skup uredjaja povezanih na zajednicki dijeljeni medijum, svi poslati okviri dolaze do svih uredjaja. Ripiteri su L1 uredjaji - ne dijele mrezu u odvojene kolizione domene, a povecavaju velicinu mreznog segmenta.
Bridge razdvaja mrezu na vise kolizionih domena, svaki port bridza pripada razlicitom kolizionom domenu - blokira pakete ako je odrediste na istoj strani bridza, u suprotnom propusta. 
Radi na principu transparentnog bridzinga - hostovi ne znaju za postoja bridza, a samim tim se i ne zahtijeva konfiguracija hostova pri povezivanju na sviceve. Svaki bridz ima bridzing tabelu sa parovima (MAC adresa hosta, identifikacija porta hosta)
Pet procesa bridzinga:
  1. Forwarding - ukoliko src_port != dest_port
  2. Filtering - ukoliko src_port == dest_port
  3. Learning - ukoliko bridz ne zna za src_port (upisuje u tabelu)
  4. Flooding - ukoliko bridz ne zna za dest_port (broadcast storm na sve osim src_port)
  5. Aging - ukoliko na pojedini MAC entry nema prometa odredjeno vrijeme
Hab je sredisnji uredjaj u zvjezdastoj topologiji (viseportni ripiter za utp kablove) - regeneracija okvira i njihov broadcast. 
Svicevi se koriste kao zamjena za hab u centralnim cvoristima lan mreza - smanjuje kolizione domene (svaka veza je poseban kolizioni domen).
  1. Store and Forward - prima cijeli okvir, provjerava FCS i prosljedjuje na izlazni port
  2. Fragment free - prosljedjuje nakon primanja prvih 64 bajtova
  3. Cut through - prosljedjuje cim primi odredisnu MAC adresu (6 bajtova)
Auto-negotiation (shodno MDIX) - uspostavlja najvecu mogucu brzinu. Kod razlicith brzina medijuma izmedju portova se mora koristiti Store and Forward. L3 svicevi koriste hardversko rutiranje na L3 nivou.

# 2. Ethernet mreze - STP, VLAN
STP Parametri:
  1. Bridge ID (2B: bridge priority - moze se rucno podesiti, 6B: MAC adresa)
  2. Port Cost (10Mbps = 100, 100Mbps  = 19, 1Gbps = 4, 10Gbps = 2), 4 bajta
  3. Path Cost - suma cijena portova na putu od izvora do odredista, najbolja putanja ima najmanju cijenu
STP poruke su BPDU - Bridge PDU (Root ID = 8B, Path Cost = 4B, Bridge ID = 8B), koje se dijele samo izmedju susjednih sviceva - enkapsulirane su unutar Ethernet okvira => STP je protokol treceg nivoa. Postoje tri vrste BPDU poruka:
  1. Configuration BPDU
  2. Topology Change Notification (TNC)
  3. Topology Change Acknowledgement (TCA)
STP proces:
  1. Izbor root svica
  2. Izbor root portova
  3. Izbor designated portova
  4. Blokiranje preostalih portova
STP konvergencija se desava pri promjeni topologije (ukoliko je zadatak samo rucno preraditi stp stablo)
STP tajmeri (oglasavaju se u ConfBPDU porukama):
  1. Hello (2s)
  2. Max age (10 x Hello period)
  3. Forward delay (15s)
EtherChannel predstavlja vise fizickih veza kombinovane u jednu logicku vezu (nigdje detalja na prezentacijama). 
STP problemi:
  1. spora konvergencija
  2. nema load-balancinga
  3. neoptimalne putanje
  
**Rapid STP** - ponoviti za ispit

VLAN - Virtual LAN - logicki dijeli fizicku LAN topologiju na vise nezavisnih logickih LAN mreza, a funkcionalno je potpuno ekvivalentan fizickom LAN-u
Konfigurisanje se vrsi:
  1. Staticki
  2. Dinamicki
VLAN-ovi sa vise sviceva se mogu povezati medjusobno zasebnim fizickim vezama (skupo) ili jednim VLAN Trunk Link-om (nema dodatnih fizickih veza, nezavisno od broja VLAN-ova)
Da bi se omogucila identifikacija frejmova upucenim pojedinim VLAN-ovima, koristi se VLAN Frame Tagging - na trank vezama u Ethernet zaglavlje se dodaje 4 bajta, a prvih 12 bita oznacavaju VLAN ID (2^12 - |{0, 1, 4095}|). Primjenjuje se samo na trank vezama.
Vrste VLAN portova:
  1. Access Port - na vezama koje prenose samo jedan VLAN
  2. Trunk Port - na trunk vezama koje prenose vise VLAN-ova
Vrste portova moraju da se poklope na obe strane jedne veze (ili oba AP ili oba TP)
Povezivanje razlicitih VLAN-ova se *mora* obaviti preko rutera na L3 nivou

# 3. WLAN
Definisan prema IEEE 802.11 standardu - dijeljeni medijum (jedna frekvencija), half duplex. Kolizije se ne mogu detekovati - tokom slanja prijem je iskljucen. Zbog nemogucnosti detektovanja kolizije ne koristimo CD (Collision Detection) nego CSMA/CA (Collision Avoidance). Takodje se zahtijeva slanje potvrde za uspjesan prijem svakog okvira.
Postoji vise rezima WLAN mreza (Service Set - grupa povezanih uredjaja unutar WLAN mreze):
  1. Ad-hoc:
     1. IBSS - Independent Basic Service Set - svi ucesnici su ravnopravni
  2. Infrastrukturni rezim
     1. BSS - Basic Service Set - centralni uredjaj (Access Point)
     2. ESS - Extended Service Set - vise Access Point-ova povezanih preko svica
SSID - Service Set Identifier - naziv WLAN mreze (4 bajta). Beacon okvir periodicno oglasava AP, a sadrzi SSID i MAC adresu AP. 
Povezivanje na WLAN se odvija u tri faze:
  1. Razmjena parametara (Probe Request - Probe Response)
  2. Autentifikacija (Auth Request - Auth Response)
  3. Uclanjivanje/asocijacija (Association Request, Association Response)
PoE - Power over Ethernet (do 12V jednosmjernog napajanja). WLAN kanal je frekvencijski domen fiksne sirine (20/40 MHz) i sluzi za prenos jednog signala. Tipicno je 16 kanala, koji su medjusobno razdvojeni za 5 MHz (medjusobno preklopljeni). AP podrzava vise kanala ali radi samo na jednom kanalu. Problem preklapanja kanala vise susjednih AP uredjaja. Upamtiti tabelu flegiranja To DS/From DS.
Svaki uredjaj zauzima neko vrijeme na medijumu - Network Allocation Vector (NAV), a zavisi od velicine okvira i brzine prenosa - ostali uredjaji znaju kada ce se medijum osloboditi.
Dva pristupa izbjegavanja kolizija na MAC nivou:
  1. Point Coordination Function (PCF) - jedan centralni AP uredjaj upravlja saobracajem
  2. Distributed Coordination Function (DCF) - svi uredjaji se nadmecu za zauzimanje medijuma - dominantan pristup
     1. Distributed Inter Frame Space (DIFS) - ukoliko je slobodan ceka se 50 mikrosekundi prije slanja
        1. Ukoliko je zauzet: ST (slot time, =20us), R (random, 0 -:- CW, Contention Window - inkrementuje se CW pri neuspjelom slanju)
        2. Back-off = R * ST
        3. Total delay = DIFS + Back-Off
Pri svakoj uspjesno primljenoj poruci bez kolizije salje se ACK 
Dva rezime prenosa okvira:
  1. 2way handshake - ACK
     1. Data
        1. SIFS delay (Short Inter Frame Space, 10us)
     2. ACK
  2. 4way handshake - RTS/CTS
     1. Request to send
        1. SIFS
     2. Clear to send (OK)
     3. Data
        1. SIFS
     4. ACK
WEP - Wired Equivalent Privacy (RC2-40)
WPA - Wi-Fi Protected Access
IEEE 802.1i - WPA2 (AES)
Standardi:
  1. 802.11a - 5G, 6 -:- 54 Mbps
  2. 802.11b - 2.4, 1 -:- 11
  3. 802.11g - 2.4, 6 -:- 54 Mbps
  4. 802.11n - 2.4 / 5G, ? -:- 240/450 Mbps
  5. 802.11ac - 2.4 / 5G, ? -:- 700/1300 Mbps
  
# 4. WAN tehnologije
Circuit-Switched - trenutno-fiksan fizicki link izmedju dva korisnika u komunikaciji
Packet-Switched - paketi se medjusobno komutiraju kroz WAN mrezu (L2/3VPN)
WAN veze na L1 nivou:
  1. Analogne - digitalni siganlu se modulisu i pretvaraju u analogne
     1. voiceband - uskopojasni
     2. broadband - sirokopojasni
  2. Digitalne veze
Modemi su povezani na fizicku vezu i digitalne signale transformisu u modulisani analogni signal i obrnuto. Uskopojasni modemi su u govornom podrucju preko telefonske veze (Dial-up), a broadband na visim frekvencijama, iznad govornog opsega (DSL). Kablovski modemi sluze za prenos preko koaksijalnog kabla kablovskog operatora.
CSU - Channel Service Unit, uredjaj povezan na digitalnu liniju
DSU - Data Service Unit, uredjaj koji adaptira fizicku vezu od DTE (Data Terminal Equipment) za transimisiju u digitalni signal preko CSU. Obicno su CSU/DSU integrisani u jedan eksterni uredjaj ili u karticu rutera.
WAN tehnologije:
  1. L1 - RS-232, RS-449, X.21, V.35, ..
  2. L2 - HDLC, PPP, Frame Relay, ...
  3. Multilayer - ISDN, ATM, SONET
L1 WAN prenos se odvija tipicno preko sinhronog linka (do 10 Gbps). Povezivanjem dva rutera u laboratoriji bez CSU/DSU se naziva back-to-back povezivanje, pri cemu jedan od njih mora da bude DCE (Data Circuit-terminating Equipment) i da daje clock.

L2 protokol za prenos preko sinhrone i asinhrone serije je PPP (P2PP, Point to Point Protocol), koji je jos unaprijedjena verzija HDLC protokola. Na L1 nivou prenosi signal preko serijske veze, dok na L2 nivou ima operise sa dva protokola:
  1. LCP - Link Control Protocol
     1. uspostavljanje, odrzavanje i raskidanje veze
     2. pregovaranje izmedju ucesnika
     3. postavljanje kontrolnih opcija PPP okvira
     4. automatska konfiguracija parametara obe strane
  2. NCP - Network Control Protocolset (interfejs prema L3 nivou)
Odvijanje u tri faze:
  1. Link establishment - uspostavljanje linka za komunikaciju
  2. Determine link quality - uspostavljanje standarda
  3. Network protocol negotiation
**Format PPP okvira**

Postoje tri vrste LCP okvira:
  1. Link-establishment frames
     1. Configure-Request, Configure-Ack, Configure-Nack, Configure-Reject
  2. Link-maintenance frames
     1. Code-Reject, Protocol-Reject, Echo-Request, Echo-Reply, Discard-Request 
  3. Link-termination frames - Terminate-Request, Terminate-Ack
*ponoviti jos ppp ndms*

# 5. Principi rutiranja - ARP, ICMP
Router/gateway - komunikacioni uredjaj treceg nivoa, gledaju odredisnu IP adresu iz zaglavlja paketa, odredjuju izlazni interfejs koji vodi do odredista.
Principi rutiranja:
  1. Svaki ruter samostalno donosi odluku o rutiranju na osnovu routing tabel
  2. Razliciti ruteri imaju razlicite routing tabele
  3. Routing tabela uticu na paket prema odredistu, ali ne i na povratni put
Posljedice:
  1. Paketi se rutiraju hop by hop
  2. Paketi se rutiraju nezavisno u oba smjera
Rutiranje se moze vrsiti na osnovu odredisne adrese (Destination-based) ili na osnovu izvorisne adrese (Source-based)
Broadcast IP paket - host dio popunjen jedinicama, Broadcast L2 paket (frejm) - FF-FF-FF-FF-FF-FF (FFFF.FFFF.FFFF). Broadcast domen == IP mreza

Staticko rutiranje:
  + rucna konfiguracija
  + privremeno testiranje, pojedinacne mreze
  - neadaptivno
  - neskalabilno
Dinamicko rutiranje:
  + Skalabilno
  + Adaptivno

Najspecificnija ruta - za trenutni paket bira se najmanja mreza, ona sa najduzim prefiksom/maskom.

ARP - Address Resolution Protocol - rezolucija odredisnih MAC adresa (automatsko pronalazenje MAC adresa na osnovu IP adrese), jer je neophodno:
  1. Source IP
  2. Destination IP
  3. Source MAC
  4. i Destination MAC
ARP sprovode svi IP uredjaji na LAN mrezi:
  1. ARP Request (parametar: IP adresa, ocekuje MAC adresu u Reply)
     1. salje se na broadcast MAC (ffff.ffff.ffff)
     2. ako niko ne javi MAC, prijavljuje se greska na IP (L3) nivou 
     3. Sender HA i target HA polja
  2. ARP Reply (parametar: IP adresa, rezultat: MAC adresa ili odbacuje paket)
     1. Salje se na unikast MAC adresu posiljaoca
     2. MAC adresa se prepoznaje iz **tijela** ARP paketa, a ne iz Ethernet zaglavlja
     3. Target IP i Target HA, Sender IP i Sender HA polja
ARP tabela (ARP kes), parovi (IP, MAC) entry-ja

ICMP (Internet Control Message Protocol) sluzi za slanje kontrolnih poruka o radu IP mreze (L3 protokol), enkapsulira se u IP poruku. Dijeli se na dvije osnovne grupe:
  1. Error message
  2. Query message (Request, Reply)
Vrste ICMP poruka:
  1. Destination unreachable - izvorni paket se odbacuje, a vraca se prvih 100 bajtova originalnog paketa
     1. Can't fragment - IP paket je veci od MTU vrijednosti, a postavljen je DF flag
     2. Network unreachable - routing tabela ne sadrzi rutu za dati paket
     3. Host unreachable - IP adresa se ne nalazi u ARP kesu (salje se ARP Request)
     4. Protocol unreachable - ne postoji L4 protokol koji odgovara source ip + source port
     5. Port unreachable - ne postoji otvoren port na L4 nivou 
  2. Time exceeded - istekao TTL, doticni ruter obavjestava izvorisni uredjaj
  3. Too many redirects 
  4. Echo Request/Echo Reply

# 6. Protokoli rutiranja - DV
Autonomni sistem - sistem koji upravlja domenom racunarske mreze.
Protokoli rutiranja se dijele (po autonomnom sistemu):
  1. Interno
     1. Distance vector (DV) - RIP, IGRP
     2. Link State (LS) - OSPF, IS-IS
     3. Hibridni - EIGRP
  2. Eksterno - BGP (Border Gateway Protocol)

Osnovni cilj svih ruting protokola je uspostavljanje potpune routing tabele:
  1. Potpuno - za sve mreze u routing domenu
  2. Konzistentno - ispravno/bez petlji
  3. Optimalno - prema odgovarajucoj metrici
  4. Adaptivno - prilagodjavanje promjeni topologije

DV - susjedni ruteri razmjenjuju informacije o mrezama:
  1. distancu do odredjene mreze - metrika
  2. vektor koji vodi do odredjene mreze - next-hop

Classful routing protokoli: rute koje se razmjenjuju ne sadrze maske (podrzane su maske, ali su iste duzine u svim IP mrezama). Autosumarizacija je automatska agregacija svih IP mreza, a sprovodi se na vezi sa drugim routing domenom.
Classless - maske su sadrzane u rutama koje se razmjenjuju izmedju rutera (najcesce u upotrebi). 
Metrika sluzi za izbor najbolje rute kada postoji vise razlicitih ruta do odredjene mreze, a moze se koristiti (izmedju ostalog):
  1. Hop count
  2. Link bandwidth
  3. Cost (proizvoljna cijena)
  4. Delay
  5. Load
  6. Reliability
Load balancing ostvarujemo kada postoji vise ruta/putanja do odredjene mreze sa *istom metrikom*. U routing tabeli za jednu mrezu postoje dvije ili vise next-hop adrese.

**Administrativna distanca je fiksna vrijednost za razlicite protokole rutiranja, a odredjuje prioritet rute u slucaju poredjenja sa rutom od drugog protokola.**

___

Distanca - metrika, Vector - next hop
DV protokoli rutiranja: razmjena routing informacija o susjednim ruterima - adresa mreze sa maskom, metrika do mreze. Router na osnovu ruta od susjednih rutera zna distancu do odredjene mreze, next-hop koji vodi do te mreze. Ruter ne zna ostale rutere, topologiju mreze, brzinu veze niti bilo koji drugi detalj, nevezan za njega sopstveno.
Pravilo DV rutiranja: samo se najbolja ruta bira i upusije - u slucaju vise najbolji ruta sve se upisuju (load-balancing). Konvergencija zavisi od brzine propagacije ruting apdejta od rutera do rutera, te brzine racunanja ruta i uspostavljanja ruting tabela.

Neke od tehnika zastite od ruting petlji su:
  1. Na nivou IP protokola
     1. TTL
  2. Na nivou routing protokola
     1. Route Poisoning - oglasavanje da je mreza postala nedostupna (beskonacna metrika)
     2. Triggered update - kada ruta postane nedostupna (ne ceka se sledeci routing apdejt)
        1. oglasava se samo jedna ruta, a ne cijela routing tabela
     3. Split horizon - nikada se ne oglasava ruta na interfejs preko koga je ta ruta pristigla
     4. Holddown timer - ceka se odredjeno vrijeme da bi se informacija o promjeni propagirala do svih rutera

RIPv1 - administrativna distanca 120, classful (ne podrzava VLSM, autosumarizacija), metrika je Hop Count (max = 16), a radi na aplikativnom nivou (UDP, port 520). Komunikacija se odvija u dva koraka, na periodu od 30 sekundi:
  1. RIP Request
     1. navodi se mrezna adresa za trazenu rutu (0.0.0.0 za sve rute)
     2. slanje na limited broadcast adresu (255.255.255.255)
  2. RIP Response
     1. odgovor na upit - cijela ruting tabela
     2. do 25 ruta u jednoj poruci
     3. slanje na unikast adresu izvornog rutera

RIPv2 - classless (podrzava vlsm)
Glavne razlike u odnosu na RIPv1:
  1. RIP Request 
     1. salje se na 224.0.0.9 multikast adresu
  2. Zajednicki kljuc dva susjedna rutera
  3. Niz kljuceva (Key Chain) 

**primjer rip paketa**

Distance Vector:
  + jednostavni
  + nezahtjevni
  + malo zauzece linka za manje mreze
  - neadekvatna metrika
  - nedovoljna skalabilnost
  - spora konvergencija 

# 7. Protokoli rutiranja - LS

# 8. Protokoli na aplikativnom nivou - DNS
Serverske aplikacije - komunikacija sa klijentom putem soketa (IP adresa + port)
Klijent inicira komunikaciju sa serverom putem odredjenih aplikacija - dvosmjerna komunikacija.
HTTP - Hyper Text Transfer Protocol, HTML - Hyper Text Markup Language.
HTTP : 80, HTTPS : 443
Odrzavanje konekcija:
  1. Perzistentno - jedna uspostavljena TCP veza se koristi za vise odgovora
  2. Neperzistentno - za svaki odgovor se kreira TCP veza
Konekcija se moze posmatrati:
  1. Stateful - uz pomoc kolacica (npr. SOAP principi)
  2. Stateless - ne prati aktivnost klijenta, svaki dio komunikacije je nezavisan od drugih (REST)
- kesiranje zahtjeva uz pomoc proxy servera (kao medijatora u komunikaciji)

FTP:
  - TCP 20, 21
  - stateful
  - jedna konekcija za prenos jedne datoteke
  - 20: data port (put/STOR, get/RETR)
  - 21: kontrolni port

SMTP:
  - TCP, 25

POP3:
  - TCP, 110
  - SSL/TLS POP3: port 995

IMAP:
  - TCP, 143
  - SSL/TLS IMAP: 993

TELNET:
  - TCP 23
  - moguce navesti specifican port za otvaranje TCP konekcije prema datom portu

SSH:
  - TCP, 22

RDP (Remote Desktop Protocol):
  - TCP/UDP 3389
  - RDP klijent


DNS - Domain Name System, prevodjene izmedju simbolickih naziva i IP adresa hostova. Inicijalno, nazivi svih racunara su bili definisani u jednoj datoteci "HOSTS.TXT", koja je hostovana i azurirana u Stanford Research Institutu. Svaki lokalni Windows uredjaj ima "hosts.txt" datoteku koja omogucava razrjesavanje imena bez koriscenja DNS-a.

DNS stablo se topoloski sastoji od dva elementa:
  1. Korijen stabla, root domen u oznaci praznog stringa ""
  2. Cvor u stablu - simbolicki naziv, ime

Apsolutni naziv domena (FQDN, Fully Qualified Domain Name) jeste putanja od cvorova do korijena stabla.
Relativni domen je poddomen nekog domena (npr. "etf" u "etf.unibl.org", "rc" u "rc.etf.unibl.org")

Top Level Domain (TLD) - .org, .rs, .com, .org, .ba, ..., pri cemu su ".rs", ".ba" i ostali TLD tzv. Couny Code TLD (ccTLD). 
DNS Zona je dio stabla (jedan ili vise cvorova), a sadrzi informacije o pripadajucim domenima - cesto se skladisti u obliku tekstualne datotetke (DNS ili nameserver).
Postoji vise principa rada DNS servera:
  1. Primarni DNS server (za neki domen)
     1. dns server na kome je definisana zona za neki domen
  2. Sekundarni DNS server (za neki domen)
     1. periodicno preuzima zonu od primarnog DNS servera - transfer zone
  3. Autoritativni DNS server (za neki domen)
     1. imaju cjelokupne zone za odredjene domene
DNS server razrjesava imena upotrebom DNS resolvera, koji funkcionise na obe strane:
  1. Kod klijenta: ako nema podataka u lokalnom DNS kesu - salje se upit lokalno-podesenom DNS serveru
  2. Kod servera: ako nema podataka u lokalnom kesu ili bazi zona - salje se upit autoritativnim DNS serverima za pripadajuci domen

zona - tekstualni ASCII fajl
Resource Record - pojedinacan zapis u zoni
  [Name TTL Class Type Value]
  [etf.rs 86400 IN A 147.91.8.42]
postoji vise vrsta RR:
  1. SOA (Start of Authority)
     1. Serial - serijski broj zona fajla
     2. Refresh - period provjeravanja sekundarnog DNS-a
     3. Retry - delay nakon neuspjele provjere
     4. Expire - koliko dugo se cuva DNS zapis od primarnog DNS
     5. Minimum TTL - koliko dugo se cuvaju zapisi u drugim DNS serverima
  2. NS - nameserver
  3. MX - adrese mejl servera za domen
  4. A - definisanje mapiranja u IPv4
  5. AAAA - definisanje mapiranja u IPv6
  6. CNAME - kanonicko ime, alias
     1. upit za alias se razrjesava u dva koraka (nedostatak)
        1. Vracanje originalnog naziva
        2. Vracanje IP adrese za originalni zapis
  7. PTR - pointer, mapiranje IP adrese u ime (reverzno)

Glue Record - IP adresa DNS servera poddomena, definisana u zoni domen
