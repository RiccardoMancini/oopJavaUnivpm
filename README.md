# Progetto OOP in Java

Il progetto che andremo a descrivere è un'applicazione sviluppata in Java, che grazie allo SpringBoot-Framework, rende possibile la creazione di un Web Service.  
Un Web Service è un sistema software che riceve richieste da un client tramite il protocollo HTTP, fornendo le relative riposte.  
Nel nostro caso il client effettua delle rischieste GET specifiche, su dati contenuti in un Data-set in formato csv.  

Il Data-set in questione, rappresenta le spese sostenute, dai Paesi dell'Unione Europea, riguardanti i servizi postali negli anni compresi tra il 2012 e il 2017. 
In particolare ogni riga del Data-set contiene:
- la frequenza di rilevazione del dato (indicata con "**freq**"), che nel nostro caso è sempre annuale ("A").
- l'unità di misura (indicata con "**unit**") che può assumere i seguenti valori ("..")
- l'indicatore delle statistiche postali (indicato con "**indicps**") che può assumere i seguenti valori("..")
- la nazione in questione (indicata con "**geo**"), che può assumere i seguenti valori("..")

Come accennato prima, la nostra applicazione permette di richiedere, mediante API REST (GET) con rotte distinte, la:

-   Restituzione dei metadati, formato JSON, ovvero l’elenco degli attributi, alias degli stessi e tipo di dati contenuti.
-   Restituzione dei dati riguardanti ogni record, formato JSON.
-   Restituzione dei dati riguardanti record filtrati, formato JSON.
-   Restituzione delle statistiche sui dati di uno specifico campo.
-   Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati.
-   Restituzione del numero di occorrenze in uno specifico attributo




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

> **Nota:** Le richieste vengono effettuate solamente tramite il metodo GET , in quanto vengono trattati dei dati tutt'altro che confidenziali, perciò, l'utilizzo del metodo POST, che permette di nascondere le richieste effettuate dalla barra URL di Postman, è pressochè inutile. 

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
