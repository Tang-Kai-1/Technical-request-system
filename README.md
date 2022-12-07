# Tehnikas pieprasījumu sistēma
Izveidota ar java spring boot framework un angular ar Postgresql datubāzi.

Sistēmā ir iespējams pievienot jaunus pieprasījumus, dzēst vai apstiprināt/noraidīt esošos.

### Kā palaist
Jāpieslēdz Postgresql datubāze ar 5432 portu un applicaiton properties failā jāievada datubāzes lietotājvārds un parole.

            ./mvnw spring-boot:run



### Kā izmantot
Iespējams visus pieprasījumus sūtīt uz REST API ar adresi 'localhost:8080' un kādu no sekojošajiem turpinājumiem

            [GET request] /requests          - atgriež visus pieprasījumus
            [POST request] /requests         - izveido jaunu pieprasījumu
            [PUT request] /requests/{id}     - izmaina pieprasījuma statusu
            [DELETE request] /requests/{id}  - izdzēš pieprasījumu

Vai arī pēc aplikācijas palaišanas pārlūkprogrammā ejot uz 'localhost:8080/' kur ar pieprasījumiem var strādāt izmantojot grafisko saskarni.