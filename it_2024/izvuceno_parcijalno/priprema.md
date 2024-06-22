it

2. 4, 2

3.
encapsulation pa onda ip address
svi svicevi moraju imati sve vlanove

4.
ripv1 - ne mozemo slati masku u apdejtima te samo sumarnu mrezu - diskontinuirane mreze u pitanju razdvojene nekim drugim opsegom
r2 dobio dvije razlicite informacije po njemu istoj mrezi (sa istim distancama)
rjesenje: ripv2

5.
1 designated => 49 + 48 (back ne uspostavlja sa designated)

6.
a ulaz b izlaz, izlaz nije jedinstven, 
10.1.0.13 a, b moze biti interfejs nat .1 ili bilo koju adresu iz gore mreze (osim .2 od r2)

7.
host a u drugoj mrezi, r1 relay agent, kucamo komandu na r1 fa0/0 gdje poruka dolazi
ip helper address (adresa servera)

8.
a. local pref i med u jednom smjeru, as path u oba smijera, ako zelimo da uticemo na saobracaj odlazni podesavamo local preference, a med podesavamo na dolazni saobracaj (sa nadom, med je po niskom prioriteti)
b. ne znamo u kom smo as administratori govorimo za bilo koji as generalno, kad budemo oglasavli net6 ne znam dalje ne mogu ga upratiti 
- med bolji sto je manji (metrika) a lp sto je veci

9. peta podmreza 1003 mreza: 2002:db8:acad:1003:f je sesnaesta adresa nulta moze da se koristi kao mrezna a i ne mora
10.
prioritet je jednak (nije mijenjan prioritet u konfiguraciji) s1 ima oba dp, port priority je nepodesen, gledamo indeks sa druge strane svica s2 (port na s1) s1 fa0/1 je nizi port -> s2 fa0/2 je designate
b: prioritet svica, port priority (default 128) 

11.
.20 i .30 adrese su u istom opsegu
greska pri adresiranju na interfejsima

12.
0 - source list 100 a mi pravio pakete
obavezno mora biti source list 1 - da moze izaci koliko ima adresa u access list
kod PAT na jednu adresu mozemo prevesti 2^16 adresa

13.
10^8/brzina linka = 64 + 64 + 1 (gigabitni link gornje mreze) = 129
10^8 = 100mb, imamo gigabitni link pa bismo trebali koristiti 1000mb

14.
najbitnije prioritet pa onda router id
defaultni prio je 1 kod ospf
r2 ima najveci prioritet pa je designated
ako nema rid onda gledamo najvecu loopback pa onda prio

r1: 1.1.1.1 
r2: dr 
r3: nema loopback, uzima najvecu fizicku adresu 192.168.1.4
r4: loopback je 172.16.1.1

r3 je backup designated (najveca adr)

15.
link local d)

16.
lijevi ruter ima dvije direktno povezane mreze, wireless routing defaultno radi nat
ne prolazi zato sto wireless ruter blokira echo request defaultno (jedan blokira drugi ne)

17.
preko local pref - kad prima saobracaj stavlja manji preference na nekom ruteru
as path - 
b. next hop je sledeci ruter u drugoj mrezi (u admin sistemu) u ovoj desnoj mrezi