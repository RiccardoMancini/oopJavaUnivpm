# Progetto OOP in Java

Il progetto che andremo a descrivere è un'applicazione sviluppata in Java, che grazie allo SpringBoot-Framework, rende possibile la creazione di un Web Service.  
Un Web Service è un sistema software che riceve richieste da un client tramite il protocollo HTTP, fornendo le relative riposte.  
Nel nostro caso il client effettua delle rischieste GET specifiche, su dati contenuti in un Data-set in formato csv.  

Il Data-set in questione, rappresenta le spese sostenute, dai Paesi dell'Unione Europea, riguardanti i servizi postali negli anni compresi tra il 2012 e il 2017. In particolare ogni riga del Data-set contiene:

-   la frequenza di rilevazione del dato (indicata con "**freq**");
-   l'unità di misura (indicata con "**unit**");
-   l'indicatore delle statistiche postali (indicato con "**indicps**");
-   la nazione in questione (indicata con "**geo**").  

Nella seguente tabella vediamo che valori possono assumere i precedenti attributi:  

|Attributi| Valori ammessi |
|--|--|
| freq | "A" |
| unit |![](https://lh3.googleusercontent.com/RDY5tb5LMO7oOMdxzonPcW4unLzrzcOM-90k53U1F5qCesozMwXYP_tCdbRXb93xO4gqc5G8AwBU) |
| indicps | ![](https://lh3.googleusercontent.com/TL2rQqbErnKzGMBpr-gY3hhzOl7clF3qVP8oYL7StUSyYNFePbRo15G5-olI5SOwcnDQqY_3COjR)|
| geo | ![](https://lh3.googleusercontent.com/_8QBZ5tL0j6BVbj6fJiZ1ZmJB8X9iHYzYYezkmZcT1yYjkLEg_L7HjlPP3K5CBF-t_WUU4nCi0nw)|

Come accennato prima, la nostra applicazione permette di richiedere, mediante API REST (GET) con rotte distinte, la:

-   Restituzione dei metadati, formato JSON, ovvero l’elenco degli attributi, alias degli stessi e tipo di dati contenuti.
-   Restituzione dei dati riguardanti ogni record, formato JSON.
-   Restituzione dei dati riguardanti record filtrati, formato JSON.
-   Restituzione delle statistiche sui dati di uno specifico campo.
-   Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati.
-   Restituzione del numero di occorrenze in uno specifico attributo

## Gestione data
Il dataset all'interno del file csv presenta alcuni dati affiancati a dei flag e alcuni dati non disponibili.
Si è reso necessario gestirli considerando solo valori numerici in quanto eventuali flag possono creare complicazioni ai fini delle computazioni.
 
Quindi durante il parsing ogni flag associato ad un valore numerico viene trascurato, mentre se il flag non è associato a nessun valore numerico viene considerato un valore negativo (-1), in modo da poter essere facilmente discriminabile durante le computazioni.


| flag | significato | gestione|
|--|--|:--:|
| : | not available | -1
|:c| not available, confidencial| -1
|:bc| not available, break in time series, confidencial|  -1|
|:z|not available, not applicable| -1|
|b| break in time series| solo valore numerico
|d| definition differs| solo valore numerico
|e| estimated| solo valore numerico



## Eseguire richieste

Per eseguire le richieste GET utiliziamo un Api-testing come Postman.
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
|Get|/data?attribute1="attr1" &operator1="op1"&value1="val1" &logicOp="op.logico" &operator2="op2"&value2="val2"|Restituisce il dataset combinando più filtri con op.logico (and, or)

&nbsp;

> **Nota:** Le richieste vengono effettuate solamente tramite il metodo GET , in quanto vengono trattati dei dati tutt'altro che confidenziali, perciò, l'utilizzo del metodo POST (che permette di nascondere i parametri delle richieste, non mostrandoli nella barra degli indirizzi) è pressochè inutile. 

&nbsp;&nbsp;


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

E i seguenti operatori logici per combinare più filtri

|Operatore Logico|Descrizione  |
|--|--|
|and| entrambe le condizioni sono vere |
|or| almeno una condizione è vera|

&nbsp;&nbsp;&nbsp;

### Esempi applicazione filtri su Postman  


|        Descrizione        |Query Params                      
|----------------|-----------------------------
|Restituzione dati filtrati|     ![](https://lh3.googleusercontent.com/BWpdbtECh8-3Ph10fMqul3Bu_7S-FrAQ-sv_uJXzIdIXr5_1y9zoApxTSBG8VO577C8fXaBBn3y0)     
|Restituzione dati filtrati combinando più filtri con op.logico| ![](https://lh3.googleusercontent.com/3ieaRNQ_73wXABhgYgNHm4mGQZocu53akgUbI4jSAyjlK6QaFwBRQKdbV8wf-X8P8O26ChTfPTSv)
|Restituzione statistiche filtrate sui dati dell'anno richiesto|![](https://lh3.googleusercontent.com/5zDBKAI9IWKGCE8qvlYRHF7KoKZmBlo38WK_FYXQuvNq9MT6F3pMzNCX_Rgsr_LoNPYjmLlhScU-)


## UML

blablablablabablablalbalbalbalbalblablablabalbalba

foto 

foto 

immgine 

## Autori

-   **Riccardo Mancini**  
-   **Enrico Tarsi** 
