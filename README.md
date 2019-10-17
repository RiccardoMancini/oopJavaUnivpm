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
Come accennato prima, l'applicazione permette di richiedere, mediante API REST (GET) con rotte distinte, la:

-   Restituzione dei metadati, formato JSON, ovvero l’elenco degli attributi, alias degli stessi e tipo di dati contenuti.
-   Restituzione dei dati riguardanti ogni record, formato JSON.
-   Restituzione dei dati riguardanti record filtrati, formato JSON.
-   Restituzione delle statistiche sui dati di uno specifico campo.
-   Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati.
-   Restituzione del numero di occorrenze in uno specifico attributo

### Come eseguire le richieste
Per eseguire le richieste GET è possibile utilizzare Postman, in quanto API-Testing, scrivendo nella barra degli indirizzi "http://localhost:8080/" seguito da:


| Tipo | Indirizzo | Descrizione|
|---|---|---|
| Get | /metadata | Restituisce i metadati (formato JSON)|
| Get | /data| Restituisce il dataset (formato JSON)|
| Get | /operation?anno="anno"| Restituisce statistiche sui dati dell'"anno" richiesto (avg,min,max,dev std,sum,count)|
|Get|/occorence?attribute="attributo"| Restituisce il numero di occorrence dell'"attributo" richiesto|


Inoltre è possibile applicare dei filtri nel seguente modo dove le indicazioni tra " " corrispondono alle richieste da inserire:

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

### Come applicare i filtri su Postman  

