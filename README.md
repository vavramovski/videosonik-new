VIDEOSONIK
Admin account:
username: test
password: test

Za da se startuva aplikacijata se poterbni slednive preduslovi
application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/videosonik
spring.datasource.username=postgres
spring.datasource.password=mouseav555

Dump file na POSTGRES bazata se naogja vo dbexport.pqsql
Prvo treba da napravite baza so ime videosonik,a potoa importnete ja so slednava komanda
pg_dump -U postgres videosonik < "lokacijata na dbexport.pqsql"


VIDEOSONIK Spring Boot aplikacija koja koristi
Spring Security za delot so login vklucuvajki i JWT token,
Spring data za polesni operacii so bazata.
Strogo e zapazena sloevitata arhitektura.

Funkcionalnosti na aplikacijata:
Aplikacija ima 10 tabeli, 1 od niv e so MN relacija (Users M<>N Wishlist),
poveketo od niv se razlozheni bidejki samata relacija sodrzhi vrednost vo nea kako na primer relacijata Cart(Users M< quantity >N Product)
Postojat i enumeraciski tabeli koi za sega sodrzhat samo 2 vrednosti(admin, sales) koi ne igraat uloga zasega.
Backend validacija i avtentikacija na korisnik.
Dokolku korisnikot e admin ima pravo na add/edit/remove operacii nad produktite i ima pristap do kontakt porakite prateni do sluzhbata.
Pokraj bonus privilegiite, kako i adminot taka i sekoj korisnik, ima svoja koshnica (cart) i svoj lista od posakuvani proizvodi (wishlist),
vo koi mozhe da dodava i odzema produkti, zgolemuva i namaluva kolichini i slichno.
Ponudena e paginacija i ednostaven search mehanizam.
Zasega e napraveno site produkti od bazata da se loadiraat na otvoranje na aplikacijata, so cel pogobro korisnicko iskustvo
bidejki e predvideno da ima mal broj na produkti.No dokolku skalira brojot na produkti, ke ja koristam backend paginacijata koja veke postoi no ne se koristi.

Vo delot Contact, sekoj moze da isprati poraka do sluzhbata koja potoa ke se pokaze kaj onie korisnici koi se so Admin privilegii.
Delot Projects e vo izrabotka i celta e da bide mal CMS kade Admin korisnicite ke mozhat da postavuvaat sliki i nekakov tekst okolu dejnosta so koja se bavi kompanijata (bidejki kompanijata ne e samo obichna prodavnica).

Ovoj produkt e so mali izmeni okolu bezbednosta e namenet da izleze vo produkcija.
