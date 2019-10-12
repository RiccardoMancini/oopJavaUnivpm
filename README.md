# TITOLO

Un .... è un sistema software in grado di mettersi al servizio di un Client (applicazione, sito web, Postman), comunicando tramite il protocollo HTTP. Un Web service consente quindi agli utenti che vi si collegano di usufruire delle funzioni che mette a disposizione. Con Spring Boot, è stato possibile creare questo software che lancia l'intera applicazione web, compreso il web server integrato.

Il Data-set rappresenta le spese sostenute da diversi Paesi riguardanti i servizi postali negli anni compresi tra il 2012 e il 2017. 
Ogni dato fa riferimento a:
-  Regione geografica (es. Unione Europea),
-  Indicatore delle statistiche postali (es. PRI901)
-  Paese (es. IT), 
-  Periodo (es. 2012) 

La nostra applicazione permette di richiedere mediante API REST (GET) con rotte distinte:

-   Restituzione dei metadati, formato JSON, ovvero l’elenco degli attributi, alias degli stessi e tipo di dati contenuti.
-   Restituzione dei dati riguardanti ogni record, formato JSON.
-   Restituzione dei dati riguardanti record filtrati, formato JSON.
-   Restituzione delle statistiche sui dati di uno specifico campo.
-   Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati.




## Come iniziare

### Download

Usando l'ide eclipse si possono seguire i seguenti passi:

-   aprire eclipse, nella Show view premere il pulsante "clone a Git Repository".
-   nella finestra che appare, incollare URL di questa repository nella casella URI e procedere.
-   recarsi nel clone della repository che apparirà, tasto destro quindi Import Project (verificare che sia importato come progetto Maven) e procedere.
-   a questo punto potete provare ad eseguire il codice, selezionando "nome_Progetto" tasto destro, "Run as" e quindi "Sprign boot App".

In alternativa su linux senza l'utilizzo del ide eclipse si puo scaricare il file Zip ed estrarlo, da terminale recarsi nella directory, digitare il comando  `mvn clean install`  se il BUILD avrà suceccesso, all'interno del progetto nella directory target si troveranno i file compilati. Per eseguire il programma  `java -jar target/nomeProgettoCompilato.jar`  (oppure  `mvn spring-boot:run`).

Ora l'aplicazione Web Service sarà attiva e in ascolto alla porta  [http://localhost:8080](http://localhost:8080/).

### Eseguire richieste

Per eseguire le richieste GET  utiliziamo un Api-testing come Postman.
sarà possibile effettuare le seguenti richieste:

| Tipo | Indirizzo | Descrizione|
|---|---|---|
| Get | /metadata | Restituisce i metadati (formato JSON)|
| Get | /data| Restituisce il dataset (formato JSON)|
| Get | /operation?anno="anno"| Restituisce statistiche sui dati dell'"anno" richiesto (avg,min,max,dev std,sum,count)|
|Get|/occorence?attribute="attributo"| Restituisce il numero di occorrence dell'"attributo" richiesto|


Inoltre è possibile applicare dei filtri nel seguente modo:

| Tipo | Indirizzo | Descrizione|
|--|--|--|
|Get|/data?attribute="attributo" &operator="operatore"&value="valore"|Restituisce il dataset filtrato|
|Get|/operation?anno="anno"&attribute="attributo" &operator="operatore"&value="valore"| Restituisce statistiche filtrate sui dati dell'"anno" richiesto|
|Get|/data?attribute1="attr1" &operator1="op1"&value1="val1" &logicOp="op.logico" &operator2="op2"&value2="val2"|Restituisce il dataset combinando più filtri con op.logico (and, or)|

Si potranno utilizzare i seguenti operatori:

|Nome Operatore| Descrizione|
|--|--|
|gt| ">" maggiore  (numeri)|
|gte|  ">=" maggiore uguale (numeri)|
|lt|  "<" minore  (numeri)|
|lte| "<=" minore uguale (numeri)|
|bt| ">= value <=" compreso tra  (numeri)|
| in | trova  il valore richiesto (stringhe/numeri)|
|nin| trova il valore NON richiesto (stringhe/numeri)|

operatori logici per combinare più filtri

|Operatore Logico|Descrizione  |
|--|--|
|and| entrambe le condizioni sono vere |
|or| almeno una condizione è vera|

#### Esempi applicazione filtri su Postman



 



## UML

blablablablabablablalbalbalbalbalblablablabalbalba

foto 

foto 

immgine 

## Autori

-   **Riccardo Mancini**  
-   **Enrico Tarsi** 