|        Descrizione        |Query Params                      
|----------------|-----------------------------
|Restituzione dati filtrati|     ![](https://lh3.googleusercontent.com/BWpdbtECh8-3Ph10fMqul3Bu_7S-FrAQ-sv_uJXzIdIXr5_1y9zoApxTSBG8VO577C8fXaBBn3y0)     
|Restituzione dati filtrati combinando più filtri con op.logico| ![](https://lh3.googleusercontent.com/3ieaRNQ_73wXABhgYgNHm4mGQZocu53akgUbI4jSAyjlK6QaFwBRQKdbV8wf-X8P8O26ChTfPTSv)
|Restituzione statistiche filtrate sui dati dell'anno richiesto|![](https://lh3.googleusercontent.com/5zDBKAI9IWKGCE8qvlYRHF7KoKZmBlo38WK_FYXQuvNq9MT6F3pMzNCX_Rgsr_LoNPYjmLlhScU-)


## UML
### Use Case Diagram
![enter image description here](https://lh3.googleusercontent.com/8fNAPms7xfX1hqWU7qdBucC0OWAj1dL-ecxz2U6Zue2vZrT3IjsBVJaGMYfh9M4zVk-Jc_Zc_G8 "Use_Case_Diagram")
### Activity Diagram

![enter image description here](https://lh3.googleusercontent.com/IEDgeXg-QiP9b-JjyOKN3mZQp4ebF95-AMXETSeZg9qD_1i1Q9-bfMnl_Ill9vrjZhedXXvuFSM "Activity_Diagram")
### Sequence Diagram

![enter image description here](https://lh3.googleusercontent.com/ieT1K0Y7IJjijcb-W2hdNUFzjkvHZWH6sRdZZGZscIg8ZoLhs5YiexjRmmZvkuCKQeBzY-jAo9I "Sequence_Diagram")

https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=UML_Sequence_DiagWorkin%20prog.drawio#R7V1Zd5tIFv41PifzYJ1aWB%2B9xOmZTiaZ9nTP9LxhCducIOGD8KL%2B9VMgtrpVQAGFgx30kJgSKrbvu3tdTujF9uVT7D3cf4k2fnhC0OblhF6eEIINQtl%2F6cjhOGJj8zhwFwebfKdq4Dr4y88HUT76GGz8PbdjEkVhEjzwg%2Btot%2FPXCTfmxXH0zO92G4X8UR%2B8O18YuF57oTj6n2CT3OejGKHqi1%2F84O4%2BP7Rj5l%2FceOvvd3H0uMuPd0LobfY5fr31irny%2Fff33iZ6rg3Rjyf0Io6i5PjX9uXCD9N7W9y24%2B%2BuGr4tzzv2d4nKD%2Bwb78bDa%2BNmTexb4wadkuMMT174mN%2BLE3r2m79PLqJdEkdh6Mf5mSeH4m6xi3hI%2F3zchp%2BDWz8Mdmzr%2FMGPg62fsP3pZZgPf6vGzp%2Fvg8S%2FfvDW6U%2BfGY7Y2H2yDdkWZn%2ByR5t47CdxuR2G3sM%2BuMmOithI7K8f433w5LPTOyIoHY0ek%2FRIFyUysl3TJ%2BJv8qnKm46yebfBOv879G788Lx8hBdRGKWH30XZBe3Z9X%2F3i0H2ZFH2Kb8pkJIe4jYIw9qeV9knHWdXdeVtgzAlxh9%2BvPF2Xj6cswCTfFt2IC8M7nZsbM0eb3YTxeedQ%2BDJjxP%2FpTaUP%2F9PfsQeQHxgu%2BTfEiPHYs5VJ998rgG%2FwP19DfMYFT%2F0crbdlXNXiGN%2F5KCTA%2FCU2k8vv318%2BN%2FhcPvr6fblT3T5x6kpghBiroaUhyjYJdkpmOcn5iWAXhQn99FdtPPCOvgqQKD3DohGiisjxLA4gBBkShAiAsSaCh7FwRZ8zBMfjho%2BXHMqfDgLPmaFD5vDh4FkGkbEhzOV%2FKCLfpkzPkyqJj8wmkqAFCe0AGQmAOEVjEPVBAieTIIYoob59PHfbKqIPXkvCSJ2S67YHU8k3lINOOkdCJjXeZbfxJsoSaIt%2B8Lfbc5SNzYdC6P1904kKD5F9YfjbzgPWXw0sR%2ByC33iHWbZjc5%2F%2Bi0lSfVIT120wlb1sQ3%2BERvGCtoH%2B%2BgxXvv5PHWfFkwN%2FRkDzJN48Z2fCPOwG%2B4darvlrIZQKW%2BBEnqE20tFyULPzh9vbxe%2Fet5SrLdfXZo5Pf1qgjRILQF3WAK8RaVpU2m0NzrMbnCI2NARcRHO3ZCJpG8eEwG7u0UmzRmGvWWSOTDWV4JRK%2FCoBHmLTNImk4y%2B6AAyyX29MJ9w7hIPnZ5lFtqll3iLVJozEHtLJcsdmoGgUzl4SwBgSslk9kUIkEzYeD1z6fL5s2GZX%2F%2FhHc6ji39dWr8ezuxT7C74GIcP4dmrQEYVHyUYfoTqshpV1xc%2F8TaL%2BpohGkepLwfz6otaqvpLh1Utz4AREYSLfNKmv6y%2BEAHyyVRUX84E4kli2dCzi2j78M%2FH7SKY5gzD3oLJtXjBZCgLJjKFYiRL2nVKoWT3hQcUSmruPsymaIGGmE77PUkvfRFIc4Zgb4GEB6ZE9JQaigJJzIkcs7hSI%2F1H5m3ZLY8P%2F02hsyo3%2F8w2sVlsX77k0DpuHepbNTJkg43P8pgbbbEsc%2FZPnR7GJuY9OtdcodoHTKiaGma2OpyWn%2Bg1c8Nyy11mnl1llQS%2FJ0G4XyTi%2B5KIsFrBVpaJOmw0eXHLUl6rERKtLJ%2FYgZysAlsMLxxLWD48xuHf5qU5w5ts0uLA6RDTXdf52VXw%2FFiNnjPR9lQKrFL3lhtHzUscq0m9%2Bi9Bkv1ihaiTbx9%2FRA0z31ZWyZ2qtqioYqdECV8pV6jrkdrYMHkhhWHeRbk0ywSBfAuEOHrrX%2FlxTGRKT7jpvIT98%2FOqOHI8g4Zf89zkryi6vd37yQlknAZTQcyeswOl6dEP86LgaGQjZvoVOmgkki3ggZChSLZpx0QNSK4mmh4gYiaCndFmfgCpxCXhhSWl%2BXbl26Qbh9qGIHorTwnKa72e0hEoLXc%2FlwN1j6o1l9iDDdh0eXGFtJCDIt47okiL0wWpQmHd%2FmCn6zXJJFtTZHnb1HHa3ezT%2F7Lz%2FRzsk%2FKLkD3382s%2Ffgr%2BCr5F%2B4SZi%2BV3d0mGLn6KsbSMHnz21fnG29%2FX7JdigbWjPRwBKGZZ9hCOFfxPoxm8BDBtp7cEUGJsKxO1BUEqywwRxBe4E02UJYCy0PzoVENNJIUTdbJ9egqKRRf7ewZ7gnTE6948dTjiOANU52hV14sPrqGFADBQSCnTWWQYB2B0kNL5cQCLAcJjzHrbVFzyU8StAfR4zMrTTfpj1iDdSu2BC5iI47RP9OOj1LLKbSVrqKqB4u0g1F4hNXNhjtLFahy%2BHUSGALyQ56cI%2BEIWKQJHryHQi%2FqhTkuo8DzUnRfs2pRDd2F1aXZeDBgfV9UCDojIGzD3OEIL9I9jwXPBgM61uJQ2cot1Grmd9dboWRpHqDSHcnY6uDebamQ3KU92ar5ybKGBdjxhVdXeFFYZrDwyB5KxLBFommgOJpkYZ4OLwWdpk6UPvPI6crMMOePcEJPjGXUnckOaKoi6FZajqLDGMsAGwHXcocYgnGhsykQ7%2FkW%2F3EsP%2FrWA%2F2zDzbxSGGJi1ZUC0AmUatUJ%2FUR9Eb3p1iSdSgEbiOqx0ECdvDk094IR6phJQ0T5RXqV02kRQgQWKbpUXys18x5iyw2qxJ4qFNzIHXWfhkl7EN3VxBiI86FmlOt2TDQDM0pSjZm7HdrsqNf3O2w%2BLOsSMg2IW22dbqdAHeypQrCxJi%2FBzO6QQRwz%2B9fgSWRaBlM%2BbvUZhn1iEW5aC88vqkukPTjSVTnXSby04Zh5iV%2F%2Fqk9YCG8VwaofV%2FVJlqaZU1d9liyfuOwTKnd9GBE9vTzSsV5HMbv6tbhiZxahDjH9NKVv1hb9ZlpOk%2B4kK0qoSVwDY9syLF53WkN9KwIsRWGiN1GsU5x0DagVROcWjqhAikAMAZsjo3GuwZmfpmvpMz87Q21EbloqGK60vdtDVuls801jiRZWQYfLskGwTTlEgUEWqexx87Z4JKkxzn0ybRL%2F9XO1MH1joUHpm1quNo%2BjV36ePpoNSPGMZxgTPWkpnhZFBVJBNmx6MTQVJEw0Az%2BOiqmgXxiuvzBPi68Jzb06dhT0d2ZE3qXdX99D8K6sblshYHE5eGSBGwIFEa8YSCGq2SXaP3RogeUjRI99CIPtlmsNox3GtGOmOfBu6df2Q18h5PDLzmxbrZfEdB38aVOD9qx8ZZa92WsGigHcAENvKrFbjNn9xFhqASGkZ61hR1DYdlzm1VQx4YH2uWBMvE3zXNaGkDccrv3QXydzc3nLDDzvn1q42B6UgdfkPg%2B3EwredBKscA57EMygRTpntI9rrEDzcequBpYqY2Jb3bO9CTIZYtnjssJLWtk8yluGeX3D1ZgSHarZFLhtoJM2hrILYUqEt%2BQ1LfHCCDIM9nVQtuWJ3TnXDKx5Q%2FSiawu9jqYbA%2F8bYVKJe17XuUhjaeSAEKvdbdFhPVUs2HBXTnOqwrHY1%2Bb4ND%2Bw6Bx7fsAuQmoyFRNy2iLbWse%2Bl%2FbAk%2BqTfGuWVh1y%2BMpK7Pa361Sx3l66aOiBcNp%2BzKG1lfDgTQkUr2wyzIKCTTpdCiaam%2FEkXTr9swDb5OP8pj00DClIbAHprekvVAjR0cC2VsiqCV9eNlObedtWrQWEMQzkQots%2BGa%2BNwFysUCRnbOuNVEzRmxzTxXsjPCwuymgsp6DdHKFFt1SpuWKgd2VoYMrcP0hVrOI5sWVlgXCi0JoohdPLjJsLdYwcsnbSbf6BzA0q8vUameZo0cjuZBlzsxjVlKWtYSs3gHL6gsVYf0edccEoRhxMU9cUm7rt%2BSU6zFUiqqMLl5iZhxy0MZaeEkJLAy0hzEPIwfOpJaanhf1JK%2F5eYfUAyoJj%2B1S5PLBXzK4q4Ue1qnmazodMuraoPOqJtYBx8mBLwdWT9SA1rDCTG%2BCddK31yzt0WdcWNLxoree7dFdS1ZZIist0fGeEikEl3Uy0yKimfeNMAHLZIrYWNebbOyJEFIcbHnH1nvAY793bLlYVUDBV4%2Fog5%2FkHSKLhJpaQuH2%2BoBhL9vCcK2yPpC874xNk%2F8yKmjAuS5ocD%2BKvq5LK8k724u3a840slKIB72eS%2FVy7kIywpyPuusizASCfvNu9yJ%2FfpJuF7Ms1WzO%2FYwKBWBQBmaWJQPzplN3Dz1crI8YTSDg%2BzBGDQ25weIYNtVbTCpJ2s7%2BRCWZDQWU1oiME4aktm1jCKs1MlGy1KqFse0FbIhfI6yp06yg2TAy1XryyQoyMZjKwtw7N0hPxh%2BkFzUhJQdXTb%2BztmUNff0dZ1CiSp1Q3WsNOi1A2%2BWdE6qtcBlgG5ZkKtMENvwTp5pBdafR%2BH6KsoHZm61dnrSRWb%2F3RmhyT9qLkhnA2PcDl8wSx1plmAU1Cm1zvy5%2B5aJcTK4wvM6tXYqqZBRRNBIxJrSh7cGrpgyrc6oGrGlbOSg86m9evPfjD8cnPq9HPv4dnjpED7Zhyxk9JbjwlYQYLkVVRZWFHLC4h2Bn9FK8pmO50pNuPDfDGrU%2FwUov5HyFGmAxuO6FiUCXWlLnKva2KSA7Mjb5tGNyEUBAkcJGqgeZqSwXIayVUQgzs804ipL63WXXdP8l2vjpHv8H

## Autori

-   **Riccardo Mancini**  
-   **Enrico Tarsi** 
