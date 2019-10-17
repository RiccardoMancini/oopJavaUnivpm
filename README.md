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



[enter link ](https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=UML_Sequence_DiagWorkin%20prog.drawio#R7V1Zd5tIFv41PifzYJ1aWB%2b9xOmZTiaZ9nTP9LxhCducIOGD8KL%2b9VMgtrpVQAGFgx30kJgSKrbvu3tdTujF9uVT7D3cf4k2fnhC0OblhF6eEIINQtl/6cjhOGJj8zhwFwebfKdq4Dr4y88HUT76GGz8PbdjEkVhEjzwg%2btot/PXCTfmxXH0zO92G4X8UR%2b8O18YuF57oTj6n2CT3OejGKHqi1/84O4%2bP7Rj5l/ceOvvd3H0uMuPd0LobfY5fr31irny/ff33iZ6rg3Rjyf0Io6i5PjX9uXCD9N7W9y24%2b%2buGr4tzzv2d4nKD%2bwb78bDa%2bNmTexb4wadkuMMT174mN%2bLE3r2m79PLqJdEkdh6Mf5mSeH4m6xi3hI/3zchp%2bDWz8Mdmzr/MGPg62fsP3pZZgPf6vGzp/vg8S/fvDW6U%2bfGY7Y2H2yDdkWZn%2byR5t47CdxuR2G3sM%2buMmOithI7K8f433w5LPTOyIoHY0ek/RIFyUysl3TJ%2bJv8qnKm46yebfBOv879G788Lx8hBdRGKWH30XZBe3Z9X/3i0H2ZFH2Kb8pkJIe4jYIw9qeV9knHWdXdeVtgzAlxh9%2bvPF2Xj6cswCTfFt2IC8M7nZsbM0eb3YTxeedQ%2bDJjxP/pTaUP/9PfsQeQHxgu%2bTfEiPHYs5VJ998rgG/wP19DfMYFT/0crbdlXNXiGN/5KCTA/CU2k8vv318%2bN/hcPvr6fblT3T5x6kpghBiroaUhyjYJdkpmOcn5iWAXhQn99FdtPPCOvgqQKD3DohGiisjxLA4gBBkShAiAsSaCh7FwRZ8zBMfjho%2bXHMqfDgLPmaFD5vDh4FkGkbEhzOV/KCLfpkzPkyqJj8wmkqAFCe0AGQmAOEVjEPVBAieTIIYoob59PHfbKqIPXkvCSJ2S67YHU8k3lINOOkdCJjXeZbfxJsoSaIt%2b8Lfbc5SNzYdC6P1904kKD5F9YfjbzgPWXw0sR%2byC33iHWbZjc5/%2bi0lSfVIT120wlb1sQ3%2bERvGCtoH%2b%2bgxXvv5PHWfFkwN/RkDzJN48Z2fCPOwG%2b4darvlrIZQKW%2bBEnqE20tFyULPzh9vbxe/et5SrLdfXZo5Pf1qgjRILQF3WAK8RaVpU2m0NzrMbnCI2NARcRHO3ZCJpG8eEwG7u0UmzRmGvWWSOTDWV4JRK/CoBHmLTNImk4y%2b6AAyyX29MJ9w7hIPnZ5lFtqll3iLVJozEHtLJcsdmoGgUzl4SwBgSslk9kUIkEzYeD1z6fL5s2GZX//hHc6ji39dWr8ezuxT7C74GIcP4dmrQEYVHyUYfoTqshpV1xc/8TaL%2bpohGkepLwfz6otaqvpLh1Utz4AREYSLfNKmv6y%2bEAHyyVRUX84E4kli2dCzi2j78M/H7SKY5gzD3oLJtXjBZCgLJjKFYiRL2nVKoWT3hQcUSmruPsymaIGGmE77PUkvfRFIc4Zgb4GEB6ZE9JQaigJJzIkcs7hSI/1H5m3ZLY8P/02hsyo3/8w2sVlsX77k0DpuHepbNTJkg43P8pgbbbEsc/ZPnR7GJuY9OtdcodoHTKiaGma2OpyWn%2bg1c8Nyy11mnl1llQS/J0G4XyTi%2b5KIsFrBVpaJOmw0eXHLUl6rERKtLJ/YgZysAlsMLxxLWD48xuHf5qU5w5ts0uLA6RDTXdf52VXw/FiNnjPR9lQKrFL3lhtHzUscq0m9%2bi9Bkv1ihaiTbx9/RA0z31ZWyZ2qtqioYqdECV8pV6jrkdrYMHkhhWHeRbk0ywSBfAuEOHrrX/lxTGRKT7jpvIT98/OqOHI8g4Zf89zkryi6vd37yQlknAZTQcyeswOl6dEP86LgaGQjZvoVOmgkki3ggZChSLZpx0QNSK4mmh4gYiaCndFmfgCpxCXhhSWl%2bXbl26Qbh9qGIHorTwnKa72e0hEoLXc/lwN1j6o1l9iDDdh0eXGFtJCDIt47okiL0wWpQmHd/mCn6zXJJFtTZHnb1HHa3ezT/7Lz/Rzsk/KLkD3382s/fgr%2bCr5F%2b4SZi%2bV3d0mGLn6KsbSMHnz21fnG29/X7JdigbWjPRwBKGZZ9hCOFfxPoxm8BDBtp7cEUGJsKxO1BUEqywwRxBe4E02UJYCy0PzoVENNJIUTdbJ9egqKRRf7ewZ7gnTE6948dTjiOANU52hV14sPrqGFADBQSCnTWWQYB2B0kNL5cQCLAcJjzHrbVFzyU8StAfR4zMrTTfpj1iDdSu2BC5iI47RP9OOj1LLKbSVrqKqB4u0g1F4hNXNhjtLFahy%2bHUSGALyQ56cI%2bEIWKQJHryHQi/qhTkuo8DzUnRfs2pRDd2F1aXZeDBgfV9UCDojIGzD3OEIL9I9jwXPBgM61uJQ2cot1Grmd9dboWRpHqDSHcnY6uDebamQ3KU92ar5ybKGBdjxhVdXeFFYZrDwyB5KxLBFommgOJpkYZ4OLwWdpk6UPvPI6crMMOePcEJPjGXUnckOaKoi6FZajqLDGMsAGwHXcocYgnGhsykQ7/kW/3EsP/rWA/2zDzbxSGGJi1ZUC0AmUatUJ/UR9Eb3p1iSdSgEbiOqx0ECdvDk094IR6phJQ0T5RXqV02kRQgQWKbpUXys18x5iyw2qxJ4qFNzIHXWfhkl7EN3VxBiI86FmlOt2TDQDM0pSjZm7HdrsqNf3O2w%2bLOsSMg2IW22dbqdAHeypQrCxJi/BzO6QQRwz%2b9fgSWRaBlM%2bbvUZhn1iEW5aC88vqkukPTjSVTnXSby04Zh5iV//qk9YCG8VwaofV/VJlqaZU1d9liyfuOwTKnd9GBE9vTzSsV5HMbv6tbhiZxahDjH9NKVv1hb9ZlpOk%2b4kK0qoSVwDY9syLF53WkN9KwIsRWGiN1GsU5x0DagVROcWjqhAikAMAZsjo3GuwZmfpmvpMz87Q21EbloqGK60vdtDVuls801jiRZWQYfLskGwTTlEgUEWqexx87Z4JKkxzn0ybRL/9XO1MH1joUHpm1quNo%2bjV36ePpoNSPGMZxgTPWkpnhZFBVJBNmx6MTQVJEw0Az%2bOiqmgXxiuvzBPi68Jzb06dhT0d2ZE3qXdX99D8K6sblshYHE5eGSBGwIFEa8YSCGq2SXaP3RogeUjRI99CIPtlmsNox3GtGOmOfBu6df2Q18h5PDLzmxbrZfEdB38aVOD9qx8ZZa92WsGigHcAENvKrFbjNn9xFhqASGkZ61hR1DYdlzm1VQx4YH2uWBMvE3zXNaGkDccrv3QXydzc3nLDDzvn1q42B6UgdfkPg%2b3EwredBKscA57EMygRTpntI9rrEDzcequBpYqY2Jb3bO9CTIZYtnjssJLWtk8yluGeX3D1ZgSHarZFLhtoJM2hrILYUqEt%2bQ1LfHCCDIM9nVQtuWJ3TnXDKx5Q/Siawu9jqYbA/8bYVKJe17XuUhjaeSAEKvdbdFhPVUs2HBXTnOqwrHY1%2bb4ND%2bw6Bx7fsAuQmoyFRNy2iLbWse%2bl/bAk%2bqTfGuWVh1y%2bMpK7Pa361Sx3l66aOiBcNp%2bzKG1lfDgTQkUr2wyzIKCTTpdCiaam/EkXTr9swDb5OP8pj00DClIbAHprekvVAjR0cC2VsiqCV9eNlObedtWrQWEMQzkQots%2bGa%2bNwFysUCRnbOuNVEzRmxzTxXsjPCwuymgsp6DdHKFFt1SpuWKgd2VoYMrcP0hVrOI5sWVlgXCi0JoohdPLjJsLdYwcsnbSbf6BzA0q8vUameZo0cjuZBlzsxjVlKWtYSs3gHL6gsVYf0edccEoRhxMU9cUm7rt%2bSU6zFUiqqMLl5iZhxy0MZaeEkJLAy0hzEPIwfOpJaanhf1JK/5eYfUAyoJj%2b1S5PLBXzK4q4Ue1qnmazodMuraoPOqJtYBx8mBLwdWT9SA1rDCTG%2bCddK31yzt0WdcWNLxoree7dFdS1ZZIist0fGeEikEl3Uy0yKimfeNMAHLZIrYWNebbOyJEFIcbHnH1nvAY793bLlYVUDBV4/og5/kHSKLhJpaQuH2%2boBhL9vCcK2yPpC874xNk/8yKmjAuS5ocD%2bKvq5LK8k724u3a840slKIB72eS/Vy7kIywpyPuusizASCfvNu9yJ/fpJuF7Ms1WzO/YwKBWBQBmaWJQPzplN3Dz1crI8YTSDg%2bzBGDQ25weIYNtVbTCpJ2s7%2bRCWZDQWU1oiME4aktm1jCKs1MlGy1KqFse0FbIhfI6yp06yg2TAy1XryyQoyMZjKwtw7N0hPxh%2bkFzUhJQdXTb%2bztmUNff0dZ1CiSp1Q3WsNOi1A2%2bWdE6qtcBlgG5ZkKtMENvwTp5pBdafR%2bH6KsoHZm61dnrSRWb/3RmhyT9qLkhnA2PcDl8wSx1plmAU1Cm1zvy5%2b5aJcTK4wvM6tXYqqZBRRNBIxJrSh7cGrpgyrc6oGrGlbOSg86m9evPfjD8cnPq9HPv4dnjpED7Zhyxk9JbjwlYQYLkVVRZWFHLC4h2Bn9FK8pmO50pNuPDfDGrU/wUov5HyFGmAxuO6FiUCXWlLnKva2KSA7Mjb5tGNyEUBAkcJGqgeZqSwXIayVUQgzs804ipL63WXXdP8l2vjpHv8H)



## Autori

-   **Riccardo Mancini**  
-   **Enrico Tarsi** 
