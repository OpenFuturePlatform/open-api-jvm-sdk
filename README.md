# OpenJ

OpenJ is a library for interaction with Open Platform.

## Content


* [Installing](#installing)
* [Get started](#get-started)
* [Entity](#entity)
* [API](#api)


## Installing

Using gradle:

```xml
compile("io.openfuture:sdk:1.0.0")
```

Using maven:

```xml
<dependency>
    <groupId>io.openfuture</groupId>
    <artifactId>sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Get started

`token` - your open key

> Kotlin:
```kotlin
val open = OpenJ(token)
```

> Java:
```java
OpenJ open = new OpenJ(token)
```


## Entity

### Base

#### Page request attributes

Attribute | Type | Description
----------|------|-----------
offset    |Long  | Page offset
limit     |Int   | Page limit

#### Page response attributes

Attribute | Type | Description
----------|------|-----------
totalCount|Long  | Total count of entities in a database
list      |T[]   | List of entities with type T (T is generic)


### Scaffold

#### Ethereum scaffold attributes

Attribute       | Type                                                                 | Description
----------------|----------------------------------------------------------------------|-----------
address         |String                                                                | Scaffold address
abi             |String                                                                | Scaffold json interface
description     |String                                                                | Scaffold description
fiatAmount      |String                                                                | Scaffold fiat amount
currency        |String                                                                | Fiat amount currency
conversionAmount|String                                                                | Fiat amount converted to ethereum 
developerAddress|String                                                                | Scaffold developer address
webHook         |String                                                                | Scaffold webhook for events
properties      |[EthereumScaffoldProperty](#ethereum-scaffold-properties-attributes)[]| Ethereum scaffold properties

#### Ethereum scaffold properties attributes

Attribute   | Type       | Description
------------|------------|-----------
name        |String      | Property name
type        |PropertyType| Property type
defaultValue|String      | Property default value

#### Ethereum scaffold summary attributes

Attribute       | Type                                                  | Description
----------------|-------------------------------------------------------|-----------
scaffold        |[EthereumScaffold](#ethereum-scaffold-attributes)      | Ethereum scaffold
transactionIndex|BigInteger                                             | Transaction index
tokenBalance    |BigInteger                                             | Scaffold token balance
enabled         |Boolean                                                | Scaffold enabled
currency        |String                                                 | Fiat amount currency
shareHolders    |[EthereumShareHolder](#ethereum-shareholder-attributes)| Ethereum scaffold share holders

#### Ethereum scaffold quota attributes

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
currentCount    |Int                                                  | Current deactivated scaffolds count
limitCount      |Int                                                  | Limit of deactivated scaffolds count

#### Deploy ethereum scaffold request

Attribute       | Type                                                                 | Description
----------------|----------------------------------------------------------------------|-------------
openKey         |String                                                                | User open key
description     |String                                                                | Scaffold description
fiatAmount      |String                                                                | Scaffold fiat amount
currency        |String                                                                | Fiat amount currency
conversionAmount|String                                                                | Fiat amount converted to ethereum 
developerAddress|String                                                                | Scaffold developer address
webHook         |String                                                                | Scaffold webhook for events
properties      |[EthereumScaffoldProperty](#ethereum-scaffold-properties-attributes)[]| Ethereum scaffold properties

#### Set web hook request

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
address         |String                                               | Ethereum scaffold address
webHook         |String                                               | Ethereum scaffold webhook for events

#### Open scaffold attributes

Attribute       | Type  | Description
----------------|-------|-----------
description     |String | Scaffold description
developerAddress|String | Scaffold developer address
webHook         |String | Scaffold webhook

#### Save open scaffold request

Attribute       | Type   | Description
----------------|--------|------------
openKey         | String | User open key
developerAddress| String | Scaffold developer address
description     | String | Scaffold description
webHook         | String | Scaffold webhook

### Shareholder

#### Ethereum shareholder attributes

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
address         |String                                               | Ethereum shareholder address
percent         |Int                                                  | Ethereum shareholder percent

#### Add ethereum shareholder request

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
address         |String                                               | Ethereum shareholder address
percent         |Int                                                  | Ethereum shareholder percent

#### Update ethereum shareholder request

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
address         |String                                               | Ethereum shareholder address
percent         |Int                                                  | Ethereum shareholder percent

#### Remove ethereum shareholder request

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
address         |String                                               | Ethereum shareholder address

### Transaction

#### Ethereum transaction attributes

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
scaffold        |[EthereumScaffold](#ethereum-scaffold-attributes)    | Ethereum scaffold
event           |[Event](#event)                                      | Event


### Event

Each event has field `type` which define an event type

#### Activate ethereum scaffold event

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
activated       |Boolean                                              |Ethereum scaffold state
type            |String                                               |"ACTIVATED_SCAFFOLD"

#### Added ethereum share holder event

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
userAddress     |String                                               |Share holder address
partnerShare    |BigInteger                                           |Share holder share
type            |String                                               |"ADDED_SHARE_HOLDER"

#### Delete ethereum share holder event

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
userAddress     |String                                               |Share holder address
type            |String                                               |"DELETED_SHARE_HOLDER"

#### Edit ethereum share holder event

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
userAddress     |String                                               |Shareholder address
partnerShare    |BigInteger                                           |Shareholder share
type            |String                                               |"EDITED_SHARE_HOLDER"

#### Ethereum funds deposited event

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
amount          |BigInteger                                           |Funds amount
toAddress       |String                                               |To address
type            |String                                               |"FUNDS_DEPOSITED"

#### Paid for ethereum shareholder event

Attribute       | Type                                                | Description
----------------|-----------------------------------------------------|-----------
userAddress     |String                                               |Shareholder address
amount          |BigInteger                                           |Paid amount
type            |String                                               |"PAID_FOR_SHARE_HOLDER"

#### Payment completed event

Attribute               | Type                                                | Description
------------------------|-----------------------------------------------------|-----------
customerAddress         |String                                               |Customer address
transactionAmount       |BigInteger                                           |Paid amount
scaffoldTransactionIndex|BigInteger                                           |Transaction index
properties              |Map<String, Any>                                     |Transaction properties
type                    |String                                               |"PAYMENT_COMPLETED"



## API

`sender` - an object that produces requests for each entity type

## Ethereum scaffold
### Scaffold

> Kotlin:
```kotlin
val sender = open.ethereumScaffold()
```

> Java:
```java
EthereumScaffoldSender sender = open.ethereumScaffold()
```

#### Get All

`Can be used with` [page request](#page-request-attributes)

> Kotlin:
```kotlin
val scaffolds = sender.getAll()
```

> Java:
```java
PageResponse<EthereumScaffold> scaffolds = sender.getAll()
```

`Response entity is` [PageResponse](#page-response-attributes) `with param` [EthereumScaffold](#ethereum-scaffold-attributes)

#### Get one

> Kotlin:
```kotlin
val scaffold = sender.get(address)
```

> Java:
```java
EthereumScaffold scaffold = sender.get(address)
```

`address` - `Ethereum scaffold address`

`Response entity is` [EthereumScaffold](#ethereum-scaffold-attributes)

#### Deploy

> Kotlin:
```kotlin
val scaffold = sender.deploy(DeployEthereumScaffoldRequest(openKey, developerAddress, description, fiatAmount, currency, 
                                                   conversionAmount, properties, webHook))
```

> Java:
```java
EthereumScaffold scaffold = sender.deploy(new DeployEthereumScaffoldRequest(openKey, developerAddress, description, fiatAmount, currency, 
                                                   conversionAmount, properties, webHook))
```

`Request entity is` [DeployEthereumScaffoldRequest](#deploy-ethereum-scaffold-request)

`Response entity is` [EthereumScaffold](#ethereum-scaffold-attributes)

#### Set webhook

> Kotlin:
```kotlin
val scaffold = sender.setWebHook(SetWebHookRequest(address, webHook))
```

> Java:
```java
EthereumScaffold scaffold = sender.setWebHook(new SetWebHookRequest(address, webHook))
```

`Request entity is` [SetWebHookRequest](#set-web-hook-request)

`Response entity is` [EthereumScaffold](#ethereum-scaffold-attributes)

#### Get summary

> Kotlin:
```kotlin
val summary = sender.summary(address)
```

> Java:
```java
EthereumScaffoldSummary summary = sender.summary(address)
```

`address` - `Ethereum scaffold address`

`Response entity is` [EthereumScaffoldSummary](#ethereum-scaffold-summary-attributes)

#### Deactivate 

> Kotlin:
```kotlin
val summary = sender.deactivate(address)
```

> Java:
```java
EthereumScaffoldSummary summary = sender.deactivate(address)
```

`address` - `Ethereum scaffold address`

`Response entity is` [EthereumScaffoldSummary](#ethereum-scaffold-summary-attributes)

#### Get quota

> Kotlin:
```kotlin
val quota = sender.quota()
```

> Java:
```java
EthereumScaffoldQuota quota = sender.quota()
```

`Response entity is` [EthereumScaffoldQuota](#ethereum-scaffold-quota-attributes)


### Shareholder

> Kotlin:
```kotlin
val sender = open.EthereumShareHolderSender(address)
```

> Java:
```java
EthereumShareHolderSender sender = open.EthereumShareHolderSender(address)
```

`address` - `Ethereum scaffold address`

#### Add

> Kotlin:
```kotlin
val summary = sender.add(AddEthereumShareHolderRequest(address, percent))
```

> Java:
```java
EthereumScaffoldSummary summary = sender.add(new AddEthereumShareHolderRequest(address, percent))
```

`Request entity is` [AddEthereumShareHolderRequest](#add-ethereum-shareholder-request)

`Response entity is` [EthereumScaffoldSummary](#ethereum-scaffold-summary-attributes)

#### Update

> Kotlin:
```kotlin
val summary = sender.add(UpdateEthereumShareHolderRequest(address, percent))
```

> Java:
```java
EthereumScaffoldSummary summary = sender.add(new UpdateEthereumShareHolderRequest(address, percent))
```

`Request entity is` [UpdateEthereumShareHolderRequest](#update-ethereum-shareholder-request)

`Response entity is` [EthereumScaffoldSummary](#ethereum-scaffold-summary-attributes)

#### Remove

> Kotlin:
```kotlin
val summary = sender.add(RemoveEthereumShareHolderRequest(address))
```

> Java:
```java
EthereumScaffoldSummary summary = sender.add(new RemoveEthereumShareHolderRequest(address))
```

`Request entity is` [RemoveEthereumShareHolderRequest](#remove-ethereum-shareholder-request)

`Response entity is` [EthereumScaffoldSummary](#ethereum-scaffold-summary-attributes)


### Ethereum transaction

> Kotlin:
```kotlin
val sender = open.ethereumTransaction(address)
```

> Java:
```java
EthereumTransactionSender sender = open.ethereumTransaction(address)
```

`address` - `Scaffold address`

#### Get All

`Can be used with` [page request](#page-request-attributes)

> Kotlin:
```kotlin
val transactions = sender.getAll()
```

> Java:
```java
PageResponse<EhereumTransaction> transactions = sender.getAll()
```

`Response entity is` [PageResponse](#page-response-attributes) `with param` [EthereumTransaction](#ethereum-transaction-attributes)




## Open scaffold
### Scaffold

> Kotlin:
```kotlin
val sender = open.openScaffold()
```

> Java:
```java
OpenScaffoldSender sender = open.openScaffold()
```

#### Get all

`Can be used with` [page request](#page-request-attributes)

> Kotlin:
```kotlin
val scaffolds = sender.getAll()
```

> Java:
```java
PageResponse<OpenScaffold> scaffolds = sender.getAll()
```

`Response entity is` [PageResponse](#page-response-attributes) `with param` [OpenScaffold](#open-scaffold-attributes)


#### Create

> Kotlin:
```kotlin
val scaffold = sender.create(SaveOpenScaffoldRequest(openKey, developerAddress, description, webHook))
```

> Java:
```java
OpenScaffold scaffold = sender.create(new SaveOpenScaffoldRequest(openKey, developerAddress, description, webHook))
```

`Request entity is` [SaveOpenScaffoldRequest](#save-open-scaffold-request)

`Response entity is` [OpenScaffold](#open-scaffold-attributes)


