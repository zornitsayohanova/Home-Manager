Документация за приложение # Home Manager
             
Цел

```diff
-

Основното предназначение е предоставяне на възможност, фирма потребител, да осъществи поддръжка на жилищни сгради. Необходимо е определяне на: домоуправител (служител на компанията), отделна такса за всяка сграда, списък с обслужваните сгради, списък с платежните статуси на всяка една и др. </br>
Тези функционалности са осъществени чрез следните класове: <span style="color: blue">Company, Person, Owner, Employee, Fee, Apartment, Building, HomeManager</span>. Всеки един съдържа два конструктора (дифолтен и с параметри), както и предефиниран метод toString(с изключение на клас HomeManager).

Клас Company

Клас, съдържащ три полета (име на собственика, име на компанията и списък със служителите). Освен аксесорите и мутаторите, са налични още три метода: </br>
AddEmployee и AddEmployees - добавяне на служител; в AddEmployee се добавя обект на клас AddEmployee, а в AddEmployees се добавя предварително запълнен списък със служителите. </br>
Третият метод отпечатва списъка със служители.

Клас Person

Абстрактен клас, явяващ се базов за други два - Owner и Employee. Съдържа основни описателни характеристики за един човек (име, години, националност, пол). Всички предоставени методи служат за аксесори и мутатори.

Клас Owner

Производен на клас Person, включващ допълнително поле (професия). Всички предоставени методи служат за аксесори и мутатори.

Клас Employee

Производен на клас Person, включва три допълнителни полета (идентификационен номер, максимално допустим брой обслужвани сгради и списък с управляваните сгради). Освен наличните аксесори и мутатори, съществуват методи за добавяне на сграда към списъка и за отпечатване на прилежащите към него сгради.

Клас  Fee

Клас, съдържащ две полета -  задължителната такса за апартамент и таксата за всеки обитател в него. Всички предоставени методи служат за аксесори и мутатори.

Клас Apartment 

Клас, съдържащ основните описателни характеристики за един апартамент (собственик, номер на апартамент, етаж, брой живущи, съгласие за плащане на таксата по поддръжка). Освен тях, има и още две - зададената от фирмата такса и обща сума от таксите на обитателите.
Освен аксесори и мутатори, още два метода допълват класа:

SetPaymentFeе - задаване изискваната от фирмата такса (обект на клас Fee); методът се извиква в метода SetRequiredFee на клас Building </br>
PayFee - проверяване, дали собственикът е съгласен да плати изискваната от фирмата такса; при положителен отговор се изчислява общата за апартамента сума (задължителна за апартамент + такса за обитател * броя на обитателите в дадения апартамента). 

Клас Building

Клас, съдържащ основните описателни характеристики за един апартамент (адрес, година на строителство, застроена площ, обитаема площ, общи части, брой етажи, брой апартаменти, брой обитатели, строителен материал). Към тях са добавени едно поле (за мениджър от клас Employee) и две колекции - списък с апартаментите в сградата и платежният статус (относно таксата) на всеки апартамент. Освен аксесорите и мутаторите, съществуват още няколко метода:

SetBuildingManager - задаване на домоуправителя (клас Employee) </br>
SetRequiredFee – апартамент от списъка извиква аксесора си SetPaymentFee и подава като параметър изискваната от фирмата такса </br>
GetBuildingResidentsAmount - определяне броя на обитателите, като сума от обитателите във всеки апартамент </br>
AddApartment и AddApartments - добавяне на апартамент; в AddApartment се добавя обект от AddApartment, а в AddApartments предварително запълнен списък с апартаменти </br>
ShowOwnersList - отпечатване списъка с апартаменти </br>

Клас HomeManager

Клас, съдържащ  основните описателни характеристики (фирма, задължителна такса за апартамент, такса за обитател). Допълнителните полета са (изчислената такса за апартамент, сбора на таксите на всички апартаменти, сума на събраните такси, брой на обитатели във всяка сграда) и четири колекции (списък с управлявани сгради, списък с домоуправителите, списък на апартаментите в дадената сграда, списък на платежния статус за всеки апартамент). Освен аксесори и мутатори, налични са и следните методa:

SetHomeManager - overload-нат метод; в едната си версия избира домоуправител, чието име е зададено от фирмата потребител, а в другата - се избира, в зависимост дали той е достигнал броят на максимално обслужвани сгради (ако не е, името на служителя се отпечатва - в противен случай изхвърля изключение от тип MaxBuildingsAmountException) </br>
SetFloorFeeIncrement и SetResidentFeeIncrement - задаване допълнително повишение на таксите, в зависимост от броя на етажите и обитателите </br>
SetCalculatedApartmentFee - задаване на сградата изчислената, изисквана такса </br>
SetPaymentStatus и SetStatus - отбелязване променения платежен статус на дадения апартамент, в списъка с апартаменти </br>
GetCollectedFees - сумиране на всички платени такси </br>
AddHomeManagers - добавяне предварително създаден списък със служители </br>
AddHomeManagerToList - добавяне на служител (клас Employee) </br>
AddBuildingToList - добавяне на сграда към списъка с обслужвани сгради </br>
ShowRequiredFee - отпечатване общата сума, която сградата трябва да предостави </br>
ShowManagedBuildings - отпечатване списъка със сградите </br>
ShowPaymentStatus - отпечатване всеки апартамент, неговата такса и платежният му статус </br>
ShowResidentsAmount - отпечатване броя на обитателите в дадената сграда </br>


Начин на работа

Фирмата потребител въвежда необходимите данни за таксата, максималния брой управлявани от служител сгради и (евентуално) конкретен служител за домоуправител.
